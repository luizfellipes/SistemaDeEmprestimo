package org.example;

public class Pessoa {
    private String nome;
    private String telefone;
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }


    public boolean pessoaExiste(Pessoa pessoa) {
        if (nome.isEmpty() && cpf.isEmpty() && telefone.isEmpty()) {
            System.out.println("Pessoa sem dados cadastrados ! \nNão será possível realizar o emprestimo !");
        }
        return true;
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
