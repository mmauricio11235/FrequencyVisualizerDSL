package FrequencyVisualizerDSL;
import java.awt.Component;
import java.awt.Container;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import objectdraw.*;

public class FrequencyVisualizerDSL{

	protected static DrawingCanvas canvas = new AWTFrameCanvas();
	protected static DrawingCanvas VisualizerCanvas;
	private static final long serialVersionUID = 1L;
	private static Time newestDefinedTime; 
	private static Frequency newestFrequency;
	private static Amplitude newestAmplitude;
	private static ArrayList<Time> definedTimeList = new ArrayList<Time>();
	
	/**
	 * 
	 * @param args
	 */
	public void begin(){
		new FilledRect(50,50,50,50, VisualizerCanvas);
	}
	
	
	public static Frequency Frequency(int start, int end){
		Frequency newFrequency = new Frequency(start, end);
		newestDefinedTime.addFrequency(newFrequency);
		newestFrequency = newFrequency;
		return newFrequency;
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static Amplitude Amplitude(int start, int end){
		Amplitude newAmplitude = new Amplitude(start, end);
		newestFrequency.addAmplitude(newAmplitude);
		newestAmplitude = newAmplitude;
		return newAmplitude;
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static Time Time(int start, int end){
		Time newTime = new Time(start, end);
		newestDefinedTime = newTime;
		definedTimeList.add(newTime);
		return newTime;
	}
	
	/**
	 * 
	 * @param effect
	 * @return
	 */
	public static Effect Effect(String effect){
		if(effect.equals("Bounce")){
		return new Bounce();
		
	}		
		return null;
	}
	
	public Image Image(String imageLocation){
		Image newImage = new Image(imageLocation);
		return newImage;
	}
	
	public static Image Image(DrawableInterface imageLocation){
		Image newImage = new Image(imageLocation);
		return newImage;
	}
	public static void Image(){
		new FramedRect(50,50,50,50,canvas);
	}
		
	/**
	 * 
	 * @param musicFileLocation
	 */
	public static void setMusic(String musicFileLocation) throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException{
		new musicCalc(musicFileLocation);
	}
		
		
}