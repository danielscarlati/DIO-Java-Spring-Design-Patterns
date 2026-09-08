package org.example.AbstractFactory.app;

import org.example.AbstractFactory.buttons.Button;
import org.example.AbstractFactory.factories.GUIFactory;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Button> buttons;

    public Application(GUIFactory factory) {
        buttons = new ArrayList<>();
        buttons.add(factory.createButton());
    }

    public Application(GUIFactory... factories) {
        buttons = new ArrayList<>();
        for (GUIFactory f : factories) {
            buttons.add(f.createButton());
        }
    }

    public void paint() {
        for (Button b : buttons) {
            b.paint();
        }
    }
}

