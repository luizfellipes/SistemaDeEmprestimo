package org.example;

public class Emprestimo {
    private float valorEmprestimo;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;
    private Pessoa pessoa;

    public Emprestimo(float valorEmprestimo, int numeroDeParcelas, int numeroDeParcelasPagas, Pessoa pessoa) throws Exception {
        verificaValorEmprestimo(valorEmprestimo);
        verificaNumeroParcelas(numeroDeParcelas);
        verificaNumeroParcelasPagas(numeroDeParcelasPagas);
        verificaPessoa(pessoa);
    }


    //Métodos
    private void verificaPessoa(Pessoa pessoa) {
        if (pessoa.pessoaExiste()) {
            this.pessoa = pessoa;
        }else {
            throw new NullPointerException("Dados da pessoa incorretos !");
        }
    }

    private void verificaValorEmprestimo(float valorEmprestimo) throws Exception {
        if (valorEmprestimo > 0) {
            this.valorEmprestimo = valorEmprestimo;
        } else {
            throw new Exception("Selecione um valor maior que 0...");
        }

    }

    private void verificaNumeroParcelas(int numeroDeParcelas) {
        if (numeroDeParcelas > 0) {
            this.numeroDeParcelas = numeroDeParcelas;
        } else {
            System.out.println("Numero de parcelas invalida, selecione uma parcela maior que 0...");
        }
    }

    private void verificaNumeroParcelasPagas(int numeroDeParcelasPagas) {
        if (numeroDeParcelasPagas >= 0 && numeroDeParcelasPagas < numeroDeParcelas) {
            this.numeroDeParcelasPagas = numeroDeParcelasPagas;
        }
    }

    public void realizarPagamento(int numeroDeParcelasPagas) {
        if (numeroDeParcelasPagas >= 0 && this.numeroDeParcelasPagas + numeroDeParcelasPagas <= this.numeroDeParcelas) {
            this.numeroDeParcelasPagas += numeroDeParcelasPagas;
            System.out.println(this.numeroDeParcelasPagas + " parcelas pagas.");
        } else {
            System.out.println("Não foi possivel realizar o pagamento !");

        }
    }

    public void getValorTotalPago() {
        float total = numeroDeParcelasPagas * (valorEmprestimo / numeroDeParcelas);
        System.out.println("Valor total pago: R$" + total + "\nSaldo Devedor: R$" + (valorEmprestimo - total));
    }

    public void verificarQuitado() {
        if (numeroDeParcelas > 0 && numeroDeParcelasPagas > 0 && numeroDeParcelasPagas == numeroDeParcelas) {
            System.out.println("Pagamento concluído ! O emprestimo foi quitado! \nO " + this + " \nFoi realizado pela: " + pessoa.toString());
        } else {
            System.out.println("Divida não quitada ! \nO " + this + "\nFoi realizado pela: " + pessoa.toString());
        }
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

