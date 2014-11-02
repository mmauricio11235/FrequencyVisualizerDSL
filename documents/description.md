# Project description and plan

## Motivation

**Why is this project useful or interesting, what problem are you trying to address, and why is a DSL an appropriate solution?**

Up until now, I haven't come across any language that allows the programmer to easily create music visualization without having to purchase a larger software product like [Adobe Photoshop](http://www.adobe.com/products/aftereffects.html). While these tools are powerful and allow for very creative music visualizers to be created, certain things like changes as music progresses or changes in animation in the middle of the same song are difficult to implement. I felt that a DSL was appropriate because it allows for more flexibility in these areas, while hopefully still being intuitive. As with programming languages in general, there is also room for randomness like that seen in context free, which results in surprising results that a person may not have thought of ahead of time. A DSL could be created that is simple and yet powerful, while still retaining creativity.  

## Language domain

**What is the domain that this language addresses, and why is the domain useful?** 

Visual expression of music. This is a fairly complicated domain due to how variable music is and also how complicated creating the visuals can be. Having a language that defines these changes and allows for use of more powerful programming tools. 



**Who will benefit from this language? Are there any other DSLs for this domain? If so, what are they, and how might they influence your language design and implementation?**

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

## Language design
**If you had to capture your DSL's design in one sentence, what would it be?**

DSL for creation of music visualizations. 


**What constitutes a program in your language? What happens when a program runs?** 

The DSL will essentially be a set of the following: 

* Set of rules for what objects and animations occur at different amplitudes. So users will be able to designate what happens to the music visualizer at different ranges of amplitude. Will probably normalize so that the ranges that can be defined are between 0 (min) to 100 (max)
* Animation: Effect, magnitude of music effect on animation, transitions, shape, number of objects in animation. Animation for now will focus only on individual object movement and on a vertical bar that makes up the music bar in the visualizer. 
* Object: Objects will make up the sound bar. Users will define what the object is, individual effects including change of color, distance from other objects in animation, and change in size. Also relationship in proportion between objects


This will most likely be an external DSL implemented using Scala parsing tools and java libraries. When the program runs, I hope to parse it down to an intermediary representation, which then executes semantics using ScalaFX and Java Sound API to create the music visualizer as defined by the user. 


**What kinds of input might a program take, and what kinds of output might it produce?** 

Input will be a set of rules as described above, and the output will be a functional music visualizer with the music and visualizer designated by the user.
Ideally I'd like to have some graphical user interface so people can manipulate and change effects in the visualizer as it's running, but that is a reach goal. 


**Are there data or control structures that you know will be useful? What kinds of things might go wrong in a program in this domain (e.g., syntax errors, compile-time errors, run-time errors)?**

Something I have been thinking about a lot is default values for things. There are many things that could be seen as optional in a music visualizer and don't necessarily need to be described by the user unless they want, but there are other things, like what objects to use in the sound bar, that are necessary to be defined. I need to find the values that need to be define and have defaults, and then allow the user to overwrite them if necessary. 

Another issue is range of values that are allowed. With the music affecting object and animations, what range of values are allowed to describe the magnitude of the effects. 

There are also many different kinds of sound file formats, so being able to handle different ones, or be able to convert between file types may be an issue.

Lastly, because I'm hoping to parse the files described by the user there may be syntax errors in general. 
 

**How might you design your language to prevent such errors or to clearly communicate the results of errors to the user?**

What I've been thinking so far is that there needs to be some way to designate an order in which things that are required be implemented, that way things that need to be defined aren't forgotten. Having default values for some fields may also help avoid error when users choose not to define things. 



## Example computations
**Describe some example computations in your DSL. These computations should describe what happens when a specific program in your DSL executes. Note that you shouldn't describe the syntax of the program. Rather you should describe some canonical examples that help someone else understand the kinds of things that your DSL will eventually be able to do.**

As mentioned before, there are three specific things that user needs to define. Properties of the sound bar, the objects that make up the bars in the sound bar, and the effects that occur with the music in the bars. Converting from this to the intermediary representation and eventually semantics will be done using parsing tools in Scala.  

Once these things are defined, the actual computation will mainly take the form of hiding and showing objects to make it seem as if the bar is bouncing and reacting to the music. This computation will need to be done in conjunction with input being given by the music so that the sound bar reacts in the way specified by the user. 

The user also has the option to define how the objects react at certain ranges of amplitude, so that will also need to be taken into account and occur as the program runs. 


Aside from the general animation of the sound bar, each individual object may have some animation themselves, which will most likely be predefined optional animations I create instead of user defined (at least at first). 

Lastly, all of these steps need to come together to create the music visualizer, which shows the animation and plays the music at the same time. 