package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo {

    private Pessoa pessoa;
    private float valorDoEmprestimo;
    private float valorDoPagamento;
    private int quantidadeDeMesesParaPagamento;
    private int numeroDeParcelasPagas;

    public Emprestimo(float valorDoEmprestimo, float valorDoPagamento, int quantidadeDeMesesParaPagamento, int numeroDeParcelasPagas) {
        this.valorDoPagamento = valorDoPagamento;
        this.valorDoEmprestimo = valorDoEmprestimo;
        this.quantidadeDeMesesParaPagamento = quantidadeDeMesesParaPagamento;
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public float getValorDoEmprestimo() {
        return valorDoEmprestimo;
    }

    public void setValorDoEmprestimo(float valorDoEmprestimo) {
        this.valorDoEmprestimo = valorDoEmprestimo;
    }

    public float getValorDoPagamento() {
        return valorDoPagamento;
    }

    public void setValorDoPagamento(float valorDoPagamento) {
        this.valorDoPagamento = valorDoPagamento;
    }

    public int getQuantidadeDeMesesParaPagamento() {
        return quantidadeDeMesesParaPagamento;
    }

    public void setQuantidadeDeMesesParaPagamento(int quantidadeDeMesesParaPagamento) {
        this.quantidadeDeMesesParaPagamento = quantidadeDeMesesParaPagamento;
    }

    public int getNumeroDeParcelasPagas() {
        return numeroDeParcelasPagas;
    }

    public void setNumeroDeParcelasPagas(int numeroDeParcelasPagas) {
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
    }

    List<Emprestimo> emprestimos;

    public void solicitacaoDeEmprestimo(Emprestimo emprestimo) {
        if (emprestimos == null) {
            emprestimos = new ArrayList<>();
        } else {
            emprestimos.add(emprestimo);
        }
    }

    public void pagamento(float pagandoEmprestimo) {

    }

    public void emprestimoPessoal() {
    }

    public void emprestimoConsiginado() {
    }

    public void emprestimoRotativo() {
    }

}
