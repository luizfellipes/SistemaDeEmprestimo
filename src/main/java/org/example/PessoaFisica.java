package org.example;

public class PessoaFisica extends Pessoa {

    private String cpf;
    private String tituloEleitor;

    public PessoaFisica(String nome, String telefone, String cpf, String tituloEleitor) {
        this.nome = nome;
        this.telefone = telefone;
        validaCpf(cpf);
        this.tituloEleitor = tituloEleitor;
    }

    public void validaCpf(String cpf) {
        cpf = cpf.replaceAll("\\D+", "");
        if (cpf.length() == 11) {
            this.cpf = cpf;
        } else {
            throw new RuntimeException("Cpf Invalido");
        }
    }
    public boolean pessoaExiste() {
        if (campoNulo(cpf) || campoNulo(tituloEleitor)) {
            System.out.println("Pessoa sem dados cadastrados ! \nNão será possível realizar o emprestimo !");
            return false;
        }
        return true;
    }

    private static final float taxaJuros = 1.10f;

    @Override
    public float taxaJuros() {
        return taxaJuros;
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
