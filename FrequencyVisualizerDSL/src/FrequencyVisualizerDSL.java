import java.awt.Graphics;
import java.awt.Graphics2D;

public class FrequencyVisualizerDSL {

	
	/*
	 * Received code example from :
	 * http://alvinalexander.com/java/java-audio-example-java-au-play-sound
	 */
	public static void main(String[] args) {
		

	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
	}
	
	
}

//// What mixers are available on my system? 
//for(Mixer.Info x : listOfMixers){
//	System.out.println(x);
//}
//

// Create audiostream from inputstream
//AudioStream audioStream = new AudioStream(in);
//InputStream in = new FileInputStream(musicFile); NOT SURE IF I NEED THIS		
//Chooses the mixer I want to use
//Mixer mixer = AudioSystem.getMixer(listOfMixers[1]);
//System.out.println("Information on the line: " + mixer.getLineInfo() + "\n");
//System.out.println("Information on the lines");
//		

//Get all the lines in that mixer. 
//	Line.Info[] lineInfo = mixer.getSourceLineInfo();
//  for(Line.Info y : lineInfo){
//	System.out.println(y);
//	}
//				
//Get the ClipDataLine from the Mixer
//Line theLine = AudioSystem.getLine(lineInfo[1]);
//System.out.println("The line I currently have is: " + theLine);
		
// Play the audio clip with the audioplater class
// Prints out the location of the current working directory
//System.out.println(new File(".").getAbsolutePath());
// AudioPlayer player = AudioPlayer.player;
// player.start(audioStream);
