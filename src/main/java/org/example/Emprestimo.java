package org.example;

public class Emprestimo {
    private float valorEmprestimo;
    private float valorParcela;
    private float saldoPago;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;


    public Emprestimo(float valorParcela, int numeroDeParcelas, int numeroDeParcelasPagas) {
        this.valorParcela = valorParcela;
        this.numeroDeParcelas = numeroDeParcelas;
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
    }

    public float getValorEmprestimo() {
        return this.valorEmprestimo;
    }

    public void setValorEmprestimo(float valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public float getValorParcela() {
        return valorParcela;
    }

    public float setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
        return valorParcela;
    }
    public int getNumeroDeParcelas() {
        return this.numeroDeParcelas;
    }

    public float getSaldoPago() {
        return saldoPago;
    }

    public void setSaldoPago(float saldoPago) {
        this.saldoPago = saldoPago;
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
    public void emprestimoQuitado() {
        float valorPorParcela = setValorParcela(getValorEmprestimo() / getNumeroDeParcelas());
        System.out.println("Valor da parcela: " + valorPorParcela);
        float valorPago = getNumeroDeParcelas() * valorPorParcela;
        System.out.println(valorPago);
        setSaldoPago(valorPago);
        if (valorPago == 0 && getNumeroDeParcelasPagas() == 0) {
            System.out.println("Pagamento concluído ! O emprestimo foi quitado !");
        } else if (valorPago < 0 || getNumeroDeParcelasPagas() < 0) {
            System.out.println("Pagamento inválido. Por favor, selecione uma parcela válida.");
        } else {
            System.out.println("Ainda existe um emprestimo de: " + getValorParcela() + ", com x" + getNumeroDeParcelasPagas() + " parcelas restante ! " +
                    "\nValor inicial do emprestimo: " + getValorEmprestimo() + ", com x" + getNumeroDeParcelas() + " parcelas.");
        }
    }

    public void pagamento() {
        parcelasPagas();
        emprestimoQuitado();
    }

    public void parcelasPagas() {
        setValorParcela(getNumeroDeParcelas() - getNumeroDeParcelasPagas());
    }

}

