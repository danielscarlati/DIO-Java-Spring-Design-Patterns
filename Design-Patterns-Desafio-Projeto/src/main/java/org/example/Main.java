package org.example;

import org.example.AbstractFactory.app.Application;
import org.example.AbstractFactory.factories.AttackButtonFactory;
import org.example.AbstractFactory.factories.GUIFactory;
import org.example.AbstractFactory.factories.JumpButtonFactory;
import org.example.Bridge.Canais.CanalNotificacao;
import org.example.Bridge.Canais.EmailCanal;
import org.example.Bridge.Canais.SMSCanal;
import org.example.Bridge.Notificacoes.Notificacao;
import org.example.Bridge.Notificacoes.NotificacaoPromocional;
import org.example.Bridge.Notificacoes.NotificacaoUrgente;
import org.example.ChainOfResponsability.Handlers.AuthenticationHandler;
import org.example.ChainOfResponsability.Handlers.FieldValidationHandler;
import org.example.ChainOfResponsability.Handlers.Handler;
import org.example.ChainOfResponsability.Handlers.RoleCheckHandler;

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

        // Bridge (Ponte)
        // Criando os canais (Implementações)
        CanalNotificacao email = new EmailCanal();
        CanalNotificacao sms = new SMSCanal();

        // Enviando notificação URGENTE via SMS
        Notificacao urgenciaSms = new NotificacaoUrgente(sms);
        urgenciaSms.notificar("+5511999999999", "Servidor caiu!");

        // Enviando notificação URGENTE via Email (Mesma abstração, outro canal)
        Notificacao urgenciaEmail = new NotificacaoUrgente(email);
        urgenciaEmail.notificar("admin@empresa.com", "Servidor caiu!");

        // Enviando notificação PROMOCIONAL via Email
        Notificacao promoEmail = new NotificacaoPromocional(email);
        promoEmail.notificar("cliente@gmail.com", "50% de desconto no plano Pro.");

        // Chain of Responsibility (Cadeia de Responsabilidade)
        // Montagem da corrente: FieldValidation -> Authentication -> RoleCheck
        Handler pipeline = new FieldValidationHandler();
        pipeline.linkWith(new AuthenticationHandler())
                .linkWith(new RoleCheckHandler());

        System.out.println("--- Tentativa 1: Senha inválida ---");
        pipeline.handle("admin@cyber.com", "123", true);

        System.out.println("\n--- Tentativa 2: Sem privilégio de admin ---");
        pipeline.handle("admin@cyber.com", "123456", false);

        System.out.println("\n--- Tentativa 3: Sucesso ---");
        boolean sucesso = pipeline.handle("admin@cyber.com", "123456", true);
        System.out.println("Resultado do Acesso: " + (sucesso ? "AUTORIZADO" : "BLOQUEADO"));
    }
}

