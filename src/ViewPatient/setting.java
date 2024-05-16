package ViewPatient;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.patients;

public class setting extends JPanel{
	private CardLayout settingLayout;
	
//	cac bien cua jpanel defaultPanel
	private JPanel defaultPanel;
	private setIcon icon;
	private JButton setPro;
	private JButton changePass;
	private JButton logOut;
	
//	cac bien cua jpanel setProPanel
	private JPanel setProPanel;
	private JLabel title[];
	private JTextField content[];
	private JComboBox<String> text_Sex;
	private JButton saveProPanel;
	private JButton cancelProPanel;
	private patients pas;
	
//	cac bien cua jpanel changePassPanel
	private JPanel changePassPanel;
	private JPasswordField oldPass;
	private JPasswordField newPass;
	private JPasswordField re_newPass;
	private JButton saveChangePassPanel;
	private JButton cancelChangePassPanel;
	
	
	public setting() {
		pas = new patients();
		settingLayout = new CardLayout();
		this.setLayout(settingLayout);
		icon = new setIcon();
		defaultPanel = new JPanel(new GridBagLayout());
		setProPanel = new JPanel(new BorderLayout());
		changePassPanel = new JPanel(new GridBagLayout());
		init();
		this.add(defaultPanel,"defaultPanel");
		this.add(setProPanel,"setProPanel");
		this.add(changePassPanel,"changePassPanel");
	}
	
	public void init() {
//		khoi tao jpanel defaultPanel
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(15, 0, 15, 0);
		gc.gridy=0;
		setPro = new JButton("Set Profile");
		setPro.setIcon(icon.loadImage("resources/set_profile.png"));
		setPro.setBackground(new Color(0,0,0,0));
		setPro.setBorderPainted(false);
		setPro.setContentAreaFilled(false);
		defaultPanel.add(setPro,gc);
		gc.gridy=1;
		changePass = new JButton("Change Password");
		changePass.setIcon(icon.loadImage("resources/changepass.png"));
		changePass.setBackground(new Color(0,0,0,0));
		changePass.setBorderPainted(false);
		changePass.setContentAreaFilled(false);
		defaultPanel.add(changePass,gc);
		gc.gridy=2;
		logOut = new JButton("Log Out");
		logOut.setIcon(icon.loadImage("resources/log_out.png"));
		logOut.setBackground(new Color(0,0,0,0));
		logOut.setBorderPainted(false);
		logOut.setContentAreaFilled(false);
		defaultPanel.add(logOut,gc);
		
//		khoi tao jpanel setProPanel
		JPanel panel_header = new JPanel();
		JLabel titlepanel = new JLabel("Setting Profile");
		titlepanel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		panel_header.add(titlepanel);
		
		JPanel panel_center = new JPanel(new GridBagLayout());
		String sex[] = {"Nam", "Nữ"};
		text_Sex = new JComboBox<String>(sex);
		title = new JLabel[8];
		content = new JTextField[7];
		String tir[] = {"ID: ", "SID: ", "Name: ","Birth: ", "Sex: ", "Phone: ", "Email: ", "Address: "};
		for(int i=0 ; i<8 ; i++)
			title[i] = new JLabel(tir[i]);
		for(int i=0 ; i<7 ; i++)
			content[i] = new JTextField();
		content[0].setEditable(false);
		content[0].setBackground(Color.white);
		content[1].setEditable(false);
		content[1].setBackground(Color.white);
		JPanel panel_left = new JPanel(new GridBagLayout());
		JPanel panel_right = new JPanel(new GridBagLayout());
		gc.gridx=0;
		gc.gridy=0;
		gc.anchor=GridBagConstraints.WEST;
		gc.fill=GridBagConstraints.BOTH;
		
		for(int i=0 ; i<4 ; i++) {
			gc.gridy=i;
			gc.gridx=0;
			gc.weightx=0.2;
			panel_left.add(title[i],gc);
			gc.gridx=1;
			gc.weightx=0.5;
			panel_left.add(content[i],gc);
		}
		
		gc.gridx=0;
		gc.gridy=0;
		panel_right.add(title[4],gc);
		gc.gridx=1;
		gc.weightx=0.5;
		panel_right.add(text_Sex,gc);
		for(int i=5 ; i<8 ; i++) {
			gc.gridy=i-4;
			gc.gridx=0;
			gc.weightx=0.2;
			panel_right.add(title[i],gc);
		}
		for(int i=4 ; i<7 ; i++) {
			gc.gridy=i-4+1;
			gc.gridx=1;
			gc.weightx=0.5;
			panel_right.add(content[i],gc);
		}
		gc.gridx=0;
		gc.gridy=0;
		gc.weightx=1;
		gc.insets=new Insets(0, 10, 0, 10);
		panel_center.add(panel_left,gc);
		gc.gridx=1;
		panel_center.add(panel_right,gc);
		
		JPanel panel_bottom = new JPanel(new GridLayout(1,2));
		saveProPanel = new JButton("save");
		saveProPanel.setFont(saveProPanel.getFont().deriveFont(16f));
		saveProPanel.setBackground(new Color(0,0,0,0));
		saveProPanel.setBorderPainted(false);
		saveProPanel.setContentAreaFilled(false);
		cancelProPanel = new JButton("cancel");
		cancelProPanel.setFont(cancelProPanel.getFont().deriveFont(16f));
		cancelProPanel.setBackground(new Color(0,0,0,0));
		cancelProPanel.setBorderPainted(false);
		cancelProPanel.setContentAreaFilled(false);
		panel_bottom.add(cancelProPanel);
		panel_bottom.add(saveProPanel);
		
		setProPanel.add(panel_header,BorderLayout.NORTH);
		setProPanel.add(panel_center,BorderLayout.CENTER);
		setProPanel.add(panel_bottom,BorderLayout.SOUTH);
		
		
//		khoi tạo jpanel ChangePassPanel
		JPanel panel_top = new JPanel();
		JLabel res = new JLabel("Change Password");
		res.setFont(new Font("Segoe UI", Font.BOLD, 20));
		panel_top.add(res);
		
		JPanel panel_mid = new JPanel(new GridBagLayout());
		gc.gridwidth=1;
		gc.gridx=0;
		gc.gridy=0;
		gc.insets=new Insets(15,0, 15, 0);
		JLabel tirOldPass = new JLabel("Current Password:");
		panel_mid.add(tirOldPass,gc);
		gc.gridy=1;
		JLabel tirNewPass = new JLabel("New Password:");
		panel_mid.add(tirNewPass,gc);
		JLabel tirRe_NewPass = new JLabel("Confirm new Password:");
		gc.gridy=2;
		panel_mid.add(tirRe_NewPass,gc);
		gc.gridx=1;
		gc.gridy=0;
		oldPass = new JPasswordField();
		panel_mid.add(oldPass,gc);
		gc.gridy=1;
		newPass = new JPasswordField();
		panel_mid.add(newPass,gc);
		gc.gridy=2;
		re_newPass = new JPasswordField();
		panel_mid.add(re_newPass,gc);
		
		JPanel panel_bot = new JPanel(new BorderLayout());
		saveChangePassPanel = new JButton("save");
		saveChangePassPanel.setFont(saveChangePassPanel.getFont().deriveFont(16f));
		saveChangePassPanel.setBackground(new Color(0,0,0,0));
		saveChangePassPanel.setBorderPainted(false);
		saveChangePassPanel.setContentAreaFilled(false);
		cancelChangePassPanel = new JButton("cancel");
		cancelChangePassPanel.setFont(cancelChangePassPanel.getFont().deriveFont(16f));
		cancelChangePassPanel.setBackground(new Color(0,0,0,0));
		cancelChangePassPanel.setBorderPainted(false);
		cancelChangePassPanel.setContentAreaFilled(false);
		panel_bot.add(saveChangePassPanel,BorderLayout.EAST);
		panel_bot.add(cancelChangePassPanel,BorderLayout.WEST);
		gc.gridx=0;
		gc.gridy=0;
		changePassPanel.add(panel_top,gc);
		gc.gridy=1;
		changePassPanel.add(panel_mid,gc);
		gc.gridy=2;
		changePassPanel.add(panel_bot,gc);
	}
	
