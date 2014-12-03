package FrequencyVisualizerDSL;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import objectdraw.*;

public class Image implements Runnable {

	private String animationType;
	private ArrayList<Integer> amplitudesOverTime;
	private int amplitudeThreshold = 0; 
	private int pauseTime = 100;
	private RandomIntGenerator randomSleepTime = new RandomIntGenerator(100,300);
	private Resizable2DInterface image; 
	private Random rand = new Random();
	
	public Image(String imageLocation) {
	

	}

	public Image(Resizable2DInterface imageLocation) {

		image = imageLocation;
	}

	public void setAmplitudeThreshold(int threshold){
		amplitudeThreshold = threshold;
	}
	// TODO
	public void animate() throws InterruptedException {
		int i = 0; 
		image.setColor(Color.white);
//		if (animationType == "bounce") {
			while(i <  amplitudesOverTime.size()){
				float r = rand.nextFloat() % 1;
				float g = rand.nextFloat() % 1;
				float b = rand.nextFloat() % 1;
				System.out.println("Reached animate effectively: " + i);
				image.setHeight(amplitudesOverTime.get(i));
				image.setColor(new Color(r,g,b));
				i++;
				pauseTime = randomSleepTime.nextValue();
				Thread.sleep((long)pauseTime);
			//}
		}
	}

	public void run() {
		// TODO
		try {
			animate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setAmplitudesOverTime(ArrayList<Integer> random){
		
		amplitudesOverTime = random;
}
}
