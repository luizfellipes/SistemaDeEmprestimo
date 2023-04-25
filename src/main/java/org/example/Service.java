package org.example;

import java.util.*;

public class Service {
    Scanner scanner = new Scanner(System.in);
    Emprestimo emprestimo = new Emprestimo();

    private List<Emprestimo> listEmprestimo;

    //Adiciona um novo emprestimo
    public void novoEmpretimo(Emprestimo emprestimo) {
        if (listEmprestimo == null) {
            listEmprestimo = new ArrayList<>();
        }
        listEmprestimo.add(emprestimo);
    }

    //retorna todos os emprestimos da lista
    public void ListaDeEmprestimo() {
        List<Emprestimo> emprestimoList = this.listEmprestimo;
        for (Emprestimo emprestimo : emprestimoList) {
            System.out.println(emprestimo.toString());
        }
    }

    //Retorna os elementos da lista
    public Emprestimo retornaEmprestimos(String nome) {
        for (Emprestimo emprestimo : listEmprestimo) {
            if (nome.equals(emprestimo.getPessoa().getNome())) {
                return emprestimo;
            }
        }
        return null;
    }

    //Inicia o emprestimo
    public void novaSolicitacaoEmprestimo() {
        Pessoa pessoa = pessoa();
        Tipo tipoEmprestimo = tipoEmprestimo();
        float valorEmprestimo = valorEmprestimo();
        int quantidadeMeses = quantidadeMeses();
        int pagamentoInicial = pagamentoInicial(quantidadeMeses);
        float valorPagamento = valorPagamento(valorEmprestimo, quantidadeMeses, pagamentoInicial);
        novoEmpretimo(emprestimo = new Emprestimo(pessoa, tipoEmprestimo, valorEmprestimo, quantidadeMeses, pagamentoInicial, valorPagamento));
    }

    //Cria uma nova pessoa
    public Pessoa pessoa() {
        System.out.println("Digite seu nome: ");
        String nome = scanner.next();
        System.out.println("Digite seu telefone: ");
        String telefone = scanner.next();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.next();
        return new Pessoa(nome, telefone, cpf);
    }

    //Seleciona o tipo de emprestimo
    public Tipo tipoEmprestimo() {
        System.out.println("Selecione a forma de emprestimo : \n[PESSOAL] - [CONSIGNADO] - [ROTATIVO]");
        String tipoEmprestimo = scanner.next();
        return Arrays.stream(Tipo.values())
                .filter(tipo -> tipoEmprestimo.equalsIgnoreCase(tipo.name()))
                .findFirst()
                .orElse(null);
    }

    //Seleciona o valor do emprestimo
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


    //Seleciona a quantidade de meses a pagar (parcelas)
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

    //Realiza um pagamento, caso o contratante deseja pagar alguma parcela adiantada
    public int pagamentoInicial(int quantidadeMeses) {
        int pagamento = -1;
        while (pagamento < 0 || pagamento > quantidadeMeses) {
            System.out.println("Quantas parcelas deseja pagar incialmente ? ");
            pagamento = scanner.nextInt();
            if (pagamento < 0 || pagamento > quantidadeMeses) {
                System.out.println("Pagamento inválido, selecione uma parcela valida ! ");
            }
        }
        return pagamento;
    }

    //Gera o valor do pagamento feito pelo pagamentoIncial()
    public float valorPagamento(float valorEmprestimo, int quantidadeMeses, int pagamentoInicial) {
        float valorDaParcela = valorEmprestimo / quantidadeMeses;
        if (quantidadeMeses > 5) {
            float juros = valorDaParcela * 1.025f;
            return pagamentoInicial * juros;
        } else {
            return pagamentoInicial * valorDaParcela;
        }
    }

    //Realiza um pagamento depois do emprestimo concluido
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

    //Busca o maior valor de emprestimo feito
    public void maiorValorDoEmprestimo() {
        Emprestimo maior = listEmprestimo.stream().max(Comparator.comparing(Emprestimo::getValorDoEmprestimo)).orElse(null);
        System.out.println("Maior valor de empréstimo: " + maior);
    }

    //Busca o menor valor de emprestimo feito
    public void menorValorDoEmprestimo() {
        Emprestimo menor = listEmprestimo.stream().min(Comparator.comparing(Emprestimo::getValorDoEmprestimo)).orElse(null);
        System.out.println("Menor valor de emprestimo: " + menor);
    }

    //Busca o total dos valores dos emprestimos feitos
    public void totalEmprestimosRealizados() {
        double total = listEmprestimo.stream().mapToDouble(Emprestimo::getValorDoEmprestimo).sum();
        System.out.println("Total de empréstimos realizados: " + total);
    }

    //Busca as medias de todos os valores de emprestimos feitos
    public void mediaValorEmprestimo() {
        double media = listEmprestimo.stream().mapToDouble(Emprestimo::getValorDoEmprestimo).average().orElse(0.0);
        System.out.println("Média de valores de empréstimo: " + media);
    }

}
