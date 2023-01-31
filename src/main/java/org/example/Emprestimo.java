package org.example;

public class Emprestimo extends Pessoa {
    private float valorEmprestimo;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;


    public Emprestimo(String nome, int telefone, String cpf, float valorEmprestimo, int numeroDeParcelas, int numeroDeParcelasPagas) {
        super(nome, telefone, cpf);
        this.valorEmprestimo = valorEmprestimo;
        this.numeroDeParcelas = numeroDeParcelas;
        this.numeroDeParcelasPagas = numeroDeParcelasPagas;
    }

    public float getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(float valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public int getNumeroDeParcelas() {
        return numeroDeParcelas;
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


    public void pagamentoEmprestimo(int parcelasPagas) {
        this.numeroDeParcelas = this.numeroDeParcelas - parcelasPagas;
        System.out.println("Parcelas quitadas até o momento: " + parcelasPagas);
    }

    public void valorPago(float totalPago) {
        this.valorEmprestimo = this.valorEmprestimo - totalPago;
        System.out.println("Valor quitado até o momento: " + totalPago);
    }

    public void emprestimoQuitado(boolean dividaZero) {
        if (this.valorEmprestimo == 0 || this.numeroDeParcelas == 0) {
            System.out.println("A divida esta quitada !");
        } else{
            System.out.println("Ainda há debítos na conta ! " + "Saldo devedor: " + this.valorEmprestimo + " Parcelas Restantes: " + this.numeroDeParcelas);
        }
    }


    @Override
    public String toString() {
        return "Emprestimo{" + super.toString() +
                " valorEmprestimo=" + valorEmprestimo +
                ", numeroDeParcelas=" + numeroDeParcelas +
                ", numeroDeParcelasPagas=" + numeroDeParcelasPagas +
                '}';
    }
}

