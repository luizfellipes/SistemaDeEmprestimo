package org.example;

public class PessoaFisica extends Pessoa {
    private String CPF;
    private String tituloEleitor;

    public PessoaFisica(String nome, String telefone, String CPF, String tituloEleitor) {
        super(nome, telefone);
        this.CPF = CPF;
        this.tituloEleitor = tituloEleitor;
    }

    private static final float taxaJuros = 1.10f;

    @Override
    public float taxaJuros() {
        return taxaJuros;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "CPF='" + CPF + '\'' +
                ", tituloEleitor='" + tituloEleitor + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
