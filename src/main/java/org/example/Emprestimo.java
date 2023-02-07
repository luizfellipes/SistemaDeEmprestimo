package org.example;

public class Emprestimo {
    private float valorEmprestimo;
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
    public void emprestimoQuitado() {
        int parcelaRestante = getNumeroDeParcelas() - getNumeroDeParcelasPagas();
        float valor = getValorEmprestimo() - valorPago();
        if (valor == 0 && parcelaRestante == 0) {
            System.out.println("Pagamento concluído ! O emprestimo foi quitado !");
        } else if (valor < 0 && parcelaRestante < 0) {
            System.out.println("Pagamento de parcela inválida !! selecione uma parcela valida !! ");
        } else {
            System.out.println("Ainda existe um emprestimo de: R$" + valor + ", com x" + parcelaRestante + " parcelas restante ! " +
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

