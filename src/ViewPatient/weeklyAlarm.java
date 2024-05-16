package ViewPatient;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import model.musics;

public class weeklyAlarm {
	private Timer timer;
	private LocalDateTime times;
	private DayOfWeek dayofweeks[];
	private musics sound;
	private alarmView alarm;
	private static Semaphore sem = new Semaphore(1);
	
	public weeklyAlarm(DayOfWeek[] dayofweeks) {
		super();
		this.dayofweeks = dayofweeks;
		sound = new musics();
		alarm = new alarmView();
	}
	
//	lap lich cho dong ho keu lap lai
	public void startRepeat(int hour, int minute, String name) {
		timer = new Timer();
		sound.playMusic(name);
		alarm.getClock().setText(hour+":"+minute+" Alarm"+"    ");
		for(DayOfWeek dayofweek:dayofweeks) {
			getFirstTime(hour, minute, dayofweek);
			TimerTask task = new TimerTask() {
				public void run() {
					try {
						sem.acquire();
						alarm.setVisible(true);
						sound.getMusic().start();
						sound.getMusic().addLineListener(new LineListener() {
							@Override
							public void update(LineEvent event) {
								if (event.getType() == javax.sound.sampled.LineEvent.Type.STOP) {
									sound.getMusic().close();
									sem.release();
									alarm.setVisible(false);
					        	}
							}
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
//			lap lich lap lai sau 1 tuan
			timer.scheduleAtFixedRate(task, Timestamp.valueOf(times), 7*24*60*60*1000);
		}
	}
	
//	lap lich cho dong ho keu 1 lan duy nhat
	public void startNotRepeat(int hour, int minute, String name) {
		timer = new Timer();
		sound.playMusic(name);
		alarm.getClock().setText(hour+":"+minute+" Alarm"+"    ");
		getFirstTime(hour, minute, dayofweeks[0]);
		TimerTask task = new TimerTask() {
			public void run() {
				try {
					sem.acquire();
					alarm.setVisible(true);
					sound.getMusic().start();
					sound.getMusic().addLineListener(new LineListener() {
						@Override
						public void update(LineEvent event) {
							if (event.getType() == javax.sound.sampled.LineEvent.Type.STOP) {
								sound.getMusic().close();
								alarm.dispose();
								sem.release();
				        	}
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		timer.schedule(task, Timestamp.valueOf(times));
	}
	
//	tra ve thoi gian dau tien ma dong ho keu
	public void getFirstTime(int hour, int minute, DayOfWeek dayofweek) {
		LocalDateTime present = LocalDateTime.now();
		times = present.withHour(hour).withMinute(minute).withSecond(0).withNano(0);
		DayOfWeek currentday = DayOfWeek.from(present);
		int daytmp=0;
		if(dayofweek.getValue()<currentday.getValue())
			daytmp=7-(currentday.getValue()-dayofweek.getValue());
		else if(dayofweek.getValue()>currentday.getValue())
			daytmp=dayofweek.getValue()-currentday.getValue();
		else {
			if(times.isBefore(present))
				daytmp=7;
		}
		times=times.plusDays(daytmp);
	}

	public Timer getTimer() {
		return timer;
	}

	public alarmView getAlarm() {
		return alarm;
	}

	public musics getSound() {
		return sound;
	}
}