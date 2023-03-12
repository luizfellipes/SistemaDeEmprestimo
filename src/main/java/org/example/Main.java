package org.example;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
        while (service.finalizaPrograma()) {
            service.emprestimo = new Emprestimo(service.pessoa(), service.tipoEmprestimo(), service.valorEmprestimo(), service.quantidadeMeses(), service.pagamento());
            service.listaDeEmprestimos(service.emprestimo);
            service.selecionaEmprestimo();
            if (service.retornaListaDeEmprestimo().equals("s")) {
                service.retornaListaDeEmprestimos();
            }
        }
    }
}

/*TODO
Veificar lista
1) Duplicidade
2) Listar valores
3) Verificar pagamento por seleção de pessoas
*/