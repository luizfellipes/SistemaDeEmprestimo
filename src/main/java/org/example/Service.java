package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

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

    public Tipo tipoEmprestimo() {
        System.out.println("Selecione a forma de emprestimo : \n[P]ESSOAL - [C]ONSIGNADO - [R]OTATIVO");
        String tipoaq = scanner.next();
        return Arrays.stream(Tipo.values())
                .filter(tipo -> tipoaq.equalsIgnoreCase(tipo.name()))
                .findFirst()
                .orElse(null);
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
