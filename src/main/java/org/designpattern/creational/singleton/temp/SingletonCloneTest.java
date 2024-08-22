package org.designpattern.creational.singleton.temp;

import org.designpattern.creational.singleton.clone.Singleton;

public class SingletonCloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        // Get the singleton instance
        Singleton instance1 = Singleton.getInstance();
        System.out.println("Instance 1 hashcode: " + instance1.hashCode());

        // Break the Singleton by cloning the instance
        Singleton instance2 = (Singleton) instance1.clone();
        System.out.println("Instance 2 hashcode: " + instance2.hashCode());
    }
}