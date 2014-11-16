# Language design and implementation overview

## Language design

###How does a user write programs in your language (e.g., do they type in commands, use a visual/graphical tool, speak, etc.)?

This is going to be a text language that will be parsed. Essentially, the goal is to have users define how the visualizer is affected by changes in the music/sounds (to start off with it will be frequency visualizer like __[this](http://youtu.be/TS7Yq7OQRqA)__ ). I am going to have the user focus on three specific things, and how the visualizer is going to be affected by changes in these following values in the music: 

* **Time**: What are the changes to the objects that make up the frequency bar as time progresses?  These changes can occur what images are used for given frequencies/amplitudes, changes to background image, changes to impact changes in music will have on visualizer. 

* **Frequency ranges**: Define what frequency range each vertical bar represents in the frequency visualizer. This will be one of the first things that user has to describe in a program written in this DSL as it will lay the framework for what everything else does. Each frequency range defined will result in an additional bar added to the spectrum. 
  
* **Amplitude (loudness)**: This will be the most obvious effect that occurs on the frequency visualizer, as it will be what the main attribute of the music that causes the bars to bounce. These amplitude ranges will need to be defined within the frequency ranges. 
 
  
When it comes to creative domains like music visualizers, there are an unlimited number of additions that can be created, such as how beat affects the music, but for now I would like to create a DSL that allows for intuitive structure and allows for simple visualizers for now. 

  

###What is the basic computation that your language performs (i.e., what is the computational model)?

Basic computation will be to take in the different attributes of the music listed above (**Amplitude, Frequency, Time**) and have them affect the animation in the way described by the user. This also includes allowing the program written by the user to change over time, so I need to create the data structures in such a way that they only occur when certain times occur. Another basic computation that needs to occur is the continuous collection of data from the music as it progresses, and making changes to the frequency visualizer as it occurs. 


###What are the basic data structures in your DSL, if any? How does a the user create and manipulate data?

The basic data structures are the time range, frequency range, and amplitude range data structures.  These structures are built upon each other, and most of the smaller details of what happens is held at the lowest level, which is the amplitude layer. The user generally is able to create and manipulate data using a combination of these data structures, and structures are built from a combination of the lower level data structures. 



###What are the basic control structures in your DSL, if any? How does the user specify or manipulate control flow?

The basic control structures are dependent on the three attributes of the sound being visualized mentioned above: **Time, Beat and Amplitude**. The program is dependent on being able to react to each of those attributes in the way described by the user. The basic model is that the user define what occurs at different times. At each time, from beginning to end, a user can choose to change what the frequency bar is entirely, or change only a few values as time progresses. Users must at least define the initial set up of the frequency visualizer. 

The frequency ranges will be defined by what occurs at the amplitude ranges. Amplitude ranges describe the images that make up the bars, and some of the effects that occur (I will need to keep these limited at first to get at least the minimal thing working!).  


The outer most layer that is taken into account is time of music, which I will normalize to be 0 to 100 to make it simpler for the user, where 0 is the very beginning of the song to 100 being the end of the song. Within the time structure, the user defines the entirety of the the frequency visualizer, which includes more nested fields. 

The user will need to define the different frequency intervals, and at least the base image that they will be using for the lowest amplitude range within that frequency. This is repeated for each amplitude. 

The user will start off by defining the different frequency ranges. For each frequency range, a user must choose what the base object is going to be (base object being the object that will be at the lowest amplitude of the that given frequency. A sample of what a program will look like can be found in notes.txt. 



###What kind(s) of input does a program in your DSL require? What kind(s) of output does a program produce?

Input is going to be code written in the text and syntax described above and as seen in notes.txt. The output will hopefully be a frequency visualizer that is reflective of the definition given by the user. 

###Error handling: How can programs go wrong, and how does your language communicate those errors to the user?

Because I'm hoping to make an external DSL, many of the issues that will arise are going to be syntax errors. Other issues that could arise are from the user not defining things in the order that I specified, which is time(frequency(amplitude(details))). This will most likely be a very strict structure, and can thus be mistaken often. A major challenge that I will have is trying to communicate general syntax errors from these structural errors, since the parser will most likely see them both as being similar types of errors. 

###What tool support (e.g., error-checking, development environments) does your project provide?

More than anything, it provides a very easy way to manipulate a visualization with the attributes of music, without having to deal directly with the music and some of the complicated APIs. This means that having a general idea of what you'd like to see is simpler to implement with a couple commands, while still giving you enough room to be flexible. 


###Are there any other DSLs for this domain? If so, what are they, and how does your language compare to these other languages?

There are a few different DSLs for this domain, including : 
#### VSXu:
[Video of VSXu](http://youtu.be/iJaQxibbaR0)

[VSXu Website](http://www.vsxu.com/for-programmers)

####Music visualizers using a Photoshop After Effects:

[Example Visualizer](http://youtu.be/yNdhfrIz6Ug)

[Tutorial for After Effects](http://layersmagazine.com/audio-visualization-in-after-effects.html)

####Another 3D tool: VST Plugin (Not Free)
[Website](http://createdigitalmotion.com/2012/12/3d-music-visualization-powerful-editing-rendering-now-as-a-vst-plug-in/)

However, none of these tools allow for programming in a traditional sense, and can also be difficult to learn or even expensive. The people who benefit from this DSL will be those who would like to build simple music visualizers and maybe even learn how to code a little. Also those who may be looking to make a quick music visualizer and doesn't necessarily have the time to learn one of the more complicated DSLs. 


## Language implementation

###Your choice of an internal vs. external implementation and how and why you made that choice.

I decided on an external DSL since I would like the flexibilty of using Scala Parsing tools. I also feel that the heavily nested structure that I'm hoping for is very similar to the implementation of piconot external and will therefore be a bit easier to implement. 

 
###Your choice of a host language and how and why you made that choice.

The host languages that I'm hoping to use are Java and Scala. The language I am strongest in is Java, and Scala Parsing tools are the ones I am most familiar with given that we have used them in class. 

After failing to understand ScalaFX for several hours, I've decided to go for a simpler library called Java 2D API, which I hope will prove to be easier to use! I still hope to use Java Sound API, but am also looking into another music java library called Minim that provides higher level tools for developers that are simpler to use than directly from Java Sound. While it will take more time to familiarize myself with these new libraries, the utilities they bring could make the development process a bit easier. 


###Any significant syntax design decisions you've made and the reasons for those decisions.

As of now I have a general idea of what I'd like the language to look like, and have written an example in note.txt, and a more formal description in EBNF in lang_design.txt. My basic hope for implementation is to build the DSL as seen in the example, outwards. This means starting with simply having a way for users to define amplitude, then frequency, then time. I felt that this natural structure for development would hopefully make milestones that could be built on top of each other easily. 


##An overview of the architecture of your system.

Architecture of the language will be as follows in terms of how the user constructs the visualizer: 
 
* Time { Frequency { Amplitude { Details } } } 
	* This means that time is built by collections of frequency interval definitions, which are defined by a collection of amplitude intervals, and amplitudes are defined with details on how images react to music, where images make up the bar.
* Details include background image, image of bar, size of image, angle from image below it, distance from image below it. I'm hoping to add more later, but to start off would like to have at least size of image and change in image. 