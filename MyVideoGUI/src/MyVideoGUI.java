

import java.io.File;
import processing.core.*;
import controlP5.*;
import jmcvideo.*;


public class MyVideoGUI extends PApplet {
	JMCMovie myMovie; // Movie file
	
	ControlP5 controlP5; // Object to initialize controllers
	Slider slide_loc; // Slider for location
	Button playButton; // Play/Pause button
	CheckBox doloop; // Checkbox to turn on/off looping
	Textfield txt; // Text Field for inputting a video label
	Textarea lbl; // Text area for displaying a video label
	
	public void setup() 
	{
	  size(640, 480);
	  frame.setResizable(true);
	  background(0);

	  // Load and play the video
	  myMovie = movieFromDataPath("allosphere_body.mov"); 
	  myMovie.play();
	  
	  // Create controllers
	  controlP5 = new ControlP5(this);
	  
	  slide_loc = controlP5.addSlider("PROGRESS", 0, 1, 10, myMovie.height + 20, myMovie.width, 20);

	  playButton = controlP5.addButton("PLAY", 0, 10, myMovie.height + 50, 30, 20);
	  
	  doloop = controlP5.addCheckBox("doloop", 50, myMovie.height + 50);
	  doloop.addItem("LOOP",1);
	  
	  txt = controlP5.addTextfield("LabelText", 10, myMovie.height + 80, myMovie.width, 50);
	  lbl = controlP5.addTextarea("label","", 10, 10, myMovie.width, 40);
	  
	}

	public void draw() 
	{
	  tint(255, 20);
	  
	  if(playButton.booleanValue()) {
//		  image(myMovie, 10, 10, myMovie.width, myMovie.height);
		  myMovie.pause();
	  	}
	  else {
		  if(doloop.getState(0)) {
			  myMovie.loop();
		  }
		  else {
			  myMovie.play();
		  }

	  }
	  
	  image(myMovie, 10, 10, myMovie.width, myMovie.height);
	  
	  lbl.setText(txt.getText());
	  
	  if (slide_loc.isMousePressed()) {
		  myMovie.setPlaybackPercentage(slide_loc.value());
	  }
	  else {
		  slide_loc.setValue((float)myMovie.getPlaybackPercentage());
	  }
	  
	}

	JMCMovie movieFromDataPath(String filename)
	{
	   return new JMCMovie(this, filename, RGB);
	}
	
	public static void main(String args[]) {
	    PApplet.main(new String[] {"MyVideoGUI" });
	}

}

	
	
	

