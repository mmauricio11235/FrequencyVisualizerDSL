# November 18th Critique - Paul Dapolito

I referred to your [Language design and implementation overview](https://github.com/mmauricio11235/project/blob/master/documents/design_and_implementation.md) document while formulating my feedback on your project for this week.

## Design Feedback

I think the nested structure of your language's design is a major strength. I like how, in your [grammar-ideal](https://github.com/mmauricio11235/project/blob/master/grammar-ideal.txt), you have `Time` at the topmost level of your nested structure. This makes sense intuitively about how we might think about a piece of audio at the most basic level. I cannot speak much to the benefits of having `Amplitude` be a nested member of `Frequency` or vice versa, but I think the syntax you have currently laid out is very clean and sensible in the domain of your language. I also really love how you can leave out some particular aspects of the visualization for a range of amplitudes, and I am interested in your decision process as to what the default values for some of these options (like `distance` and `size`) will be. 

I think that your data structures and layout of control flow will work wonderfully together, and I especially like how the two interact in the syntax you specified. I think your idea to standardize values also makes programs in your language look cleaner, as specifying ranges between 1 and 100 seems a lot more readable than variable ranges. This standardization, which I think is worth mentioning, might restrict the needs of more advanced users. Because you will give users access to this paradigm of standardization, will you pre-process the user's audio file to make sense of the standardized ranges for time, frequency, and amplitude as part of your computational model? I am also wondering if computation in your language would involve rendering the user's visualization while playing back the audio that they would like to have accompanying the visualization. I feel that this would allow users to more easily tweak their programs as it incorporates real-time feedback into your visualization tool. 

All things considered, I think your language design is spectacular. The structure and flow make sense and will be easy for users to express, and the standardization of the numbers involved will make your language accessible for users with different levels of experience manipulating audio. As I mentioned to you in class, your syntax seems so programmatically natural that it can probably be implemented as an internal DSL in Scala. It seems that your nested hierarchical object structure lends itself nicely to Scala's syntax, and I think this would lessen the burden on you to create a parser for the language. 

## Implementation Feedback

I think that your [grammar-ideal](https://github.com/mmauricio11235/project/blob/master/grammar-ideal.txt) as well as your written description are a great elucidation of your software architecture, and I'm excited to see your implementation of your DSL's internal representation.

As we discussed in class and as is discussed below, it seems that your syntax is similar enough to Scala such that you can probably implement your DSL internally within Scala. This would save you the cost of having to engineer a robust parser for the language and might allow you to explore more components of your DSL. With that aside, I think that Java and Scala will be a duo for implementing this DSL. In the end, you might choose to do away with Scala all-together, given that you have found the Java sound APIs a bit more user-friendly and you may be able to avoid writing a brand new parser for the language.

I think that the general layout of your classes/objects is perfect for the project, and I think that you should consider how these objects will interact with the third-party APIs you are using as you begin to implement your language's internal representation.


## Specific Questions

### What are the most pressing issues with the current design of the language?

I would say that the most pressing issue for your project with regards to the design of your language is making the decision as to whether you will implement the DSL as internal or external. You seemed to suggest that you'd like to get moving on some code in the coming week, and I'd say that this decision is the first you would need to make to start digging into the code. 

You might also want to consider programs in your language that define different visualizations for different time sequences of a particular piece of audio. The examples you gave seem to all operate over `Time(0,100)`, and I think it'd be interesting to think about how you might design the language to support different visualization specifications for several different time ranges (ie. one specification for `Time(0, 50)` and another for `Time(50, 100)`) over inputted audio.

### Do you have any recommendations for how I should approach the implementation of the DSL?

I would definitely try to write your internal representation first, as I think this will help you think about how the syntax and semantics of your language should look. You will have to consider what default values will be hard-coded into your internal representation at this time, and I think that tackling this consideration early will allow you to receive feedback from your critique group on how you give users different options as they instantiate data in your language. Along this process, as I noted above, you should think about how your internally represented objects will interact with the different third-party sound tools you are using. This might make the implementation of your DSL's semantics a bit easier.

### Do you have any advice on how to implement the DSL given that it will be changing as the music continuously plays? What are best practices that you've seen in the past?

I think that the way you have designed your language makes it very easy for the user to visualize how their program will manifest itself visually over time. This is because your top-level object in your data hierarchy is `Time`. This makes sense intuitively, and as the user fleshes out different specifications for various ranges of `Frequency`, it will make sense to them that they are specifying what will happen over some range of time when the sound falls into some specific range of frequency.

With this said, your program will have to somehow recognize the frequency and amplitude of every unit of time in the audio and follow down the object hierarchy to produce the visualization declared by the user at that specific time. This can probably be done very quickly, but might require you to ultimately pre-process the audio before creating a visualization for the user. This consideration is definitely a matter of your language's semantics, but you can certainly think about how you will take some `Time` object and relate its various buckets of `Frequency` objects to the user's inputted audio.

Have you thought about how your DSL will be used? Were you thinking that users would create a visualization by way of a program in your language, and then provide that program as well as an input audio file to your DSL in order to see output? It seems that you might need to pre-process the user's audio and then link each unit of time in the audio to a specific part of the user's specified visualization. I am not sure if this truly answers the question you asked, and I'd be happy to chat more about this during our next class.

### Any other general advice?

I think the first hurdle in implementing your DSL will be developing the language's internal representation in the most modular way possible. I would imagine that you will have to make changes to your internal representation when it comes time to implement your language's semantics, and assuring that your internal representation is implemented in an extensible and modular fashion will make this process much nicer. I think you might also find ideas for your project as you begin to work with the sound APIs a bit more. From your primitive examples, it seemed that you were allowing users to specify visualizations for some `Time`, in a given range of `Frequency`, and for some range of `Amplitude`. I think this structure works intuitively when we think about sound, but I am wondering if you could allow users to interchange, overlap, and exclude different parts of this hierarchy later on. For instance, I might want to create the following visualization:

	    Time(0, 10){
	    	image("http://www.someurl.com")
	    }
	    Time(10, 90){
	    	Frequency(0, 50) {
	    		image("http://www.someOtherURL.com")
	    	}
	    	Amplitude(0, 20){
	    		image("http://www.someOtherOtherURL.com")
	    	}
	    }
	    Time(90, 100) {
          image("http://www.someurl.com")
          size(10)
          distance(2)
        } 

I feel that you could achieve this level of flexibility early-on in your project by perhaps encompassing every "block" (`Time` element) in a higher-level `Visualization` class. If we think about your DSL's representation this way, you could say that every `Visualization` object has (for example) data members `Time`, `Amplitude`, `Frequency`, `image`, `size`, and `distance`. Then, if we consider that any field of a visualization can be left blank, all of `Time`, `Amplitude`, and `Frequency` could inherit from the `Visualization` class and be mixed-and-matched as per the user's desires. This would allow an almost unbounded range of visualization expression and would highlight the true benefit of your system's number standardization paradigm. For instance, we might see the following visualization:
	
	Time(0, 100){
		# show a static image for the first 10% of the audio
		Time(0, 10) {
			image("http://www.images.com/static_image.png")
		}

		Time(10, 40) {
			# lower sounds
			Amplitude(10, 50){
				image("http://www.someurl.com")
				distance(2)
			}

			# higher sounds
			Amplitude(50, 90) {
				image("http://www.someOtherURL.com")
				distance(3)
			}

			# all other sounds
			image("http://www.someRandomURL.com")
		}
	}

This suggestion might reach a level of generalization that is outside the scope of your project, but I figured it's worth mentioning because you noted that your syntax might be a bit too specific and concrete.What I really wanted to point out is that the nested structure of your syntax can be leveraged in so many different awesome ways. I think this nested layout is awesome, and I hope I've given you some food for thought as you start implementing your DSL's internal representation.
