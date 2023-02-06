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
    public void pagandoEmprestimo(int numeroDeParcelasPagas) {
        setNumeroDeParcelasPagas(numeroDeParcelasPagas);
        System.out.println("Total de parcelas: " + getNumeroDeParcelas() + " \nTotal de parcelas pagas: " + getNumeroDeParcelasPagas());
        System.out.println("O valor a ser pago: " + (valorPorParcela() * getNumeroDeParcelasPagas()));
    }

    public void pagandoEmprestimo(float valorPago) {
        float pagamentoRestante = getValorEmprestimo() - valorPago;


        if (valorPago > getValorEmprestimo() || valorPago < 0) {
            System.out.println("Impossível realizar pagamento !");

        } else {
            System.out.println("Saldo devedor: " + pagamentoRestante);
        }
    }

    public void emprestimoQuitado(float valorPago, int quantidadeDeParcelas) {
        float valor = getValorEmprestimo() - valorPago;
        int parcela = getNumeroDeParcelas() - quantidadeDeParcelas;
        if (valor == 0 && parcela == 0) {
            System.out.println("O emprestimo foi quitado !");
        } else {
            System.out.println("Ainda existe um emprestimo de: R$" + valor + ", com x" + parcela + " parcelas restante ! " +
                    "\nValor inicial do emprestimo: " + getValorEmprestimo() + ", com x " + getNumeroDeParcelas() + " parcelas iniciais.");
        }
    }

    public void valorMaisParcela(float valorEmprestimo, int parcela) {
        setValorEmprestimo(valorEmprestimo);
        setNumeroDeParcelas(parcela);
    }

    public float valorPorParcela() {
        float valor = getValorEmprestimo();
        int parcela = getNumeroDeParcelas();
        return valor / parcela;
    }


}

