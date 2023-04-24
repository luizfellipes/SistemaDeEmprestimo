package org.example;

import java.util.*;

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
        //cadastra uma nova pessoa
        Pessoa pessoa = pessoa();

        //seleciona o tipo de emprestimo
        Tipo tipoEmprestimo = tipoEmprestimo();

        //Valor do Emprestimo
        float valorEmprestimo = 0;
        while (valorEmprestimo <= 0) {
            System.out.println("Digite o valor que deseja solicitar o emprestimo: ");
            valorEmprestimo = scanner.nextFloat();
            if (valorEmprestimo <= 0) {
                System.out.println("Valor de emprestimo invalido ! \nSolicite um valor maior que 0 ...");
            }
        }

        //Quantidade de meses a serem pagas
        int quantidadeMeses = 0;
        while (quantidadeMeses <= 0) {
            System.out.println("Selecione a quantidade de parcelas mês que deseja a pagar: ");
            quantidadeMeses = scanner.nextInt();
            if (quantidadeMeses > 5) {
                System.out.println("Acima de 5 parcelas hávera um juros de 2,5 por parcela");
            } else if (quantidadeMeses <= 0) {
                System.out.println("Parcela inválida !! \nSelecione uma parcela maior que 0...");
            }
        }

        //pagamento inicial
        int pagamentoInicial = -1;
        while (pagamentoInicial < 0 || pagamentoInicial > quantidadeMeses ) {
            System.out.println("Quantas parcelas deseja pagar incialmente ? ");
            pagamentoInicial = scanner.nextInt();
            if (pagamentoInicial < 0 ) {
                System.out.println("Pagamento inválido, selecione uma parcela valida ! ");
            }
        }

        //valor do pagamento realizado
        float valorDoPagamento;
        float valorDaParcela = valorEmprestimo / quantidadeMeses;
        if (quantidadeMeses > 5){
            float juros = valorDaParcela * 1.025f;
            valorDoPagamento = pagamentoInicial * juros;
        }else{
            valorDoPagamento = valorDaParcela * pagamentoInicial;
        }

        novoEmpretimo(emprestimo = new Emprestimo(pessoa, tipoEmprestimo, valorEmprestimo, quantidadeMeses, pagamentoInicial, valorDoPagamento));
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
                emprestimoEncontrado.pagamento(pagamento);
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
        Emprestimo maior = listEmprestimo.stream().max(Comparator.comparing(Emprestimo::getValorDoEmprestimo)).orElse(null);
        System.out.println("Maior valor de empréstimo: " + maior);
    }

    public void menorValorDoEmprestimo() {
        Emprestimo menor = listEmprestimo.stream().min(Comparator.comparing(Emprestimo::getValorDoEmprestimo)).orElse(null);
        System.out.println("Menor valor de emprestimo: " + menor);
    }

    public void totalEmprestimosRealizados() {
        double total = listEmprestimo.stream().mapToDouble(Emprestimo::getValorDoEmprestimo).sum();
        System.out.println("Total de empréstimos realizados: " + total);
    }

    public void mediaValorEmprestimo() {
        double media = listEmprestimo.stream().mapToDouble(Emprestimo::getValorDoEmprestimo).average().orElse(0.0);
        System.out.println("Média de valores de empréstimo: " + media);
    }

}
