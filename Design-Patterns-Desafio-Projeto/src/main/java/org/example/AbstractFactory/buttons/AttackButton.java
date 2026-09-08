package org.example.AbstractFactory.buttons;

public class AttackButton implements Button{

    @Override
    public void paint() {
        System.out.println("You have created AttackButton");
    }
}
