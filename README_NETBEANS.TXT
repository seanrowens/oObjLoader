To create a netbeans project (using Netbeans 7.01.1) that will compile
and run this code;

0) This step need only be done once.

   a) Download the latest LWJGL (I tested this code using LWJGL 2.7.1)
from the LWJGL website;

   http://lwjgl.org/download.php

   b) extract the LWJGL download archive into a directory.  It's
   probably a good idea to name your directory something like lwjgl
   plus the version number of lwjgl that you downloaded. For our
   example, we will choose as our directory;   

   /Users/sean/lwjgl-2.7.1

   c) add LWJGL to the libraries in Netbeans, so you can laater add
   them to your project.  These instructions are pretty much stolen from;

   http://lwjgl.org/wiki/index.php?title=Setting_Up_LWJGL_with_NetBeans

   but just in case, I'll include the instructions here.

      i) Open up NetBeans.

      ii) Go to Tools|Libraries in the main menu.

      iii) Click on the New Library button.

      iv) Type in LWJGL or LWJGL-X.X to distinguish it from
      earlier/later versions or any other name that you want for the
      Library Name.

      v) Always make sure that the correct Library is selected; you
      don't want to accidentally modify another Library. Now select
      the Classpath tab for your newly created Library and then click
      the Add JAR/Folder... button.

      vi) Go to the folder where you extracted lwjgl-X.X.zip and then
      go into the jar folder. The only JARs that you really need are
      lwjgl.jar, lwjgl_util.jar, and jinput.jar. You can select
      multiple files by holding down the Ctrl key while you click so
      that you can do this in just one step.

   There are some optional steps listed on that web page if you wish
   to also install LWJGL sources and java docs.
   
1) download and extract the java source, into some directory, which
will be referred to as "mydir".  When you run "ls -l" on mydir, you
should see something like;

   total 16
   -rw-r--r--  1 sean  staff  2613 Jan  8 21:31 #README_NETBEANS.TXT#
   -rw-r--r--  1 sean  staff  1786 Jan  8 21:04 README.TXT
   drwxr-xr-x  3 sean  staff   102 Jan  8 21:03 com

2) In netbeans, create a new project;

   a) Use the menu option File->New project - this opens a New Project
   dialogue box

   b) In Categories click on Java, then in Projects click on "Java
   Project with existing sources", then click Next

   c) Give the project a name - I'll use "oObjLoader", click Next

   d) Click on the "Add Folder" button next to the "Source Package
   Folders" field and browse to "mydir"

   e) click "Finish" button

3) Open the Project Properties dialogue on your new project, using the
File menu or by right clicking on the project in the Projects side
bar.  

      a) click on "Run" in the "Categories" list on the left of the
      dialogue

      b) In the VM Options field, enter

        -Djava.library.path=/Users/sean/lwjgl-2.7.1/lwjgl-2.7.1/native/macosx
	
	where "/Users/sean/lwjgl-2.7.1" is replaced by your extracted
	LWJGL directory, and macosx has the appropriate directory for
	your OS

      c) In the Main Class field enter;
      
         com.owens.oobjloader.lwjgl.Test

      d) in Arguments, add the full path of an .obj file you want to
      load and display.  Optionally, add a "default" texture image
      file by adding "-defaulttexture somefile.jpg" - I've noticed
      that a lot of the time, .obj files either don't specify a
      texture or the texture file get's left out.  If your .obj file
      doesn't specify a texture, it won't be loaded and displayed
      unless you specify an default texture.

      e) In the Categories list on the left, click on "Libaries"

      f) Click the "Add Library" button on the right, and the "Add
      Library" dialogue will come up

      g) Select LWJGL-2.7.1 from the list of "Available Libraries" on
      the left, then click the "Add Library button", the "Add Library"
      dialogue should close.

      h) You should now be back at the "Project Properties" dialogue,
      click the "OK" button and it should close

And you're done!  Now use the menu option Run->Run Main Project, and
if oObjLoader is your current main project, it should compile
oObjLoader and run the lwgjl.Test program.  If you specified an .obj
file and a texture in the Project Propertries->Run dialogue, as
discussed in part 4d of the instructions above, it should shortly load
and display your model from the .obj file.  (Note that LARGE models
may take a while to load, so may simply see a window filled with black
for a moment.  Note also that if the default texture ends up being
used, your model may well look reall weird texture-wise.)



