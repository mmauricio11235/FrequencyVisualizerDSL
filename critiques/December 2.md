Critique for Week Ending on December 2
Chloe Calvarin

## Response to Project Description:

**Personal background for context**

I've been messing around with creating animated films that work with music, in the historical tradition of "visual music," which isn't quite the same as creating a visualization of the sounds using the frequency space. For what I've been doing, most drawing can create a ton of frames, and stringing them together into a film is relatively simple, all you need is ffmpeg or the like. This takes forever, obviously, but there are definitely other options. Any drawing tool will let you create and edit images, and save them as frame#.png, but there are some more specialized tools that allow for frame-by-frame animation. 

* [POV-Ray](http://www.povray.org/) is a 3D graphics programming language with a "clock" variable that allows the artist to define the dependence of objects' characteristics on this value, and then generates the frames. 
* [Processing](https://www.processing.org/) is another graphic programming language that has animation functionality. 

**Interesting design questions for this project**

Compared to the above, I think the key difference of what you're suggesting is the link with music, along with the suggestion that the artist/creator will *not* have complete control, only the power of suggestion. The examples you show provide this functionality, but do so in a super-powerful tool that is out of reach, both in terms of expense and the amount of time it takes to learn the tool. I think it'd be really cool if you can do this well, but I'm currently having difficulty seeing what aspects of the process you want to automate, what will be left to the user, and what you wish to add randomness too, a la ContextFree.

A major design challenge I foresee is being able to create the frequency & amplitude link with visuals in a way that doesn't seem too clear-cut, so that your language's output will seem natural despite the limited scope of tools. If, say, someone wants the melody in the upper register to be visualized by bounding circles, and the lower register and bass notes to be represented differently, the intersection is going to be difficult. Some notes in the melody might be lower than the higher notes of the bass line, for example, and having a harsh frequency cutoff might make this look weird. Or, percussive sounds occur in all frequencies, so you either need to accept this or try to take events that span most of the frequency space as seperate somehow. At that point, this becomes a STEMs problem, and I'm sure you don't want to go too far into that, but it's a question to keep in mind. 

It seems your current goal bypasses this by having the frequency plot be the main element, but I'm not too clear on that. Describing your idea in terms of what is linked to frequency and what to amplitude at a frequency might make this easier to understand. The terms "magnitude" and "amplitude" are thrown around, and I assume you know what you mean, but this wasn't too clear to me. Is the "sound bar" the frequency spectrum?

I think you should more clearly define what your objects, animations, and rules are first. This will lead to necessary questions about your syntax in the IR/functional version, as well as potential consideration of how it translates to a visual interface and how easily it can later be extended. Until you define this more specifically, I think it'll be easy to get side-tracked with all those additional concerns you mention (default values, range, formats, errors.)

## Response to Project Plan

**Maximizing time on language design**

As I said above, I think you should spend a lot of time ironing out the design of your IR, in terms of the basic functionality you wish to provide, and of the syntax, to work towards your goal of making this simple and easy to learn even for non-programmers. Your plan seems to have this same goal, so that's hopefully fine. You might want to start sketching out potential 'programs' and their results, before even looking at the APIs you'll be using, as you want your idea to influence how you learn your tools, and not the other way around. This should help prevent spending too much time on the tool-learning. I'm looking forward to seeing sample programs! If you think of multiple possible syntaxes, please include them, it'll help clarify what decisions you've made on design. 

I think it'll be easy to get bogged down by how to deconstruct the music into usable signals, so be careful! 

