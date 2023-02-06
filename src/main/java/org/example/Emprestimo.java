package org.example;

public class Emprestimo {
    private float valorEmprestimo;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;

    public Emprestimo() {
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

    //Métodos
    public int pagandoEmprestimo(int numeroDeParcelasPagas) {
        setNumeroDeParcelasPagas(numeroDeParcelasPagas);
        System.out.println("Total de parcelas : " + getNumeroDeParcelas() + " Total de parcelas pagas: " + getNumeroDeParcelasPagas());
        return numeroDeParcelasPagas;
    }

    public float pagandoEmprestimo(float valorPago) {
        float pagamentoRestante = getValorEmprestimo() - valorPago;
        if (valorPago > getValorEmprestimo() || valorPago < 0) {
            System.out.println("Impossível realizar pagamento !");
        } else {
            System.out.println("Saldo devedor: " + pagamentoRestante);
        }
        return pagamentoRestante;
    }

    public boolean emprestimoQuitado(float valorPago, int quantidadeDeParcelas) {
        float valorFinal = pagandoEmprestimo(valorPago);
        pagandoEmprestimo(quantidadeDeParcelas);
        int parcelaFinal = pagandoEmprestimo(quantidadeDeParcelas);
        if (valorFinal == 0 && parcelaFinal == 0) {
            System.out.println("O emprestimo foi quitado !");
        } else {
            System.out.println("Ainda existe um emprestimo de: R$" + valorFinal + ", com x" + parcelaFinal + " parcelas restante !");
        }
        return false;
    }

    public void valorMaisParcela(float valorEmprestimo, int parcela) {
        setValorEmprestimo(valorEmprestimo);
        setNumeroDeParcelas(parcela);
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "valorEmprestimo=" + valorEmprestimo +
                ", numeroDeParcelas=" + numeroDeParcelas +
                ", numeroDeParcelasPagas=" + numeroDeParcelasPagas +
                '}';
    }
}

