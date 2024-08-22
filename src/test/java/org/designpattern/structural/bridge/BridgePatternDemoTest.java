package org.designpattern.structural.bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class BridgePatternDemoTest {
    private Color redColor;
    private Color greenColor;
    private Shape circle;
    private Shape square;

    @BeforeEach
    void setUp() {
        redColor = new Red();
        greenColor = new Green();
        circle = new Circle(redColor);
        square = new Square(greenColor);
    }

    @Test
    void testCircleApplyRedColor() {
        circle.applyColor();
        Assertions.assertEquals("Circle filled with color red.\n", System.out.toString());
    }
}