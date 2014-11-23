package FrequencyVisualizerDSL;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.*;


public class musicCalc implements Runnable{
	static Mixer.Info[] listOfMixers = AudioSystem.getMixerInfo();
	static Clip clip;
	static Line line; 
	static FloatControl pan, volume, sampleRate; 
	static int[][] graphData;
	static double durationInSeconds;
	
	public musicCalc(String musicFileLocation) throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException {
		// Open the example music file
		String musicFile = musicFileLocation;
		File file = new File(musicFile);
			
		if(file.exists()){	
			
			clip = AudioSystem.getClip();
			line = AudioSystem.getLine(clip.getLineInfo());
			AudioInputStream ais = AudioSystem.getAudioInputStream(file.toURI().toURL());
			long frames = ais.getFrameLength();
			AudioFormat format = ais.getFormat();
			durationInSeconds = (frames+0.0) / format.getFrameRate(); 
	        clip.open(ais);
	        int i = 0;
	        volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			sampleRate = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			System.out.println(sampleRate);
			System.out.println("FILE EXISTS!!");
			
			//Get the currentVolume: 
			//volume.setValue(1.0f);
			//volume.getValue();
		}
		else{
			System.out.println("FILE DOES NOT EXIST");
		}			
	}
	
	/*
	 * Plays the sound clip. 
	 */
	public static void play() throws InterruptedException{
		clip.setFramePosition(0);
		volume.setValue((float) -20 );
		clip.start();
		
		
		while(clip.getMicrosecondLength() != clip.getMicrosecondPosition())
		{
		}
		
		pan = (FloatControl) clip.getControl(FloatControl.Type.PAN);
		clip.close();
	}
	
	/*
	 * TO-DO
	 * 
	 * Ideally gives the user the option of having
	 * the sound loop instead of exiting when done. 
	 */
	public void loop(){
		
	}
	
	/*
	 * Returns the run time of the song. Used to normalize 
	 * time to range 0 - 100
	 */
	public double playTimeInSeconds(){
		return durationInSeconds;
	}
	
	/*
	 * Plays the sound clip
	 * @see java.lang.Runnable#run()
	 */
	public void run(){
		try {
			System.out.println("Started Playing music successfully");
			play();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
