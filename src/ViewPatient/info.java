package ViewPatient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.patients;

public class info extends JPanel{
	private JLabel tirle[];
	private JTextField content[];
	private patients pas;
	
	public info() {
		this.setLayout(new BorderLayout());
		tirle = new JLabel[8];
		content = new JTextField[8];
		pas = new patients();
		init();
	}
	
	public void init() {
		JPanel panel_top = new JPanel(new FlowLayout());
		JLabel res = new JLabel("Information");
		res.setFont(new Font("Segoe UI", Font.BOLD, 20));
		panel_top.add(res);
		
		JPanel panel_mid = new JPanel(new GridBagLayout());
		String tir[] = {"ID: ", "SID: ", "Name: ", "Birth ", "Sex: ", "Phone: ", "Email: ", "Address: "};
		for(int i=0 ; i<8 ; i++) {
			tirle[i] = new JLabel(tir[i]);
			content[i] = new JTextField();
			content[i].setBackground(Color.white);
			content[i].setEditable(false);
		}
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(10, 10, 10, 10);
		gc.anchor = GridBagConstraints.WEST;
		for(int i=0 ; i<4 ; i++) {
			gc.gridy=i;
			gc.gridx=0;
			gc.weightx=0.1;
			panel_mid.add(tirle[i],gc);
			gc.gridx=1;
			gc.weightx=0.4;
			gc.fill=GridBagConstraints.BOTH;
			panel_mid.add(content[i],gc);
		}
		for(int i=4 ; i<8 ; i++) {
			gc.gridy=i-4;
			gc.gridx=2;
			gc.weightx=0.1;
			panel_mid.add(tirle[i],gc);
			gc.gridx=3;
			gc.weightx=0.4;
			panel_mid.add(content[i],gc);
		}
		
		this.add(panel_top,BorderLayout.NORTH);
		this.add(panel_mid,BorderLayout.CENTER);
	}
	
	public patients getPas() {
		return pas;
	}

	public void setPas(patients pas) {
		this.pas = pas;
	}

	public JTextField[] getContent() {
		return content;
	}
	
	public void getInfor() {
		String tmp[] = {pas.getId(),pas.getSid(),pas.getName(),pas.getBirth().toString(),pas.getSex(),pas.getPhone(),pas.getEmail(),pas.getAddress()};
		for(int i=0 ; i<8 ; i++) {
			content[i].setText(tmp[i]);
		}
	}
}
