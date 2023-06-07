package org.example;

public class PessoaJuridica extends Pessoa {
    private String CNPJ;
    private String inscricaoEstadual;

    public PessoaJuridica(String nome, String telefone, String CNPJ, String inscricaoEstadual) {
        this.nome = nome;
        this.telefone = telefone;
        validaCnpj(CNPJ);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public void validaCnpj(String CNPJ) {
        CNPJ = CNPJ.replaceAll("\\D+", "");
        if (CNPJ.length() == 14) {
            this.CNPJ = CNPJ;
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
                "CNPJ='" + CNPJ + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
