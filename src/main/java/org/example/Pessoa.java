package org.example;

public abstract class Pessoa {
    private String nome;
    private int telefone;
    private String cpf;

    public Pessoa(String nome, int telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Dados{" +
                "nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", cpf='" + cpf + '\'' ;
    }
}
