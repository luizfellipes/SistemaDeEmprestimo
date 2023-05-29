package org.example;

public class PessoaFisica extends Pessoa {
    private String CPF;
    private String tituloEleitor;

    public PessoaFisica(String nome, String telefone, String CPF, String tituloEleitor) {
        super(nome, telefone);
        validaCpf(CPF);
        this.tituloEleitor = tituloEleitor;
    }

    public void validaCpf(String CPF) {
        CPF = CPF.replaceAll("\\D+", "");
        if (CPF.length() == 11) {
            this.CPF = CPF;
        } else {
            throw new RuntimeException("Cpf Invalido");
        }
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
