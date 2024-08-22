package org.designpattern.creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {
    @Test
    void testPizzaCreationWithAllIngredients() {
        Pizza pizza = new Pizza.PizzaBuilder("Large")
                .cheese(true)
                .pepperoni(true)
                .bacon(true)
                .build();
        assertEquals("Large", pizza.getSize());
        assertEquals("Pizza [size=Large, cheese=true, pepperoni=true, bacon=true]", pizza.toString());
        assertTrue(pizza.isCheese());
        assertTrue(pizza.isPepperoni());
        assertTrue(pizza.isBacon());
    }

    @Test
    void testPizzaCreationWithNoOptionalIngredients() {
        Pizza pizza = new Pizza.PizzaBuilder("Small")
                .build();

        assertEquals("Small", pizza.getSize());
        assertFalse(pizza.isCheese());
        assertFalse(pizza.isPepperoni());
        assertFalse(pizza.isBacon());
    }

    @Test
    void testImmutablePizza() {
        Pizza pizza = new Pizza.PizzaBuilder("Large")
                .cheese(true)
                .build();

        // Verify immutability
        assertThrows(IllegalAccessException.class, () -> {
            // Attempting to change any attribute should fail
            pizza.getClass().getDeclaredField("size").setAccessible(true);
            pizza.getClass().getDeclaredField("size").set(pizza, "Extra Large");
        });
    }

}