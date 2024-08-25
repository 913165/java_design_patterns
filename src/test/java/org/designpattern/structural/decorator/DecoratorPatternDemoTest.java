package org.designpattern.structural.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorPatternDemoTest {
    @Test
    public void testSimpleCoffee() {
        Coffee coffee = new SimpleCoffee();
        assertEquals("Simple Coffee", coffee.getDescription());
        assertEquals(5.0, coffee.getCost());
    }

    @Test
    public void testCoffeeWithMilk() {
        Coffee coffee = new MilkDecorator(new SimpleCoffee());
        assertEquals("Simple Coffee, Milk", coffee.getDescription());
        assertEquals(5.5, coffee.getCost());
    }

    @Test
    public void testCoffeeWithMilkAndSugar() {
        Coffee coffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        assertEquals("Simple Coffee, Milk, Sugar", coffee.getDescription());
        assertEquals(6.0, coffee.getCost());
    }
}