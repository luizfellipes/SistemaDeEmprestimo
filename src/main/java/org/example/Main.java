package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {

        PessoaFisica pessoa = new PessoaFisica("Fulano", "123456789", "123.456.789-00", "a16sf551s6");
        Emprestimo emprestimo = new Emprestimo(10000, 4, 4, pessoa, Tipo.PESSOAL);
        criaEmprestimo(emprestimo);

        PessoaJuridica pessoa1 = new PessoaJuridica("Cicrano", "123456780", "12.345.678/0001-90", "s214214");
        Emprestimo emprestimo1 = new Emprestimo(5000, 10, 4, pessoa1, Tipo.ROTATIVO);
        criaEmprestimo(emprestimo1);

        Aposentado pessoa2 = new Aposentado("Beltrano", "123456712", "123.010.789-01", "s2142232314", "05/02/2023");
        Emprestimo emprestimo2 = new Emprestimo(1000, 10, 3, pessoa2, Tipo.CONSIGNADO);
        criaEmprestimo(emprestimo2);



        buscaEmprestimo(emprestimo2);
        System.out.println("\n-----------------------------------------------------");

        buscaEmprestimo(10000, Tipo.PESSOAL, "Fulano");
        System.out.println("\n-----------------------------------------------------");

        removerEmprestimo(emprestimo1);
        maiorValorDoEmprestimo();
        menorValorDoEmprestimo();
        totalEmprestimosRealizados();
        mediaValorEmprestimo();

    }

    //Lista de Emprestimos
    public static List<Emprestimo> listEmprestimo;

    public static void criaEmprestimo(Emprestimo emprestimo) {
        if (listEmprestimo == null) {
            listEmprestimo = new ArrayList<>();
            listEmprestimo.add(emprestimo);
        } else {
            listEmprestimo.add(emprestimo);
        }
    }

    public static void removerEmprestimo(Emprestimo emprestimo) {
        listEmprestimo.remove(emprestimo);
    }

    public static void buscaEmprestimo(float valorEmprestimo, Tipo tipo, String pessoa) throws Exception {
        for (Emprestimo emprestimo : listEmprestimo) {
            if (emprestimo.getPessoa().getNome().equals(pessoa) && emprestimo.getValorEmprestimo() == valorEmprestimo && emprestimo.getTipo() == tipo) {
                System.out.println(emprestimo);
                emprestimo.realizarPagamento(1);
                emprestimo.ValorTotalPago();
                emprestimo.verificarQuitado();
                return;
            }
        }
    }

    public static void buscaEmprestimo(Emprestimo emprestimo) {
        for (Emprestimo emprestimo1 : listEmprestimo){
            if(emprestimo1.equals(emprestimo)){
                System.out.println(emprestimo);
            }
        }
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