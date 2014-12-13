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

/**
 * Constructs the Intermediary Representation of the DSL. 
 * 
 * 
 * @author Mauricio
 *
 */
public class FrequencyVisualizerDSL {

	protected static AWTFrameCanvas canvas = new AWTFrameCanvas(800, 800);
	protected static DrawingCanvas VisualizerCanvas;
	private static Time newestDefinedTime;
	private static Frequency newestFrequency;
	private static Amplitude newestAmplitude;
	private static ArrayList<Time> definedTimeList = new ArrayList<Time>();
	protected static java.awt.Image backgroundImage;
	protected static double runTimeInSeconds;
	static VisibleImage background;
	private static Image lastImage;
	static Hashtable<Integer, ArrayList<Integer>> amplitudesForFrequencies = new Hashtable<Integer, ArrayList<Integer>>();
	private static double timeIncrement;

	/**
	 * 
	 * @param args
	 */
	public void begin() {
		canvas.windowActivated(null);
	}
	
	/**
	 * Sets up the background image.
	 * 
	 * Still need to figure out how to allow the user to change the background
	 * in a different time.....
	 * 
	 * @param imageURL
	 * @throws IOException
	 */
	public static void setBackgroundImage(String imageURL) throws IOException {
		BufferedImage image = null;
		URL url = new URL(imageURL);
		image = ImageIO.read(url);
		background = new VisibleImage(image, 0, 0, canvas.getWidth(),
				canvas.getHeight(), canvas);
	}

	public static Frequency Frequency(int start, int end) {
		
		if(start > 100 || start < 0 || end < 0 || end > 100){
			throw new IllegalArgumentException("Malformed Interval. Interval start and end should have values between 0 and 100");
		}
		else if(start > end ){
			throw new IllegalArgumentException("Malformed Interval: Start must be smaller than end variable");
		}
		else{
		Frequency newFrequency = new Frequency(start, end);
		newestDefinedTime.addFrequency(newFrequency);
		newestFrequency = newFrequency;
		return newFrequency;
	}
	}


	/**
	 * Optional structure to be used for extra spcificity of what occurs at a given amplitude interval for 
	 * a given frequency interval. Not fully implemented...still needs extra testing. 
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static Amplitude Amplitude(int start, int end) {
		Amplitude newAmplitude = new Amplitude(start, end);
		newestFrequency.addAmplitude(newAmplitude);
		newestAmplitude = newAmplitude;
		return newAmplitude;
	}


	public static Time Time(double start, int end) {
		if(start > 100 || start < 0 || end < 0 || end >100){
			throw new IllegalArgumentException("Malformed Interval. Interval start and end should have values between 0 and 100");
		}
		else if(start > end ){
			throw new IllegalArgumentException("Malformed Interval: Start must be smaller than end variable");
		}
		else{
		Time newTime = new Time(start, end);
		newestDefinedTime = newTime;
		definedTimeList.add(newTime);
		newestDefinedTime.setRunTimeInSeconds(runTimeInSeconds);
		return newTime;
	}
	}

	/**
	 * Ideally this will allow users to define their own effect by defining a
	 * runnable class that extends the effect interface.
	 * 
	 * @param effect
	 */
	public static void Effect(String effect) {
		lastImage.setAnimationType(effect);
	}

	/**
	 * This image constructor handles when the user wants to use a URL. Similar
	 * to how the background image is set up
	 * 
	 * @param imageLocation
	 * @return
	 */
	public static Image Image(Resizable2DInterface imageLocation) {
		Image newImage = new Image(imageLocation);
		lastImage = newImage;
		newImage.hide();
		ArrayList<Integer> random = createPsuedoData();
		newestFrequency.addImage(newImage);
		newImage.setAmplitudesOverTime(random);
		newImage.setEndTime(newestDefinedTime.getEndTime());
		newImage.setRunTime(timeIncrement * (newestDefinedTime.getEndTime() - newestDefinedTime.getStartTime()));
		newImage.setStartTime(newestDefinedTime.getStartTime())
;		return newImage;
	}

	/**
	 * Plays the music file and returns information that information used by the DSL. 
	 * @param musicFileLocation
	 */
	public static void setMusic(String musicFileLocation)
			throws LineUnavailableException, IOException,
			UnsupportedAudioFileException, InterruptedException {
		musicCalc music = new musicCalc(musicFileLocation);
		runTimeInSeconds = music.playTimeInSeconds();
		timeIncrement = runTimeInSeconds / 100;
		new Thread(music).start();
		System.out
				.println("Run time of the visualizer is: " + runTimeInSeconds);
		createPsuedoData();
	}

	/**
	 * The analysis of sound is much more complicated than anticipated. For now,
	 * creating data structure to simulate what data might look like
	 * 
	 * @return
	 */
	private static ArrayList<Integer> createPsuedoData() {
		ArrayList<Integer> random = new ArrayList<Integer>();
		RandomIntGenerator generator = new RandomIntGenerator(20, 500);

		for (int i = 0; i < runTimeInSeconds * 100; i++) {
			random.add(generator.nextValue());
		}
		return random;

	}

	public static void VisualizerStart() {
		// Starts the animations as defined for each Time structure
		for (Time x : definedTimeList) {
			new Thread(x).start();
		}
	}
}