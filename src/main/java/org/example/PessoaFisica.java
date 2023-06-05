package org.example;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private String tituloEleitor;

    public PessoaFisica(String nome, String telefone, String cpf, String tituloEleitor) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.tituloEleitor = tituloEleitor;
    }

    public boolean pessoaExiste() {
        if (campoNulo(cpf)  || campoNulo(tituloEleitor)) {
            System.out.println("Pessoa sem dados cadastrados ! \nNão será possível realizar o emprestimo !");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", tituloEleitor='" + tituloEleitor + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
