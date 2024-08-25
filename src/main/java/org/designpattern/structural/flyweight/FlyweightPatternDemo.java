package org.designpattern.structural.flyweight;

public class FlyweightPatternDemo {
    public static void main(String[] args) {
        CharacterFlyweightFactory characterFlyweightFactory = new CharacterFlyweightFactory();
        CharacterFlyweight characterA = characterFlyweightFactory.getCharacter('A');
        CharacterFlyweight characterB = characterFlyweightFactory.getCharacter('B');
        CharacterFlyweight characterC = characterFlyweightFactory.getCharacter('C');
        CharacterFlyweight characterA2 = characterFlyweightFactory.getCharacter('A');

        characterA.display(12, "Red");
        characterB.display(14, "Green");
        characterC.display(16, "Blue");
        characterA2.display(18, "Yellow");

        String document = "Hello Flyweight Pattern!";
        int fontSize = 12;

        for (char c : document.toCharArray()) {
            CharacterFlyweight characterFlyweight = characterFlyweightFactory.getCharacter(c);
            characterFlyweight.display(fontSize, "black");
        }

    }
}
