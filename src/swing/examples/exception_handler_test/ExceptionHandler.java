
package swing.examples.exception_handler_test;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class ExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {

		StringWriter strStackTrace = new StringWriter();
		throwable.printStackTrace(new PrintWriter(strStackTrace));
		DialogUnhandledException.showException(throwable.toString(), strStackTrace.toString());
	}

}
