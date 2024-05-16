package ViewAdmin;

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
import javax.swing.JTextField;

import model.account;

public class JPanelAccount extends JPanel{
	private account accs;
    private JTextField text_Search;
    private JTextField text_Password;
    private JButton jButton_Search;
    private JButton jButton_Save;
    private JButton jButton_Cancel;
    private JTextField text_Username;
    private JButton jButton_Delete;

    // Constructor
    public JPanelAccount() {
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
        JLabel headerInformation = new JLabel("Account");
        headerInformation.setFont(font_header);
        headerJPanel.add(headerInformation);

        // Details
        JLabel jLabel_Search = new JLabel("Enter ID: ");
        jLabel_Search.setFont(font_jLabel);
        text_Search = new JTextField("");
        text_Search.setFont(font_jTextField);
        text_Search.setEditable(true);
        text_Search.setBackground(Color.WHITE);

        JLabel jLabel_Username = new JLabel("Username: ");
        jLabel_Username.setFont(font_jLabel);
        text_Username = new JTextField("");
        text_Username.setFont(font_jTextField);
        text_Username.setEditable(false);
        text_Username.setBackground(Color.WHITE);

        JLabel jLabel_Password = new JLabel("Password: ");
        jLabel_Password.setFont(font_jLabel);
        text_Password = new JTextField("");
        text_Password.setFont(font_jTextField);
        text_Password.setEditable(true);
        text_Password.setBackground(Color.WHITE);

        jButton_Search = new JButton("Search");
        jButton_Search.setFont(font_jTextField);


        // Location
        JPanel jPanel_Details = new JPanel();
        jPanel_Details.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.2;
        jPanel_Details.add(jLabel_Search, c);
        c.gridy = 1;
        jPanel_Details.add(jLabel_Username, c);
        c.gridy = 2;
        jPanel_Details.add(jLabel_Password, c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.7;
        c.fill = GridBagConstraints.BOTH;
        jPanel_Details.add(text_Search, c);
        c.gridy = 1;
        jPanel_Details.add(text_Username, c);
        c.gridy = 2;
        jPanel_Details.add(text_Password, c);
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.1;
        jPanel_Details.add(jButton_Search, c);

        // Save
        jButton_Save = new JButton("Save");
        jButton_Save.setFont(font_jTextField);

        jButton_Delete = new JButton("Delete");
        jButton_Delete.setFont(font_jTextField);

        jButton_Cancel = new JButton("Cancel");
        jButton_Cancel.setFont(font_jTextField);

        JPanel jPanel_Button = new JPanel(new FlowLayout());
        jPanel_Button.add(jButton_Cancel);
        jPanel_Button.add(jButton_Delete);
        jPanel_Button.add(jButton_Save);

        // Layout
        this.setLayout(new BorderLayout());
        this.add(headerJPanel, BorderLayout.NORTH);
        this.add(jPanel_Details, BorderLayout.CENTER);
        this.add(jPanel_Button, BorderLayout.SOUTH);
    }

    // Getters and Setters
    public JTextField getText_Password() {
        return text_Password;
    }

    public void setText_Password(JTextField text_Password) {
        this.text_Password = text_Password;
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

    public JButton getjButton_Search() {
        return jButton_Search;
    }

    public void setjButton_Search(JButton jButton_Search) {
        this.jButton_Search = jButton_Search;
    }

    public JTextField getText_Search() {
        return text_Search;
    }

    public void setText_Search(JTextField text_Search) {
        this.text_Search = text_Search;
    }
    
    public JTextField getText_Username() {
        return text_Username;
    }

    public void setText_Username(JTextField text_Username) {
        this.text_Username = text_Username;
    }

    public account getAccs() {
        return accs;
    }

    public void setAccs(account accs) {
        this.accs = accs;
    }

    public JButton getjButton_Delete() {
        return jButton_Delete;
    }

    public void setjButton_Delete(JButton jButton_Delete) {
        this.jButton_Delete = jButton_Delete;
    }

    public void getInfor(account res) {
        this.accs = res;
        this.getText_Username().setText(this.accs.getUsername());
        this.getText_Password().setText(this.accs.getPassword());
    }

    public void SaveChanges() {
        this.accs.setUsername(this.getText_Username().getText());
        this.accs.setPassword(this.getText_Password().getText());
    }

    public void reset() {
        this.getText_Search().setText("");
        this.getText_Username().setText("");
        this.getText_Password().setText("");
    }
}