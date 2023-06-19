package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class EmprestimoTest {

    private final Pessoa pessoa = new PessoaFisica("Fulano", "123456789", "65161651515", "a16sf551s6");
    private final Emprestimo emprestimo = new Emprestimo(10000, 10, 10, pessoa, Tipo.PESSOAL);

    public EmprestimoTest() throws Exception {
    }

    @Test
    public void deveVerificarPessoa() {
        emprestimo.verificaPessoa(pessoa);
        Assertions.assertEquals(pessoa, emprestimo.getPessoa());
        Assertions.assertThrows(NullPointerException.class, () -> emprestimo.verificaPessoa(null));
    }

    @Test
    public void deveVerificarValorEmprestimo() throws Exception {
        emprestimo.verificaValorEmprestimo(1000);
        Assertions.assertEquals(1000, emprestimo.getValorEmprestimo());
        Assertions.assertThrows(Exception.class, () -> emprestimo.verificaValorEmprestimo(-1000));
    }

    @Test
    public void deveVerificarNumeroParcelas() throws Exception {
        emprestimo.verificaNumeroParcelas(10);
        Assertions.assertEquals(10, emprestimo.getNumeroDeParcelas());
        Assertions.assertThrows(Exception.class, () -> emprestimo.verificaNumeroParcelas(-10));
    }

    @Test
    public void deveVerificarNumeroParcelasPagas() {
        emprestimo.verificaNumeroParcelasPagas(7);
        Assertions.assertEquals(7, emprestimo.getNumeroDeParcelasPagas());
    }

    @Test
    public void deveVerificarTipo() {
        emprestimo.verificaTipoDeEmprestimo(Tipo.PESSOAL);
        Assertions.assertEquals(Tipo.PESSOAL, emprestimo.getTipo());
    }

    @Test
    public void deveVerificarRealizarPagamento() {
        emprestimo.realizarPagamento(1);
        Assertions.assertEquals(10, emprestimo.getNumeroDeParcelasPagas());
    }

    @Test
    public void deveVerificarValorPago() {
        emprestimo.ValorTotalPago();
        Assertions.assertEquals(10360.0, emprestimo.getValorFinalPago());
    }

    @Test
    public void deveVerificarVerificarQuitado() throws Exception {
        emprestimo.verificarQuitado();
        Assertions.assertTrue(emprestimo.getNumeroDeParcelasPagas() > 0 && emprestimo.getNumeroDeParcelas() > 0 && emprestimo.getNumeroDeParcelasPagas() == emprestimo.getNumeroDeParcelas());
    }

}
