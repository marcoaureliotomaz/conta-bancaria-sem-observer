package com.gryphem;

public class ContaBancaria {
    private double saldo;

    // Referências diretas a notificadores específicos
    private NotificadorEmail notificadorEmail;
    private NotificadorSMS notificadorSMS;
    private boolean enviarEmail;
    private boolean enviarSMS;

    public ContaBancaria(boolean enviarEmail, boolean enviarSMS) {
        this.saldo = 0.0;
        this.enviarEmail = enviarEmail;
        this.enviarSMS = enviarSMS;

        // Criação direta das dependências (acoplamento forte)
        if (enviarEmail) {
            notificadorEmail = new NotificadorEmail("cliente@exemplo.com");
        }
        if (enviarSMS) {
            notificadorSMS = new NotificadorSMS("+55 11 99999-0000");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
        String msg = "Depósito de R$ " + valor + " realizado. Saldo atual: R$ " + saldo;
        notificar(msg);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            notificar("Saque de R$ " + valor + " realizado. Saldo atual: R$ " + saldo);
        } else {
            notificar("Saque de R$ " + valor + " falhou. Saldo insuficiente.");
        }
    }

    private void notificar(String mensagem) {
        // Lógica rígida e duplicada
        if (enviarEmail && notificadorEmail != null) {
            notificadorEmail.enviarEmail(mensagem);
        }
        if (enviarSMS && notificadorSMS != null) {
            notificadorSMS.enviarSMS(mensagem);
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
