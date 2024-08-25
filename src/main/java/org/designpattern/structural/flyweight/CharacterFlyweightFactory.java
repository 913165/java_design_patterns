package org.designpattern.structural.flyweight;

import java.util.Map;

public class CharacterFlyweightFactory {
    private final Map<Character,CharacterFlyweight> flyweightPool = new java.util.HashMap<>();

    public CharacterFlyweight getCharacter(Character character) {
        CharacterFlyweight characterFlyweight = flyweightPool.get(character);
        if(characterFlyweight == null) {
            characterFlyweight = new ConcreteCharacter(character);
            flyweightPool.put(character, characterFlyweight);
        }
        return characterFlyweight;
    }
}
