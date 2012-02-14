package com.owens.oobjloader.builder;

// Written by Sean R. Owens, sean at guild dot net, released to the
// public domain. Share and enjoy. Since some people argue that it is
// impossible to release software to the public domain, you are also free
// to use this code under any version of the GPL, LPGL, Apache, or BSD
// licenses, or contact me for use of another license.

import java.util.*;
import java.text.*;
import java.io.*;
import java.io.IOException;

public class FaceVertex {

    int index = -1;
    public VertexGeometric v = null;
    public VertexTexture t = null;
    public VertexNormal n = null;

    public String toString() {
        return v + "|" + n + "|" + t;
    }
}