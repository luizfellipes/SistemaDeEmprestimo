package org.example;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String inscricaoEstadual;
    public PessoaJuridica(String nome, String telefone, String cnpj, String inscricaoEstadual) {
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public boolean pessoaExiste() {
        if (campoNulo(cnpj)  || campoNulo(inscricaoEstadual)) {
            System.out.println("Pessoa sem dados cadastrados ! \nNão será possível realizar o emprestimo !");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
