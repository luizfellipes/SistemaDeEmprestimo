package org.example;

import java.util.ArrayList;
import java.util.List;

public class Emprestimo {

    private Pessoa pessoa;
    private float valorDoEmprestimo;
    private float valorDoPagamento;
    private float valorDaParcela;
    private int quantidadeDeMesesParaPagamento;
    private int numeroDeParcelasPagas;
    private Tipo tipoDeEmprestimo;


    public Emprestimo(Pessoa pessoa, Tipo tipoDeEmprestimo, float valorDoEmprestimo, int quantidadeDeMesesParaPagamento, int numeroDeParcelasPagas) {
        this.pessoa = pessoa;
        this.tipoDeEmprestimo = tipoDeEmprestimo;
        this.valorDoEmprestimo = valorDoEmprestimo;
        this.quantidadeDeMesesParaPagamento = quantidadeDeMesesParaPagamento;
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
    }

    public Emprestimo() {
    }

    public int getNumeroDeParcelasPagas(){
        return this.numeroDeParcelasPagas;
    }

    public int quantidadeDeMesesParaPagamento(){
        return this.quantidadeDeMesesParaPagamento;
    }
    private List<Emprestimo> emprestimos;

    public void listaDeEmprestimos(Emprestimo emprestimo) {
        if (emprestimos == null) {
            emprestimos = new ArrayList<>();
        }
        emprestimos.add(emprestimo);
    }

    public void retornaListaDeEmprestimos() {

        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

    public void pagamento(int pagamentoParcela) {
        numeroDeParcelasPagas += pagamentoParcela;
        valorDaParcela = valorDoEmprestimo / quantidadeDeMesesParaPagamento;
        if (quantidadeDeMesesParaPagamento > 5) {
            float juros = valorDaParcela * 1.025f;
            System.out.println("Acima de 5 parcelas hávera um juros de 2,5 por parcela, valor da parcela: " + juros);
            valorDoPagamento = (juros * numeroDeParcelasPagas);
        } else {
            valorDoPagamento = valorDaParcela * numeroDeParcelasPagas;
            System.out.println("Valor por parcela (Sem juros): " + (valorDoEmprestimo - valorDoPagamento));
        }
        pagamentoQuitado();
    }

    public void pagamentoQuitado() {
        if (valorDoPagamento < 0 || valorDoPagamento > valorDoEmprestimo) {
            System.out.println("Pagamento invalido !");
        } else if (valorDoPagamento == valorDoEmprestimo) {
            System.out.println("O emprestimo foi quitado !");
        } else {
            System.out.println("Pagamento restante do emprestimo no valor de R$:" + (valorDoEmprestimo - valorDoPagamento) + " com x:" + (quantidadeDeMesesParaPagamento - numeroDeParcelasPagas) +
                    "\nparcelas valor inicial do emprestimo R$: " + valorDoEmprestimo + " numero de parcelas: " + quantidadeDeMesesParaPagamento);
        }
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "pessoa=" + pessoa +
                ", valorDoEmprestimo=" + valorDoEmprestimo +
                ", valorDoPagamento=" + valorDoPagamento +
                ", quantidadeDeMesesParaPagamento=" + quantidadeDeMesesParaPagamento +
                ", numeroDeParcelasPagas=" + numeroDeParcelasPagas +
                ", tipoDeEmprestimo=" + tipoDeEmprestimo +
                '}';
    }
}
