package org.example.ChainOfResponsability.Handlers;

public class RoleCheckHandler extends Handler{
    @Override
    public boolean handle(String email, String password, boolean isAdmin) {
        if (!isAdmin) {
            System.out.println("[ERRO] Acesso negado: Requer privilegios de Administrador.");
            return false;
        }
        System.out.println("[OK] Acesso de Administrador concedido.");
        return checkNext(email, password, isAdmin);
    }
}
