package ViewPatient;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import model.musics;

public class notify extends JPanel{
	private CardLayout notifyLayout;
	private musics ringtones;
	private setIcon icon;
	
//	cac bien cua jpanel normal
	private JButton urgency;
	private JPanelBackground normal;
	private List<JLabel> clocks;
	private JLabel add;
	private List<JRadioButton> on_offs;
	private JScrollPane scp;
	
//	cac bien cua jpanel setclock
	private List<JPanelBackground> setclocks;
	private List<JCheckBox[]> dates;
	private List<JComboBox<String>> musics;
	private List<JSpinner> hours;
	private List<JSpinner> minutes;
	private List<JButton> saves;
	private List<JButton> cancels;
	
//	cac bien toan cuc
	int y=1;//set vi tri cho setclock
	Border lineborder = new LineBorder(Color.black);
	Border roundBorder = BorderFactory.createEmptyBorder(20, 200, 20, 200);

	public notify() {
		notifyLayout=new CardLayout();
		this.setLayout(notifyLayout);
		icon = new setIcon();
		normal();
		setclocks = new ArrayList<JPanelBackground>();
		saves = new ArrayList<JButton>();
		cancels = new ArrayList<JButton>();
		musics = new ArrayList<JComboBox<String>>();
		dates = new ArrayList<JCheckBox[]>();
		hours = new ArrayList<JSpinner>();
		minutes = new ArrayList<JSpinner>();
	}
	
	public void normal() {
//		khoi tao jpanel normal
		on_offs = new ArrayList<JRadioButton>();
		clocks = new ArrayList<JLabel>();
		normal = new JPanelBackground();
		normal.setBackground("resources/notify_bg.png");
		
		normal.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx=0;
		gc.gridy=0;
		gc.anchor=GridBagConstraints.WEST;
		
//		tao button urgency
		urgency = new JButton();
		urgency.setIcon(icon.loadImage("resources/bell1.png"));
		urgency.setRolloverIcon(icon.loadImage("resources/bell.png"));
		urgency.setBackground(new Color(0,0,0,0));
		urgency.setBorderPainted(false);
		urgency.setContentAreaFilled(false);
		normal.add(urgency,gc);
		
//		tao label add
		add = new JLabel("        ");
		add.setBackground(Color.white);
		add.setOpaque(true);
		add.setBorder(BorderFactory.createCompoundBorder(lineborder,roundBorder));
		add.setLayout(new BorderLayout());
		JLabel tmp = new JLabel();
		tmp.setIcon(icon.loadImage("resources/add.png"));
		add.add(tmp,BorderLayout.CENTER);
		gc.anchor=GridBagConstraints.CENTER;
		gc.gridwidth=2;
		gc.gridy=1;
		normal.add(add,gc);
		scp = new JScrollPane(normal);
		scp.setViewportView(normal);
		this.add(scp,"normal");
	}
	
	public void addSetClock() {

//		khoi tao jpanel setclock
		JPanelBackground setclock = new JPanelBackground();
		setclock.setLayout(new GridBagLayout());
		setclock.setBackground("resources/clock_bg.jpg");
		GridBagConstraints gc = new GridBagConstraints();
		ringtones = new musics();
		
//		tao panel1 chua tirhour, hour, tirminute, minute
		JPanel panel1 = new JPanel(new GridBagLayout());
		panel1.setBackground(new Color(0,0,0,0));
		gc.gridx=0;
		gc.gridy=0;
		gc.gridwidth=1;
		
//		tao jlabel tirhour
		JLabel tirhour = new JLabel("Hour");
		panel1.add(tirhour,gc);
		gc.gridy=1;
		
//		tao jspinner hour
		JSpinner hour = new JSpinner(new SpinnerNumberModel(0,0,23,1));
		hour.setFont(hour.getFont().deriveFont(16f));
		hour.setPreferredSize(new Dimension(170,hour.getPreferredSize().height));
		hours.add(hour);
		panel1.add(hours.get(hours.size()-1),gc);
		gc.gridx=1;
		gc.gridy=0;
		
//		tao jlabel tirminute
		JLabel tirminute = new JLabel("Minute");
		panel1.add(tirminute,gc);
		gc.gridy=1;
		
//		tao jspinner minute
		JSpinner minute = new JSpinner(new SpinnerNumberModel(0,0,59,1));
		minute.setFont(minute.getFont().deriveFont(16f));
		minute.setPreferredSize(new Dimension(170,minute.getPreferredSize().height));
		minutes.add(minute);
		panel1.add(minutes.get(minutes.size()-1),gc);
		gc.gridy=0;
		gc.gridx=0;
		gc.insets=new Insets(20,0,20,0);
		setclock.add(panel1,gc);
		
//		tao panel2 chua tirmusic, musics
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridBagLayout());
		panel2.setBackground(new Color(0,0,0,0));
		
//		tao jlabel tirmusic
		JLabel tirmusic = new JLabel("Ringtone: ");
		panel2.add(tirmusic,gc);
		
//		tao jcombobox musics
		
		JComboBox<String> music = new JComboBox<String>(ringtones.getListMusic());
		gc.gridx=1;
		musics.add(music);
		panel2.add(musics.get(musics.size()-1),gc);
		gc.gridy=1;
		gc.gridx=0;
		setclock.add(panel2,gc);
		
//		tao panel3 chua date, save, cancel
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridBagLayout());
		panel3.setBackground(new Color(0,0,0,0));
		panel3.setOpaque(false);
