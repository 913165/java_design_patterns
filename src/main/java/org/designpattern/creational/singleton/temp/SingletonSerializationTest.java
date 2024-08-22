package org.designpattern.creational.singleton.temp;

import org.designpattern.creational.singleton.Serializable.Singleton;

import java.io.*;

public class SingletonSerializationTest {

    public static void main(String[] args) {
        try {
            // Get the Singleton instance
            Singleton instance1 = Singleton.getInstance();
            System.out.println("Instance 1 hashcode: " + instance1.hashCode());

            // Serialize the Singleton instance
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
            oos.writeObject(instance1);
            oos.close();

            // Deserialize the Singleton instance
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));
            Singleton instance2 = (Singleton) ois.readObject();
            ois.close();

            System.out.println("Instance 2 hashcode: " + instance2.hashCode());

            // Check if both instances are the same
            System.out.println("Are both instances the same? " + (instance1 == instance2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
