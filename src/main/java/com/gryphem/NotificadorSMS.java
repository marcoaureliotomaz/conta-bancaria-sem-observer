package com.gryphem;

public class NotificadorSMS {
    private String numero;

    public NotificadorSMS(String numero) {
        this.numero = numero;
    }

    public void enviarSMS(String mensagem) {
        System.out.println("[SMS enviado para " + numero + "] " + mensagem);
    }
}
