package org.example.Bridge.Notificacoes;

import org.example.Bridge.Canais.CanalNotificacao;

public class NotificacaoUrgente extends Notificacao{

    public NotificacaoUrgente(CanalNotificacao canal) {
        super(canal);
    }

    @Override
    public void notificar(String destinatario, String conteudo) {
        String mensagemFormatada = "[ALERTA CRITICO] " + conteudo.toUpperCase();
        canal.enviarMensagem(destinatario, mensagemFormatada);
    }
}
