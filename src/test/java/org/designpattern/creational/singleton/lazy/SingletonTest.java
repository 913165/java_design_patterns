package org.designpattern.creational.singleton.lazy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

   //check not null
   @Test
    public void testSingletonInstanceNotNull(){
         Singleton instance = Singleton.getInstance();
         assertNotNull(instance, "The singleton instance is null.");
    }

    // check for same  instance
    @Test
    public void testSingletonInstance(){
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // Asser that the two instances are the same
        assertSame(instance1, instance2,"The two instances are not the same.");
    }

    // check for private constructor
    @Test
    public void testPrivateContructor() throws NoSuchMethodException {
        // attempt to get the constructor and assert that it is private
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();

        // ensure that the constructor is private
        assertTrue(constructor.isAccessible() == false, "The constructor is not private.");
     }

     // check for multiple two threads
        @Test
    public void testMultipleThreads() {
        Thread thread1 = new Thread(() -> {
            Singleton instance1 = Singleton.getInstance();
            System.out.println("Instance 1: " + instance1.hashCode());
        });

        Thread thread2 = new Thread(() -> {
            Singleton instance2 = Singleton.getInstance();
            System.out.println("Instance 2: " + instance2.hashCode());
        });

        thread1.start();
        thread2.start();
        }


}
