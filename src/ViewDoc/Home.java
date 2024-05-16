package ViewDoc;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ViewPatient.setIcon;

public class Home extends JPanel{
	private JLabel jLabelHome;

    public Home() {
        this.jLabelHome = new JLabel();
        jLabelHome.setIcon(new setIcon().loadImage("resources/home_bg.jpg"));
    
        this.setLayout(new BorderLayout());
        this.add(jLabelHome, BorderLayout.CENTER);
    }
}
