package org.example;

public class PessoaJuridica extends Pessoa {
    private String CNPJ;
    private String inscricaoEstadual;
    public PessoaJuridica(String nome, String telefone, String CNPJ, String inscricaoEstadual) {
        super(nome, telefone);
        this.CNPJ = CNPJ;
        this.inscricaoEstadual = inscricaoEstadual;
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
