package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Fulano", "123456789", "123.456.789-00");
        Emprestimo emprestimo = new Emprestimo(10000, 4, 2, pessoa, Tipo.PESSOAL);
        System.out.println(emprestimo);
        emprestimo.realizarPagamento(2);
        emprestimo.ValorTotalPago();
        emprestimo.verificarQuitado();


        System.out.println();

        Pessoa pessoa1 = new Pessoa("Cicrano", "123456780", "123.456.789-01");
        Emprestimo emprestimo1 = new Emprestimo(1000, 10, 4, pessoa1, Tipo.ROTATIVO);
        System.out.println(emprestimo1);
        emprestimo1.realizarPagamento(6);
        emprestimo1.ValorTotalPago();
        emprestimo1.verificarQuitado();


        listEmprestimo.add(emprestimo);
        listEmprestimo.add(emprestimo1);

        System.out.println("\n");

        maiorValorDoEmprestimo();
        menorValorDoEmprestimo();
        totalEmprestimosRealizados();
        mediaValorEmprestimo();

    }

    //Lista de Emprestimos
    public static List<Emprestimo> listEmprestimo = new ArrayList<>(); ;

    //Busca o maior valor de emprestimo feito
    public static void maiorValorDoEmprestimo() {
        Emprestimo maior = Main.listEmprestimo.stream().max(Comparator.comparing(Emprestimo::getValorEmprestimo)).orElse(null);
        System.out.println("Maior valor de empréstimo: " + maior);
    }

    //Busca o menor valor de emprestimo feito
    public static void menorValorDoEmprestimo() {
        Emprestimo menor = Main.listEmprestimo.stream().min(Comparator.comparing(Emprestimo::getValorEmprestimo)).orElse(null);
        System.out.println("Menor valor de emprestimo: " + menor);
    }

    //Busca o total dos valores dos emprestimos feitos
    public static void totalEmprestimosRealizados() {
        double total = Main.listEmprestimo.stream().mapToDouble(Emprestimo::getValorEmprestimo).sum();
        System.out.println("Total de empréstimos realizados: " + total);
    }

    //Busca as medias de todos os valores de emprestimos feitos
    public static void mediaValorEmprestimo() {
        double media = Main.listEmprestimo.stream().mapToDouble(Emprestimo::getValorEmprestimo).average().orElse(0.0);
        System.out.println("Média de valores de empréstimo: " + media);
    }

}
