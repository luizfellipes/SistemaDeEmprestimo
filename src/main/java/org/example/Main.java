package org.example;

public class Main {
    public static void main(String[] args) {

        String continua = "s";
        while (continua.equals("s")) {
            Service service = new Service();
            System.out.println("Sistema de Emprestimo");
            System.out.println("[1]realizar um emprestimo: \n[2]Pagamentos: \n[3]Lista de Emprestimos: ");
            int selecao = service.scanner.nextInt();
            switch (selecao) {
                case 1 -> {
                    service.emprestimo = new Emprestimo(
                            service.pessoa(),
                            service.tipoEmprestimo(),
                            service.valorEmprestimo(),
                            service.quantidadeMeses(),
                            service.pagamento());
                    service.emprestimo.listaDeEmprestimos(service.emprestimo);
                }
                case 2 -> {
                    service.pagamentoPosterior();
                }
                case 3 -> {
                    service.emprestimo.retornaListaDeEmprestimos();
                }
                default -> {
                    continua = "n";
                }
            }
        }
    }
}