package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class EmprestimoTest {

    private final Pessoa pessoa = new PessoaFisica("Fulano", "123456789", "65161651515", "a16sf551s6");
    private final Emprestimo emprestimo = new Emprestimo(1000, 10, 10, pessoa, Tipo.PESSOAL);

    public EmprestimoTest() throws Exception {
    }

    @Test
    public void deveVerificarPessoa() {
        Assertions.assertEquals(pessoa, emprestimo.getPessoa());
        Assertions.assertThrows(NullPointerException.class, () -> emprestimo.verificaPessoa(null));
    }

    @Test
    public void deveVerificarValorEmprestimo() {
        Assertions.assertEquals(1000, emprestimo.getValorEmprestimo());
        Assertions.assertThrows(Exception.class, () -> emprestimo.verificaValorEmprestimo(-1000));
    }

    @Test
    public void deveVerificarNumeroParcelas() {
        Assertions.assertEquals(10, emprestimo.getNumeroDeParcelas());
        Assertions.assertThrows(Exception.class, () -> emprestimo.verificaNumeroParcelas(-10));
    }

    @Test
    public void deveVerificarNumeroParcelasPagas() {
        Assertions.assertEquals(10, emprestimo.getNumeroDeParcelasPagas());
    }

    @Test
    public void deveVerificarTipo() {
        Assertions.assertEquals(Tipo.PESSOAL, emprestimo.getTipo());
    }

    @Test
    public void deveVerificarRealizarPagamento() {
        Assertions.assertEquals(10, emprestimo.getNumeroDeParcelasPagas());
    }

    @Test
    public void deveVerificarValorPago() {
        emprestimo.valorTotalPago();
        Assertions.assertEquals(1036.0, emprestimo.getValorFinalPago());
    }

    @Test
    public void deveVerificarVerificarQuitado() {
        Assertions.assertTrue(emprestimo.getNumeroDeParcelasPagas() > 0 && emprestimo.getNumeroDeParcelas() > 0 && emprestimo.getNumeroDeParcelasPagas() == emprestimo.getNumeroDeParcelas());
    }

}
