package org.designpattern.creational.builder;

public class Pizza {
    private final String size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean bacon;

    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.bacon = builder.bacon;
    }

    public String getSize() {
        return size;
    }

    public boolean isCheese() {
        return cheese;
    }

    public boolean isPepperoni() {
        return pepperoni;
    }

    public boolean isBacon() {
        return bacon;
    }

    public static class PizzaBuilder{
        private final String size;
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean bacon = false;

        public PizzaBuilder(String size) {
            this.size = size;
        }

        public PizzaBuilder cheese(boolean value){
            cheese = value;
            return this;
        }

        public PizzaBuilder pepperoni(boolean value){
            pepperoni = value;
            return this;
        }

        public PizzaBuilder bacon(boolean value){
            bacon = value;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }
    @Override
    public String toString() {
        return "Pizza [size=" + size +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", bacon=" + bacon + "]";
    }
}
