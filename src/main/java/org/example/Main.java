package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Emprestimo realizandoEmprestimo = new Emprestimo();

        System.out.println("============= Sistema de empréstimo =============");

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu telefone: ");
        String telefone = scanner.nextLine();
        System.out.println("Digite seu cpf: ");
        String cpf = scanner.nextLine();
        Pessoa pessoa = new Pessoa(nome, telefone, cpf);


        boolean alguem = true;
        if (pessoa.pessoaExiste(alguem)) {
            System.out.print("Digite o valor de empréstimo a ser solicitado: R$");
            float valorEmprestimo = scanner.nextFloat();
            System.out.print("Em quantas parcelas deseja pagar: ");
            int numeroDeParcelas = scanner.nextInt();
            System.out.println("========================================================");
            String continua = "s";
            while (continua.equalsIgnoreCase("s")) {
                System.out.println("Digite quantas parcelas deseja pagar: ");
                int parcelaPaga = scanner.nextInt();
                Emprestimo emprestimo = new Emprestimo(valorEmprestimo, numeroDeParcelas, parcelaPaga);
                emprestimo.pagamento();
                System.out.println("Deseja realizar mais algum pagamento ?");
                continua = scanner.next();
            }
        }

    }
}