package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TesteEmprestimo {

    private final Emprestimo emprestimo = new Emprestimo();
    private final Pessoa pessoa = new PessoaFisica("Fulano", "123456789", "65161651515", "a16sf551s6");

    @Test
    public void testePessoa() {
        emprestimo.verificaPessoa(pessoa);
    }

    @Test
    public void testeValorEmprestimo() throws Exception {
        emprestimo.verificaValorEmprestimo(1000);
    }

    @Test
    public void testeNumeroParcelas() throws Exception {
        emprestimo.verificaNumeroParcelas(10);
    }

    @Test
    public void testeNumeroParcelasPagas() {
        emprestimo.verificaNumeroParcelasPagas(10);
    }

    @Test
    public void testeTipo() {
        emprestimo.verificaTipoDeEmprestimo(null);
    }

    @Test
    public void testeRealizarPagamento() {
        emprestimo.realizarPagamento(1);
    }

    @Test(expected = NullPointerException.class)
    public void testeValorPago() {
        emprestimo.ValorTotalPago();
    }

    @Test
    public void testeVerificarQuitado() throws Exception {
        emprestimo.verificarQuitado();
    }

}