	public String getOldPass() {
		return new String(oldPass.getPassword());
	}
	
	public String getNewPass() {
		return new String(newPass.getPassword());
	}
	
	public String getRe_NewPass() {
		return new String(re_newPass.getPassword());
	}
	
	public JButton getSaveChangePassPanel() {
		return saveChangePassPanel;
	}
	
	public JButton getCancelChangePassPanel() {
		return cancelChangePassPanel;
	}
	
	public JButton getSaveProPanel() {
		return saveProPanel;
	}
	
	public JButton getCancelProPanel() {
		return cancelProPanel;
	}

	public JButton getSetPro() {
		return setPro;
	}

	public JButton getChangePass() {
		return changePass;
	}

	public JButton getLogOut() {
		return logOut;
	}

	public CardLayout getSettingLayout() {
		return settingLayout;
	}

	public JTextField[] getContent() {
		return content;
	}

	public patients getPas() {
		return pas;
	}

	public void setPas(patients pas) {
		this.pas = pas;
	}
	
	public void getInfor() {
		String tmp[] = {pas.getId(),pas.getSid(),pas.getName(),pas.getBirth().toString(),pas.getPhone(),pas.getEmail(),pas.getAddress()};
		for(int i=0 ; i<7 ; i++) {
			content[i].setText(tmp[i]);
		}
		text_Sex.setSelectedItem(pas.getSex());
	}
	
	public void reset() {
		oldPass.setText("");
		newPass.setText("");
		re_newPass.setText("");
	}
	
	public void getNewInfor() {
		LocalDate lc = LocalDate.parse(content[3].getText());
		Date date = Date.valueOf(lc);
		pas.setId(content[0].getText());
		pas.setSid(content[1].getText());
		pas.setName(content[2].getText());
		pas.setBirth(date);
		pas.setSex(text_Sex.getSelectedItem().toString());
		pas.setPhone(content[4].getText());
		pas.setEmail(content[5].getText());
		pas.setAddress(content[6].getText());
	}
	
	public boolean checkBirth(String birth) {
    	SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
    	dateform.setLenient(false);
    	try {
			dateform.parse(birth);
			return true;
		} catch (ParseException e) {
			return false;
		}
    }

    public boolean checkEmail(String res) {
        String word[] = res.split("@");
        if (word.length == 2 && word[1].equals("gmail.com"))
            return true;
        return false;
    }

    public boolean checkPhone(String res) {
        if (res.length() == 10 && res.charAt(0) == '0') {
            for (int i = 0; i < res.length(); i++) {
                if (!Character.isDigit(res.charAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }
}
