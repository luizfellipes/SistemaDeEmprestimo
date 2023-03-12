package org.example;

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

    public float getValorDaParcela() {
        return this.valorDaParcela;
    }
    public float getValorDoEmprestimo() {
        return this.valorDoEmprestimo;
    }

    public float getValorDoPagamento() {
        return this.valorDoPagamento;
    }

    public int getNumeroDeParcelasPagas() {
        return this.numeroDeParcelasPagas;
    }

    public int quantidadeDeMesesParaPagamento() {
        return this.quantidadeDeMesesParaPagamento;
    }

    public Pessoa getPessoa(){
        return this.pessoa;
    }

    public void pagamento(int pagamentoParcela) {
        numeroDeParcelasPagas += pagamentoParcela;
        valorDaParcela = valorDoEmprestimo / quantidadeDeMesesParaPagamento;
        if (quantidadeDeMesesParaPagamento > 5) {
            float juros = valorDaParcela * 1.025f;
            valorDoPagamento = (juros * numeroDeParcelasPagas);
        } else {
            valorDoPagamento = valorDaParcela * numeroDeParcelasPagas;
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
