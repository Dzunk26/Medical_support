package ViewAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.patients;

public class JPanelPatient extends JPanel{
	private patients pas;
    private JTextField text_Search;
    private JTextField text_Name;
    private JTextField text_Birh;
    private JComboBox<String> text_Sex;
    private JTextField text_Phone;
    private JTextField text_Room;
    private JTextField text_Building;
    private JTextField text_Disease;
    private JTextField text_SID;
    private JTextField text_Email;
    private JTextField text_Address;
    private JButton jButton_Search;
    private JButton jButton_Save;
    private JButton jButton_Cancel;
    private JButton jButton_Delete;

    // Constructor
    public JPanelPatient() {
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
        JLabel headerInformation = new JLabel("Patient");
        headerInformation.setFont(font_header);
        headerJPanel.add(headerInformation);

        // Details
        JLabel jLabel_SID = new JLabel("SI ID: ");
        jLabel_SID.setFont(font_jLabel);
        text_SID = new JTextField(this.pas.getName(),15);
        text_SID.setFont(font_jTextField);
        text_SID.setEditable(true);
        text_SID.setBackground(Color.WHITE);

        JLabel jLabel_Name = new JLabel("Name: ");
        jLabel_Name.setFont(font_jLabel);
        text_Name = new JTextField(this.pas.getName(),15);
        text_Name.setFont(font_jTextField);
        text_Name.setEditable(true);
        text_Name.setBackground(Color.WHITE);

        JLabel jLabel_Birth = new JLabel("Birth: ");
        jLabel_Birth.setFont(font_jLabel);
        text_Birh = new JTextField(this.pas.getBirth().toString(),15);
        text_Birh.setFont(font_jTextField);
        text_Birh.setEditable(true);
        text_Birh.setBackground(Color.WHITE);

        JLabel jLabel_Sex = new JLabel("Sex: ");
        jLabel_Sex.setFont(font_jLabel);
        String sex[] = {"Nam", "Nữ"};
        text_Sex = new JComboBox<String>(sex);
        text_Sex.setPreferredSize(new Dimension(156,23));
        text_Sex.setSelectedItem(pas.getSex());
        text_Sex.setFont(font_jTextField);
        text_Sex.setBackground(Color.WHITE);

        JLabel jLabel_Phone = new JLabel("Phone: ");
        jLabel_Phone.setFont(font_jLabel);
        text_Phone = new JTextField(this.pas.getPhone(),15);
        text_Phone.setFont(font_jTextField);
        text_Phone.setEditable(true);
        text_Phone.setBackground(Color.WHITE);

        JLabel jLabel_Email = new JLabel("Email: ");
        jLabel_Email.setFont(font_jLabel);
        text_Email = new JTextField(this.pas.getEmail(),15);
        text_Email.setFont(font_jTextField);
        text_Email.setEditable(true);
        text_Email.setBackground(Color.WHITE);

        JLabel jLabel_Address = new JLabel("Address: ");
        jLabel_Address.setFont(font_jLabel);
        text_Address = new JTextField(this.pas.getName(),15);
        text_Address.setFont(font_jTextField);
        text_Address.setEditable(true);
        text_Address.setBackground(Color.WHITE);

        JLabel jLabel_Room = new JLabel("Room: ");
        jLabel_Room.setFont(font_jLabel);
        text_Room = new JTextField(this.pas.getRoom(),15);
        text_Room.setFont(font_jTextField);
        text_Room.setEditable(true);
        text_Room.setBackground(Color.WHITE);

        JLabel jLabel_Building = new JLabel("Building: ");
        jLabel_Building.setFont(font_jLabel);
        text_Building = new JTextField(this.pas.getBuilding(),15);
        text_Building.setFont(font_jTextField);
        text_Building.setEditable(true);
        text_Building.setBackground(Color.WHITE);

        JLabel jLabel_Disease = new JLabel("Disease: ");
        jLabel_Disease.setFont(font_jLabel);
        text_Disease = new JTextField(this.pas.getDisease(),15);
        text_Disease.setFont(font_jTextField);
        text_Disease.setEditable(true);
        text_Disease.setBackground(Color.WHITE);

        JLabel jLabel_Search = new JLabel("Patient's ID: ");
        jLabel_Search.setFont(font_jLabel);
        text_Search = new JTextField(15);
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
        c.weightx=0.1;
        c.gridwidth=5;
        jPanel_Details.add(jLabel_Search, c);
        c.gridwidth=1;
        c.weightx=0.1;
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
        jPanel_Details.add(text_Phone, c);
        c.gridy = 2;
        jPanel_Details.add(text_Email, c);
        c.gridy = 3;
        jPanel_Details.add(text_Address, c);
        c.gridy = 4;
        jPanel_Details.add(text_Room, c);
        c.gridy = 5;
        jPanel_Details.add(text_Building, c);


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

        // Add
        this.add(headerJPanel, BorderLayout.NORTH);
        this.add(jPanel_Details, BorderLayout.CENTER);
        this.add(jPanel_Button, BorderLayout.SOUTH);
    }
    
    // Getters and Setters
    public patients getPas() {
        return pas;
    }

    public void setModelSearch(patients modelSearch) {
        this.pas = modelSearch;
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

    public JComboBox<String> getText_Sex() {
        return text_Sex;
    }

    public void setText_Sex(JComboBox<String> text_Sex) {
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

    public JButton getjButton_Delete() {
        return jButton_Delete;
    }

    public void setjButton_Delete(JButton jButton_Delete) {
        this.jButton_Delete = jButton_Delete;
    }

    // getInfor
    public void getInfor(patients res) {
        this.pas = res;
        this.getText_SID().setText(this.pas.getSid());
        this.getText_Name().setText(this.pas.getName());
        this.getText_Birh().setText(this.pas.getBirth().toString());
        this.getText_Sex().setSelectedItem(this.pas.getSex());
        this.getText_Phone().setText(this.pas.getPhone());
        this.getText_Email().setText(this.pas.getEmail());
        this.getText_Address().setText(this.pas.getAddress());
        this.getText_Room().setText(this.pas.getRoom());
        this.getText_Building().setText(this.pas.getBuilding());
        this.getText_Disease().setText(this.pas.getDisease());
    }

    // Save changes
    public void Save() {
    	LocalDate lc = LocalDate.parse(this.getText_Birh().getText());
    	Date date = Date.valueOf(lc);
        this.getPas().setId(this.getText_Search().getText());
        this.getPas().setSid(this.getText_SID().getText());
        this.getPas().setName(this.getText_Name().getText());
        this.getPas().setBirth(date);
        this.getPas().setSex(this.getText_Sex().getSelectedItem().toString());
        this.getPas().setPhone(this.getText_Phone().getText());
        this.getPas().setAddress(this.getText_Address().getText());
        this.getPas().setRoom(this.getText_Room().getText());
        this.getPas().setBuilding(this.getText_Building().getText());
        this.getPas().setDisease(this.getText_Disease().getText());
    }

    public void reset() {
        this.getText_Search().setText("");
        this.getText_SID().setText("");
        this.getText_Name().setText("");
        this.getText_Birh().setText("");
        this.getText_Phone().setText("");
        this.getText_Email().setText("");
        this.getText_Address().setText("");
        this.getText_Room().setText("");
        this.getText_Building().setText("");
        this.getText_Disease().setText("");
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
