package org.example;


public class Emprestimo {
    private float valorEmprestimo;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;
    private Pessoa pessoa;
    private Tipo tipo;

    public Emprestimo(float valorEmprestimo, int numeroDeParcelas, int numeroDeParcelasPagas, Pessoa pessoa, Tipo tipo) throws Exception {
        verificaValorEmprestimo(valorEmprestimo);
        verificaNumeroParcelas(numeroDeParcelas);
        verificaNumeroParcelasPagas(numeroDeParcelasPagas);
        verificaPessoa(pessoa);
        verificaTipoDeEmprestimo(tipo);
    }

    public float getValorEmprestimo() {
        return valorEmprestimo;
    }

    //Métodos
    private void verificaPessoa(Pessoa pessoa) {
        if (pessoa.pessoaExiste()) {
            this.pessoa = pessoa;
        } else {
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

    private void verificaNumeroParcelas(int numeroDeParcelas) throws Exception {
        if (numeroDeParcelas > 0) {
            this.numeroDeParcelas = numeroDeParcelas;
        } else {
            throw new Exception("Numero de parcelas invalida, selecione uma parcela maior que 0...");
        }
    }

    private void verificaNumeroParcelasPagas(int numeroDeParcelasPagas) {
        if (numeroDeParcelasPagas >= 0 && numeroDeParcelasPagas < numeroDeParcelas) {
            this.numeroDeParcelasPagas = numeroDeParcelasPagas;
        }
    }

    private void verificaTipoDeEmprestimo(Tipo tipo) {
        if (tipo == Tipo.ROTATIVO || tipo == Tipo.PESSOAL || tipo == Tipo.CONSIGNADO) {
            this.tipo = tipo;
        } else {
            System.out.println("Tipo de emprestimo invalido");
        }
    }

    //Metodos da instancia
    public void realizarPagamento(int numeroDeParcelasPagasDepois) {
        if (numeroDeParcelasPagasDepois >= 0 && this.numeroDeParcelasPagas + numeroDeParcelasPagasDepois <= this.numeroDeParcelas) {
            this.numeroDeParcelasPagas += numeroDeParcelasPagasDepois;
            System.out.println(this.numeroDeParcelasPagas + " parcelas pagas.");
        } else {
            System.out.println("Não foi possivel realizar o pagamento !");
        }
    }

    public void ValorTotalPago() {
        float totalPago = (numeroDeParcelasPagas * (valorEmprestimo / numeroDeParcelas));
        float saldoDevedor = valorEmprestimo - totalPago;
        if (numeroDeParcelas > 5) {
            float juros = 2.5f;
            float valorComJuros = juros * totalPago / 100 + totalPago;
            saldoDevedor = (valorEmprestimo - totalPago) * juros;
            System.out.println("Valor total pago: R$" + valorComJuros + "\nSaldo Devedor: R$" + saldoDevedor);
        } else {
            System.out.println("Valor total pago: R$" + totalPago + "\nSaldo Devedor: R$" + saldoDevedor);
        }
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
                ", pessoa=" + pessoa +
                ", tipo=" + tipo +
                '}';
    }
}
