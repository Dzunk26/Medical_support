package ViewLog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JPanel{
	private JTextField text_ID;
	private JTextField text_UserName;
	private JPasswordField text_Password;
    private JPasswordField text_rePassword;
    private JComboBox<String> jComboBox;
    private JButton jButton_SignUp;
    private JButton jButton_Back;
    private JLabel notice;
    
    // Constructor
    public SignUp() {
        this.run();
    }

    public void run() {
        // Font
        Font font_header = new Font("Segoe UI", Font.BOLD, 20);
        Font font_jLabel = new Font("Segoe UI", Font.BOLD, 12);
        Font font_jTextField = new Font("Segoe UI", Font.PLAIN, 12);
        

        // Header
        JPanel headerJPanel = new JPanel();
        headerJPanel.setLayout(new FlowLayout());
        JLabel headerInformation = new JLabel("Medical Support");
        headerInformation.setFont(font_header);
        headerJPanel.add(headerInformation);


        // Details
        JLabel id = new JLabel("Enter your ID: ");
        id.setFont(font_jLabel);
        text_ID = new JTextField("");
        text_ID.setFont(font_jTextField);
        text_ID.setBackground(Color.WHITE);

        JLabel userName = new JLabel("Username: ");
        userName.setFont(font_jLabel);
        text_UserName = new JTextField("");
        text_UserName.setFont(font_jTextField);
        text_UserName.setBackground(Color.WHITE);

        JLabel passWord = new JLabel("Password: ");
        passWord.setFont(font_jLabel);
        text_Password = new JPasswordField("");
        text_Password.setFont(font_jTextField);
        text_Password.setBackground(Color.WHITE);

        JLabel rePassword = new JLabel("Re-Password: ");
        rePassword.setFont(font_jLabel);
        text_rePassword = new JPasswordField("");
        text_rePassword.setFont(font_jTextField);
        text_rePassword.setBackground(Color.WHITE);

        JLabel youAre = new JLabel("You are: ");
        youAre.setFont(font_jLabel);

        String[] who = new String[] {"", "Doctor", "Patient"};
        jComboBox = new JComboBox<>(who);
        jComboBox.setFont(font_jTextField);


        // Location
        JPanel jPanel_Details = new JPanel();
        jPanel_Details.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.1;
        jPanel_Details.add(id, c);
        c.gridy = 1;
        jPanel_Details.add(userName, c);
        c.gridy = 2;
        jPanel_Details.add(passWord, c);
        c.gridy = 3;
        jPanel_Details.add(rePassword, c);
        c.gridy = 4;
        jPanel_Details.add(youAre, c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.9;
        c.fill = GridBagConstraints.BOTH;
        jPanel_Details.add(text_ID, c);
        c.gridy = 1;
        jPanel_Details.add(text_UserName, c);
        c.gridy = 2;
        jPanel_Details.add(text_Password, c);
        c.gridy = 3;
        jPanel_Details.add(text_rePassword, c);
        c.gridy = 4;
        jPanel_Details.add(jComboBox, c);
        c.gridy=5;
        notice = new JLabel(" ");
        notice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        notice.setForeground(Color.red);
        jPanel_Details.add(notice,c);

        // Button
        jButton_Back = new JButton("Back");
        jButton_Back.setFont(font_jTextField);

        jButton_SignUp = new JButton("Sign up");
        jButton_SignUp.setFont(font_jTextField);

        JPanel button = new JPanel(new FlowLayout());
        button.add(jButton_SignUp);
        button.add(jButton_Back);

		// Layout
		this.setLayout(new BorderLayout());

        // Add
        this.add(headerJPanel, BorderLayout.NORTH);
		this.add(jPanel_Details, BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);
    }

    public JTextField getText_ID() {
        return text_ID;
    }

    public void setText_ID(JTextField text_ID) {
        this.text_ID = text_ID;
    }

    public JTextField getText_UserName() {
        return text_UserName;
    }

    public void setText_UserName(JTextField text_UserName) {
        this.text_UserName = text_UserName;
    }

    public String getText_Password() {
        return new String(text_Password.getPassword());
    }

    public void setText_Password(JPasswordField text_Password) {
        this.text_Password = text_Password;
    }

    public String getPassword(JPasswordField text_Password) {
        char[] passwordChars = text_Password.getPassword();
        String password = new String(passwordChars);
        return password;
    }

    public JComboBox<String> getjComboBox() {
        return jComboBox;
    }

    public String getTypeAcc() {
    	return jComboBox.getSelectedItem().toString();
    }

    public JButton getjButton_SignUp() {
        return jButton_SignUp;
    }

    public void setjButton_SignUp(JButton jButton_SignUp) {
        this.jButton_SignUp = jButton_SignUp;
    }

    public JButton getjButton_Back() {
        return jButton_Back;
    }

    public void setjButton_Back(JButton jButton_Back) {
        this.jButton_Back = jButton_Back;
    }

    public String getText_rePassword() {
        return new String(text_rePassword.getPassword());
    }

    public void setText_rePassword(JPasswordField text_rePassword) {
        this.text_rePassword = text_rePassword;
    }

    public JLabel getNotice() {
		return notice;
	}

	public void setNotice(JLabel notice) {
		this.notice = notice;
	}

	public String getRePassword(JPasswordField text_rePassword) {
        char[] passwordChars = text_rePassword.getPassword();
        String password = new String(passwordChars);
        return password;
    }

    public void reset() {
        this.text_ID.setText("");
        this.text_UserName.setText("");
        this.text_Password.setText("");
        this.text_rePassword.setText("");
        this.notice.setText("");
        this.jComboBox.setSelectedItem("");
    }
}
