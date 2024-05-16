package ViewDoc;

import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ViewPatient.setIcon;

public class Menu extends JMenuBar{
	private JMenu menu, setting;
    private JMenuItem home, notification, information, search, profile, security, logout, exit;

    // Constructor
    public Menu() {
        this.menu = new JMenu("Menu");
        this.setting = new JMenu("Setting");
        this.home = new JMenuItem("Home");
        this.notification = new JMenuItem("Notification");
        this.information = new JMenuItem("Information");
        this.search = new JMenuItem("Search");
        this.profile = new JMenuItem("Profile");
        this.security = new JMenuItem("Security");
        this.logout = new JMenuItem("Log out");
        this.exit = new JMenuItem("Exit");
        this.run();
    }

    public void run() {
        // Font
        Font font = new Font("Segoe UI", Font.PLAIN, 12);
        this.menu.setFont(font);
        this.setting.setFont(font);
        this.home.setFont(font);
        this.notification.setFont(font);
        this.information.setFont(font);
        this.search.setFont(font);
        this.profile.setFont(font);
        this.security.setFont(font);
        this.logout.setFont(font);
        this.exit.setFont(font);

        // Icon
        this.home.setIcon(new setIcon().loadImage("resources/IconHome.png"));
        this.notification.setIcon(new setIcon().loadImage("resources/IconNotification.png"));
        this.information.setIcon(new setIcon().loadImage("resources/IconInformation.png"));
        this.search.setIcon(new setIcon().loadImage("resources/IconSearch.png"));
        this.profile.setIcon(new setIcon().loadImage("resources/IconProfile.png"));
        this.security.setIcon(new setIcon().loadImage("resources/IconSecurity.png"));
        this.logout.setIcon(new setIcon().loadImage("resources/IconLogOut.png"));
        this.exit.setIcon(new setIcon().loadImage("resources/IconExit.png"));

        // Add
        this.menu.add(home);
        this.menu.addSeparator();
        this.menu.add(this.notification);
        this.menu.addSeparator();
        this.menu.add(this.information);
        this.menu.addSeparator();
        this.menu.add(this.search);
        this.add(menu);
        this.setting.add(this.profile);
        this.setting.addSeparator();
        this.setting.add(this.security);
        this.setting.addSeparator();
        this.setting.add(this.logout);
        this.setting.addSeparator();
        this.setting.add(this.exit);
        this.add(setting);
    }

    // Getters and Setters
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

    public JMenuItem getNotification() {
        return notification;
    }

    public void setNotification(JMenuItem notification) {
        this.notification = notification;
    }

    public JMenuItem getInformation() {
        return information;
    }

    public void setInformation(JMenuItem information) {
        this.information = information;
    }

    public JMenuItem getProfile() {
        return profile;
    }

    public void setProfile(JMenuItem profile) {
        this.profile = profile;
    }

    public JMenuItem getSecurity() {
        return security;
    }

    public void setSecurity(JMenuItem security) {
        this.security = security;
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

    public JMenuItem getSearch() {
        return search;
    }

    public void setSearch(JMenuItem search) {
        this.search = search;
    }
}
