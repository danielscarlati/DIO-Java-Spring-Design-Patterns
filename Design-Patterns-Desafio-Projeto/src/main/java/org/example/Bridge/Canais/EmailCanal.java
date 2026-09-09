package org.example.Bridge.Canais;

public class EmailCanal implements CanalNotificacao{
    @Override
    public void enviarMensagem(String destinatario, String mensagem) {
        System.out.println("[EMAIL] Enviando mensagem para " + destinatario + ": " + mensagem);
    }
}
