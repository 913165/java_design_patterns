package org.designpattern.creational.abstractfactory;


interface Button {
    void paint();
}

interface CheckBox {
    void paint();
}

class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("Windows button");
    }
}

class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac button");
    }
}

class WinCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("Windows checkbox");
    }
}

class MacCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("Mac checkbox");
    }
}

interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}

class WinFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WinCheckBox();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

public class AbstractFactoryPatternDemo  {
    static Application configureApplication() {
        Application app;
        GUIFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacFactory();
            app = new Application(factory);
        } else {
            factory = new WinFactory();
            app = new Application(factory);
        }
        return app;
    }


    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}

// Supporting Application class
class Application {
    private final Button button;
    private final CheckBox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckBox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}