package org.designpattern.creational.singleton.temp;

import org.designpattern.creational.singleton.lazy.Singleton;

public class SingletonTestBreak {
    public static void main(String[] args) {
        // create an array of 20 threads
        Thread threads[] = new Thread[20];

        // Initialize each thread to call Singleton.getInstance() and print the hashcode
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                System.out.println("Instance hashcode : " + Singleton.getInstance().hashCode());
            });
        }

        // start all threads at the same time
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        // Join all threads to ensure main thread waits for them to finish
        for (int i = 0; i < 20; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
