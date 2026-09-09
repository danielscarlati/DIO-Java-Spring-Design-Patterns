package org.example.Bridge.Notificacoes;

import org.example.Bridge.Canais.CanalNotificacao;

public abstract class Notificacao {
    protected CanalNotificacao canal;

    public Notificacao(CanalNotificacao canal) {
        this.canal = canal;
    }

    public abstract void notificar(String destinatario, String conteudo);
}
