package org.example;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        while (service.finalizaPrograma()) {
            Emprestimo emprestimo = new Emprestimo(service.pessoa(), service.tipoEmprestimo(), service.valorEmprestimo(), service.quantidadeMeses(), service.pagamento());
            emprestimo.listaDeEmprestimos(emprestimo);
            emprestimo.pagamento();
            if (service.retornaListaDeEmprestimo().equals("s")) {
                emprestimo.retornaListaDeEmprestimos();
            }

        }
    }
}