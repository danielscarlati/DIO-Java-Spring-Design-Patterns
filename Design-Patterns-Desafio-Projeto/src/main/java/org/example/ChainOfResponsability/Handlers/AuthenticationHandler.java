package org.example.ChainOfResponsability.Handlers;

public class AuthenticationHandler extends Handler{
    @Override
    public boolean handle(String email, String password, boolean isAdmin) {
        if (!"admin@cyber.com".equals(email) || !"123456".equals(password)) {
            System.out.println("[ERRO] Credenciais incorretas.");
            return false;
        }
        System.out.println("[OK] Usuario autenticado.");
        return checkNext(email, password, isAdmin);
    }
}
