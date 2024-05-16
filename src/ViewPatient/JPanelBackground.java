package ViewPatient;

import javax.swing.*;
import java.awt.*;

public class JPanelBackground extends JPanel {
	public Image backgroundImage;
	
	public JPanelBackground() {
		super();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	public void setBackground(String url) {
		this.backgroundImage = new setIcon().loadImage(url).getImage();
		this.repaint();
	}
}
