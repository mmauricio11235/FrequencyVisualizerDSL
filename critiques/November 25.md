# Critique for Week ending in November 23rd

## Reaction to the syntax 

I'm sorry you spend so much time trying to get Scala to work! At the same time, though, 
congrats on getting something to work.

I don't find the syntax at all intuitive, but I think there is some amount of relatively 
trivial changes that can help. Currently, you have the user input things in this general 
format (ideally, as you said, you have no way of inforcing this):
```
Time(,)
  Frequency(,)
    Amplitude(,)
      Image
        Effect
        
  Frequency
    ...
```
I assume this means something that looks like this:
```
During time range (,)
  For the frequency range (,)
    apply the amplitude range(,)
      to this image()
        with this effect()
```
The problem currently is two fold. First, the lack of enforcement for the grouping and 
ordering of elements makes it hard to tell what each element is for, and what it effects. 
This is particularly true for the Time function, which spans many frequencies in your 
example. This would be completely opaque without the indentation you provide in your 
examples. Second, the names of the functions don't really reflect how a piece fits into 
the whole. 

My spelling out of (my understanding of) the functions above would look more like 
Objective-C than Java, but I do think you should be able to fix that with somewhat better 
names. Another option is to force the grouping by making some calls occur inside of a 
function call, so that insertion of different, irrelevant code is prevented. I'm not 
sure this is doable, or even entirely desirable, but it is an option.

## Fourier

I agree that a fourier transform is what you're looking for. As to how best to approach
it, well, that's difficult. There's an entire class on how it works and applications for
physics majors, and most Mudders get a quick introduction to it during Stems (Systems
and Signals), a required Engineering class. I think you need to understand how to use
it more than how to implement it, and in that case (though, both maybe) you might want 
to consider going to talk to an engineering prof, someone who teaches baby stems for 
example. It will take some time, but if you focus on finding the solution to your problem, 
and sidestep the problem of understanding everything that the FT is doing, you might be 
able to make some progress.

You're right to ignore this for now, and to instead focus on the usability and 
functionality of your language. Artificial data will do for a demo. I do think it would
be cool to actually have a visualization that's linked to the music though, but y'know. 

