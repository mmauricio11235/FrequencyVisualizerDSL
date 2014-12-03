Critique for Week Ending on December 2
Matt Cook

Addressing questions in notebook:

* One of the criticisms that I received was that my language isn't very intuitive as is now. The [recommendation seen here](https://github.com/mmauricio11235/FrequencyVisualizerDSL/blob/master/critiques/November%2025.md) shows what Chloe believes would be more intuitive, but it is difficult to do in Java. One possibility is to use camel case, but then it's just very long names. Do you have any other ideas? 

I think in terms of words used, it really is fine as it is now as long as it is well-defined in some API that each
of those function calls says that the arguments are for a range. It would be tedious and repetitive for the user to 
need to say it is a range again and again after they are used to it after the first time they use it.

The main concern I would say is with nesting. Right now it is not intuitive in any way what is nested other than by 
indentation. I mention this below, but I think the language can benefit from implicit arguments (i.e. define the range as (0,100) if not specified). That does not seem possible with the way it currently is, and as Chloe mentioned, the only way to know how attributes relate is by user-set arbitrary indentation. As an internal DSL, this could be more difficult without the use of parsing. 

As an internal DSL, I cannot currently think of an easy way to do so, but one completely different alternative could be to define each image on one line. For example, you could have 
```
Visualize([Image], [Effect], [TimeRange], [FrequencyRange], [AmplitudeRange])
```
The user would probably be doing a lot of copy-pasting for this, though that may be the case for the current language. You can define a class (or use a Java one) for the intervals, and the user can even define variables initially then for these, for example:
```
Interval time1 = Interval(0,50);
Interval time2 = Interval(50,100);
Interval freq1 = ...
```
And then the code could possibly be even cleaner for definition (cannot guarantee the truth to this, just in my mind currently it might).


* Do you have any resources on Fourier Fast Transforms (FFT's) such as example projects or simple libraries that I might be able to work with. 

Here is one package for Java called [JTransforms](https://sites.google.com/site/piotrwendykier/software/jtransforms) that seems promising. At the link there are also example projects of visualizers and a MusicReader (which turns music pages as you play I guess), which both could be part of distinct portions of your project. I haven't looked deeply into it, but if you decide to try to get this working it looks promising.

Another one is [FFTW](http://www.fftw.org/download.html) which has a Java wrapper to use it. This is supposed to be a really fast one, and might be worth looking at the API to see which of these is easiest to do what you want. At the bottom of that link is example projects as well.

* Do you think that there needs to be a strict binding of amplitude to frequency? Do you think that a strict structure makes the language simpler to work with? 

To me (with hardly any music creation experience at all), it would seem to make sense as you want to "filter" the sounds of some given amplitude at a frequency, rather than just any sound at high amplitude as that seems less useful. If you were to make it more lax of a requirement as that would seem to be a good compromise (allowing for both, as it can make sense without the binding too), then I would say it could be ideal, but possibly much harder to reason about in terms of possible errors. 

One thing I would say is that you can have implicit parameters. For example, if you don't specify amplitude it defaults to all of them, if you see an amplitude without frequency, assume all frequencies. This would probably make more sense, though your language may need to alter syntax a bit to ensure the block structure correctly.


