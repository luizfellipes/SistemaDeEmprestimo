package org.example;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        String continua = "s";
        if (continua.equals("s")) {
            while(service.finalizaPrograma()) {
                Emprestimo emprestimo = new Emprestimo(service.pessoa(), service.tipoEmprestimo(), service.valorEmprestimo(), service.quantidadeMeses(), service.pagamento());
                emprestimo.listaDeEmprestimos(emprestimo);
                service.pagamentoPosterior();
                if (service.retornaListaDeEmprestimo().equals("s")) {
                    emprestimo.retornaListaDeEmprestimos();
                }
            }
        }
    }
}