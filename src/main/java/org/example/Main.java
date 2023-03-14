package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        String continua = "s";
        while (continua.equals("s")) {
            System.out.println("Sistema de Emprestimo");
            System.out.println("[1]realizar um emprestimo: \n[2]Pagamentos: \n[3]Lista de Emprestimos: ");
            int selecao = service.scanner.nextInt();
            switch (selecao) {
                case 1 -> {
                    service.novoEmprestimo();
                }
                case 2 -> {
                    service.pagamentoPosterior();
                }
                case 3 -> {
                    service.retornaListaDeEmprestimo();
                }
                case 4 -> {
                    service.selecionaEmprestimo();
                }
                default -> {
                    continua = "n";
                }
            }
        }
    }
}

/*TODO
Veificar lista
1) Listar valores
2) Verificar pagamento por seleção de pessoas
*/
