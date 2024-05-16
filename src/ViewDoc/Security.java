package ViewDoc;

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
import model.account;

public class Security extends JPanel{
	private account accs;
    private JPasswordField text_Password;
    private JPasswordField text_NewPassword;
    private JPasswordField text_RePassword;
    private JButton jButton_Save;
    private JButton jButton_Cancel;

    // Constructor
    public Security() {
        this.accs = new account();
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
        JLabel headerInformation = new JLabel("Security");
        headerInformation.setFont(font_header);
        headerJPanel.add(headerInformation);

        // Details
        JLabel jLabel_Password = new JLabel("Password: ");
        jLabel_Password.setFont(font_jLabel);
        text_Password = new JPasswordField("");
        text_Password.setFont(font_jTextField);
        text_Password.setEditable(true);
        text_Password.setBackground(Color.WHITE);

        JLabel jLabel_NewPassword = new JLabel("New-Password: ");
        jLabel_NewPassword.setFont(font_jLabel);
        text_NewPassword = new JPasswordField("");
        text_NewPassword.setFont(font_jTextField);
        text_NewPassword.setEditable(true);
        text_NewPassword.setBackground(Color.WHITE);

        JLabel jLabel_RePassword = new JLabel("Re-Password: ");
        jLabel_RePassword.setFont(font_jLabel);
        text_RePassword = new JPasswordField("");
        text_RePassword.setFont(font_jTextField);
        text_RePassword.setEditable(true);
        text_RePassword.setBackground(Color.WHITE);


        // Location
        JPanel jPanel_Details = new JPanel();
        jPanel_Details.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.2;
        jPanel_Details.add(jLabel_Password, c);
        c.gridy = 1;
        jPanel_Details.add(jLabel_NewPassword, c);
        c.gridy = 2;
        jPanel_Details.add(jLabel_RePassword, c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.8;
        c.fill = GridBagConstraints.BOTH;
        jPanel_Details.add(text_Password, c);
        c.gridy = 1;
        jPanel_Details.add(text_NewPassword, c);
        c.gridy = 2;
        jPanel_Details.add(text_RePassword, c);

        // Save
        jButton_Save = new JButton("Save");
        jButton_Save.setFont(font_jTextField);

        jButton_Cancel = new JButton("Cancel");
        jButton_Cancel.setFont(font_jTextField);

        JPanel jPanel_Button = new JPanel(new FlowLayout());
        jPanel_Button.add(jButton_Cancel);
        jPanel_Button.add(jButton_Save);

        // Layout
        this.setLayout(new BorderLayout());
        this.add(headerJPanel, BorderLayout.NORTH);
        this.add(jPanel_Details, BorderLayout.CENTER);
        this.add(jPanel_Button, BorderLayout.SOUTH);
    }

    // Getters and Setters
    public account getAccs() {
        return accs;
    }

    public void setAccs(account accs) {
        this.accs = accs;
    }

    public JPasswordField getText_Password() {
        return text_Password;
    }

    public String getTextPassword() {
        return new String(this.text_Password.getPassword());
    }

    public void setText_Password(JPasswordField text_Password) {
        this.text_Password = text_Password;
    }

    public JPasswordField getText_NewPassword() {
        return text_NewPassword;
    }

    public String getTextNewPassword() {
        return new String(this.text_NewPassword.getPassword());
    }

    public void setText_NewPassword(JPasswordField text_NewPassword) {
        this.text_NewPassword = text_NewPassword;
    }

    public JPasswordField getText_RePassword() {
        return text_RePassword;
    }

    public String getTextRePassword() {
        return new String(this.text_RePassword.getPassword());
    }

    public void setText_RePassword(JPasswordField text_RePassword) {
        this.text_RePassword = text_RePassword;
    }

    public JButton getjButton_Save() {
        return jButton_Save;
    }

    public void setjButton_Save(JButton jButton_Save) {
        this.jButton_Save = jButton_Save;
    }

    public JButton getjButton_Cancel() {
        return jButton_Cancel;
    }

    public void setjButton_Cancel(JButton jButton_Cancel) {
        this.jButton_Cancel = jButton_Cancel;
    }

    public boolean CheckPassword() {
        if (this.getTextPassword().equals(this.accs.getPassword()))
            return true;
        return false;
    }

    public boolean CheckRePassword() {
        if (this.getTextNewPassword().equals(this.getTextRePassword()))
            return true;
        return false;
    }

    public void SaveChanges() {
        this.accs.setPassword(this.getTextNewPassword());
    }
}
