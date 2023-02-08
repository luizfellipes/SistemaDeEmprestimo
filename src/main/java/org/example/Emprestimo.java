package org.example;

public class Emprestimo {
    private float valorEmprestimo;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;

    public Emprestimo() {
    }

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
        System.out.println("Valor de cada parcela: " + valorPorParcela());
        System.out.println("Esse é valor a ser pago: " + valorPago());
        emprestimoQuitado();
    }

    public void emprestimoQuitado() {
        int parcelaRestantes = getNumeroDeParcelas() - getNumeroDeParcelasPagas();
        float saldo = getValorEmprestimo() - valorPago();
        if (saldo == 0 && parcelaRestantes == 0) {
            System.out.println("Pagamento concluído ! O emprestimo foi quitado !");
        } else if (saldo < 0 || parcelaRestantes < 0) {
            System.out.println("Pagamento inválido. Por favor, selecione uma parcela válida.");
        } else {
            System.out.println("Ainda existe um emprestimo de: R$" + saldo + ", com x" + parcelaRestantes + " parcelas restante ! " +
                    "\nValor inicial do emprestimo: " + getValorEmprestimo() + ", com x" + getNumeroDeParcelas() + " parcelas.");
        }
    }

    public float valorPorParcela() {
        return (getValorEmprestimo() / getNumeroDeParcelas());
    }

    public float valorPago() {
        return getNumeroDeParcelasPagas() * valorPorParcela();
    }

}

