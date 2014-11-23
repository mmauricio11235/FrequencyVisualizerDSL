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
		setMusic("src/Fun.wav");
		setBackgroundImage("https://d1mi3s36zg393u.cloudfront.net/event/207483/og/97118d4d45c44a0a9361a1b2aba8370c.image!jpeg.288619.jpg.EDC-event-image.jpg");
		
		Time(0,50);
			for(int i = 50; i < 1000; i+=50){
				Image(new FilledRect(i,50,50,50, canvas));
			}
//			Frequency(0,10);
//				Amplitude(0,100);
//					Image(new FilledRect(500,50,50,50, canvas));
//					Effect("Stretch");
//			Frequency(10,20);
//				Amplitude(0,100);
//					Effect("Bounce");
//			Frequency(20,30);
//				Amplitude(0,100);
//					Image(new FilledRect(50,50,50,50, canvas));
//					Effect("Bounce");
//			Frequency(30,50);
//				Amplitude(0,100);
//					Effect("Bounce");
//			Frequency(0,10);
//				Amplitude(0,100);
//					Image(new FilledRect(100,50,50,50, canvas));
//					Effect("Stretch");
//			Frequency(10,20);
//				Amplitude(0,100);
//					Effect("Bounce");
//			Frequency(20,30);
//				Amplitude(0,100);
//					Image(new FilledRect(400,50,50,50, canvas));
//					Image(new FilledRect(450,50,50,50, canvas));
//					Image(new FilledRect(300,50,50,50, canvas));
//					Image(new FilledRect(350,50,50,50, canvas));
//					Image(new FilledRect(250,50,50,50, canvas));
//					Image(new FilledRect(200,50,50,50, canvas));
//					Effect("Bounce");
//			Frequency(30,50);
//				Amplitude(0,100);
//					Effect("Bounce");
//					
		VisualizerStart();
//		Time(50,100);
//			Frequency(0,10);
//				Amplitude(0,50);
//					Effect("Bounce");
//					Effect("Bounce");
//			Frequency(0,50);
//				Amplitude(50,100);
//					Effect("Bounce");
//					Effect("Bounce");
					
			Thread.sleep(50000);
			canvas.windowClosing(null);
		
		
	}
	
	
	

}
