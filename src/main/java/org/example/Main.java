package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o valor de empréstimo a ser solicitado: R$");
        float valorEmprestimo = scanner.nextFloat();
        System.out.print("Em quantas parcelas deseja pagar: ");
        int numeroDeParcelas = scanner.nextInt();
        System.out.println("========================================================");
        System.out.println("Digite quantas parcelas deseja pagar: ");
        int parcelaPaga = scanner.nextInt();
        Emprestimo emprestimo = new Emprestimo(valorEmprestimo, numeroDeParcelas, parcelaPaga);
        System.out.println("Valor de cada parcela: " + emprestimo.valorPorParcela());
        System.out.println("Esse é valor a ser pago: " + emprestimo.valorPago());
        emprestimo.emprestimoQuitado();

    }
}