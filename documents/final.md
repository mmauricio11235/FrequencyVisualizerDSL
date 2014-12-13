#Java Music Visualizer: A DSL for Music Visualization
####Mauricio Molina

##Introduction

The domain for my language is Music visualization, specifically the ability for users to define a visual for several different attributes of music, such as time, amplitude and frequency. The essence of the language is to open up the domain of music visualization to a larger pool of people, including experts, but also including people who simply want to play and maybe have minimal programming experience. I wanted to provide a space where users are able to create visualizers in a text language that makes sense at a high level and is simple enough to be done in a couple minutes, but also powerful enough to allow for creative and vivid visualizations of music. I believe that my language does provide this simplicity, and while not all the features are implemented quite yet, I believe it already allows users to create interesting visualization in a way that makes sense and is easy to learn. 

There are several different available DSLs, including:  
#### VSXu:
[Video of VSXu](http://youtu.be/iJaQxibbaR0)

[VSXu Website](http://www.vsxu.com/for-programmers)

####Music visualizers using a Photoshop After Effects:

[Example Visualizer](http://youtu.be/yNdhfrIz6Ug)

[Tutorial for After Effects](http://layersmagazine.com/audio-visualization-in-after-effects.html)

####Another 3D tool: VST Plugin (Not Free)
[Website](http://createdigitalmotion.com/2012/12/3d-music-visualization-powerful-editing-rendering-now-as-a-vst-plug-in/)

However, none of these tools allow for programming in a traditional sense, and can also be difficult to learn or even expensive. The people who benefit from this DSL will be those who would like to build simple music visualizers and maybe even learn how to code a little. Also those who may be looking to make a quick music visualizer and doesn't necessarily have the time to learn one of the more complicated DSLs. 


##**Language design details:** 

The user writes programs in this DSL by defining data structures called Time, which are made of a collection of Frequency data structure, which contain the information for how Images are animated using an Effect attribute, which is ultimately reactive to changes in amplitude as the music progresses.This DSL is a text based language which provides a nested structure to provide a framework for how visualizers are built. The general structure for how a person creates a visualizer is as follows:
	
	backgroundImage("Background Image URL");

	setMusic("music file location);
	
	Time(startTime, endTime);

		Frequency(lowFrequency, highFrequency);
			
			Image("URL");

			Effect("effect name");
	
	VisualizerStart();

A user can choose to define as many different Time structures as they would like. Each time range defined can have any number of frequencies, and frequencies can have any number of images defined within them. The effects are associated with the latest defined image. Each range, for Time and Frequency, are normalized so that users simply have to choose values from 0 to 100, where 0 is the smallest value (such as start time of the song) and 100 is the largest (like the end time of the song, or largest frequency available). There is an additional structure that wasn't quite completely implemented called Amplitude that goes within a Frequency object that allows for more specific effect that occur when certain amplitudes within a frequency range occur. 

The background image simply pulls an image from the given URL to set as the background of the visualizer, and the setMusic line retrieves the music file and plays it as the visualizer music. VisualizerStart line simply starts the visualizer once the user has defined every structure of the visualizer that they would like to. 

 My hope was to extract some of the complexity of music analysis that is generally associated with music visualization and provide the structure necessary so users know what happening, why it's happening, and so their definitions are reactive to the music. I believe that this simple structure is easy to reason about, and allows the user to define things in a way that they might think about visualization in general. Additionally, for those who have a bit more programming experience, this DSL even allows for the use of Java tools, such as loops, for creating several of the same kind of visualization as described in the first provided example of the visualizer.  

Once the user has described their visualizer using the DSL, each of the objects: Time, Frequency, Image and Effect, are contained within each other in the Intermediate representation. Each Time object has it's own thread, and when its interval for running occurs, it starts the visualization described by the user for that interval as defined by each of its nested frequency objects. Each Image is bound to a given frequency and it's animation is reflective of the effect described by the user, which takes continuously incoming information about that frequency at every moment to affect how the image reacts within that animation. So, for example, if a user define bounce for the Frequency(0,20), the image with that effect will react to the amplitude of the normalized frequency range of (0,20). The higher the amplitude, the higher the image bounces. 

Currently, the sound analysis required to use as input for the effects of each image hasn't been completed, so psuedo data representing what that information could potentially look like is being used. 

Control structures that are available to the user are the general structure of interval that are required for each data structure they must define, and also all the java control structures that already exist! Ideally I would have liked Amplitude to allow for more specificity to add accents to certain moments in the visualizer, but it is still buggy. 

Ultimately, once the visualizer has been described and started by the user, a popup window with the defined music, background image and visualization will appear!

Currently, the structure of the language provides the framework for what the DSL expects, but in situations where the user may not correctly organize the structure, or potentially provides invalid parameters, there are error messages that are printed to the console in the form of exceptions. The program will attempt to continue without stopping, but may not behave the way the user expects. These error messages provide details on what was incorrectly defined. 



##**Example program(s):**

Provide one or more examples that give the casual reader a good sense of your language. Include inputs and outputs. Think of this section as “Tutorial By Example”. You might combine this section with the previous one, i.e., use examples to help describe your language.

Please look at the example provided in the TestVisualizer folder of the project! Here is a snipped of the code and resulting visualizer: 

<p style = "text-align:center;">
<img src="/Prototype-code1.jpg" style="width:800px;height:600px;"/>
</p>

<p style = "text-align:center;">
<img src="/Prototype-Image.jpg" style="width:500px;height:500px;"/>
</p>



##Language Implementation

The host language that I decided on was Java. The reason for using Java over other languages was primarily due to my own personal familiarity with the language, but also allows me to use several powerful internal and external libraries to build the DSL. The use of Java also opens up several tools to the user that allow them to build more powerful visualizers in this language. The language is an internal DSL for Java. I found that an internal DSL was particularly well suited to this DSL because of the allowance for the control structures that already available in Java. The combination of existing tools in Java with my DSL could allow for greater flexibility for more experience programmers, while still resulting in a simpler way to create visualizers. For the front end images, I used the [objectdraw library](http://eventfuljava.cs.williams.edu/library/objectdrawJavadocV1.1.1/), which provides a simple way to handle graphical objects and gives a canvas to work with. Also provides several methods to work with those images. For the back end, I used the [Java Sound API](https://docs.oracle.com/javase/tutorial/sound/) to play and extract information on the sound. The rest of the back end used Java to build the structure for the language. 

I created different objects to represent each of the data structures that are available to the user. Each object, when created, is associated with its outer data structure within the DSL and as part of it's creation in the intermediate representation.The psuedo sound data that I created is simply a long array of values that would be similar to that returned by complete analysis of the sound. 

The computational model is dependent on being able to have inner structures be connected to their outer structures. The way that I was able to do this is by creating the association of the inner data structures to the outer data structures when the intermediate representation is being run. So, for example, when a Frequency object is being created, it is added to the list of Frequencies that belong to that Time interval that the Frequency belongs to after the Frequency object is created!  In this way, it's simple to populate each structure and there is a similar patter throughout. The semantics of my host language has to define all of these relationship explicitly, while my DSL simply shows what the relationship is and doesn't require the user to think about how those associations occur. 

Additionally, the creation of the intervals is a simple normalization and mapping of values. So the time and frequency interval that is natural to music are both simply scaled down to an interval of 0-100, and the logic is handled for the user internally. The difference between the host language and the DSL is that the user doesn't need to think about how time and frequency intervals for any given song works. For any sound clip they could want to visualize, they just hve to think about it in a more simple min-max 0 to 100 scale.  

##Evaluation

**How “DSL-y” is your language? How close or far away is it from a general- purpose language?**

Within the scope of the DSL on its own, I would say it is very DSL-y as it has a very specific function of Music Visualization, and doesn't do anything outside of that (although it could potentially simplify the task of playing music if you only ran setMusic line). Overall, this DSL is very far from a general purpose language. 

I believe the language structure itself is fairly well established, and allows users some flexibility in what they want to make given that they can use actual Java code within the DSL itself. I think that the language makes sense and provides just enough guidance to allow even people unfamiliar with programming and music to create visualizers. My goal was simplicity in the language.  

I'm also particularly please with how much of the more complicated code is hidden from the user, and how the user can literally use only what I have defined in the DSL to create their visualizers. A user can create a simple visualizer in 4 lines as of now, though it wouldn't be very exciting. 

However, the number of animations and effects available to users is still incredibly limited. My goal was to try to create a way for users to define their own code for animations, but decided that error handling and good error messages was more important. I may still try to add this functionality before the presentation. 

I also feel that the structure of the language requires writing a lot of the same code. While a person could easily write a for loop, it would be nice to have added a functionality that does the looping structure for the user. 

Additionally, I unfortunately was never able to get to the actual implementation of the sound analysis that is required for the DSL to be truly reflective of the music. I spent several hours reading and studying how this could be done, and even found several libraries that could have been helpful, but ultimately decided that the language aspect of the DSL had to be as close to done as possible. My hope is that this analysis can be added later.

The largest source of difficulty for my DSL was in the choice of host language in the first place, and also in the decision on whether the language should be internal or external. 

To start, I originally was hoping to create an external language, which would allow me to take advantage of Scala parsing tools. However, after discussing with my critique partners and spending several hours unsuccessfully getting libraries to work well with Scala, I ended up deciding on a fully Java based internal DSL. This did bring with it some challenges, primarily in how to hide some of the java specific syntax that isn't relevant to my DSL. 

Another major challenge that I had with using Java as a host language is that it is very difficult to create new language structures. To require any kind of structure that the user must follow requires tricky logic in the backend that hasn't been implemented yet. This did, however, bring up the question on whether it even made sense to require a certain kind of structure for my DSL. For now, I've decided to try to implement some of the more major functions of the language that assume the structure of the language is held, and then decide if it is necessary to implement any form of control for the DSL structure. 

The last biggest challenge I faced and ultimately was unable to complete was the more complicated analysis necessary for the DSL to take sound data as input that is reflected in the visualizer. I decided to focus more on the language and unfortunately didn't have time to complete this. 

To evaluate the ease of use of my DSL, I had user testing by allowing people to try to create small programs in my DSL and by letting people see the sample program that I wrote. The people who have tried out my DSL have been a couple of friends and my critique partners. I've received mixed feedback, but generally positive overall. I think the biggest thing I've learned is that for every decision that is made in a language's design, there will be people who like it, and people who don't. While there are ways to make a language more readable, that often simply adds more text that needs to be written. Finally, flexibility is great and allowing the user to do some work can help save me some, which is why I wish I could have finished implementing the "create your own effect/animation" ability to the DSL. 

##Overall Experience

The domain of Domain Specific Languages itself has been completely new to me, but I can honestly say it was incredibly rewarding. I found myself being challenged in ways no other class in computer science had before, and also found myself researching topics that I'd never had to chance to before, and also having to think about clever ways to implement things that I otherwise may not have thought of. The design of a language is ultimately completely dependent on my ability to understand the user, the domain, and how they can work well together. I feel like most of the skills from this class are transferable to several other areas within computer science, and I really enjoyed the studio structure. I enjoy receiving feedback and truly appreciate my parter's ability to think critically and provide me with support and great ideas as I progressed. I like to think that my DSL is fun to use, and look forward to continued work on it in the future. 

