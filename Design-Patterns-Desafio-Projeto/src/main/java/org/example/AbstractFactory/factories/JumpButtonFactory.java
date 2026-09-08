package org.example.AbstractFactory.factories;

import org.example.AbstractFactory.buttons.Button;
import org.example.AbstractFactory.buttons.JumpButton;

public class JumpButtonFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new JumpButton();
    }
}
