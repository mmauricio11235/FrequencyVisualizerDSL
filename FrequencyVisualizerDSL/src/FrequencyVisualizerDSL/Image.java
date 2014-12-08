package FrequencyVisualizerDSL;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import objectdraw.*;

public class Image implements Runnable {

	private String animationType;
	private ArrayList<Integer> amplitudesOverTime;
	// AmplitudeThreshold will tell image at what amplitudes it should react
	private int amplitudeThreshold = 0;
	private int pauseTime = 100;
	private RandomIntGenerator randomSleepTime = new RandomIntGenerator(100,
			300);
	private Resizable2DInterface image;
	private Random rand = new Random();
	
	private double endTime, startTime;
	private double runTime;
	

	public Image(String imageLocation) {

	}

	public Image(Resizable2DInterface imageLocation) {

		image = imageLocation;
	}

	public void setAmplitudeThreshold(int threshold) {
		amplitudeThreshold = threshold;
	}

	// TODO
	public void animate() throws InterruptedException {
		startTime = System.currentTimeMillis();
	
		int i = 0;
		double runTimeOfThread = System.currentTimeMillis() - startTime;
//		while(( runTimeOfThread - startTime) < runTime * 100){
		image.setColor(Color.white);
		if ((animationType == "Bounce" || animationType == "bounce") &&  runTimeOfThread < runTime) {
			while (i < amplitudesOverTime.size()) {
				float r = rand.nextFloat() % 1;
				float g = rand.nextFloat() % 1;
				float b = rand.nextFloat() % 1;
				System.out.println("Reached animate effectively: " + i);
				image.setHeight(amplitudesOverTime.get(i));
				image.setColor(new Color(r, g, b));
				i++;
				pauseTime = randomSleepTime.nextValue();
				Thread.sleep((long) pauseTime);
				runTimeOfThread = System.currentTimeMillis();
			}
		}

		else if ((animationType == "random" || animationType == "Random") ) {
			i++;
			while (i < amplitudesOverTime.size() &&  runTimeOfThread < runTime * 1000) {
				image.moveTo(amplitudesOverTime.get(i-1) * 2,amplitudesOverTime.get(i) * 2);
				image.show();
				Thread.sleep((long) pauseTime);
				pauseTime = randomSleepTime.nextValue();
				
				image.hide();
				Thread.sleep(50);
				System.out.println("Hot hurr");
				i++;
				runTimeOfThread = System.currentTimeMillis() - startTime;
				System.out.println("runtime: " + runTimeOfThread + "stop time: " + runTime * 1000);
			}
		}
	}
	//}
	
	public void run() {
		// TODO
		try {
			animate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setAmplitudesOverTime(ArrayList<Integer> random) {
		amplitudesOverTime = random;
	}

	public void hide() {
		// TODO Auto-generated method stub
		image.hide();
	}

	public void show() {
		image.show();
	}

	public void setAnimationType(String animation) {
		animationType = animation;
	}
	public void setEndTime(double d){
		endTime = d;
	}
	public void setRunTime(double run){
		runTime = run;
	}
	public void setStartTime(double d){
		startTime = d;
	}
}
