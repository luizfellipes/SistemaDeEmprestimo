package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Fulano", "123456789", "123.456.789-00");
        Emprestimo emprestimo = new Emprestimo(1000, 5, 0, pessoa);

        System.out.println(emprestimo);

        emprestimo.realizarPagamento(5);

        System.out.println("Valor total pago: R$" + emprestimo.getValorTotalPago());

        emprestimo.verificarQuitado();
    }
}