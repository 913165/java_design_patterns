package org.designpattern.creational.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryPatternTest {
    @Test
    void testWindowsFactory() {
        GUIFactory factory = new WinFactory();
        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();

        assertNotNull(button);
        assertNotNull(checkBox);

        assertInstanceOf(WinButton.class, button);
        assertInstanceOf(WinCheckBox.class, checkBox);
    }

    @Test
    void testMacFactory() {
        GUIFactory factory = new MacFactory();
        Button button = factory.createButton();
        CheckBox checkBox = factory.createCheckBox();

        assertNotNull(button);
        assertNotNull(checkBox);

        assertInstanceOf(MacButton.class, button);
        assertInstanceOf(MacCheckBox.class, checkBox);
    }

    @Test
    void testApplicationWithWindowsFactory() {
        GUIFactory factory = new WinFactory();
        Application app = new Application(factory);

        assertNotNull(app);

        app.paint();  // This should invoke paint() methods of WinButton and WinCheckbox
    }

    @Test
    void testApplicationWithMacFactory() {
        GUIFactory factory = new MacFactory();
        Application app = new Application(factory);

        assertNotNull(app);

        app.paint();  // This should invoke paint() methods of MacButton and MacCheckbox
    }

    @Test
    void testConfigureApplicationForWindows() {
        System.setProperty("os.name", "Windows 10");
        Application app = AbstractFactoryPatternDemo.configureApplication();

        assertNotNull(app);

        // This should use WinFactory and produce Windows-style UI elements
        app.paint();
    }

    @Test
    void testConfigureApplicationForMac() {
        System.setProperty("os.name", "Mac OS X");
        Application app = AbstractFactoryPatternDemo.configureApplication();

        assertNotNull(app);

        // This should use MacFactory and produce Mac-style UI elements
        app.paint();
    }

}