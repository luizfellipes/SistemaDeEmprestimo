package org.example;

public class Emprestimo {

    private Pessoa pessoa;
    private float valorDoEmprestimo;
    private float valorDoPagamento;
    private float valorDaParcela;
    private int quantidadeDeMesesParaPagamento;
    private int numeroDeParcelasPagas;
    private Tipo tipoDeEmprestimo;

    public Emprestimo() {
    }

    public Emprestimo(Pessoa pessoa, Tipo tipoDeEmprestimo, float valorDoEmprestimo, int quantidadeDeMesesParaPagamento, int numeroDeParcelasPagas) {
        this.pessoa = pessoa;
        this.tipoDeEmprestimo = tipoDeEmprestimo;
        this.valorDoEmprestimo = valorDoEmprestimo;
        this.quantidadeDeMesesParaPagamento = quantidadeDeMesesParaPagamento;
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
    }

    public float getValorDoEmprestimo() {
        return this.valorDoEmprestimo;
    }

    public int getNumeroDeParcelasPagas() {
        return this.numeroDeParcelasPagas;
    }

    public int getQuantidadeDeMesesParaPagamento() {
        return this.quantidadeDeMesesParaPagamento;
    }

    public void setNumeroDeParcelasPagas(int numeroDeParcelasPagas) {
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }


    //Metódos
    public int pagamento(int pagamentoParcela) {
        numeroDeParcelasPagas += pagamentoParcela;
        valorDaParcela = valorDoEmprestimo / quantidadeDeMesesParaPagamento;
        if (quantidadeDeMesesParaPagamento > 5) {
            float juros = valorDaParcela * 1.025f;
            valorDoPagamento = (juros * numeroDeParcelasPagas);
        } else {
            valorDoPagamento = valorDaParcela * numeroDeParcelasPagas;
        }
        pagamentoQuitado();
        return numeroDeParcelasPagas;
    }

    public void pagamentoQuitado() {
        if (valorDoPagamento < 0 || numeroDeParcelasPagas > quantidadeDeMesesParaPagamento) {
            System.out.println("Pagamento invalido !");
        } else if (numeroDeParcelasPagas == quantidadeDeMesesParaPagamento) {
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
