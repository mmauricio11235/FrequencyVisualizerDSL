package FrequencyVisualizerDSL;
import java.util.ArrayList;

import objectdraw.*;


public class Time implements Runnable{

	
	private int startTime, endTime;
	private ArrayList<Frequency> frequencyList = new ArrayList<Frequency>();
	private int maxFrequencies = 10; 
	
	
	public Time(int start, int end){
		startTime = start; 
		endTime = end; 
	}
	
	public int getStartTime(){
		return startTime; 
	}
	public int getEndTime(){
		return endTime;
	}
	public void setStartTime(int newStartTime){
		startTime = newStartTime; 
	}
	
	public void setEndTime(int newEndTime){
		endTime = newEndTime; 
	}
	
	public int getMaxFrequencies(){
		return maxFrequencies; 
	}
	
	
	public void addFrequency(Frequency newFrequency){
		frequencyList.add(newFrequency);
	}
	
	public void run(){
		
	}
	
}
