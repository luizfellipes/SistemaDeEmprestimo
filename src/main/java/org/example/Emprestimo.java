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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Tipo getTipo() {
        return tipo;
    }

    //Métodos de verificação
    public void verificaPessoa(Pessoa pessoa) {
        if (pessoa.pessoaExiste()) {
            this.pessoa = pessoa;
        } else {
            throw new NullPointerException("Dados da pessoa incorretos !");
        }
    }

    public void verificaValorEmprestimo(float valorEmprestimo) throws Exception {
        if (valorEmprestimo > 0) {
            this.valorEmprestimo = valorEmprestimo;
        } else {
            throw new Exception("Selecione um valor maior que 0...");
        }
    }

    public void verificaNumeroParcelas(int numeroDeParcelas) throws Exception {
        if (numeroDeParcelas > 0) {
            this.numeroDeParcelas = numeroDeParcelas;
        } else {
            throw new Exception("Numero de parcelas invalida, selecione uma parcela maior que 0...");
        }
    }

    public void verificaNumeroParcelasPagas(int numeroDeParcelasPagas) {
        if (numeroDeParcelasPagas >= 0 && numeroDeParcelasPagas <= numeroDeParcelas) {
            this.numeroDeParcelasPagas = numeroDeParcelasPagas;
        }
    }

    public void verificaTipoDeEmprestimo(Tipo tipo) {
        if (tipo == Tipo.ROTATIVO || tipo == Tipo.PESSOAL || tipo == Tipo.CONSIGNADO) {
            this.tipo = tipo;
        } else {
            System.out.println("Tipo de emprestimo invalido");
        }
    }

    //Metodos Emprestimo
    public void realizarPagamento(int numeroDeParcelasPagasDepois) {
        if (numeroDeParcelasPagasDepois >= 0 && this.numeroDeParcelasPagas + numeroDeParcelasPagasDepois <= this.numeroDeParcelas) {
            this.numeroDeParcelasPagas += numeroDeParcelasPagasDepois;
            System.out.println(this.numeroDeParcelasPagas + " parcelas pagas.");
        } else {
            System.out.println("Não foi possível realizar o pagamento !");
        }
    }

    public void ValorTotalPago() {
        float totalJaPago = numeroDeParcelasPagas * (valorEmprestimo / numeroDeParcelas);
        float jurosPessoa = pessoa.taxaJuros() * totalJaPago / 100;
        float jurosParcelaMaiorQueCinco = (2.5f * totalJaPago / 100) + totalJaPago;
        float valorFinalPago = numeroDeParcelasPagas > 5 ? (jurosParcelaMaiorQueCinco + jurosPessoa) : totalJaPago + jurosPessoa;
        float saldoDevedor = numeroDeParcelasPagas > 5 ? ((valorEmprestimo - jurosParcelaMaiorQueCinco) + jurosPessoa) : (valorEmprestimo - totalJaPago) + jurosPessoa;
        System.out.println("Valor total pago: R$" + valorFinalPago + "\nSaldo Devedor: R$" + saldoDevedor);
    }

    public void verificarQuitado() throws Exception {
        if (numeroDeParcelas > 0 && numeroDeParcelasPagas > 0 && numeroDeParcelasPagas == numeroDeParcelas) {
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
