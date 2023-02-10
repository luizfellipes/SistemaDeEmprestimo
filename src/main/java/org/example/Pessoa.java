package org.example;

public class Pessoa {
    private String nome;
    private String telefone;
    private String cpf;

    public Pessoa(String nome, String telefone, String cpf) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public boolean pessoaExiste(boolean pessoa){
        if(getNome().isEmpty() && getCpf().isEmpty() && getTelefone().isEmpty()){
            System.out.println("Pessoa sem dados cadastrados ! \nNão será possível realizar o emprestimo !");
            pessoa = false;
        }
        return pessoa;
    }


}
