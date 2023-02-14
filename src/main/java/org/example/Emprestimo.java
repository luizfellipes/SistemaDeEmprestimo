package org.example;

public class Emprestimo {
    private float valorEmprestimo;
    private float valorParcela;
    private float saldoPago;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;

    public Emprestimo(float valorEmprestimo, int numeroDeParcelas, int parcelaPaga) {
        this.valorEmprestimo = valorEmprestimo;
        this.numeroDeParcelas = numeroDeParcelas;
        this.numeroDeParcelasPagas = parcelaPaga;
    }

    public float getValorEmprestimo() {
        return this.valorEmprestimo;
    }

    public void setValorEmprestimo(float valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public float getSaldoPago() {
        return saldoPago;
    }

    public void setSaldoPago(float saldoPago) {
        this.saldoPago = saldoPago;
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

    //Métodos
    public void pagamento() {
        setValorParcela(getValorEmprestimo() / getNumeroDeParcelas());
        System.out.println("Valor da parcela: " + getValorParcela());
        float valorPago = getNumeroDeParcelasPagas() * getValorParcela();
        setSaldoPago(valorPago);
        System.out.println("Esse é valor a ser pago: " + valorPago);
        setSaldoPago(getValorEmprestimo() - valorPago);
        emprestimoQuitado();
    }

    public void emprestimoQuitado() {
        setNumeroDeParcelasPagas(getNumeroDeParcelas() - getNumeroDeParcelasPagas());
        if (getSaldoPago() == 0 && getNumeroDeParcelasPagas() == 0) {
            System.out.println("Pagamento concluído ! O emprestimo foi quitado !");
        } else if (getSaldoPago() < 0 || getNumeroDeParcelasPagas() < 0) {
            System.out.println("Pagamento inválido. Por favor, selecione uma parcela válida.");
        } else {
            System.out.println("Ainda existe um emprestimo de: " + getSaldoPago() + ", com x" + getNumeroDeParcelasPagas() + " parcelas restante ! " +
                    "\nValor inicial do emprestimo: " + getValorEmprestimo() + ", com x" + getNumeroDeParcelas() + " parcelas.");
        }
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "valorEmprestimo=" + valorEmprestimo +
                ", valorParcela=" + valorParcela +
                ", saldoPago=" + saldoPago +
                ", numeroDeParcelas=" + numeroDeParcelas +
                ", numeroDeParcelasPagas=" + numeroDeParcelasPagas +
                '}';
    }
}

