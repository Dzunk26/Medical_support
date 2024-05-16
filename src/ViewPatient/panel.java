package ViewPatient;

import java.awt.CardLayout;
import java.time.DayOfWeek;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import model.patients;

public class panel extends JPanel{
	private setting psetting;
	private notify pnotify;
	private info pinfo;
	private CardLayout card;
	
	public panel() {
		card=new CardLayout();
		this.setLayout(card);
		pnotify = new notify();
		this.add(pnotify,"notify");
		pinfo = new info();
		this.add(pinfo,"info");
		psetting = new setting();
		this.add(psetting,"setting");
	}
	
	public panel(setting jsetting, notify jnotify, info jinfo) {
		super();
		this.psetting = jsetting;
		this.pnotify = jnotify;
		this.pinfo = jinfo;
	}
	
	public void callAddClock(int index) {
		pnotify.addClock(index);
	}
	
	public CardLayout getCard() {
		return card;
	}
	
	public void callAddSetClock() {
		pnotify.addSetClock();
	}
	
//	getter cac thuoc tinh cua jsetting
	public JPanel getPsetting() {
		return psetting;
	}

	public JButton getSetProButton() {
		return psetting.getSetPro();
	}
	
	public JButton getSaveSetPro() {
		return psetting.getSaveProPanel();
	}
	
	public JButton getCancelSetPro() {
		return psetting.getCancelProPanel();
	}
	
	public JTextField[] getContentSetting() {
		return psetting.getContent();
	}
	
	public JButton getChangePassButton() {
		return psetting.getChangePass();
	}
	
	public JButton getSaveChangePass() {
		return psetting.getSaveChangePassPanel();
	}
	
	public JButton getCancelChangePass() {
		return psetting.getCancelChangePassPanel();
	}
	
	public JButton getLogOutButton() {
		return psetting.getLogOut();
	}
	
	public CardLayout getSetLayout() {
		return psetting.getSettingLayout();
	}
	
	public String getOldPassword() {
		return psetting.getOldPass();
	}
	
	public String getNewPassword() {
		return psetting.getNewPass();
	}
	
	public String getRe_NewPassword() {
		return psetting.getRe_NewPass();
	}
	
	public void setPasSetting(patients res) {
		psetting.setPas(res);
	}
	
	public patients getPasSetting() {
		return psetting.getPas();
	}
	
	public void getNewInforSetting() {
		psetting.getNewInfor();
	}
	
	public void getPatientSetting() {
		psetting.getInfor();
	}
	
	public void resetChangePass() {
		psetting.reset();
	}
	
	public boolean checkBirthForm(String birth) {
		return psetting.checkBirth(birth);
	}
	
	public boolean checkEmailForm(String email) {
		return psetting.checkEmail(email);
	}
	
	public boolean checkPhoneForm(String phone) {
		return psetting.checkPhone(phone);
	}
//	getter cac thuoc tinh cua jnotify
	public JPanel getPnotify() {
		return pnotify;
	}

	public DayOfWeek[] getTimetable(int index) {
		return pnotify.getDaysOfWeek(index);
	}
	
	public JLabel getAddLabel() {
		return pnotify.getAdd();
	}
	
	public String getClockInfomation(int index) {
		return pnotify.getClockInfo(index);
	}
	
	public JLabel getClock(int i) {
		return pnotify.getListClock().get(i);
	}
	
	public List<JPanelBackground> getListSetClockPanel(){
		return pnotify.getListSetClock();
	}
	
	public JSpinner getClockHour(int index) {
		return pnotify.getHours().get(index);
	}

	public JSpinner getClocksMinute(int index) {
		return pnotify.getMinutes().get(index);
	}
	
	public List<JLabel> getListClockLabel() {
		return pnotify.getListClock();
	}
	
	public List<JRadioButton> getListOn_offs(){
		return pnotify.getOn_offs();
	}
	
	public JRadioButton getOn_off(int i) {
		return pnotify.getOn_offs().get(i);
	}
	
	public List<JButton> getSaveButton() {
		return pnotify.getSave();
	}

	public List<JButton> getCancelButton() {
		return pnotify.getCancel();
	}
	
	public CardLayout getNotifyLayout() {
		return pnotify.getnotifyLayout();
	}
	public JComboBox<String> getListMusic(int index){
		return pnotify.getMusics().get(index);
	}
	
	public boolean checkCountDaysRepeat(int index) {
		return pnotify.checkCountDays(index);
	}
	
	public JButton getUrgenccyButton() {
		return pnotify.getUrgency();
	}
//	getter cac thuoc tinh cua jinfo
	public JPanel getPinfo() {
		return pinfo;
	}
	
	public JTextField[] getContentInfo() {
		return pinfo.getContent();
	}
	
	public void setPasInfor(patients res) {
		pinfo.setPas(res);
	}
	
	public void getPatientInfor() {
		pinfo.getInfor();
	}
}
