import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;


public class musicCalc {
	static Mixer.Info[] listOfMixers = AudioSystem.getMixerInfo();
	static Clip clip;
	static Line line; 
	static FloatControl pan, volume, sampleRate; 
	static int[][] graphData;
	
	public musicCalc() throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException{
		// Open the example music file
				String musicFile = "C:\\Users\\Mauricio\\workspace\\SoundPracticex\\src\\Fun.wav";
				File file = new File(musicFile);
				
				//This is code from http://stackoverflow.com/questions/4708613/graphing-the-pitch-frequency-of-a-sound
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(musicFile)));
				byte[] bytes = new byte[(int) (audioInputStream.getFrameLength()) * (audioInputStream.getFormat().getFrameSize())];
				audioInputStream.read(bytes);
				graphData = getUnscaledAmplitude(bytes, 3);

				
				if(file.exists()){	
				
				clip = AudioSystem.getClip();
				line = AudioSystem.getLine(clip.getLineInfo());
				AudioInputStream ais = AudioSystem.getAudioInputStream(file.toURI().toURL());
				
		        clip.open(ais);
		        int i = 0;
		        volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				sampleRate = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				System.out.println(sampleRate);
		        play();
		        
//		        clip.start();
		        
		        //clip.drain();
				//clip.close();
				System.out.println("FILE EXISTS!!");
				}
				else{
					System.out.println("FILE DOES NOT EXIST");
				}
				
				
				
				volume.setValue(1.0f);
				//Get the currentVolume: 
				volume.getValue();
	}
	
	public static void play() throws InterruptedException{
		clip.setFramePosition(0);
		volume.setValue((float) -20 );
		clip.start();
		pan = (FloatControl) clip.getControl(FloatControl.Type.PAN);
		
		int i = 0;
		while(i < 100000000){
        	
        	i++;
        	System.out.println("This is a pan: " + pan);
        	System.out.println(volume);
        	System.out.println(sampleRate);
        	System.out.println(Math.sqrt(Math.abs(graphData[0][i])));
		}
		clip.drain();
		clip.close();
	}
	
	public void loop(){
		
	}
	public static int[][] getUnscaledAmplitude(byte[] eightBitByteArray, int nbChannels)
	{
	    int[][] toReturn = new int[nbChannels][eightBitByteArray.length / (2 * nbChannels)];
	    int index = 0;

	    for (int audioByte = 0; audioByte < eightBitByteArray.length;)
	    {
	        for (int channel = 0; channel < nbChannels; channel++)
	        {
	            // Do the byte to sample conversion.
	            int low = (int) eightBitByteArray[audioByte];
	            audioByte++;
	            int high = (int) eightBitByteArray[audioByte];
	            audioByte++;
	            int sample = (high << 8) + (low & 0x00ff);

	            toReturn[channel][index] = sample;
	        }
	        index++;
	    }

	    return toReturn;
	}
	

}
