package ControllerAdmins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DataAccessObject.AccountDAO;
import ViewAdmin.Admin;

public class ControllerJPanelAccount implements ActionListener{
	private Admin viewAdmin;

    public ControllerJPanelAccount(Admin viewAdmin) {
        this.viewAdmin = viewAdmin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Search")) {
            if (AccountDAO.getInstance().checkID(this.viewAdmin.getAccount().getText_Search().getText())) {
                this.viewAdmin.getAccount().getInfor(AccountDAO.getInstance().getByID(this.viewAdmin.getAccount().getText_Search().getText()));
            } else {
                int choice = JOptionPane.showConfirmDialog(this.viewAdmin, "NOT EXIST !!!\nDo you want to find another account ?", "Search", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                this.viewAdmin.getAccount().reset();
                if (choice != 0) {
                    this.viewAdmin.showHome();
                }
            }
        } else if (s.equals("Cancel")) {
//            this.viewAdmin.getAccount().getInfor(this.viewAdmin.getAccount().getAccs());
            this.viewAdmin.showHome();
        } else if(s.equals("Save")) {
            this.viewAdmin.getAccount().SaveChanges();
            AccountDAO.getInstance().update(this.viewAdmin.getAccount().getAccs());
            JOptionPane.showMessageDialog(this.viewAdmin, "Successfull", "Save Changes", JOptionPane.INFORMATION_MESSAGE);
        } else if (s.equals("Delete")) {
            this.viewAdmin.getAccount().reset();
            AccountDAO.getInstance().delete(this.viewAdmin.getAccount().getAccs());
            JOptionPane.showMessageDialog(this.viewAdmin, "Successfull", "Delete", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
