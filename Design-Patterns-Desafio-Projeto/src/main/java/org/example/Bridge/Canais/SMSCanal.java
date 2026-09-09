package org.example.Bridge.Canais;

public class SMSCanal implements CanalNotificacao{
    @Override
    public void enviarMensagem(String destinatario, String mensagem) {
        System.out.println("[SMS] Enviando mensagem para " + destinatario + ": " + mensagem);
    }
}
