package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Service {
    Scanner scanner = new Scanner(System.in);
    Emprestimo emprestimo = new Emprestimo();

    private List<Emprestimo> emprestimos;

    public void listaDeEmprestimos(Emprestimo emprestimo) {
        if (emprestimos == null) {
            emprestimos = new ArrayList<>();
        }
        emprestimos.add(emprestimo);
    }

    public List<Emprestimo> retornaListaEmprestimos() {
        return this.emprestimos;
    }

    public Emprestimo retornaEmprestimos(String nome) {
        for (Emprestimo emprestimo : emprestimos) {
            if (nome.equals(emprestimo.getPessoa().getNome())) {
                return emprestimo;
            }
        }
        return null;
    }

    public void novoEmprestimo() {
        emprestimo = new Emprestimo(pessoa(), tipoEmprestimo(), valorEmprestimo(), quantidadeMeses(), pagamento());
        listaDeEmprestimos(emprestimo);
    }

    public Pessoa pessoa() {
        System.out.println("Digite seu nome: ");
        String nome = scanner.next();
        System.out.println("Digite seu telefone: ");
        String telefone = scanner.next();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.next();
        return new Pessoa(nome, telefone, cpf);
    }

    public Tipo tipoEmprestimo() {
        System.out.println("Selecione a forma de emprestimo : \n[P]ESSOAL - [C]ONSIGNADO - [R]OTATIVO");
        String tipoEmprestimo = scanner.next();
        return Arrays.stream(Tipo.values())
                .filter(tipo -> tipoEmprestimo.equalsIgnoreCase(tipo.name()))
                .findFirst()
                .orElse(null);
    }

    public float valorEmprestimo() {
        System.out.println("Digite o valor que deseja solicitar o emprestimo: ");
        return scanner.nextFloat();
    }

    public int quantidadeMeses() {
        System.out.println("Selecione a quantidade de parcelas mês que deseja a pagar: ");
        int pagamentoMes = scanner.nextInt();
        if (pagamentoMes > 5) {
            System.out.println("Acima de 5 parcelas hávera um juros de 2,5 por parcela, valor da parcela: " + ((emprestimo.getValorDoEmprestimo() / pagamentoMes) + 1.025f));
        } else {
            System.out.println("Valor por parcela (Sem juros): " + (emprestimo.getValorDoEmprestimo() / pagamentoMes));
        }
        return pagamentoMes;
    }

    public int pagamento() {
        System.out.println("Quantas parcelas deseja pagar inicialmente ? ");
        return scanner.nextInt();
    }

    public void pagamentoPosterior() {
        System.out.println("Deseja realizar um pagamento ? [S/N]");
        String aceite = scanner.next();
        while (aceite.equals("s")) {
            System.out.print("Digite quantas parcelas deseja pagar: ");
            int pagamento = scanner.nextInt();
            emprestimo.pagamento(pagamento);
            if (emprestimo.getNumeroDeParcelasPagas() == emprestimo.quantidadeDeMesesParaPagamento() || emprestimo.getNumeroDeParcelasPagas() > emprestimo.quantidadeDeMesesParaPagamento()) {
                aceite = "n";
            } else {
                System.out.println("Deseja realizar mais algum pagamento ?");
                String pagarMais = scanner.next();
                if (pagarMais.equals("n")) {
                    aceite = "n";
                }
            }
        }
    }

    public void selecionaEmprestimo() {
        System.out.println("Deseja selecionar um emprestimo a lista de emprestimo ?");
        String selecionar = scanner.next();
        if (selecionar.equals("s")) {
            System.out.println("Digite o nome do dono do emprestimo: ");
            String dono = scanner.next();
            Emprestimo emprestimoEncontrado = retornaEmprestimos(dono);
            System.out.println(emprestimoEncontrado.toString());
        }
    }

    public void retornaListaDeEmprestimo() {
        List<Emprestimo> emprestimoList = retornaListaEmprestimos();
        for (Emprestimo emprestimo : emprestimoList) {
            System.out.println(emprestimo.toString());
        }
    }

    public boolean finalizaPrograma() {
        System.out.println("Deseja realizar um emprestimo ?");
        String continua = scanner.next();
        return continua.equalsIgnoreCase("s");
    }
}
