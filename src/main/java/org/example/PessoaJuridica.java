package org.example;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String inscricaoEstadual;

    public PessoaJuridica(String nome, String telefone, String cnpj, String inscricaoEstadual) {
        this.nome = nome;
        this.telefone = telefone;
        validaCnpj(cnpj);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public void validaCnpj(String cnpj) {
        cnpj = cnpj.replaceAll("\\D+", "");
        if (cnpj.length() == 14) {
            this.cnpj = cnpj;
        } else {
            throw new RuntimeException("Cnpj Invalido");
        }
    }

    private static final float taxaJuros = 1.05f;

    @Override
    public float taxaJuros() {
        return taxaJuros;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "CNPJ='" + cnpj + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
