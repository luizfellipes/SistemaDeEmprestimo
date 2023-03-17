package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Service {
    Scanner scanner = new Scanner(System.in);
    Emprestimo emprestimo = new Emprestimo();

    private List<Emprestimo> emprestimos;

    public List<Emprestimo> ListaEmprestimos() {
        return this.emprestimos;
    }

    public void novoEmpretimo(Emprestimo emprestimo) {
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

    public void ListaDeEmprestimo() {
        List<Emprestimo> emprestimoList = ListaEmprestimos();
        for (Emprestimo emprestimo : emprestimoList) {
            System.out.println(emprestimo.toString());
        }
    }

    public void novoEmprestimo() {
        emprestimo = new Emprestimo(pessoa(), tipoEmprestimo(), valorEmprestimo(), quantidadeMeses(), pagamento());
        novoEmpretimo(emprestimo);
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
        do {
            System.out.println("Digite o valor que deseja solicitar o emprestimo: ");
            float valor = scanner.nextFloat();
            if (valor <= 0) {
                System.out.println("Valor de emprestimo invalido ! \nSolicite um valor maior que 0 ...");
            } else {
                return valor;
            }
        } while (true);
    }

    public int quantidadeMeses() {
        do {
            System.out.println("Selecione a quantidade de parcelas mês que deseja a pagar: ");
            int quantidade = scanner.nextInt();
            if (quantidade > 5) {
                System.out.println("Acima de 5 parcelas hávera um juros de 2,5 por parcela");
            }
            if (quantidade <= 0) {
                System.out.println("Parcela inválida !! \nSelecione uma parcela maior que 0...");
            } else {
                return quantidade;
            }
        } while (true);
    }

    public int pagamento() {
        do {
            System.out.println("Quantas parcelas deseja pagar incialmente ? ");
            int pagamento = scanner.nextInt();
            if (pagamento < 0 || pagamento > emprestimo.getQuantidadeDeMesesParaPagamento()) {
                System.out.println("Pagamento inválido, selecione uma parcela valida ! ");
            } else {
                return pagamento;
            }
        } while (true);
    }

    public void pagamentoPosterior() {
        try {
            System.out.println("Digite o nome do dono do emprestimo: ");
            String dono = scanner.next();
            Emprestimo emprestimoEncontrado = retornaEmprestimos(dono);
            System.out.println(emprestimoEncontrado.toString());
            String aceite = "s";
            while (aceite.equals("s") && emprestimoEncontrado.getQuantidadeDeMesesParaPagamento() != emprestimoEncontrado.getNumeroDeParcelasPagas()) {
                System.out.print("Digite quantas parcelas deseja pagar: ");
                int pagamento = scanner.nextInt();
                if (pagamento > 0 && pagamento <= emprestimoEncontrado.getQuantidadeDeMesesParaPagamento()) {
                    emprestimoEncontrado.setNumeroDeParcelasPagas(emprestimo.pagamento(pagamento));
                    if (emprestimoEncontrado.getNumeroDeParcelasPagas() == emprestimoEncontrado.quantidadeDeMesesParaPagamento()) {
                        aceite = "n";
                    } else {
                        System.out.println("Deseja realizar mais algum pagamento?");
                        if (scanner.next().equals("n")) {
                            aceite = "n";
                        }
                    }
                } else {
                    System.out.println("Pagamento inválido! Selecione uma parcela válida: x" + emprestimoEncontrado.getQuantidadeDeMesesParaPagamento());
                }
            }
        } catch (Exception donoNaoEncontrado) {
            System.out.println("Dono do emprestimo não encontrado");
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
