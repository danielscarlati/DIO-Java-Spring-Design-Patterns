package org.example.Bridge.Notificacoes;

import org.example.Bridge.Canais.CanalNotificacao;

public class NotificacaoPromocional extends Notificacao{

    public NotificacaoPromocional(CanalNotificacao canal) {
        super(canal);
    }

    @Override
    public void notificar(String destinatario, String conteudo) {
        String mensagemFormatada = "Oferta especial: " + conteudo;
        canal.enviarMensagem(destinatario, mensagemFormatada);
    }
}
