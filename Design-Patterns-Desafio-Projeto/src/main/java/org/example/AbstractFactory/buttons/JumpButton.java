package org.example.AbstractFactory.buttons;

public class JumpButton implements Button{
    @Override
    public void paint() {
        System.out.println("You have created JumpButton");
    }
}
