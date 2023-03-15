package org.example;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        String continua = "s";
        while (continua.equals("s")) {
            System.out.println("Sistema de Emprestimo");
            System.out.print("[1]realizar um emprestimo: \n[2]Pagamentos: \n[3]Lista de emprestimos: " +
                    "\n[4]Estatística dos emprestimos \n[5]Finalizar acesso: \nSeleção de opção: ");
            int selecao = service.scanner.nextInt();
            switch (selecao) {
                case 1 -> service.novoEmprestimo();
                case 2 -> service.pagamentoPosterior();
                case 3 -> service.ListaDeEmprestimo();
                case 4 -> {
                    System.out.println("[1]Maior emprestimo realizado: \n[2]Menor emprestimo realizado: \n[3]Valor total de todos os emprestimos: \n[4]Media dos valores totais de emprestimos realizados:");
                    int opcao = service.scanner.nextInt();
                    if (opcao == 1) {
                        service.maiorValorDoEmprestimo();
                    } else if (opcao == 2) {
                        service.menorValorDoEmprestimo();
                    } else if (opcao == 3) {
                        service.totalEmprestimosRealizados();
                    } else if (opcao == 4) {
                        service.mediaValorEmprestimo();
                    } else {
                        System.out.println("Opção invalida!");
                    }
                }
                case 5 -> continua = "n";
                default -> System.err.println("Opção invalida, selecione as opções do menu acima !");
            }
        }
    }
}
