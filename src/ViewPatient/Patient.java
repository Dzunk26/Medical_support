package ViewPatient;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Patient extends JFrame{
	private panel alpanel;
	private menu almenu;
	
	public Patient(){
		this.setTitle("Medical Support");
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		alpanel = new panel();
		almenu = new menu();
		
		this.add(almenu, BorderLayout.NORTH);
		this.add(alpanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public panel getAlpanel() {
		return alpanel;
	}

	public menu getAlmenu() {
		return almenu;
	}
}
