package org.example;

import org.junit.Test;

public class EmprestimoTest {

    private final Pessoa pessoa = new PessoaFisica("Fulano", "123456789", "65161651515", "a16sf551s6");
    private final Emprestimo emprestimo = new Emprestimo(10000, 4, 3, pessoa, Tipo.PESSOAL);

    public EmprestimoTest() throws Exception {
    }

    @Test
    public void deveVerificarPessoa() {
        emprestimo.verificaPessoa(pessoa);
    }

    @Test
    public void deveVerificarValorEmprestimo() throws Exception {
        emprestimo.verificaValorEmprestimo(1000);
    }

    @Test
    public void deveVerificarNumeroParcelas() throws Exception {
        emprestimo.verificaNumeroParcelas(10);
    }

    @Test
    public void deveVerificarNumeroParcelasPagas() {
        emprestimo.verificaNumeroParcelasPagas(10);
    }

    @Test
    public void deveVerificarTipo() {
        emprestimo.verificaTipoDeEmprestimo(null);
    }

    @Test
    public void deveVerificarRealizarPagamento() {
        emprestimo.realizarPagamento(1);
    }

    @Test
    public void deveVerificarValorPago() {
        emprestimo.ValorTotalPago();
    }

    @Test
    public void deveVerificarVerificarQuitado() throws Exception {
        emprestimo.verificarQuitado();
    }

}
