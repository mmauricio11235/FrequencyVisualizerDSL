package FrequencyVisualizerDSL;
import java.util.ArrayList;

import objectdraw.*;


public class Frequency implements Runnable{

	private static int startFrequency, endFrequency;
	private ArrayList<Effect> effects;
	private static int numFrequencies = 0;
	private ArrayList<FrequencyBar> frequencyBars = new ArrayList<FrequencyBar>();
	private ArrayList<Amplitude> amplitudeList = new ArrayList<Amplitude>();
	private ArrayList<Image> imageList = new ArrayList<Image>();
	
	
	
	public Frequency(int start, int end){
		startFrequency = start;
		endFrequency = end; 
	}
	
	public void addEffect(Effect newEffect){
		effects.add(newEffect);
	}
	
	

	public void addAmplitude(Amplitude newAmplitude) {
		amplitudeList.add(newAmplitude);	
	}
	
	public void addImage(Image image){
		imageList.add(image);
	}
	public ArrayList<Image> getImageList(){
		return imageList;
	}
	
	public void run(){
			
	}
}
