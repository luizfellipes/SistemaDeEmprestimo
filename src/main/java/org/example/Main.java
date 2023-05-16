package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Fulano", "123456789", "123.456.789-00");
        Emprestimo emprestimo = new Emprestimo(1000, 10, 2, pessoa);
        System.out.println(emprestimo);
        emprestimo.realizarPagamento(6);
        emprestimo.getValorTotalPago();
        emprestimo.verificarQuitado();


        System.out.println();

        Pessoa pessoa1 = new Pessoa("Cicrano", "123456780", "123.456.789-01");
        Emprestimo emprestimo1 = new Emprestimo(1000, 10, 4, pessoa1);
        System.out.println(emprestimo1);
        emprestimo1.realizarPagamento(6);
        emprestimo1.getValorTotalPago();
        emprestimo1.verificarQuitado();
    }
}