package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("============= Sistema de Empréstimo =============");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        Pessoa pessoa = new Pessoa(nome, telefone, cpf);



        if (pessoa.pessoaExiste(true)) {
            System.out.print("Digite o valor de empréstimo a ser solicitado: ");
            float valorEmprestimo = scanner.nextFloat();
            System.out.print("Em quantas parcelas deseja pagar: ");
            int numeroDeParcelas = scanner.nextInt();
            System.out.println("========================================================");
            System.out.print("Digite o número da parcela a ser paga: ");
            int parcelaPaga = scanner.nextInt();
            Emprestimo emprestimo = new Emprestimo(valorEmprestimo, numeroDeParcelas, parcelaPaga, pessoa);
            emprestimo.pagamento();
        }
    }
}