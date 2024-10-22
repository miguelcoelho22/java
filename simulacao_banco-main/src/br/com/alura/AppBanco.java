package br.com.alura;

import java.math.BigDecimal;

public class AppBanco {

    public static void main(String[] args) {

        Cliente cliente =  new Cliente("miguel");

        Conta conta = new Conta(cliente, new BigDecimal(100));

        OperacaoSaque operacaoSaque = new OperacaoSaque(conta, new BigDecimal(50));

        operacaoSaque.executa();

        Thread thread1 = new Thread(operacaoSaque);
        thread1.start();
        Thread thread2 = new Thread(operacaoSaque);
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
