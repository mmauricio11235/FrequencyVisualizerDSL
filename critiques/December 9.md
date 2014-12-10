# December 9th Critique - Paul Dapolito

## General Feedback

I think that the work you put in on refining the nested structure of your language is great and puts you in a great position moving into the final week of the project. Your sample program, [TestVisualizer.java](https://github.com/mmauricio11235/FrequencyVisualizerDSL/blob/master/FrequencyVisualizerDSL/src/TestVisualizers/TestVisualizer.java), looks awesome!

I am particularly impressed with the nested layout of your language. The time you spent fine-tuning this language structure last week really paid off. For instance, the following code block is particularly illuminating:

		Frequency(30,40);
		Amplitude(0,100);	
			Image(new FilledRect(400,50,100,50, canvas));
				Effect("Bounce");
				
This is true credit to just how well you've designed your language. Even entirely out of context, the code block above is readable and can be shared with another developer in your DSL. With regard to your language's design and structure, I think you've done an amazing job!

I really like that you decided to make `Amplitude` an optional specifier in your language. In fact, I tend to think that any part of your language's structure should be optional! I know this is probably not possible to implement in the last week of the project, but I figured it would be worth mentioning as something you might consider later down the road.

I'm impressed that you were able to achieve time standardization on a 0-100 scale. Unlike what you mentioned, I think that this standardization is really intuitive, but I definitely think that, for some users, it might allow for less-specific visualizations. For instance, if I wanted some effect to happen at a very particular point in a song (like you mentioned), it would take some extrapolation for me to figure out where that time falls on a 0-100 scale. In working with your sample program, I was wondering what side of the 0-100 range was inclusive. For example, is it possible to define an animation block for `Time(0,0)` as well as `Time(100,100)`? I am thinking this is not possible, and I think that you should elucidate the details of this standardization in your language's documentation.

At the moment, I think that error-handling takes priority over adding additional effects to your language. In the interest of creating a robust and high-quality product in the final week of work, I think that providing helpful error-handling for users of your language will be more useful than additional features.


## Answers to Specific Questions

### Do you think that having the time constraint and frequency constraint at 0-100 makes sense?

I think that standardizing both time and frequency makes sense both technically and intuitively. I feel that using this standardization technique will really allow users to think about their visualizations as applicable to a systematic <i>range</i> of frequency/time. If you were to remove this constraint for either of the two, I would say that discarding the standardization of time would make the most sense. However, I am a strong proponent of what this standardization does in terms of allowing users to focus on the visualization of sounds, rather than the perhaps inaccessible numbers associated with creating these visualizations over ranges of frequency and/or time.

### Would adding a time counter while the visualizer plays help users know what time they want to create the intervals for?

I definitely think that the addition of a time counter as part of the visualization would help users understand the creation of intervals more clearly. While it sometimes is excessive to include certain details as part of a GUI, I think that users of your language will find a time counter particularly helpful in fine-tuning their visualizations. In the case that displaying this information clutters your GUI, I would recommend simply making the display of the time counter configurable.

### Do you have any other ideas for how I can make defining the time more intuitive?

I thought about this for a while, and I think that one option that makes sense would be parsing strings. As your language currently stands, you can specify an animation for the first half of an audio track by declaring the visualization as:

	Time(0, 50)
	
I feel that this syntax could be more intuitive if it simply encompassed how we think of time intervals in speech. For instance, if I wanted to create an animation for the first twenty seconds of a song, I might specify:
	
	Time("00:00 to 00:20")
	
You could simplify this, in the interest of efficient implementation, to something like:

	Time("00:00", "00:20")
	
I feel that this would make defining the time intervals for visualizations very intuitive, although I really do think that your current specification of these intervals works quite well!

### What would you say the most critical things I need to implement before the end of the project are? If I had to choose 3 things to spend this week doing, what should they be?

I would say that you should definitely work on robust error-handling for your language. Users of your language should be notified when their specified ranges do not make sense, or if the files/images they try to access cannot be found. Further than this, users will want to know when they are not using the nested structure of your language correctly. This might be a particularly difficult error to handle, but I think that users of your DSL will need to receive helpful feedback on how to leverage the nested structure of your language.

Other than error-handling, I think that you definitely need to provide documentation for using and running your language. As it stands, I would have a lot of trouble creating and executing my own program for the language. While it is certainly nice to provide sample programs like `TestVisualizer.java` that exemplify the expressiveness of your language, I think that developers and users will want to know more about the syntax structure of a visualization in your language and how to instantiate and operate the many different components of your language without referring directly to the source code. 

If you are able to tackle both of the above tasks, I would say that your language would benefit from having some more effects for users to use. I think that this might be difficult to implement, given that the project is due on Friday. 

Even if you are unable to add some more effects to the language, you should be really confident and proud of what you've put forward so far. I was really impressed when I worked with your test visualizer in forming this critique. Your language's design is absolutely fantastic, as I noted above, and I think that you've gone about implementing your language in a way that will foster growth, should you decide to come back to it in the future. Awesome job, Mauricio! It has been a real pleasure tracking the progress of your project throughout the semester.
