package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Service {
    Scanner scanner = new Scanner(System.in);
    Emprestimo emprestimo = new Emprestimo();

    private List<Emprestimo> emprestimos;
    public List<Emprestimo> retornaListaEmprestimos() {
        return this.emprestimos;
    }

    public void listaDeEmprestimos(Emprestimo emprestimo) {
        if (emprestimos == null) {
            emprestimos = new ArrayList<>();
        }
        emprestimos.add(emprestimo);
    }

    public Emprestimo retornaEmprestimos(String nome) {
        for (Emprestimo emprestimo : emprestimos) {
            if (nome.equals(emprestimo.getPessoa().getNome())) {
                return emprestimo;
            }
        }
        return null;
    }

    public void retornaListaDeEmprestimo() {
        List<Emprestimo> emprestimoList = retornaListaEmprestimos();
        for (Emprestimo emprestimo : emprestimoList) {
            System.out.println(emprestimo.toString());
        }
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
        return scanner.nextInt();
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

    public void maiorValorDoEmprestimo() {
        Emprestimo maior = emprestimos.get(0);
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getValorDoEmprestimo() > maior.getValorDoEmprestimo()) {
                maior = emprestimo;
            }
        }
        System.out.println("Maior valor de emprestimo: " + maior);
    }

    public void menorValorDoEmprestimo() {
        Emprestimo menor = emprestimos.get(0);
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getValorDoEmprestimo() < menor.getValorDoEmprestimo()) {
                menor = emprestimo;
            }
        }
        System.out.println("Menor valor de emprestimo: " + menor);
    }

    public void totalEmprestimosRealizados() {
        float total = 0;
        for (Emprestimo emprestimo : emprestimos) {
            total += emprestimo.getValorDoEmprestimo();
        }
        System.out.println("Total de empréstimos realizados: " + total);
    }

    public void mediaValorEmprestimo() {
        float total = 0;
        int quantidadeDeEmprestimos = emprestimos.size();
        for (Emprestimo emprestimo : emprestimos) {
            total += emprestimo.getValorDoEmprestimo();
        }
        float media = total / quantidadeDeEmprestimos;
        System.out.println("Média de valores de empréstimo: " + media);
    }
}
