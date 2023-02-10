package org.example;

public class Emprestimo {
    private float valorEmprestimo;
    private float valorParcela;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;


    public Emprestimo(float valorEmprestimo, int numeroDeParcelas, int numeroDeParcelasPagas) {
        this.valorEmprestimo = valorEmprestimo;
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

    public int setNumeroDeParcelasPagas(int numeroDeParcelasPagas) {
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
        return numeroDeParcelasPagas;
    }

    //Métodos

    public void pagamento() {
        System.out.println("Valor da parcela: R$" + valorPorParcela());
        System.out.println("Esse é valor a ser pago: " + valorPago());
        setNumeroDeParcelasPagas(getNumeroDeParcelas() - getNumeroDeParcelasPagas());
        emprestimoQuitado();
    }

    public void emprestimoQuitado() {
        if (valorPago() == 0 && parcelasPagas() == 0) {
            System.out.println("Pagamento concluído ! O emprestimo foi quitado !");
        } else if (valorPago() < 0 || parcelasPagas() < 0) {
            System.out.println("Pagamento inválido. Por favor, selecione uma parcela válida.");
        } else {
            System.out.println("Ainda existe um emprestimo de: " + valorPago() + ", com x" + parcelasPagas() + " parcelas restante ! " +
                    "\nValor inicial do emprestimo: " + getValorEmprestimo() + ", com x" + getNumeroDeParcelas() + " parcelas.");
        }
    }

    public float valorPago() {
        return getNumeroDeParcelasPagas() * valorPorParcela();
    }

    public float valorPorParcela() {
        setValorParcela(getValorEmprestimo() / getNumeroDeParcelas());
        return getValorParcela();
    }

    public int parcelasPagas(){
        return setNumeroDeParcelasPagas(getNumeroDeParcelasPagas());

    }

}

