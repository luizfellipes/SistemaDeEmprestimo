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

    public boolean pessoaExiste() {
        if (nome.isEmpty() && cpf.isEmpty() && telefone.isEmpty()) {
            System.out.println("Sem cadastro pessoal !");
            return false;
        } else {
            return true;
        }
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
