package org.example;

public class Emprestimo {
    private float valorEmprestimo;
    private int numeroDeParcelas;
    private int numeroDeParcelasPagas;
    private float totalJaPago;
    private Pessoa pessoa;
    private Tipo tipo;

    public Emprestimo() {
    }

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
        if (numeroDeParcelasPagas >= 0 && numeroDeParcelasPagas < numeroDeParcelas) {
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
    public void realizarPagamento(int numeroDeParcelasPagas) {
        if (numeroDeParcelasPagas >= 0 && this.numeroDeParcelasPagas + numeroDeParcelasPagas <= this.numeroDeParcelas) {
            this.numeroDeParcelasPagas += numeroDeParcelasPagas;
            System.out.println(this.numeroDeParcelasPagas + " parcelas pagas.");
        } else {
            System.out.println("Não foi possível realizar o pagamento !");
        }
    }

    public void ValorTotalPago() {
        totalJaPago = numeroDeParcelasPagas * (valorEmprestimo / numeroDeParcelas);
        float valorComJuros = ((2.5f * totalJaPago) / 100) + totalJaPago;
        float jurosPessoa = pessoa instanceof PessoaFisica ? (10f * totalJaPago) / 100 : (5 * totalJaPago) / 100;
        float valorTotalPago = numeroDeParcelasPagas > 5 ? (valorComJuros + jurosPessoa) : totalJaPago + jurosPessoa;
        float saldoDevedor = numeroDeParcelasPagas > 5 ? ((valorEmprestimo - totalJaPago) * valorComJuros) : (valorEmprestimo - totalJaPago) + jurosPessoa;
        System.out.println("Valor total pago: R$" + valorTotalPago + "\nSaldo Devedor: R$" + saldoDevedor);
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
