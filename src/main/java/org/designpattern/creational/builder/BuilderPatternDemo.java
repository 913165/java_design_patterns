package org.designpattern.creational.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder("Large")
                .cheese(true)
                .pepperoni(true)
                //.bacon(true)
                .build();
        System.out.println(pizza);
    }
}
