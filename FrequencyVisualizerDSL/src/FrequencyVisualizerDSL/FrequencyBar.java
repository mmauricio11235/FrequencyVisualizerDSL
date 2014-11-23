package FrequencyVisualizerDSL;
import objectdraw.*;

public class FrequencyBar {

	private DrawableInterface barImage; 
	private int threshold;
	
	
	public FrequencyBar(int threshold, DrawableInterface barImage){
		this.threshold = threshold; 
		this.barImage = barImage; 
		
	}
	public void setBarImage(DrawableInterface newImage){
		this.barImage = newImage; 
	}
	public DrawableInterface getBarImage(){
		return barImage;
	}
	public void setThreshold(int newThreshold){
		threshold = newThreshold;
	}
	public int getThreshold(){
		return threshold;
	}
	public void show(int currentAmplitude){
		if(currentAmplitude > threshold){
			barImage.show();
		}
		else{
			barImage.hide();
		}
	}
}
