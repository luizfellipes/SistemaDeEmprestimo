package org.example;

public class Emprestimo {
    private float valorEmprestimo;
    private float valorParcela;
    private float saldoDevedor;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;
    private Pessoa pessoa;

    public Emprestimo(float valorEmprestimo, int numeroDeParcelas, int numeroDeParcelasPagas, Pessoa pessoa) {
        this.valorEmprestimo = valorEmprestimo;
        this.numeroDeParcelas = numeroDeParcelas;
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
        this.pessoa = pessoa;
    }

    public float getValorEmprestimo() {
        return this.valorEmprestimo;
    }

    public void setValorEmprestimo(float valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public float getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(float saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public float getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
    }

    public int getNumeroDeParcelas() {
        return this.numeroDeParcelas;
    }

    public void setNumeroDeParcelas(int numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public int getNumeroDeParcelasPagas() {
        return numeroDeParcelasPagas;
    }

    public void setNumeroDeParcelasPagas(int numeroDeParcelasPagas) {
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    //Métodos
    public void pagamento() {
        setValorParcela(getValorEmprestimo() / getNumeroDeParcelas());
        float valorPago = getNumeroDeParcelasPagas() * getValorParcela();
        float saldoRestante = getValorEmprestimo() - valorPago;
        int parcelasRestantes = getNumeroDeParcelas() - getNumeroDeParcelasPagas();
        setSaldoDevedor(saldoRestante);
        if (saldoRestante < 0 || getNumeroDeParcelasPagas() < 0 || getNumeroDeParcelasPagas() > getNumeroDeParcelas()) {
            System.out.println("Pagamento inválido. Por favor, selecione uma parcela válida.");
        } else {
            System.out.println("Valor da parcela: " + getValorParcela() + "\nEsse é valor a ser pago: " + getSaldoDevedor() + "\n"+
                    "\nAinda existe um emprestimo de: " + saldoRestante + ", com x" + parcelasRestantes + " parcelas restante ! " +
                    "\nValor inicial do emprestimo: " + getValorEmprestimo() + ", com x" + getNumeroDeParcelas() + " parcelas. \n");
            dividaQuitada();
        }
    }

    public void dividaQuitada() {
        if (getSaldoDevedor() == 0) {
            System.out.println("Pagamento concluído ! O emprestimo foi quitado! \nO " + toString() + " \nFoi realizado pela: " + getPessoa().toString());
        } else {
            System.out.println("Divida não quitada ! \nO " + toString() + "\nFoi realizado pela: " + getPessoa().toString());
        }
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "valorEmprestimo=" + valorEmprestimo +
                ", valorParcela=" + valorParcela +
                ", saldoDevedor=" + saldoDevedor +
                ", numeroDeParcelas=" + numeroDeParcelas +
                ", numeroDeParcelasPagas=" + numeroDeParcelasPagas +
                '}';
    }

}

