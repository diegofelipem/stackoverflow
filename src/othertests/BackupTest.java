package othertests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//import com.dfmachado.geroficios.utils.Propriedade;

/**
 * Classe para testar cópia de arquivo com diferentes 
 * métodos
 * OBS.: precisa ser copiado para o pacote utils do Geroficios
 * para funcionar
 * 
 * @author diego.felipe
 *
 */

public class BackupTest {

	public static void main(String[] args) throws Exception {
		int i = 0;

		while (i < 3) {
			benchmark();
			System.out.println();
			Thread.sleep(1000);
			i++;	
		}
	}

	static void benchmark() throws Exception {
		Date datas = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy 'at' HH'h'mm'm'");
		Propriedade prop = new Propriedade();
		String DBUrl = prop.getDatabaseURL() + prop.getDbBackupDir() + prop.getDatabaseName();
		String rotulo = DBUrl + "- [" + sdf.format(datas) + "]-[" + " copyWithChannel.bak";

		File source = new File(prop.getDatabaseURL() + prop.getDatabaseName() + ".script");
		File target = new File(rotulo);

		long start, end;

		start = System.nanoTime();
		copyWithFiles(source, target);
		end = TimeUnit.MILLISECONDS.convert((System.nanoTime() - start), TimeUnit.NANOSECONDS);
		System.out.println("copyWithFiles Time:   " + (System.nanoTime() - start));

		start = System.nanoTime();
		copyWithStream(source, target);
		end = TimeUnit.MILLISECONDS.convert((System.nanoTime() - start), TimeUnit.NANOSECONDS);
		System.out.println("copyWithStream Time:  " + (System.nanoTime() - start));

		start = System.nanoTime();
		copyWithChannel(source, target);
		end = TimeUnit.MILLISECONDS.convert((System.nanoTime() - start), TimeUnit.NANOSECONDS);
		System.out.println("copyWithChannel Time: " + (System.nanoTime() - start));
	}

	private static void copyWithChannel(File source, File target) throws IOException {

		FileInputStream in = new FileInputStream(source);
		FileOutputStream out = new FileOutputStream(target);

		FileChannel inChannel = in.getChannel();
		FileChannel outChannel = out.getChannel();

		inChannel.transferTo(0, source.length(), outChannel);

		in.close();
		out.close();

	}

	private static void copyWithFiles(File source, File target) throws IOException {

		Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}

	private static void copyWithStream(File source, File target) throws IOException {

		InputStream in = new FileInputStream(source);
		OutputStream out = new FileOutputStream(target);
		byte[] buf = new byte[8192];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

}

class Propriedade{

	public String getDatabaseURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDatabaseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDbBackupDir() {
		// TODO Auto-generated method stub
		return null;
	}}
