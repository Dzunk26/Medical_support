package ViewPatient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class alarmView extends JFrame{
	private JLabel clock;
	private JButton stop;
	
	public alarmView() {
		this.setTitle("Medical Support");
		this.setSize(300,150);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		JPanel tmp = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx=0;
		gc.gridy=0;
		clock = new JLabel();
		clock.setFont(new Font("Segoe UI", Font.BOLD, 20));
		clock.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
		tmp.add(clock,gc);
		gc.gridx=1;
		stop = new JButton("Stop");
		stop.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		stop.setPreferredSize(new Dimension(80, 35));
		tmp.add(stop,gc);
		
		this.add(tmp,BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JLabel getClock() {
		return clock;
	}

	public JButton getStop() {
		return stop;
	}
}
