package org.example;

public class Main {
    public static void main(String[] args) {
        Emprestimo emprestimo = new Emprestimo();
        Service service = new Service();

        while (service.finalizaPrograma()) {
            System.out.println("Sistema de Emprestimo");
            emprestimo = new Emprestimo(service.pessoa(), service.tipoEmprestimo(), service.valorEmprestimo(), service.quantidadeMeses());


            if (service.retornaListaDeEmprestimo().equals("s")) {
                emprestimo.retornaListaDeEmprestimos();
            }

        }
    }
}