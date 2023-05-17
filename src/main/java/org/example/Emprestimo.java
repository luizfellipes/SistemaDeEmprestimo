package org.example;

import java.util.Comparator;

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

    private void verificaTipoDeEmprestimo(Tipo tipo) {
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
            System.out.println("Não foi possivel realizar o pagamento !");
        }
    }

    public void ValorTotalPago() {
        float total = (numeroDeParcelasPagas * (valorEmprestimo / numeroDeParcelas));
        if (numeroDeParcelas > 5) {
            float valorComJuros = total * 1.025f;
            System.out.println("Valor total pago: R$" + valorComJuros + "\nSaldo Devedor: R$" + ((valorEmprestimo * 1.025f) - valorComJuros));
        } else {
            System.out.println("Valor total pago: R$" + total + "\nSaldo Devedor: R$" + (valorEmprestimo - total));
        }
    }

    public void verificarQuitado() {
        if (numeroDeParcelasPagas == numeroDeParcelas) {
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
                ", tipo=" + tipo +
                '}';
    }
}
