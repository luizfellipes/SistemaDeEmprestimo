package org.example;

public abstract class Pessoa {
    protected final String nome;
    protected final String telefone;

    public Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public boolean pessoaExiste(Pessoa pessoa) {
        if (pessoa.nome.isEmpty() && pessoa.telefone.isEmpty()) {
            System.out.println("Pessoa sem dados cadastrados ! \nNão será possível realizar o emprestimo !");
        }
        return true;
    }


    public abstract float taxaJuros();

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}