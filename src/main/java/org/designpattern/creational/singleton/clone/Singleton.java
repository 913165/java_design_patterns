package org.designpattern.creational.singleton.clone;

public class Singleton implements Cloneable {
    private static Singleton instance;

    // private constructor to avoid client applications to use constructor
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Cloning method
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("cannot clone a singleton object.");
    }
}