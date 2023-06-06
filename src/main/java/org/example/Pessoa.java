package org.example;

public class Pessoa {
    protected String nome;
    protected String telefone;

    public Pessoa() {
    }

    public boolean pessoaExiste() {
        if (campoNulo(nome) || campoNulo(telefone)) {
            System.out.println("Pessoa sem dados cadastrados ! \nNão será possível realizar o emprestimo !");
            return false;
        }
        return true;
    }

    public boolean campoNulo(Object campo) {
        if (campo == null) {
            return true;
        } else if (campo instanceof String) {
            return ((String) campo).isEmpty();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}