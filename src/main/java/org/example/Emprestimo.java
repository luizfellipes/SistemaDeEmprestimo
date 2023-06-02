package org.example;

public class Emprestimo {
    private float valorEmprestimo;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;
    private Pessoa pessoa;
    private Tipo tipo;

    public Emprestimo(float valorEmprestimo, int numeroDeParcelas, int numeroDeParcelasPagas, Pessoa pessoa, Tipo tipo) {
        verificaValorEmprestimo(valorEmprestimo);
        verificaNumeroParcelas(numeroDeParcelas);
        verificaNumeroParcelasPagas(numeroDeParcelas, numeroDeParcelasPagas);
        verificaPessoa(pessoa);
        verificaTipoDeEmprestimo(tipo);
    }

    public float getValorEmprestimo() {
        return valorEmprestimo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Tipo getTipo() {
        return tipo;
    }

    //Métodos de verificação
    private void verificaPessoa(Pessoa pessoa) {
        if (pessoa.pessoaExiste(pessoa)) {
            this.pessoa = pessoa;
        }
    }

    private void verificaValorEmprestimo(float valorEmprestimo) {
        if (valorEmprestimo > 0) {
            this.valorEmprestimo = valorEmprestimo;
        } else {
            System.out.println("Selecione um valor de emprestimo maior que 0...");
        }
    }

    private void verificaNumeroParcelas(int numeroDeParcelas) {
        if (numeroDeParcelas > 0) {
            this.numeroDeParcelas = numeroDeParcelas;
        } else {
            System.out.println("Numero de parcelas inválida, selecione uma parcela maior que 0...");
        }
    }

    private void verificaNumeroParcelasPagas(int numeroDeParcelas, int numeroDeParcelasPagas) {
        if (numeroDeParcelasPagas >= 0 && numeroDeParcelasPagas <= numeroDeParcelas) {
            this.numeroDeParcelasPagas = numeroDeParcelasPagas;
        }
    }

    private void verificaTipoDeEmprestimo(Tipo tipo) {
        if (tipo == Tipo.ROTATIVO || tipo == Tipo.PESSOAL || tipo == Tipo.CONSIGNADO) {
            this.tipo = tipo;
        } else {
            System.out.println("Tipo de emprestimo inválido");
        }
    }

    //Metodos Emprestimo
    public void realizarPagamento(int numeroDeParcelasPagas) {
        if (numeroDeParcelasPagas >= 0 && numeroDeParcelasPagas <= this.numeroDeParcelas) {
            this.numeroDeParcelasPagas += numeroDeParcelasPagas;
            System.out.println(this.numeroDeParcelasPagas + " parcelas pagas.");
        } else {
            System.out.println("Não foi possível realizar o pagamento !");
        }
    }

    public void ValorTotalPago() {
        float total = numeroDeParcelasPagas * (valorEmprestimo / numeroDeParcelas);
        float jurosPessoa = pessoa.taxaJuros();
        float valorTotalPago = numeroDeParcelas > 5 ? total * 1.025f * jurosPessoa : total * jurosPessoa;
        float saldoDevedor = numeroDeParcelas > 5 ? Math.max((valorEmprestimo - total * 1.025f) * jurosPessoa, 0) :
                Math.max((valorEmprestimo - total) * jurosPessoa, 0);
        System.out.println("Valor total pago: R$" + valorTotalPago + "\nSaldo Devedor: R$" + saldoDevedor);
    }

    public void verificarQuitado() throws Exception {
        if (this.numeroDeParcelasPagas == this.numeroDeParcelas) {
            System.out.println("Pagamento concluído ! O emprestimo foi quitado!");
        } else if (this.numeroDeParcelasPagas > this.numeroDeParcelas) {
            throw new Exception("Erro ao realizar um pagamento ! O emprestimo foi quitado!");
        } else {
            System.out.println("Divida não quitada !");
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
