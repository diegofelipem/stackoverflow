package swing.examples7;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RobotTest {
	
	
    public static void main(String[] args) {
        String admUsr = "HOMP\\adm03!@";
        iRobot_Functions irf = new iRobot_Functions();
        irf.Wait(3000);
        irf.Send(admUsr);
        System.out.println(admUsr);
    }
}

class iRobot_Functions {
	  Robot r;
	  public void Wait(int i)
	  {
	      Robot r;
	      try {
	          r = new Robot();
	          r.delay(i);
	      } catch (AWTException ex) {
	          Logger.getLogger(iRobot_Functions.class.getName()).log(Level.SEVERE, null, ex);
	      }
	  }
	  // pressionar teclas
	  public void Press(int keyCode) {
	      try {
	        r = new Robot();
	        r.keyPress(keyCode);
	        r.delay(200);
	        r.keyRelease(keyCode);
	        r.delay(200);
	      } catch (AWTException ex) {
	        Logger.getLogger(iRobot_Functions.class.getName()).log(Level.SEVERE, null, ex);
	      }
	  }
	    public void Send(String s) {
	        if (null == s) return;
	        Robot r = null;
	        char[] chars = s.toCharArray();
	        try {
	            for (char c : chars) {
	            	System.out.println(c);
	                int code = c;
	                int keyCode = KeyEvent.getExtendedKeyCodeForChar(code);
	                r = new Robot();
	                r.delay(40);
	                r.keyPress(keyCode);
	                r.keyRelease(keyCode);
	            } 
	        } catch (AWTException ex) {
	            System.err.println(ex.getMessage());
	        }
	    }
	}