package FrequencyVisualizerDSL;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import objectdraw.*;

public class FrequencyVisualizerDSL{

	protected static AWTFrameCanvas canvas = new AWTFrameCanvas(800,800);
	protected static DrawingCanvas VisualizerCanvas;
	private static final long serialVersionUID = 1L;
	private static Time newestDefinedTime; 
	private static Frequency newestFrequency;
	private static Amplitude newestAmplitude;
	private static ArrayList<Time> definedTimeList = new ArrayList<Time>();
	protected static java.awt.Image backgroundImage;
	protected static double runTimeInSeconds;
	static VisibleImage background;
	private static Image lastImage;
	static Hashtable<Integer, ArrayList<Integer>> amplitudesForFrequencies = new Hashtable<Integer, ArrayList<Integer>>();
	
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
		newestDefinedTime.setRunTimeInSeconds(runTimeInSeconds);
		return newTime;
	}
	
	/**
	 * 
	 * @param effect
	 * @return
	 */
	public static Effect Effect(String effect){
		if(effect.equals("Bounce")){
		
		
	}		
		return null;
	}
	
//	public Image Image(String imageLocation){
//		Image newImage = new Image(imageLocation);
//		lastImage = newImage; 
//		return newImage;
//	}
//	
	public static Image Image(Resizable2DInterface imageLocation){
		Image newImage = new Image(imageLocation);
		lastImage = newImage; 
		ArrayList<Integer> random = createPsuedoData();
		newestFrequency.addImage(newImage);
		newImage.setAmplitudesOverTime(random);
//		new Thread(newImage).start();
		return newImage;
	}
		
	/**
	 * 
	 * @param musicFileLocation
	 */
	public static void setMusic(String musicFileLocation) throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException{
		musicCalc music = new musicCalc(musicFileLocation);
		runTimeInSeconds = music.playTimeInSeconds();
		new Thread(music).start();
		System.out.println("Run time of the visualizer is: " +runTimeInSeconds);
		createPsuedoData();
	}
	
	/**
	 * The analysis of sound is much more complicated than anticiapted. For now, 
	 * creating data structure to simulate what data might look like
	 * @return 
	 */
	private static ArrayList<Integer> createPsuedoData() {
		ArrayList<Integer> random = new ArrayList<Integer>();
		RandomIntGenerator  generator = new RandomIntGenerator(100,500); 
		
		for(int i = 0; i < runTimeInSeconds; i++){
			random.add(generator.nextValue());
		}
		return random; 
		
	}
	
	public static void VisualizerStart(){
		//TO-DO: Once all the elements have been taken into acccount, create all threads and start them
		for(Time x : definedTimeList){
			new Thread(x).start();
		}
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