//		tao jcheckbox date chua cac ngay trong tuan
		JCheckBox date[] = new JCheckBox[7];
		dates.add(date);
		String days[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		gc.gridy=3;
		for(int i=0 ; i<=6 ; i++) {
			gc.gridx=i;
			date[i] = new JCheckBox(days[i]);
			date[i].setBackground(new Color(0, 0, 0, 0));
			date[i].setContentAreaFilled(false);
			dates.get(dates.size()-1)[i]=date[i];
			panel3.add(dates.get(dates.size()-1)[i],gc);
		}
		
		gc.gridy=4;
//		tao nut save
		JButton save = new JButton();
		save.setIcon(icon.loadImage("resources/save1.png"));
		save.setRolloverIcon(icon.loadImage("resources/save.png"));
		save.setBackground(new Color(0,0,0,0));
		save.setBorderPainted(false);
		save.setContentAreaFilled(false);
		saves.add(save);
		panel3.add(saves.get(saves.size()-1),gc);
		gc.gridx=0;
		
//		tao nut cancel
		JButton cancel = new JButton();
		cancel.setIcon(icon.loadImage("resources/cancel1.png"));
		cancel.setRolloverIcon(icon.loadImage("resources/cancel.png"));
		cancel.setBorderPainted(false);
		cancel.setContentAreaFilled(false);
		cancel.setFocusPainted(false);
		cancels.add(cancel);
		panel3.add(cancels.get(cancels.size()-1),gc);
		gc.gridy=2;
		gc.gridx=0;
		setclock.add(panel3,gc);
		setclocks.add(setclock);
		this.add(setclocks.get(setclocks.size()-1),"setclock"+(setclocks.size()-1));
	}
	
	/**
	 * them clock moi neu duoc goi
	 */
	public void addClock(int index) {
		GridBagConstraints gc = new GridBagConstraints();
		JLabel clock = new JLabel(getClockInfo(index));
		y+=1;
		gc.gridx=0;
		gc.gridy=y;
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.ipady=35;
		gc.weightx=0.9;
		clock.setFont(new Font("Arial", Font.PLAIN, 25));
		clock.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		clock.setBackground(Color.white);
		clock.setOpaque(true);
		clocks.add(clock);
		normal.add(clocks.get(clocks.size()-1),gc);
		gc.gridx=1;
		gc.weightx=0.1;
		JRadioButton on_off = new JRadioButton("On or Off");
		on_off.setBackground(Color.white);
		on_off.setFont(new Font("Arial", Font.PLAIN, 25));
		on_offs.add(on_off);
		normal.add(on_offs.get(on_offs.size()-1),gc);
	}
	
	/**
	 * dem so ngay duoc chon de lap lai dong ho
	 */
	public int countDays(int index) {
		int count=0;
		for(int i=0 ; i<7 ; i++) {
			if(dates.get(index)[i].isSelected())
				count++;
		}
		return count;
	}
	
	/**
	 * kiem tra xem dong ho co duoc set lap lai hay khong
	 */
	public boolean checkCountDays(int index) {
		if(countDays(index)==0)
			return true;
		return false;
	}
	
	/**
	 * tra ve thong tin cua dong ho
	 */
	public String getClockInfo(int index) {
		String time=hours.get(index).getValue() + ":" + minutes.get(index).getValue() + "    ";
		if(countDays(index)==0) time+="Ring once";
		else if(countDays(index)==7) time+="Every day";
		else
			for(int i=0 ; i<=6 ; i++)
				if(dates.get(index)[i].isSelected()) {
					time+=dates.get(index)[i].getText()+" ";
				}
		return time;
	}
	
	/**
	 * tra ve danh sach cac ngay hen bao thuc bao gom ca lap lai va khong lap lai
	 */
	public DayOfWeek[] getDaysOfWeek(int index) {
		DayOfWeek[] DayOfWeeks=null;
		LocalDateTime present = LocalDateTime.now();
		LocalDateTime clock = present.withHour((int)hours.get(index).getValue()).withMinute((int)minutes.get(index).getValue()).withSecond(0).withNano(0);
		if(checkCountDays(index)) {
			DayOfWeeks = new  DayOfWeek[1];
			if(clock.isAfter(present))
				DayOfWeeks[0]=DayOfWeek.from(present);
			else DayOfWeeks[0]=DayOfWeek.from(present.plusDays(1));
		}
		else {
			DayOfWeeks = new  DayOfWeek[countDays(index)];
			int j=0;
			for(int i=0 ; i<7 ; i++) {
				if(dates.get(index)[i].isSelected()) {
					DayOfWeeks[j] = DayOfWeek.of(i+1);
					j++;
				}
			}
		}
		return DayOfWeeks;
	}
	
	public CardLayout getnotifyLayout() {
		return notifyLayout;
	}
	
	public List<JPanelBackground> getListSetClock(){
		return setclocks;
	}
	
	public List<JLabel> getListClock() {
		return clocks;
	}
	
	public List<JSpinner> getHours() {
		return hours;
	}

	public List<JSpinner> getMinutes() {
		return minutes;
	}

	public List<JRadioButton> getOn_offs() {
		return on_offs;
	}
	
	public JLabel getAdd() {
		return add;
	}
	
	public List<JButton> getSave() {
		return saves;
	}
	
	public List<JButton> getCancel() {
		return cancels;
	}

	public List<JComboBox<String>> getMusics() {
		return musics;
	}

	public JButton getUrgency() {
		return urgency;
	}
}
