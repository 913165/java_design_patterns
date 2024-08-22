package org.designpattern.creational.singleton.early;

public class Singleton {
    private static final Singleton instance = new Singleton();

    // private constructor to avoid client applications to use constructor
    private Singleton () {
    }

    // global access point to get instance
    public static Singleton getInstance() {
        return instance;
    }
}
