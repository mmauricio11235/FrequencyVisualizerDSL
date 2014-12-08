package TestVisualizers;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import FrequencyVisualizerDSL.*;
import objectdraw.*;

public class TestVisualizer extends FrequencyVisualizerDSL{
	//What about having GUIs? Have sliders and allow people to place object they want to be animated
	
	
	public static void main(String[] args) throws LineUnavailableException, IOException, 
	UnsupportedAudioFileException, InterruptedException {
		
		setMusic("src/Ellie Goulding - Lights (MetroGnome ELECTRO REMIX).wav");
		setBackgroundImage("https://d1mi3s36zg393u.cloudfront.net/event/207483/og/"
		+ "97118d4d45c44a0a9361a1b2aba8370c.image!jpeg.288619.jpg.EDC-event-image.jpg");
		
		/**
		 * Not sure if I want to give users this ability. Would be kinda cool	
		 */
		//setDimensions();
		
		//Cool time to start is 5ish. That's where beat starts.
		
		Time(0,100);
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
					Effect("random");
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
					
		VisualizerStart();
		
				
		
		
		/**
		 * Example of similar code using java for loop. 			
		 */
//		Time(0,50);
//		for(int i = 0; i <= 100; i+=10){
//			Frequency(i, i+10);
//				Amplitude(0,100);
//				for(int j = 0; j < 1000; j+=50){
//					Image(new FilledRect(j,50,50,50, canvas));
//						Effect("Bounce");					
//				}
//
//		}
			
		
	}
	}

