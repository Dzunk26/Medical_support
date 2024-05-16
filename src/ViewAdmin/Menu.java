package ViewAdmin;

import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	private JMenu menu, setting;
    private JMenuItem home, doctor, patient, account, logout, exit;
    private JMenu insert;
    private JMenuItem insertDoctor, insertPatient;

    public Menu() {
        this.menu = new JMenu("Menu");
        this.setting = new JMenu("Setting");
        this.home = new JMenuItem("Home");
        this.doctor = new JMenuItem("Doctor");
        this.patient = new JMenuItem("Patient");
        this.account = new JMenuItem("Account");
        this.logout = new JMenuItem("Log out");
        this.exit = new JMenuItem("Exit");
        this.insert = new JMenu("Insert");
        this.insertDoctor = new JMenuItem("Insert Doctor");
        this.insertPatient = new JMenuItem("Insert Patient");
        this.run();
    }

    public void run() {
        // Font
        Font font = new Font("Segoe UI", Font.PLAIN, 12);
        this.menu.setFont(font);
        this.setting.setFont(font);
        this.home.setFont(font);
        this.doctor.setFont(font);
        this.patient.setFont(font);
        this.account.setFont(font);
        this.logout.setFont(font);
        this.exit.setFont(font);
        this.insert.setFont(font);
        this.insertDoctor.setFont(font);
        this.insertPatient.setFont(font);

        // Icon

        // Add
        this.insert.add(insertDoctor);
        this.insert.addSeparator();
        this.insert.add(insertPatient);
        this.insert.addSeparator();
        this.menu.add(home);
        this.menu.addSeparator();
        this.menu.add(this.doctor);
        this.menu.addSeparator();
        this.menu.add(this.patient);
        this.menu.addSeparator();
        this.menu.add(this.account);
        this.menu.addSeparator();
        this.menu.add(this.insert);
        this.add(menu);
        this.setting.add(this.logout);
        this.setting.addSeparator();
        this.setting.add(this.exit);
        this.add(setting);
    }

    public JMenu getMenu() {
        return menu;
    }

    public void setMenu(JMenu menu) {
        this.menu = menu;
    }

    public JMenu getSetting() {
        return setting;
    }

    public void setSetting(JMenu setting) {
        this.setting = setting;
    }

    public JMenuItem getHome() {
        return home;
    }

    public void setHome(JMenuItem home) {
        this.home = home;
    }

    public JMenuItem getDoctor() {
        return doctor;
    }

    public void setDoctor(JMenuItem doctor) {
        this.doctor = doctor;
    }

    public JMenuItem getPatient() {
        return patient;
    }

    public void setPatient(JMenuItem patient) {
        this.patient = patient;
    }

    public JMenuItem getAccount() {
        return account;
    }

    public void setAccount(JMenuItem account) {
        this.account = account;
    }

    public JMenuItem getLogout() {
        return logout;
    }

    public void setLogout(JMenuItem logout) {
        this.logout = logout;
    }

    public JMenuItem getExit() {
        return exit;
    }

    public void setExit(JMenuItem exit) {
        this.exit = exit;
    }

    public JMenu getInsert() {
        return insert;
    }

    public void setInsert(JMenu insert) {
        this.insert = insert;
    }

    public JMenuItem getInsertDoctor() {
        return insertDoctor;
    }

    public void setInsertDoctor(JMenuItem insertDoctor) {
        this.insertDoctor = insertDoctor;
    }

    public JMenuItem getInsertPatient() {
        return insertPatient;
    }

    public void setInsertPatient(JMenuItem insertPatient) {
        this.insertPatient = insertPatient;
    }
}
