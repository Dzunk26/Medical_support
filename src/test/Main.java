package test;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import ControllerLog.LogIn_SignUp;

public class Main{
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new LogIn_SignUp();
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}