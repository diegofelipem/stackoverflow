package othertests;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.event.TreeWillExpandListener;

import swing.examples.GetPixelColorComponent;

public class Teste {

	private static String somPath = "/res/notify.wav";
	private static InputStream fis;

	public static void main(String[] args) throws FileNotFoundException {

		fis = Teste.class.getResourceAsStream(somPath);
		// tocarSom(fis, false);
		play(fis);
	}

	public static void tocarSom(final InputStream somPath, final boolean restart) {
		try {
			// Obtem os dados sonoros
			AudioInputStream ais = AudioSystem.getAudioInputStream(somPath);
			BufferedInputStream bufferStream = new BufferedInputStream(somPath);
			ais = new AudioInputStream(bufferStream, ais.getFormat(), ais.getFrameLength());
			ais = convertToPCM(ais);

			// Carrega o formato do audio e cria uma linha
			AudioFormat af = ais.getFormat();
			DataLine.Info dataLineInfo = new DataLine.Info(Teste.class, ais.getFormat(),
					((int) ais.getFrameLength() * af.getFrameSize()));

			// Carrega o som para o dispositivo
			Clip clip = (Clip) AudioSystem.getLine(dataLineInfo);
			clip.addLineListener(new LineListener() {

				// Evento do Listener
				public void update(LineEvent e) {
					if (e.getType() == LineEvent.Type.STOP) {
						e.getLine().close();
					}
				}
			});
			clip.open(ais);

			// Tocar som
			if (restart) {
				clip.loop(clip.LOOP_CONTINUOUSLY);
			} else {
				clip.loop(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na reprodução do audio:\n" + e.getMessage(), "Zumbi ",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private static AudioInputStream convertToPCM(AudioInputStream audioInputStream) {
		AudioFormat m_format = audioInputStream.getFormat();

		if ((m_format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED)
				&& (m_format.getEncoding() != AudioFormat.Encoding.PCM_UNSIGNED)) {
			AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, m_format.getSampleRate(), 16,
					m_format.getChannels(), m_format.getChannels() * 2, m_format.getSampleRate(),
					m_format.isBigEndian());
			audioInputStream = AudioSystem.getAudioInputStream(targetFormat, audioInputStream);
		}

		return audioInputStream;
	}

	public static void play(InputStream filename) {

		try {

			Clip clip = AudioSystem.getClip();
			BufferedInputStream bufferStream = new BufferedInputStream(filename);
			clip.open(AudioSystem.getAudioInputStream(bufferStream));
			Thread.sleep(1000);
			clip.start();
			
		} catch (InterruptedException | LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
}