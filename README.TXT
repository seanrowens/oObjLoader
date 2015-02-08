Thu Oct 27 20:29:27 EDT 2011

This is a java library for parsing and loading WaveFront .OBJ files.
At present it can parse most of the .OBJ format as well as the .MTL 
(material lib) format.  The things it can't parse are mostly points,
lines, and quadric surfaces.

The parser itself is in com.owens.oobjloader.parser.  It parses the files
and, for each element parsed, calls a corresponding method in
com.owens.oobjloader.parser.BuilderInterface.  

A basic sample implementation of BuilderInterface and some associated
classes (mostly data types for vertices and faces) is in
com.owens.oobjloader.build.  This is meant to serve as an example 
and was purposefully implemented in the most straightforward way,
without attention to issues of memory and speed efficiency. Really if 
you are loading obj .OBJ files you should be 'importing' them into 
an efficient internal format of your own design. 

A simple test program that will parse .OBJ files is in
com.owens.oobjloader.test.Test.  

A basic sample .OBJ file viewer using LWJGL is in
com.owens.oobjloader.lwjgl.Test, along with some associated utility code.

This library will uses the model of parser/builder in general, i.e. you 
use the parser to turn files into a series of calls to the builder interface, 
and supply your own implementation of builder.

Among other features that need to be added to this library, it
currently only really supports vertices and faces.  More complex types
of geometries (such as quadric surfaces) are not yet supported.  

Also, while material files are completely parsed, the sample builder and
LWJGL code doesn't do much with them.

This code was written by myself, Sean R. Owens, sean at guild dot net,
and is released to the public domain. Share and enjoy. Since some
people argue that it is impossible to release software to the public
domain, you are also free to use this code under any version of the
GPL, LPGL, Apache, or BSD licenses, or contact me for use of another
license.

In addition, by request, this code may also be used under the "unlicense" 
described at http://unlicense.org/ .  See the file UNLICENSE in the repo.

If all of that isn't clear enough, the idea here is that you can do whatever
you want with the code.  Fold it, spindle it, mutilate it, knock yourself 
out.  Copy bits and pieces into your code tree, copy the whole thing into
your code tree, do as you please.

Sean Owens.
