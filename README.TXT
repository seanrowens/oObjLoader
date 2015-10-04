== INTRO ==

This is a java library for parsing and loading WaveFront .OBJ files.

There's some somewhat boring stuff before I get into the meat of
things, because most people looking for a .OBJ file loader don't know
what they really need.  (I know I certainly didn't, back when I
started looking for one, before I wrote this one.)

Very often people start learning how to write 3D programs (or video
games) and after they get tired of messing around with cubes, spheres
and tea pots they want to load a model and display it.  It is highly
likely that this is why you are reading this.

One thing that really isn't obvious until you start getting into this
stuff is that a .OBJ file loader just isn't enough to do what you want
to do.  You want to load models, display them on the screen, maybe
animate them, etc.  But no .OBJ loader will have all that you need to
do that, unless it's part of a much larger 3D system.  (In which case
it's really not an .OBJ loader, it's a large 3D system of some sort.)

This isn't an issue of oObjLoader in particular, but of all
.OBJ loaders in general.

First of all, a .OBJ file is just a model of a single object.  It
describes the geometry of an object, and also can reference external
.MTL files that describe 'materials', i.e. colors, reflectivity, textures,
etc.  (The oObjLoader parser will fully parse .MTL files as well.)

But .OBJ files do NOT include any information about lighting,
animation, or many other things you're going to need.  Heck even the
SCALE of the object isn't in there, it uses whatever scale it feels
like. If you were to, say, load a model of a shoe and a model of a car
and display both objects without adjusting the scale, you might end up
with a shoe big enough to stomp the car flat.

Once you've parsed the an .OBJ file (and possibly one or more .MTL
files), you still need to turn that data into something you can draw.
And what that data will look like depends entirely on the code you are
using (or have written) to draw it.

== HOW OOBJLOADER WORKS == 

If you break down the process of "loading" an .OBJ file, it breaks
down into three phases;

1) Parse the lines of ASCII characters, keeping track of what they are
supposed to represent, vertices, texture coordinates, vertex normals,
etc, and turning strings of digits into floats/doubles.  This includes
parsing .MTL files and the parameters inside them, i.e. textures, etc.

2) Save all of this parsed data somewhere, keeping track of vertices,
texture coordinates, vertex normals, faces, etc.

3) Turn all of those vertices/faces/etc into drawing triangles in
OpenGl, mapped to textures.  (Or at least that's what I'd do, there's
no reason you have to use OpenGL.)

Step 3 is going to be different for everyone depending on how they
write their graphics code.  Step 2 is probably going to be different
as well, because you may already have data structures to save all of
that data, or you may want them to be in a certain way to be
efficient, or whatever.  Which is why I structured the oObjLoader the
way I did.

(In fact usually people define their own "internal" file formats that
are quicker to load and parse, and may contain additional information
they need.  You should look at loading .OBJ files as more of a process
of importing them into your system.)

The oObjLoader provides you with a parser that does phase 1.  The
Parser sends all of that to phase 2 by callings methods defined in the
Builder interface.  (I named it Builder because I couldn't think of a
better name.)

Now HERE IS A KEY POINT - the Builder interface is a java style
"interface".  In other words, it defines a bunch of method calls, but
not the actual code.  The Builder interface maps very closely to the
actual .OBJ file format, each call more or less just takes one element
that we've parsed from the .OBJ or .MTL file.  It has a bunch of method
definitions. (But since it's an interface, it doesnt' actually have the
code for the method bodies, just the definition.)  The parser takes care 
of turning everything from ASCII into floats or whatever, and knows what
Builder method to call based on what everything is.  I.e "here's a vertex,
here's a face", etc.

== EXAMPLE CODE == 

Despite the fact that any Builder I implement probably won't be what
you want, I whipped together a quick implementation, along with some
classes for vertices, faces, etc.

But it's pretty straight forward.  It does things in somewhat wasteful
ways, it is probably wrong for you and definitely not nearly as
efficient as it could be.  On the other hand, hey, it works, so you
can use it to play with .OBJ files right away.

And then, because when I was trying to learn OpenGL I couldn't seem to
find any straight up simple code showing how to do VBOs and such, I
also threw in some VBO code (of the Fixed Function Pipeline style), as
examples.

And lastly I wrote some example code to convert from my example
Builder into stuff my VBO code could use to draw it on the screen
using OpenGL. (By way of the LWJGL library, which is awesome.)

Note, while oOblLoader will fully parse the .MTL files, the VBO sample
code really doesn't know what to do with most of the stuff in there.
In fact really it just uses the default OpenGL lighting and the
texture image file, if any, specified in the .MTL file.

== LWJGL ==

Also note that you will need to download and install LWJGL
(Lightweight Java Game Library http://www.lwjgl.org/) to compile/use
the OpenGL parts of oObjLoader.

== LICENSE ==

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

Sean Owens
