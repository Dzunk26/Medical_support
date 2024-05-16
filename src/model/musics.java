package model;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class musics{
	private Clip music;
	private String[] listMusic;
	
	public musics() {
		File file = new File("sounds");
		File[] files = file.listFiles();
		listMusic = new String[files.length];
		if(files!=null)
			for(int i=0 ; i<files.length ; i++)
				listMusic[i]=files[i].getName();
	}
	
	/**
	 * mo file audio
	 */
	public void playMusic(String name) {
		AudioInputStream audio;
		try {
			audio = AudioSystem.getAudioInputStream(new File("sounds/"+name));
			music=AudioSystem.getClip();
			music.open(audio);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public String[] getListMusic() {
		return listMusic;
	}

	public Clip getMusic() {
		return music;
	}
}
