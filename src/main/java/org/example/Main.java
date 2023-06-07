package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {

        Pessoa pessoa = new Pessoa("Fulano", "123456789", "123.456.789-00");
        Emprestimo emprestimo = new Emprestimo(10000, 4, 2, pessoa, Tipo.PESSOAL);
        emprestimo.realizarPagamento(1);
        emprestimo.ValorTotalPago();
        emprestimo.verificarQuitado();

        System.out.println("\n");

        Pessoa pessoa1 = new Pessoa("Cicrano", "123456780", "123.456.789-01");
        Emprestimo emprestimo1 = new Emprestimo(1000, 10, 4, pessoa1, Tipo.ROTATIVO);
        emprestimo1.realizarPagamento(5);
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
    public static List<Emprestimo> listEmprestimo = new ArrayList<>();


    //Busca o maior valor de emprestimo feito
    public static void maiorValorDoEmprestimo() {
        Emprestimo maior = listEmprestimo.stream().max(Comparator.comparing(Emprestimo::getValorEmprestimo)).orElse(null);
        System.out.println("Maior valor de empréstimo: " + maior);
    }

    //Busca o menor valor de emprestimo feito
    public static void menorValorDoEmprestimo() {
        Emprestimo menor = listEmprestimo.stream().min(Comparator.comparing(Emprestimo::getValorEmprestimo)).orElse(null);
        System.out.println("Menor valor de emprestimo: " + menor);
    }

    //Busca o total dos valores dos emprestimos feitos
    public static void totalEmprestimosRealizados() {
        double total = listEmprestimo.stream().mapToDouble(Emprestimo::getValorEmprestimo).sum();
        System.out.println("Total de empréstimos realizados: " + total);
    }

    //Busca as medias de todos os valores de emprestimos feitos
    public static void mediaValorEmprestimo() {
        double media = listEmprestimo.stream().mapToDouble(Emprestimo::getValorEmprestimo).average().orElse(0.0);
        System.out.println("Média de valores de empréstimo: " + media);
    }

}
