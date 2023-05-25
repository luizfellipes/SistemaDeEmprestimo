package org.example;

public class Aposentado extends PessoaFisica {
    String dataDaAposentadoria;

    public Aposentado(String nome, String telefone, String CPF, String tituloEleitor, String dataDaAposentadoria) {
        super(nome, telefone, CPF, tituloEleitor);
        this.dataDaAposentadoria = dataDaAposentadoria;
    }

    private static final float taxaJuros = 1.03f;

    @Override
    public float taxaJuros() {
        return taxaJuros;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Aposentado{" +
                "dataDaAposentadoria='" + dataDaAposentadoria + '\'' +
                "} ";
    }
}
