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
    private int id;
    private Tipo tipoDeEmprestimo;



    public Emprestimo(Pessoa pessoa, Tipo tipoDeEmprestimo, float valorDoEmprestimo, int quantidadeDeMesesParaPagamento, int numeroDeParcelasPagas) {
        this.pessoa = pessoa;
        this.tipoDeEmprestimo = tipoDeEmprestimo;
        this.valorDoEmprestimo = valorDoEmprestimo;
        this.quantidadeDeMesesParaPagamento = quantidadeDeMesesParaPagamento;
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
    }

    public Emprestimo(int numeroDeParcelasPagas) {
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;

    }

    public Emprestimo(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    public Tipo getTipoDeEmprestimo() {
        return tipoDeEmprestimo;
    }

    public void setTipoDeEmprestimo(Tipo tipoDeEmprestimo) {
        this.tipoDeEmprestimo = tipoDeEmprestimo;
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

    public void pagamento() {
        float valorParcela = getValorDoEmprestimo() / getQuantidadeDeMesesParaPagamento();
        if (getQuantidadeDeMesesParaPagamento() > 5) {
            float juros = valorParcela * 1.025f;
            System.out.println("Acima de 5 parcelas hávera um juros de 2,5 por parcela, valor da parcela: " + juros);
            setValorDoPagamento(juros * getNumeroDeParcelasPagas());
        } else {
            setValorDoPagamento(valorParcela * getNumeroDeParcelasPagas());
            System.out.println("Valor por parcela (Sem juros): " + (getValorDoEmprestimo() - getValorDoPagamento()));
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
                ", tipoDeEmprestimo=" + tipoDeEmprestimo +
                '}';
    }
}
