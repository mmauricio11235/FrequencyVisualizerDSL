package TestVisualizers;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import FrequencyVisualizerDSL.*;
import objectdraw.*;


/**
 * This is a simple example of using the Java Music Visualizer DSL
 * 
 * @author Mauricio Molina
 *
 */
public class TestVisualizer extends FrequencyVisualizerDSL{

	public static void main(String[] args) throws LineUnavailableException, IOException, 
	UnsupportedAudioFileException, InterruptedException {
		
		//Music files should be placed in the src folder and given as input in this format. 
		//Currently only supports AIFF, AU and WAV file formats. (MIDI as well but hasn't been tested) 
		setMusic("src/Ellie Goulding - Lights (MetroGnome ELECTRO REMIX).wav");
		
		//Background image is the web url to any image you want as a background
		setBackgroundImage("https://d1mi3s36zg393u.cloudfront.net/event/207483/og/"
		+ "97118d4d45c44a0a9361a1b2aba8370c.image!jpeg.288619.jpg.EDC-event-image.jpg");
		
		/** General Structure of the DSL is 
		 Time(start, end);
		 	Frequency(start,end);
		 		Image(imageDefinition);
		 			Effect(effectType);
		 
		 * start: value at which the given object starts controlling 
		 * end: value at which the given object no long has control
		 * 
		 */
		
		//Initial Twinkling
		Time(0,5);
			Frequency(0,100);
				Amplitude(0,100);	
				for (int i =0; i < 10; i++){		
					Image(new FilledOval(500,50,10,10, canvas));
						Effect("random");
				}
				
		//Additional twinkling
		Time(2.5,5);
			Frequency(40,50);
			Amplitude(0,100);	
			for (int i =0; i < 30; i++){	
				Image(new FilledOval(500,50,10,10, canvas));
					Effect("random");
			}
		Time(4,50);
			Frequency(40,50);
				Amplitude(0,100);	
				for (int i =0; i < 50; i++){	
					Image(new FilledOval(500,50,10,10, canvas));
						Effect("random");
					Image(new FilledOval(500,50,20,20, canvas));
						Effect("random");
				}
		
		//Frequency bars start animation. Each frequency definition represents a bar
		Time(5.7,100);
			Frequency(0,10);
				Amplitude(0,50);
					Image(new FilledRect(0,50,100,50, canvas));
						//Maybe use Enum instead of a string? 
						Effect("Bounce");
					Image(new FilledRect(50,50,100,50, canvas));
						Effect("Bounce");
			Frequency(10,20);
				Amplitude(0,100);
					Image(new FilledRect(100,50,100,50, canvas));
						Effect("Bounce");
			Frequency(20,30);
				Amplitude(0,100);
					Image(new FilledOval(300,50,100,50, canvas));
						Effect("Bounce");
			Frequency(30,40);
				Amplitude(0,100);	
					Image(new FilledRect(400,50,100,50, canvas));
						Effect("Bounce");
			Frequency(40,50);
				Amplitude(0,100);	
					Image(new FilledRect(500,50,100,50, canvas));
						Effect("bounce");
			Frequency(50,60);
				Amplitude(0,100);	
					Image(new FilledRect(600,50,100,50, canvas));
						Effect("Bounce");
			Frequency(60,70);
				Amplitude(0,100);	
					Image(new FilledRect(700,50,100,50, canvas));
						Effect("Bounce");
			Frequency(60,70);
				Amplitude(0,100);	
					Image(new FilledRect(800,50,100,50, canvas));
						Effect("Bounce");
			Frequency(60,70);
				Amplitude(0,100);	
					Image(new FilledRect(900,50,100,50, canvas));
						Effect("Bounce");
				
		//This is the required method that comes at the end of all the definitions. Will start the visualizer. 
		VisualizerStart();
		}
	}

