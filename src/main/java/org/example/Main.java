package org.example;

public class Main {
    public static void main(String[] args) {
        Emprestimo emprestimo = new Emprestimo("luiz", 33631772,"05469372170", 3000, 10, 0);

        System.out.println(emprestimo);
        emprestimo.valorPago(2700);
        emprestimo.pagamentoEmprestimo(9);
        boolean dividaZero = false;
        emprestimo.emprestimoQuitado(dividaZero);
    }
}