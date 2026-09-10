package org.example.ChainOfResponsability.Handlers;

public class FieldValidationHandler extends Handler{
    @Override
    public boolean handle(String email, String password, boolean isAdmin) {
        if (email == null || !email.contains("@")) {
            System.out.println("[ERRO] Email invalido.");
            return false;
        }
        if (password == null || password.length() < 6) {
            System.out.println("[ERRO] Senha muito curta.");
            return false;
        }
        System.out.println("[OK] Campos validos");
        return checkNext(email, password, isAdmin);
    }
}
