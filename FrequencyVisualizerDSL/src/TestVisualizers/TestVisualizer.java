package TestVisualizers;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import FrequencyVisualizerDSL.*;
import objectdraw.*;

public class TestVisualizer extends FrequencyVisualizerDSL{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException {
		
		//setMusic("C:\\Users\\Mauricio\\workspace\\SoundPracticex\\src\\Fun.wav");
		//createVisualizer(500,500);
		
		
		Time(0,50);
			Frequency(0,50);
				Amplitude(0,100);
					Image();
					Effect("Bounce");
			Frequency(50,100);
				Amplitude(0,100);
					Effect("Bounce");
					
		Time(50,100);
			Frequency(0,50);
				Amplitude(0,50);
					Effect("Bounce");
					Effect("Bounce");
			Frequency(0,50);
				Amplitude(50,100);
					Effect("Bounce");
					Effect("Bounce");
	}

}
