package com.owens.oobjloader.lwjgl;

// Written by Sean R. Owens, sean at guild dot net, released to the
// public domain. Share and enjoy. Since some people argue that it is
// impossible to release software to the public domain, you are also free
// to use this code under any version of the GPL, LPGL, Apache, or BSD
// licenses, or contact me for use of another license.

import java.util.*;

public class Scene {

    ArrayList<VBO> vboList = new ArrayList<VBO>();

    public Scene() {
    }

    public void addVBO(VBO r) {
        vboList.add(r);
    }

    public void render() {
        for (int loopi = 0; loopi < vboList.size(); loopi++) {
            vboList.get(loopi).render();
        }
    }
}