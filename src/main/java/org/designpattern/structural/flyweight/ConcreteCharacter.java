package org.designpattern.structural.flyweight;

public class ConcreteCharacter implements CharacterFlyweight {
    private char character; // intrinsic state (shared)

    public ConcreteCharacter(char character) {
        this.character = character;
    }

    @Override
    public void display(int fontSize, String color) {
        System.out.println("Character: " + character + ", Font Size: " + fontSize + ", Color: " + color);
    }
}
