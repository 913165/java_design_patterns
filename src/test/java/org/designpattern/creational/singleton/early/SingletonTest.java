package org.designpattern.creational.singleton.early;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    public void testSingletonInstance(){
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // Asser that the two instances are the same
        assertSame(instance1, instance2,"The two instances are not the same.");
    }

    // check that singleton instance is not null
    @Test
    public void testSingletonInstanceNotNull(){
        Singleton instance = Singleton.getInstance();
        assertNotNull(instance, "The singleton instance is null.");
    }

    @Test
    public void testPrivateContructor() throws NoSuchMethodException {
        // attempt to get the constructor and assert that it is private
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();

        // ensure that the constructor is private
        assertTrue(constructor.isAccessible() == false, "The constructor is not private.");

    }
}