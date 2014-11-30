# Preliminary evaluation

##Provide some analysis of the work you've done so far.

####What works well? What are you particularly pleased with?

As of now, I think the language structure itself is fairly well established, and allows users some flexibility in what they want to make given that they can use actual Java code within the DSL itself. 

I'm particularly please with how much of the more complicated code is hidden from the user, and how the user can literally use only what I have defined in the DSL to create their visualizers. A user can create a simple visualizer in 4 lines as of now, though it wouldn't be very exciting. 


####What could be improved? For example, how could the user's experience be better? 

There are quite a few things that can still be improved: 

* I need a better way to enforce the structure that I'd like the user to construct their DSL. This being Time{Frequency{Amp{Details}}}. 
	* I'm still trying to decide if the requirement for this structure is even absolutely necessary. Giving people this kind of flexibility and notifying them through helpful error message when necessary could be more effective.
* I am still using manufactured data to represent what I was hoping the input from the sound clips would be. Ideally, I'd like to include the Fourier Transform analysis information that represents Amplitude/Frequency. 
* There are still very few effects within the DSL that the user can use...
* I'd like there to be a way for the user to define their own effects
	* This can currently be done with a work around using recursion and loops within java itself, but the animations are limited to simply displaying things in different areas. 

* I've received feedback that the language isn't very intuitive, and that the structure might actually be a hindrance. Other than having several sample programs, I'd like for the DSL to be more intuitive. As in, if a person had no idea how to create a visualizer in my DSL, they'd be able to do so using what they know already. 

* The language still hasn't had a few features implemented, primarily the time constraint. As of now, all the time definitions will just be encompassed by the full time of the player. 

* Because I allow the user to use a URL for an image, the load time can be a few seconds based on the speed of the internet. This makes for an awkward delay where the music may start playing, but nothing is shown on the screen. 

####How might your implementation be simpler or more cohesive?

The nested structure of the DSL can be a bit confusing, but i think that having more descriptive names for elements of the DSL can help describe what the expectations for the structure are. 


####Re-visit your evaluation plan from the beginning of the project. Which tools have you used to evaluate the quality of your design? What have you learned from these evaluations? Have you made any significant changes as a result of these tools, the critiques, or user tests?

One of the evaluation tools that I was hoping to use was actual people trying to create tools with the DSL. I still haven't had the opportunity to test it with users mainly because there are still a few things that need to be implemented However, I have been able to receive feedback from my peers that was very helpful. My primary concern is that I'd like the language to have a structure that is fairly intuitive, and as of now that doesn't seem to be the case. My critique partners fine the language fairly confusing and slightly awkward to work with, which is something that I need to acknowledge . 

The significant change that I could need to make is in the syntax of the language, and what is needed to effectively be able to communicate to the user what is needed, as well as allows for the user to communicate with the DSL to create what they hope. These changes still haven't been implemented, but I hope to spend the last 2 weeks of the project experimenting and trying out different structures for the language. It could be the case that a simple change in the words used in the DSL 


####Where did you run into trouble and why? For example, did you come up with some syntax that you found difficult to implement, given your host language choice? 

The largest source of difficulty for my DSL so far has been in the choice of host language in the first place, and also in the decision on whether the language should be internal or external. 

To start, I originally was hoping to create an external language, which would allow me to take advantage of Scala parsing tools. However, after discussing with my critique partners and spending several hours unsuccessfully getting libraries to work well with Scala, I ended up deciding on a fully Java based internal DSL. This did bring with it some challenges, primarily in how to hide some of the java specific syntax that isn't relevant to my DSL. 

Another major challenge that I had with using Java as a host language is that it is very difficult to create new language structures. To require any kind of structure that the user must follow requires tricky logic in the backend that hasn't been implemented yet. This did, however, bring up the question on whether it even made sense to require a certain kind of structure for my DSL. For now, I've decided to try to implement some of the more major functions of the language that assume the structure of the language is held, and then decide if it is necessary to implement any form of control for the DSL structure. 

The biggest challenge I'm facing right now is on how to do the more complicated analysis necessary for the DSL to take sound data as input that is reflected in the visualizer. While I really hope to be able to research and implement this aspect of the language, which is really important, I want to make sure to have some form of working DSL first. The DSL must make sense itself before I make the great effort to try and figure out the math required to analyze the sound and retrieve the information I need. 


####Did you want to support multiple features, but you had trouble getting them to play well together?

The one feature that I would have really liked to have had in the DSL, but have no formal way for the user to do is the creation of self defined animations. Ideally, I would have liked for the user to be able to define animations and effects that occur at intervals that they later decided. This is difficult to do in Java as there isn't a way (as far as I know) to pass in segments of code as a parameter. A user could simply define a runnable method in the body of page of code that contains the DSL code, but this starts to stray away from the DSL, which I would ideally like to avoid. 

The other challenge which results from the previous limitation is that it then requires that I provide enough different animations for the users to use to where they can make several unique and interesting visualizers. Right now I'm trying to think of several different effects that could be interesting, but I can see this being a limiting factor of the language right now. 


####What's left to accomplish before the end of the project?

* Implement the time interval definitions. Things defined for certain time ranges should only show at those time ranges. 
* Implement the more tight binding of inner objects as part of the definition of the outer layers. This basically means that anything that should be part of a certain time range should be a part of that object so later changes to that object will effect everything that makes it. 
* Add several more effects to the language! Not sure what the ideal number is, but for now i hope to have at least 5 different ones available
	* Ideally should be able to find a way to allow the user to define effects. 

* Reach goal is to find out how to do the necessary analysis on sound clips to have the visualizer reflect real time changes to frequency/amplitude in the music. 