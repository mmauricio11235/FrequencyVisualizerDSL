package FrequencyVisualizerDSL;
import java.util.ArrayList;

import objectdraw.*;


public class Frequency implements Runnable{

	private static int startFrequency, endFrequency;
	private ArrayList<Effect> effects;
	private static int numFrequencies = 0;
	private ArrayList<FrequencyBar> frequencyBars = new ArrayList<FrequencyBar>();
	private ArrayList<Amplitude> amplitudeList = new ArrayList<Amplitude>();
	
	
	public Frequency(int start, int end){
		startFrequency = start;
		endFrequency = end; 
	}
	
	public void addEffect(Effect newEffect){
		effects.add(newEffect);
	}
	
	public void run(){
		
		
	}

	public void addAmplitude(Amplitude newAmplitude) {
		amplitudeList.add(newAmplitude);
		
	}
	
	
	
	
}
