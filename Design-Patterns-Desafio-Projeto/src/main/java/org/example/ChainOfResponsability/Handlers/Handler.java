package org.example.ChainOfResponsability.Handlers;

public abstract class Handler {
    private Handler next;

    public Handler linkWith(Handler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(String email, String password, boolean isAdmin);

    protected boolean checkNext(String email, String password, boolean isAdmin) {
        if (next == null) {
            return true;
        }
        return next.handle(email, password, isAdmin);
    }
}
