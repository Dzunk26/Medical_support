package ViewAdmin;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ViewPatient.setIcon;

public class Home extends JPanel{
	private JLabel jLabelHome;

    public Home() {
        this.jLabelHome = new JLabel();
         jLabelHome.setIcon(new setIcon().loadImage("resources/admin_bg2.jpg"));
    
        this.setLayout(new BorderLayout());
        this.add(jLabelHome, BorderLayout.CENTER);
    }
}
