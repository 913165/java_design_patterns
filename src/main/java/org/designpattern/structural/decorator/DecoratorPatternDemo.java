package org.designpattern.structural.decorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee c = new SimpleCoffee();
        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getDescription());

        c =  new MilkDecorator(c);
        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getDescription());

        c =  new SugarDecorator(c);
        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getDescription());
    }
}
