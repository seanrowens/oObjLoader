Thu Oct 27 20:29:27 EDT 2011

This is a java library for parsing and loading WaveFront .OBJ files.
It is still very much under developement. At present it can parse most
of the .OBJ format as well as the .MTL (material lib) format.  

The parser itself is in com.owens.oobjloader.parser.  It parses the files
and, for each element parsed, calls a correspnding method in
com.owens.oobjloader.parser.BuilderInterface.  

A basic sample implementation of BuilderInterface and some associated
classes (mostly data types for vertices and faces) is in
com.owens.oobjloader.build.

A simple test program that will parse .OBJ files is in
com.owens.oobjloader.test.Test.  

A basic sample .OBJ file viewer using LWJGL is in
com.owens.oobjloader.lwjgl.Test, along with some associated utility code.

This is the very first pre-alpha release of the code and hence the
structure of the code may change radically, including package names
and the entire package tree.  However, I hope to stick to model of
parser/builder in general, i.e. you can just use the parser to turn
files into a series of calls to the builder interface, and supply your
own implementation of builder.

Among other features that need to be added to this library, it
currently only really supports vertices and faces.  More complex types
of geometries are not yet supported.  

Also, while material files are PARSED, they are currently mostly
un-implemented.  

This code was written by myself, Sean R. Owens, sean at guild dot net,
and is released to the public domain. Share and enjoy. Since some
people argue that it is impossible to release software to the public
domain, you are also free to use this code under any version of the
GPL, LPGL, Apache, or BSD licenses, or contact me for use of another
license.

In addition, by request, this code may also be used under the "unlicense" 
described at http://unlicense.org/ .  See the file UNLICENSE in the repo.

Sean Owens.
