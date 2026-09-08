package org.example.AbstractFactory.factories;

import org.example.AbstractFactory.buttons.AttackButton;
import org.example.AbstractFactory.buttons.Button;

public class AttackButtonFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new AttackButton();
    }
}
