package org.example;

import org.example.AbstractFactory.app.Application;
import org.example.AbstractFactory.factories.AttackButtonFactory;
import org.example.AbstractFactory.factories.GUIFactory;
import org.example.AbstractFactory.factories.JumpButtonFactory;

public class Main {

    // Função da configuração da aplicação da fabrica abstrata
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String commandName = System.getProperty("command.name", "").toLowerCase();
        if (commandName.isEmpty()) {
            // No command specified: create both Attack and Jump buttons
            app = new Application(new AttackButtonFactory(), new JumpButtonFactory());
        } else {
            if (commandName.contains("attack")) {
                factory = new AttackButtonFactory();
            } else {
                factory = new JumpButtonFactory();
            }
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {

        // Fabrica abstrata
        Application app = configureApplication();
        app.paint();
    }
}