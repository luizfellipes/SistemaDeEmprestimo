package org.example;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        String continua = "s";
        while (continua.equals("s")) {
            System.out.println("Sistema de Emprestimo");
            System.out.println("[1]realizar um emprestimo: \n[2]Pagamentos: \n[3]Lista de emprestimos: " +
                    "\n[4]Seleciona emprestimo \n[5]Menor emprestimo realizado: \n[6]Maior emprestimo realizado" +
                    "\n[7]Valor total de todos os emprestimos: \n[8]Media dos valores totais de emprestimos realizados: ");
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
                case 5 -> {
                    service.maiorValorDoEmprestimo();
                }
                case 6 -> {
                    service.menorValorDoEmprestimo();
                }
                case 7 -> {
                    service.totalEmprestimosRealizados();
                }
                case 8 -> {
                    service.mediaValorEmprestimo();
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
