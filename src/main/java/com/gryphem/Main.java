package com.gryphem;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(true, true);
        conta.depositar(200);
        conta.sacar(50);
        conta.sacar(300);
    }
}