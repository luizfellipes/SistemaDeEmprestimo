package org.example;

public class Emprestimo {

    private Pessoa pessoa;
    private float valorDoEmprestimo;
    private float valorDoPagamento;
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
    public int getQuantidadeDeMesesParaPagamento(){return this.quantidadeDeMesesParaPagamento;}

    public void setNumeroDeParcelasPagas(int numeroDeParcelasPagas) {this.numeroDeParcelasPagas = numeroDeParcelasPagas;}

    public int quantidadeDeMesesParaPagamento() {
        return this.quantidadeDeMesesParaPagamento;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public int pagamento(int pagamentoParcela) {
        numeroDeParcelasPagas += pagamentoParcela;
        float valorDaParcela = valorDoEmprestimo / quantidadeDeMesesParaPagamento;
        if (quantidadeDeMesesParaPagamento > 5) {
            float juros = valorDaParcela * 1.025f;
            System.out.println("Acima de 5 parcelas hávera um juros de 2,5 por parcela, valor da parcela: " + juros);
            valorDoPagamento = (juros * numeroDeParcelasPagas);
            System.out.println("Valor por parcela (Sem juros): " + valorDoPagamento);
        } else {
            valorDoPagamento = valorDaParcela * numeroDeParcelasPagas;
        }
        pagamentoQuitado();
        return pagamentoParcela;
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
