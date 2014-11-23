package FrequencyVisualizerDSL;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import objectdraw.*;

public class FrequencyVisualizerDSL{

	protected static AWTFrameCanvas canvas = new AWTFrameCanvas(1000,1000);
	protected static DrawingCanvas VisualizerCanvas;
	private static final long serialVersionUID = 1L;
	private static Time newestDefinedTime; 
	private static Frequency newestFrequency;
	private static Amplitude newestAmplitude;
	private static ArrayList<Time> definedTimeList = new ArrayList<Time>();
	protected static java.awt.Image backgroundImage;
	static VisibleImage background;
	
	/**
	 * 
	 * @param args
	 */
	public void begin(){
		canvas.windowActivated(null);
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
		
	/**
	 * 
	 * @param musicFileLocation
	 */
	public static void setMusic(String musicFileLocation) throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException{
		new Thread(new musicCalc(musicFileLocation)).start();
	}
	
	/*
	 * Sets the backgound image
	 */
	public static void setBackgroundImage(String imageURL) throws IOException{
	BufferedImage image = null;
	URL url = new URL(imageURL);
	image = ImageIO.read(url);
	background = new VisibleImage(image, 0,0,canvas.getWidth(),canvas.getHeight(),canvas);
	
	}
		
		
}