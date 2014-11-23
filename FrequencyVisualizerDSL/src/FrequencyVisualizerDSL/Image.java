package FrequencyVisualizerDSL;

import java.awt.Color;
import java.util.ArrayList;

import objectdraw.*;

public class Image implements Runnable {

	private String animationType;
	private ArrayList<Integer> amplitudesOverTime;
	private int pauseTime = 1000;
	private Resizable2DInterface image; 
	public Image(String imageLocation) {

	}

	public Image(Resizable2DInterface imageLocation) {

		image = imageLocation;
	}

	// TODO
	public void animate() throws InterruptedException {
		int i = 0; 
		image.setColor(Color.white);
//		if (animationType == "bounce") {
			while(i <  amplitudesOverTime.size()){
				System.out.println("Reached animate effectively: " + i);
				image.setHeight(amplitudesOverTime.get(i));
				i++;
				Thread.sleep(125);
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
