package com.owens.oobjloader.test;

// Written by Sean R. Owens, sean at guild dot net, released to the
// public domain. Share and enjoy. Since some people argue that it is
// impossible to release software to the public domain, you are also free
// to use this code under any version of the GPL, LPGL, Apache, or BSD
// licenses, or contact me for use of another license.

import com.owens.oobjloader.parser.Parse;
import com.owens.oobjloader.builder.Build;


public class Test {

    public static void main(String[] argv) {

        for (String filename : argv) {

            System.err.println("LOADING FILE " + filename);
            try {
                Build builder = new Build();
                Parse obj = new Parse(builder, filename);
            } catch (java.io.FileNotFoundException e) {
                System.err.println("Exception loading object!  e=" + e);
                e.printStackTrace();
            } catch (java.io.IOException e) {
                System.err.println("Exception loading object!  e=" + e);
                e.printStackTrace();
            }
        }
    }
}