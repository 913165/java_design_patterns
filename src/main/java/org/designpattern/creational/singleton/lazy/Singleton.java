package org.designpattern.creational.singleton.lazy;

public class Singleton {
    private static Singleton instance;

    // Flag to track if an instance is already created
    private static boolean instanceCreated = false;

    // private contructor to avoid client applications to use constructor
    private Singleton() {
        if (instanceCreated) {
            throw new RuntimeException("Cannot create instance, use getInstance()");
        }
        instanceCreated = true;
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
}
