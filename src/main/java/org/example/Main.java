package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de Emprestimo");
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu telefone: ");
        String telefone = scanner.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        Pessoa pessoa = new Pessoa(nome, telefone, cpf);

        System.out.println("Selecione a forma de emprestimo : \n[PESSOAL - CONSIGNADO - ROTATIVO]");
        String tipoEmprestimo = scanner.nextLine();
        System.out.println("Digite o valor que deseja solicitar o emprestimo: ");
        float valorEmprestimo = scanner.nextFloat();
        System.out.println("Selecione a quantidade de parcelas mês que deseja a pagar: ");
        int quantidadeMeses = scanner.nextInt();
        if (quantidadeMeses > 5){
            System.out.println("Acima de 5 parcelas hávera um juros de 2,5 por parcela, valor da parcela: " + (valorEmprestimo / quantidadeMeses) * 0.975f);
        }else{
            System.out.println("Valor por parcela (Sem juros): " + valorEmprestimo / quantidadeMeses);
        }
        System.out.println("Emprestimo realizado com sucesso: " + " R$:" + valorEmprestimo + " x" + quantidadeMeses);


        System.out.println("Deseja realizar algum pagamento ?");
        String escolha = scanner.next();
        if (escolha.equalsIgnoreCase("s")){
            System.out.println("quantas parcelas deseja realizar o pagamento: ");
            int parcelas = scanner.nextInt();
            Emprestimo emprestimo = new Emprestimo(pessoa, valorEmprestimo, quantidadeMeses, parcelas, tipoEmprestimo);
            emprestimo.solicitacaoDeEmprestimo(emprestimo);
            emprestimo.pagamento();
            emprestimo.listaDeEmprestimos();
        }

    }
}