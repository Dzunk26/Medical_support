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
import javax.swing.JTextField;
import model.patients;

public class Search extends JPanel{
	private patients pas;
    private JTextField text_Search;
    private JButton jButton_Search;
    private JTextField text_Name;
    private JTextField text_Birh;
    private JTextField text_Sex;
    private JTextField text_Phone;
    private JTextField text_Room;
    private JTextField text_Building;
    private JTextField text_Disease;
    private JTextField text_SID;
    private JTextField text_Email;
    private JTextField text_Address;

    // Constructor
    public Search() {
        this.pas = new patients();
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
        JLabel headerInformation = new JLabel("Look up patient information");
        headerInformation.setFont(font_header);
        headerJPanel.add(headerInformation);

        // Details
        JLabel jLabel_SID = new JLabel("SI ID: ");
        jLabel_SID.setFont(font_jLabel);
        text_SID = new JTextField(this.pas.getName());
        text_SID.setFont(font_jTextField);
        text_SID.setEditable(false);
        text_SID.setBackground(Color.WHITE);

        JLabel jLabel_Name = new JLabel("Name: ");
        jLabel_Name.setFont(font_jLabel);
        text_Name = new JTextField(this.pas.getName());
        text_Name.setFont(font_jTextField);
        text_Name.setEditable(false);
        text_Name.setBackground(Color.WHITE);

        JLabel jLabel_Birth = new JLabel("Birth: ");
        jLabel_Birth.setFont(font_jLabel);
        text_Birh = new JTextField(this.pas.getBirth().toString());
        text_Birh.setFont(font_jTextField);
        text_Birh.setEditable(false);
        text_Birh.setBackground(Color.WHITE);

        JLabel jLabel_Sex = new JLabel("Sex: ");
        jLabel_Sex.setFont(font_jLabel);
        text_Sex = new JTextField(this.pas.getSex());
        text_Sex.setFont(font_jTextField);
        text_Sex.setEditable(false);
        text_Sex.setBackground(Color.WHITE);

        JLabel jLabel_Phone = new JLabel("Phone: ");
        jLabel_Phone.setFont(font_jLabel);
        text_Phone = new JTextField(this.pas.getPhone());
        text_Phone.setFont(font_jTextField);
        text_Phone.setEditable(false);
        text_Phone.setBackground(Color.WHITE);

        JLabel jLabel_Email = new JLabel("Email: ");
        jLabel_Email.setFont(font_jLabel);
        text_Email = new JTextField(this.pas.getEmail());
        text_Email.setFont(font_jTextField);
        text_Email.setEditable(false);
        text_Email.setBackground(Color.WHITE);

        JLabel jLabel_Address = new JLabel("Address: ");
        jLabel_Address.setFont(font_jLabel);
        text_Address = new JTextField(this.pas.getName());
        text_Address.setFont(font_jTextField);
        text_Address.setEditable(false);
        text_Address.setBackground(Color.WHITE);

        JLabel jLabel_Room = new JLabel("Room: ");
        jLabel_Room.setFont(font_jLabel);
        text_Room = new JTextField(this.pas.getRoom());
        text_Room.setFont(font_jTextField);
        text_Room.setEditable(false);
        text_Room.setBackground(Color.WHITE);

        JLabel jLabel_Building = new JLabel("Building: ");
        jLabel_Building.setFont(font_jLabel);
        text_Building = new JTextField(this.pas.getBuilding());
        text_Building.setFont(font_jTextField);
        text_Building.setEditable(false);
        text_Building.setBackground(Color.WHITE);

        JLabel jLabel_Disease = new JLabel("Disease: ");
        jLabel_Disease.setFont(font_jLabel);
        text_Disease = new JTextField(this.pas.getDisease());
        text_Disease.setFont(font_jTextField);
        text_Disease.setEditable(false);
        text_Disease.setBackground(Color.WHITE);

        JLabel jLabel_Search = new JLabel("Enter ID's patient: ");
        jLabel_Search.setFont(font_jLabel);
        text_Search = new JTextField();
        text_Search.setFont(font_jTextField);
        text_Search.setEditable(true);
        text_Search.setBackground(Color.WHITE);

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
        c.weightx = 0.1;
        jPanel_Details.add(jLabel_Search, c);
        c.gridy = 1;
        jPanel_Details.add(jLabel_SID, c);
        c.gridy = 2;
        jPanel_Details.add(jLabel_Name, c);
        c.gridy = 3;
        jPanel_Details.add(jLabel_Birth, c);
        c.gridy = 4;
        jPanel_Details.add(jLabel_Sex, c);
        c.gridy = 5;
        jPanel_Details.add(jLabel_Disease, c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.4;
        c.fill = GridBagConstraints.BOTH;
        jPanel_Details.add(text_Search, c);
        c.gridy = 1;
        jPanel_Details.add(text_SID, c);
        c.gridy = 2;
        jPanel_Details.add(text_Name, c);
        c.gridy = 3;
        jPanel_Details.add(text_Birh, c);
        c.gridy = 4;
        jPanel_Details.add(text_Sex, c);
        c.gridy = 5;
        jPanel_Details.add(text_Disease, c);
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.1;
        jPanel_Details.add(jButton_Search, c);
        c.gridy = 1;
        jPanel_Details.add(jLabel_Phone, c);
        c.gridy = 2;
        jPanel_Details.add(jLabel_Email, c);
        c.gridy = 3;
        jPanel_Details.add(jLabel_Address, c);
        c.gridy = 4;
        jPanel_Details.add(jLabel_Room, c);
        c.gridy = 5;
        jPanel_Details.add(jLabel_Building, c);
        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 0.4;
        c.fill = GridBagConstraints.BOTH;
        jPanel_Details.add(text_Phone, c);
        c.gridy = 2;
        jPanel_Details.add(text_Email, c);
        c.gridy = 3;
        jPanel_Details.add(text_Address, c);
        c.gridy = 4;
        jPanel_Details.add(text_Room, c);
        c.gridy = 5;
        jPanel_Details.add(text_Building, c);


        
        // Layout
        this.setLayout(new BorderLayout());

        // Add
        this.add(headerJPanel, BorderLayout.NORTH);
        this.add(jPanel_Details, BorderLayout.CENTER);
    }
    
    // Getters and Setters
    public patients getPas() {
        return pas;
    }

    public void setPas(patients pas) {
        this.pas = pas;
    }

    public JTextField getText_Search() {
        return text_Search;
    }

    public void setText_Search(JTextField text_Search) {
        this.text_Search = text_Search;
    }

    public JButton getjButton_Search() {
        return jButton_Search;
    }

    public void setjButton_Search(JButton jButton_Search) {
        this.jButton_Search = jButton_Search;
    }

    public JTextField getText_Name() {
        return text_Name;
    }

    public void setText_Name(JTextField text_Name) {
        this.text_Name = text_Name;
    }

    public JTextField getText_Birh() {
        return text_Birh;
    }

    public void setText_Birh(JTextField text_Birh) {
        this.text_Birh = text_Birh;
    }

    public JTextField getText_Sex() {
        return text_Sex;
    }

    public void setText_Sex(JTextField text_Sex) {
        this.text_Sex = text_Sex;
    }

    public JTextField getText_Phone() {
        return text_Phone;
    }

    public void setText_Phone(JTextField text_Phone) {
        this.text_Phone = text_Phone;
    }

    public JTextField getText_Room() {
        return text_Room;
    }

    public void setText_Room(JTextField text_Room) {
        this.text_Room = text_Room;
    }

    public JTextField getText_Building() {
        return text_Building;
    }

    public void setText_Building(JTextField text_Building) {
        this.text_Building = text_Building;
    }

    public JTextField getText_SID() {
        return text_SID;
    }

    public void setText_SID(JTextField text_SID) {
        this.text_SID = text_SID;
    }

    public JTextField getText_Email() {
        return text_Email;
    }

    public void setText_Email(JTextField text_Email) {
        this.text_Email = text_Email;
    }

    public JTextField getText_Address() {
        return text_Address;
    }

    public void setText_Address(JTextField text_Address) {
        this.text_Address = text_Address;
    }

    public JTextField getText_Disease() {
        return text_Disease;
    }

    public void setText_Disease(JTextField text_Disease) {
        this.text_Disease = text_Disease;
    }
    
    public String getIDSearch() {
    	return text_Search.getText();
    }

    // getInfor
    public void getInfor(patients res) {
        this.pas = res;
        this.getText_SID().setText(this.pas.getSid());
        this.getText_Name().setText(this.pas.getName());
        this.getText_Birh().setText(this.pas.getBirth().toString());
        this.getText_Sex().setText(this.pas.getSex());
        this.getText_Phone().setText(this.pas.getPhone());
        this.getText_Email().setText(this.pas.getEmail());
        this.getText_Address().setText(this.pas.getAddress());
        this.getText_Room().setText(this.pas.getRoom());
        this.getText_Building().setText(this.pas.getBuilding());
        this.getText_Disease().setText(this.pas.getDisease());
    }
    
    public void reset() {
    	this.getText_Search().setText("");
        this.getText_SID().setText("");
        this.getText_Name().setText("");
        this.getText_Birh().setText("");
        this.getText_Sex().setText("");
        this.getText_Phone().setText("");
        this.getText_Email().setText("");
        this.getText_Address().setText("");
        this.getText_Room().setText("");
        this.getText_Building().setText("");
        this.getText_Room().setText("");
        this.getText_Building().setText("");
        this.getText_Disease().setText("");
    }
}
