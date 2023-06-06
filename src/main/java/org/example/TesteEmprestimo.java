package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TesteEmprestimo {

    private final Emprestimo emprestimo = new Emprestimo();
    private final Pessoa pessoa = new PessoaFisica("Fulano", "123456789", "65161651515", "a16sf551s6");

    @Test
    public void testarPessoa() {
        Assertions.assertEquals(pessoa, emprestimo.verificaPessoa(pessoa));
    }

    @Test
    public void testarValorEmprestimo() throws Exception {
        Assertions.assertEquals(1000, emprestimo.verificaValorEmprestimo(1000));
    }

    @Test
    public void testarNumeroParcelas() throws Exception {
        Assertions.assertEquals(10, emprestimo.verificaNumeroParcelas(10));
    }

    @Test
    public void testarNumeroParcelasPagas() {
        Assertions.assertEquals(10, emprestimo.verificaNumeroParcelasPagas(10));
    }

    @Test
    public void testarTipo() {
        Assertions.assertEquals(Tipo.PESSOAL, emprestimo.verificaTipoDeEmprestimo(Tipo.PESSOAL));
    }

    @Test
    public void testarRealizarPagamento() {
        Assertions.assertEquals(8, emprestimo.realizarPagamento(8));
    }


}

