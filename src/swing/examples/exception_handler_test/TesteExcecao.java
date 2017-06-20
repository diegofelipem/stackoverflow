package swing.examples.exception_handler_test;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TesteExcecao {

	public static void main(String[] args) {
		// Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

		try {
			// define o look And Feel de acordo com o tema do SO em execução
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			String a = null;
			System.out.println(a.equals(""));
			System.out.println(Integer.parseInt(a));
		} catch (Exception e) {
			StringWriter strStackTrace = new StringWriter();
			e.printStackTrace(new PrintWriter(strStackTrace));
			SwingUtilities.invokeLater(() -> DialogUnhandledException.
					showException(e.getClass() + " " + e.getMessage(),strStackTrace.toString()));
		}
	}
}
