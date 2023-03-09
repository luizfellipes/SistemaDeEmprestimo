package org.example;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
        while (service.finalizaPrograma()) {
          service.emprestimo = new Emprestimo(service.pessoa(), service.tipoEmprestimo(), service.valorEmprestimo(), service.quantidadeMeses(), service.pagamento());
            }
        service.emprestimo.listaDeEmprestimos(service.emprestimo);
        service.pagamentoPosterior();
        if (service.retornaListaDeEmprestimo().equals("s")) {
            service.emprestimo.retornaListaDeEmprestimos();
        }
    }
}