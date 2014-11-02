# Project plan

## Language evaluation
**How will you know that your language has accomplished its goals?**

When I first thought of this DSL, I immediately overwhelmed myself with the number of possibilities on animations, tools and effects that can be written. After thinking for a very long time and trying to imagine what I would like to produce realistically by the end of the semester, I would say that once the language is simple enough to allow users new to programming to define unique and interesting music visualization in the form of a sound bar that can be defined using simple tools building on each other, such as object definition and pre-defined animations, I believe the language will have reached it's goals. [Here's an example of a simple visualizer I'd hope could be made with this DSL](http://youtu.be/TS7Yq7OQRqA) The requirements will be: 

* Define the objects that made up the sound bar. This includes size, color, image, and number of objects on the bar
* Define the background image of the music visualizer
* Specify the music/sound that will be effecting the music
* Define how the bar will move in relation to the sound that was chosen. What causes changes in the objects that make up the visualizer. 
* Define how the objects that make up the sound bar relate to each other. i.e. distance between objects, angle between objects. 

There are an unlimited number of additional features that could be added to the language. My hopes and ultimate goal is that the language will be malleable and allow for additional effects to be added later easily. My hope is that as ideas come up for potential animations and effects, they can be added later and used with the same DSL.  


**What tools, techniques, or measurements will you use to evaluate your language design? What tools or practices will you use to ensure that your language implementation is of high quality?**

While this DSL will have limited functionality in terms of creating music visualizers initially, my hope is that it will be simple enough and well documented enough that someone with no programming experience will be able to create music visualizers in the language. Specific evaluation tools I will hope to implement are user testing. I have several friends who have never programmed before and may be able to help me by trying to create a music visualizer in my DSL. If they are able to create music visualizers with this DSL, I'd say the DSL is approaching the quality I'd like it to. 


## Implementation plan
**How much time do you think you'll need for the various components of your language (e.g., finding a host language, implementing the semantics, the parser, tools, etc)? Provide a brief schedule (e.g., with a deliverable every week) for your project.**

I'm fairly certain that I will be building in Scala and Java since there are already plenty of libraries and tools available for both in sound manipulation and also graphical elements. 

The final product is due December 12, which give me 6 full weeks to implement the DSL. I hope to implement in the same order that is specified in the [External Lab](https://github.com/hmc-cs111-fall2014/external-lab): 

* **By Nov 9** - Formally specify the syntax for the DSL in EBNF. Also want to have explored the available tools I'll be using ([ScalaFX](http://www.scalafx.org/) and [Java Sound API](http://docs.oracle.com/javase/tutorial/sound/) )and build simple example programs before trying to build the DSL with them. 

* **By Nov 16** - Want to have come to a decision on the exact language design and how I will implement the DSL. Will have completed the Language Design and Implementation documents required for the project. Want to have started on the project itself and get the IR completed. I foresee the semantics and Parser implementations and tests being a bigger challenge and will continue to work through the next week. I hope to use the same parsing tools as used in [piconot-external](https://github.com/hmc-cs111-fall2014/piconot-external). 

* **By Nov 23** - At this point I hope to have really closed in on what the language will actually look like using the critiques I receive. I want to have the prototype done and relatively polished, as well as have completed the IR and Parser. Will focus completely on Semantics tests and implementation for the next week.  

* **By Nov 30** - Have completed at least a minimal working version of the DSL and have a simple sample program that takes input sound/music and user defined visualization. The result should be a music visualizer for the input music/sound that is reflective of amplitude. 

* **By December 7** - At this point I hope to be working on cleaning up the code and adding additional functionality, such as additional animations options or effects. I also want to make sure to acknowledge and handle any issues regarding error handling that I may not have attended to earlier. 

* **By December 12** - Final version of the DSL is complete and ready to be turned in. Want to be able to commit all material for the language with comments and clear instructions on how to run. 