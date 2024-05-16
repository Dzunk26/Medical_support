package ViewLog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JPanel {
	private JButton jButton_LogIn;
	private JButton jButton_SignUp;
	private JTextField text_UserName;
	private JPasswordField text_Password;
    private JLabel notice;


    // Constructor
    public LogIn() {
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

        // Location
        JPanel jPanel_Details = new JPanel();
        jPanel_Details.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.1;
        jPanel_Details.add(userName, c);
        c.gridy = 1;
        jPanel_Details.add(passWord, c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.9;
        c.fill = GridBagConstraints.BOTH;
        jPanel_Details.add(text_UserName, c);
        c.gridy = 1;
        jPanel_Details.add(text_Password, c);
        c.gridy = 2;
        notice = new JLabel(" ");
        notice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		notice.setForeground(Color.red);
		jPanel_Details.add(notice,c);
        

        // Button
        c.gridx=0;
        c.gridy=0;
        c.anchor=GridBagConstraints.CENTER;
        c.weightx=1;
        c.fill=GridBagConstraints.NONE;
        JPanel tmp = new JPanel(new GridBagLayout());
        jButton_LogIn = new JButton("Log in");
        jButton_LogIn.setFont(font_jTextField);
        tmp.add(jButton_LogIn,c);

        jButton_SignUp = new JButton("Don't you have an account? Register now");
        jButton_SignUp.setFont(font_jTextField);
        jButton_SignUp.setBorderPainted(false);
		jButton_SignUp.setContentAreaFilled(false);
		c.gridy=1;
		tmp.add(jButton_SignUp,c);

		// Layout
		this.setLayout(new BorderLayout());

        // Add
        this.add(headerJPanel, BorderLayout.NORTH);
		this.add(jPanel_Details, BorderLayout.CENTER);
        this.add(tmp, BorderLayout.SOUTH);
    }

    // Getters and Setters
    public JButton getjButton_LogIn() {
        return jButton_LogIn;
    }

    public JButton getjButton_SignUp() {
        return jButton_SignUp;
    }

    public String getText_UserName() {
        return text_UserName.getText();
    }

    public String getText_Password() {
        return new String(this.text_Password.getPassword());
    }
    
	public void setText_Notice(String somethings) {
		notice.setText(somethings);
	}

	public void reset() {
        this.text_UserName.setText("");
        this.text_Password.setText("");
    }
}
