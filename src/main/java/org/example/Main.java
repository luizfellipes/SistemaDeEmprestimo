package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {

        PessoaFisica pessoa = new PessoaFisica("Fulano", "123456789", "123.456.789-00", "a16sf551s6");
        Emprestimo emprestimo = new Emprestimo(10000, 4, 2, pessoa, Tipo.PESSOAL);
        criaEmprestimo(emprestimo);
        System.out.println(emprestimo);
        emprestimo.realizarPagamento(1);
        emprestimo.ValorTotalPago();
        emprestimo.verificarQuitado();
        System.out.println();

        PessoaJuridica pessoa1 = new PessoaJuridica("Cicrano", "123456780", "12.345.678/0001-90", "s214214");
        criaEmprestimo(emprestimo = new Emprestimo(5000, 10, 4, pessoa1, Tipo.ROTATIVO));
        System.out.println(emprestimo);
        emprestimo.ValorTotalPago();
        emprestimo.verificarQuitado();
        System.out.println();


        Aposentado pessoa2 = new Aposentado("Beltrano", "123456712", "123.010.789-01", "s2142232314", "05/02/2023");
        criaEmprestimo(emprestimo = new Emprestimo(1000, 10, 3, pessoa2, Tipo.CONSIGNADO));
        System.out.println(emprestimo);
        emprestimo.realizarPagamento(6);
        emprestimo.ValorTotalPago();
        emprestimo.verificarQuitado();


        System.out.println("\n");
        maiorValorDoEmprestimo();
        menorValorDoEmprestimo();
        totalEmprestimosRealizados();
        mediaValorEmprestimo();


        System.out.println(buscaEmprestimo("Beltrano"));
    }

    //Lista de Emprestimos
    public static List<Emprestimo> listEmprestimo;

    public static void criaEmprestimo(Emprestimo emprestimo) {
        if (listEmprestimo == null) {
            listEmprestimo = new ArrayList<>();
        } else {
            listEmprestimo.add(emprestimo);
        }
    }

    public static Emprestimo buscaEmprestimo(String pessoa) {
        for (Emprestimo emprestimo : listEmprestimo) {
            if (emprestimo.getPessoa().getNome().equals(pessoa)) {
                return emprestimo;
            }
        }
        return null;
    }

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