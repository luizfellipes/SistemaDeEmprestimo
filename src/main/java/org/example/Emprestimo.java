package org.example;

import java.util.ArrayList;
import java.util.List;

public class Emprestimo {

    private Pessoa pessoa;
    private float valorDoEmprestimo;
    private float valorDoPagamento;
    private int quantidadeDeMesesParaPagamento;
    private int numeroDeParcelasPagas;
    private String tipoDeEmprestimo;

    public Emprestimo(Pessoa pessoa, float valorDoEmprestimo, int quantidadeDeMesesParaPagamento, int numeroDeParcelasPagas) {
        this.pessoa = pessoa;
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

    public String getTipoDeEmprestimo() {
        return tipoDeEmprestimo;
    }

    public void setTipoDeEmprestimo(String tipoDeEmprestimo) {
        this.tipoDeEmprestimo = tipoDeEmprestimo;
    }

    List<Emprestimo> emprestimos;

    public void solicitacaoDeEmprestimo(Emprestimo emprestimo) {
        if (emprestimos == null) {
            emprestimos = new ArrayList<>();
        } else {
            emprestimos.add(emprestimo);
        }
    }

    public void listaDeEmprestimos(){
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

    public void pagamento(float pagandoEmprestimo) {
        float valorParcela = getQuantidadeDeMesesParaPagamento() / getValorDoEmprestimo();
        float valorPago = valorParcela * getNumeroDeParcelasPagas();
        if (valorPago < 0 || valorPago > getValorDoEmprestimo() ) {
            System.out.println("Pagamento invalido !");
        } else {
            System.out.println("Pagamento de emprestimo no valor de R$:" + valorPago + "com x:" + getNumeroDeParcelasPagas() + " parcelas");
            pagamentoQuitado();
        }
    }

    public void pagamentoQuitado() {
        if (getValorDoPagamento() == getValorDoEmprestimo()) {
            System.out.println("O emprestimo foi quitado !");
        }
    }

    public void tipoDeEmprestimo(String tipo) {

    }

    public void jurosPorParcela() {

    }


}
