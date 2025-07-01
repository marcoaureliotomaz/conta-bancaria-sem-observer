package com.gryphem;

public class NotificadorEmail {
    private String email;

    public NotificadorEmail(String email) {
        this.email = email;
    }

    public void enviarEmail(String mensagem) {
        System.out.println("[EMAIL enviado para " + email + "] " + mensagem);
    }
}
