package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Emprestimo emprestimo = new Emprestimo();

        System.out.println("Digite o valor de empréstimo a ser solicitado: ");
        float valorEmprestimo = scanner.nextFloat();
        System.out.println("Em quantas parcelas deseja pagar: ");
        int parcelasParaPagar = scanner.nextInt();
        emprestimo.valorMaisParcela(valorEmprestimo, parcelasParaPagar);
        System.out.println(emprestimo);


        System.out.println("Digite quantas parcelas deseja pagar: ");
        int parcelaPaga = scanner.nextInt();
        emprestimo.pagandoEmprestimo(parcelaPaga);
        System.out.println("Digite o valor a ser pago: ");
        float valorDePagamento = scanner.nextInt();
        emprestimo.pagandoEmprestimo(valorDePagamento);


        System.out.println(emprestimo.emprestimoQuitado(valorDePagamento, parcelaPaga));

    }
}