package org.example;

import java.util.Scanner;

public class Service {
    Scanner scanner = new Scanner(System.in);
    Emprestimo emprestimo = new Emprestimo();


    public Pessoa pessoa() {
        System.out.println("Digite seu nome: ");
        String nome = scanner.next();
        System.out.println("Digite seu telefone: ");
        String telefone = scanner.next();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.next();
        return new Pessoa(nome, telefone, cpf);
    }

    public String tipoEmprestimo() {
        System.out.println("Selecione a forma de emprestimo : \n[PESSOAL - CONSIGNADO - ROTATIVO]");
        return scanner.next();
    }

    public float valorEmprestimo() {
        System.out.println("Digite o valor que deseja solicitar o emprestimo: ");
        return scanner.nextFloat();
    }

    public int quantidadeMeses() {
        System.out.println("Selecione a quantidade de parcelas mês que deseja a pagar: ");
        return scanner.nextInt();
    }

    public int pagamento() {
        System.out.println("quantas parcelas deseja realizar o pagamento: ");
        return scanner.nextInt();
    }

    public String retornaListaDeEmprestimo() {
        System.out.println("Deseja visualizar a lista de emprestimo ?");
        return scanner.next();
    }

    public boolean finalizaPrograma() {
        System.out.println("Sistema de Emprestimo");
        System.out.println("Deseja realizar um emprestimo ?");
        String continua = scanner.next();
        return continua.equalsIgnoreCase("s");
    }
}
