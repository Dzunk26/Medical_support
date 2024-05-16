package ViewPatient;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class menu extends JMenuBar{
	private JMenuItem msetting;
	private JMenuItem mnotify;
	private JMenuItem minfo;
	
	public menu() {
		mnotify = new JMenuItem("Notify");
		minfo = new JMenuItem("Infomation");
		msetting = new JMenuItem("Setting");
		this.add(mnotify);
		this.add(minfo);
		this.add(msetting);
	}

	public JMenuItem getMsetting() {
		return msetting;
	}

	public JMenuItem getMnotify() {
		return mnotify;
	}

	public JMenuItem getMinfo() {
		return minfo;
	}
}
