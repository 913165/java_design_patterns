package org.designpattern.structural.bridge;

// abstraction
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract public void applyColor();
}

class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Circle filled with color ");
        color.applyColor();
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Square filled with color ");
        color.applyColor();
    }
}

// Implementor Interface
interface Color {
    void applyColor();
}

// Concrete Implementor
class Red implements Color {
    public void applyColor() {
        System.out.println("red.");
    }
}

// Concrete Implementor
class Green implements Color {
    public void applyColor() {
        System.out.println("green.");
    }
}

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new Red());
        Shape greenSquare = new Square(new Green());

        redCircle.applyColor();
        greenSquare.applyColor();
    }
}
