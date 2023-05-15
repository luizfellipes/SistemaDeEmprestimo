package org.example;

public class Emprestimo {
    private float valorEmprestimo;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;
    private Pessoa pessoa;

    public Emprestimo(float valorEmprestimo, int numeroDeParcelas, int numeroDeParcelasPagas, Pessoa pessoa) {
        verificaValorEmprestimo(valorEmprestimo);
        verificaNumeroParcelas(numeroDeParcelas);
        verificaNumeroParcelasPagas(numeroDeParcelas, numeroDeParcelasPagas);
        verificaPessoa(pessoa);
    }


    //Métodos
    private void verificaPessoa(Pessoa pessoa) {
        if (pessoa.pessoaExiste(pessoa)) {
            this.pessoa = pessoa;
        }
    }

    private void verificaValorEmprestimo(float valorEmprestimo) {
        if (valorEmprestimo > 0) {
            this.valorEmprestimo = valorEmprestimo;
        } else {
            System.out.println("Selecione um valor maior que 0...");
        }
    }

    private void verificaNumeroParcelas(int numeroDeParcelas) {
        if (numeroDeParcelas > 0) {
            this.numeroDeParcelas = numeroDeParcelas;
        } else {
            System.out.println("Numero de parcelas invalida, selecione uma parcela maior que 0...");
        }
    }

    private void verificaNumeroParcelasPagas(int numeroDeParcelas, int numeroDeParcelasPagas) {
        if (numeroDeParcelasPagas >= 0 && numeroDeParcelasPagas < numeroDeParcelas) {
            this.numeroDeParcelasPagas = numeroDeParcelasPagas;
        }
    }

    public void realizarPagamento(int numParcelasPagas) {
        if (numParcelasPagas > 0 && numParcelasPagas <= numeroDeParcelas) {
            this.numeroDeParcelasPagas += numParcelasPagas;
            System.out.println(numParcelasPagas + " parcelas pagas.");
        } else {
            System.out.println("Não foi possivel realizar o pagamento !");
        }
    }

    public float getValorTotalPago() {
        return numeroDeParcelasPagas * (valorEmprestimo / numeroDeParcelas);
    }

    public void verificarQuitado() {
        if (numeroDeParcelasPagas == numeroDeParcelas) {
            System.out.println("Pagamento concluído ! O emprestimo foi quitado! \nO " + this + " \nFoi realizado pela: " + pessoa.toString());
        } else {
            System.out.println("Divida não quitada ! \nO " + this + "\nFoi realizado pela: " + pessoa.toString());
        }
    }


    /*public void pagamento() {
        valorParcela = valorEmprestimo / numeroDeParcelas;
        float valorPago = numeroDeParcelasPagas * valorParcela;
        float saldoRestante = valorEmprestimo - valorPago;
        int parcelasRestantes = numeroDeParcelas - numeroDeParcelasPagas;
        saldoDevedor = saldoRestante;
        if (saldoRestante < 0 || numeroDeParcelasPagas < 0 || numeroDeParcelasPagas > numeroDeParcelas) {
            System.out.println("Pagamento inválido. Por favor, selecione uma parcela válida.");
        } else {
            System.out.println("Valor da parcela: " + valorParcela + "\nEsse é valor a ser pago: " + valorPago + "\n" +
                    "\nAinda existe um emprestimo de: " + saldoRestante + ", com x" + parcelasRestantes + " parcelas restante ! " +
                    "\nValor inicial do emprestimo: " + valorEmprestimo + ", com x" + numeroDeParcelas + " parcelas. \n");
            dividaQuitada();
        }
    }

    public void dividaQuitada() {
        if (saldoDevedor == 0) {
            System.out.println("Pagamento concluído ! O emprestimo foi quitado! \nO " + this + " \nFoi realizado pela: " + pessoa.toString());
        } else {
            System.out.println("Divida não quitada ! \nO " + this + "\nFoi realizado pela: " + pessoa.toString());
        }
    }*/

    @Override
    public String toString() {
        return "Emprestimo{" +
                "valorEmprestimo=" + valorEmprestimo +
                ", numeroDeParcelas=" + numeroDeParcelas +
                ", numeroDeParcelasPagas=" + numeroDeParcelasPagas +
                '}';
    }

}

