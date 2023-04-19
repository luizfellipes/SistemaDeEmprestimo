package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Service {
    Scanner scanner = new Scanner(System.in);
    Emprestimo emprestimo = new Emprestimo();


    private List<Emprestimo> listEmprestimo;

    public void novoEmpretimo(Emprestimo emprestimo) {
        if (listEmprestimo == null) {
            listEmprestimo = new ArrayList<>();
        }
        listEmprestimo.add(emprestimo);
    }

    public void ListaDeEmprestimo() {
        List<Emprestimo> emprestimoList = this.listEmprestimo;
        for (Emprestimo emprestimo : emprestimoList) {
            System.out.println(emprestimo.toString());
        }
    }

    public Emprestimo retornaEmprestimos(String nome) {
        for (Emprestimo emprestimo : listEmprestimo) {
            if (nome.equals(emprestimo.getPessoa().getNome())) {
                return emprestimo;
            }
        }
        return null;
    }

    public void novaSolicitacaoEmprestimo() {
        novoEmpretimo(emprestimo = new Emprestimo(pessoa(), tipoEmprestimo(), valorEmprestimo(), quantidadeMeses(), pagamentoInicial()));
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
        System.out.println("Selecione a forma de emprestimo : \n[PESSOAL] - [CONSIGNADO] - [ROTATIVO]");
        String tipoEmprestimo = scanner.next();
        return Arrays.stream(Tipo.values())
                .filter(tipo -> tipoEmprestimo.equalsIgnoreCase(tipo.name()))
                .findFirst()
                .orElse(null);
    }

    public float valorEmprestimo() {
        float valor = 0;
        while (valor <= 0) {
            System.out.println("Digite o valor que deseja solicitar o emprestimo: ");
            valor = scanner.nextFloat();
            if (valor <= 0) {
                System.out.println("Valor de emprestimo invalido ! \nSolicite um valor maior que 0 ...");
            }
        }
        return valor;
    }


    public int quantidadeMeses() {
        int quantidade = 0;
        while (quantidade <= 0) {
            System.out.println("Selecione a quantidade de parcelas mês que deseja a pagar: ");
            quantidade = scanner.nextInt();
            if (quantidade > 5) {
                System.out.println("Acima de 5 parcelas hávera um juros de 2,5 por parcela");
            } else if (quantidade <= 0) {
                System.out.println("Parcela inválida !! \nSelecione uma parcela maior que 0...");
            }
        }
        return quantidade;
    }

    public int pagamentoInicial() {
        int pagamento = -1;
        while (pagamento < 0 ) {
            System.out.println("Quantas parcelas deseja pagar incialmente ? ");
            pagamento = scanner.nextInt();
            if (pagamento < 0) {
                System.out.println("Pagamento inválido, selecione uma parcela valida ! ");
            }
        }
        return pagamento;
    }

    public void pagamentoPosterior() {
        try {
            System.out.println("Digite o nome do dono do emprestimo: ");
            String dono = scanner.next();
            Emprestimo emprestimoEncontrado = retornaEmprestimos(dono);
            String aceite = "s";
            while (aceite.equals("s") && emprestimoEncontrado.getQuantidadeDeMesesParaPagamento() != emprestimoEncontrado.getNumeroDeParcelasPagas()) {
                System.out.println(emprestimoEncontrado);
                System.out.print("Digite quantas parcelas deseja pagar: ");
                int pagamento = scanner.nextInt();
                emprestimoEncontrado.setNumeroDeParcelasPagas(emprestimo.pagamento(pagamento));
                if (emprestimoEncontrado.getNumeroDeParcelasPagas() == emprestimoEncontrado.getQuantidadeDeMesesParaPagamento()) {
                    aceite = "n";
                } else {
                    System.out.println("Deseja realizar mais algum pagamento?");
                    if (scanner.next().equals("n")) {
                        aceite = "n";
                    }
                }
            }
        } catch (Exception donoNaoEncontrado) {
            System.err.println("Dono do emprestimo não encontrado");
        }
    }

    public void maiorValorDoEmprestimo() {
        Emprestimo maior = null;
        for (Emprestimo emprestimo : listEmprestimo) {
            if (maior == null || emprestimo.getValorDoEmprestimo() > maior.getValorDoEmprestimo()) {
                maior = emprestimo;
            }
        }
        System.out.println("Maior valor de emprestimo: " + maior);
    }

    public void menorValorDoEmprestimo() {
        Emprestimo menor = null;
        for (Emprestimo emprestimo : listEmprestimo) {
            if (menor == null || emprestimo.getValorDoEmprestimo() < menor.getValorDoEmprestimo()) {
                menor = emprestimo;
            }
        }
        System.out.println("Menor valor de emprestimo: " + menor);
    }

    public void totalEmprestimosRealizados() {
        float total = 0;
        for (Emprestimo emprestimo : listEmprestimo) {
            total += emprestimo.getValorDoEmprestimo();
        }
        System.out.println("Total de empréstimos realizados: " + total);
    }

    public void mediaValorEmprestimo() {
        float total = 0;
        int quantidadeDeEmprestimos = listEmprestimo.size();
        for (Emprestimo emprestimo : listEmprestimo) {
            total += emprestimo.getValorDoEmprestimo();
        }
        float media = total / quantidadeDeEmprestimos;
        System.out.println("Média de valores de empréstimo: " + media);
    }
}
