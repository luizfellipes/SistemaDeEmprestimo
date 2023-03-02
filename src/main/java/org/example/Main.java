package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Emprestimo emprestimo = new Emprestimo();

        String continua = "s";
        while (continua.equalsIgnoreCase("s")) {
            System.out.println("Sistema de Emprestimo");
            System.out.println("Selecione uma operação a seguir: \n[1]Cadastro \n[2]Emprestimo \n[3]Pagamento \n[4]Lista de emprestimo \n[5]Finalizar Operação");
            int operacao = scanner.nextInt();
            switch (operacao) {
                case 1 -> {
                    System.out.println("Digite seu nome: ");
                    String nome = scanner.next();
                    System.out.println("Digite seu telefone: ");
                    String telefone = scanner.next();
                    System.out.println("Digite seu CPF: ");
                    String cpf = scanner.next();
                    Pessoa pessoa = new Pessoa(nome, telefone, cpf);
                    emprestimo = new Emprestimo(pessoa);
                    emprestimo.solicitacaoDeEmprestimo(emprestimo);
                }
                case 2 -> {
                    System.out.println("Selecione a forma de emprestimo : \n[PESSOAL - CONSIGNADO - ROTATIVO]");
                    String tipoEmprestimo = scanner.next();
                    System.out.println("Digite o valor que deseja solicitar o emprestimo: ");
                    float valorEmprestimo = scanner.nextFloat();
                    System.out.println("Selecione a quantidade de parcelas mês que deseja a pagar: ");
                    int quantidadeMeses = scanner.nextInt();
                    if (quantidadeMeses > 5) {
                        System.out.println("Acima de 5 parcelas hávera um juros de 2,5 por parcela, valor da parcela: " + (valorEmprestimo / quantidadeMeses) * 1.025f);
                    } else {
                        System.out.println("Valor por parcela (Sem juros): " + valorEmprestimo / quantidadeMeses);
                    }
                    System.out.println("Emprestimo realizado com sucesso: " + " R$:" + valorEmprestimo + " x" + quantidadeMeses);
                    emprestimo = new Emprestimo(tipoEmprestimo, valorEmprestimo, quantidadeMeses);
                    emprestimo.solicitacaoDeEmprestimo(emprestimo);
                }
                case 3 -> {
                    System.out.println("Deseja realizar algum pagamento ?");
                    String pagamento = scanner.next();
                    if (pagamento.equalsIgnoreCase("s")) {
                        System.out.println("quantas parcelas deseja realizar o pagamento: ");
                        int parcelas = scanner.nextInt();
                        emprestimo = new Emprestimo(parcelas);
                        emprestimo.pagamento();
                        emprestimo.solicitacaoDeEmprestimo(emprestimo);
                    }
                }
                case 4 -> {
                    emprestimo.listaDeEmprestimos();
                }
                default -> {
                    System.out.println("Deseja realizar mais alguma operação ?");
                    if (scanner.next().equalsIgnoreCase("N")) {
                        continua = "n";
                    }
                }
            }
        }
    }
}