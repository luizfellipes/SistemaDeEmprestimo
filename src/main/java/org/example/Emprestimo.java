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
    private String tipoDeEmprestimo;


    public Emprestimo(Pessoa pessoa, float valorDoEmprestimo, int quantidadeDeMesesParaPagamento, int numeroDeParcelasPagas, String tipoDeEmprestimo) {
        this.pessoa = pessoa;
        this.valorDoEmprestimo = valorDoEmprestimo;
        this.quantidadeDeMesesParaPagamento = quantidadeDeMesesParaPagamento;
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
        this.tipoDeEmprestimo = tipoDeEmprestimo;
    }

    public Emprestimo() {
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

    public float getValorDaParcela() {
        return valorDaParcela;
    }

    public void setValorDaParcela(float valorDaParcela) {
        this.valorDaParcela = valorDaParcela;
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
        }
        emprestimos.add(emprestimo);
    }

    public void listaDeEmprestimos() {
        for (int i = 0; i < emprestimos.size(); i++) {
            System.out.println(emprestimos.get(i));
        }
    }

    public void pagamento() {
        float valorParcela = getValorDoEmprestimo() / getQuantidadeDeMesesParaPagamento();
        if (getQuantidadeDeMesesParaPagamento() > 5) {
            float juros = valorParcela * 1.025f;
            setValorDoPagamento(juros * getNumeroDeParcelasPagas());
        } else {
            setValorDoPagamento(valorParcela * getNumeroDeParcelasPagas());
        }
        pagamentoQuitado();
    }

    public void pagamentoQuitado() {
        if (getValorDoPagamento() < 0 || getValorDoPagamento() > getValorDoEmprestimo()) {
            System.out.println("Pagamento invalido !");
        } else if (getValorDoPagamento() == getValorDoEmprestimo()) {
            System.out.println("O emprestimo foi quitado !");
        } else {
            System.out.println("Pagamento restante do emprestimo no valor de R$:" + (getValorDoEmprestimo() - getValorDoPagamento()) + " com x:" + (getQuantidadeDeMesesParaPagamento() - getNumeroDeParcelasPagas()) +
                    "\nparcelas valor inicial do emprestimo R$: " + getValorDoEmprestimo() + " numero de parcelas: " + getQuantidadeDeMesesParaPagamento());
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
                ", tipoDeEmprestimo='" + tipoDeEmprestimo + '\'' +
                '}';
    }
}
