package org.designpattern.creational.singleton.temp;

import org.designpattern.creational.singleton.lazy.Singleton;

import java.lang.reflect.Constructor;

public class SingletonReflectionBreak {
    public static void main(String[] args) {
        try {
            // Get the singleton instance
            Singleton instance1 = Singleton.getInstance();
            System.out.println("Instance 1 hashcode: " + instance1.hashCode());

            // Break the Singleton by using reflection
            Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            Singleton instance2 = constructor.newInstance();
            System.out.println("Instance 2 hashcode: " + instance2.hashCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
