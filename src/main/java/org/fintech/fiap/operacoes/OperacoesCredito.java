package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Cartao;
import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.entidades.Emprestimo;
import org.fintech.fiap.entidades.Fatura;

import java.time.LocalDate;
import java.util.Random;

public class OperacoesCredito {
    private Conta contaOrigem;

    private Conta contaDestino;

    private Double valorEmprestimo;

    private Cartao cartaoConta;

    public OperacoesCredito(Conta contaOrigem, Cartao cartaoConta) {
        this.contaOrigem = contaOrigem;
        this.valorEmprestimo = new Random().nextDouble();
        this.cartaoConta = cartaoConta;
    }

    public Emprestimo contratarEmprestimo() {
        Emprestimo emp = new Emprestimo();
        emp.setEmprestimoId(1L);
        emp.setCliente(contaOrigem.getCliente());
        emp.setConta(contaOrigem);
        emp.setValorEmprestimo(valorEmprestimo);
        emp.setTaxaJuros(0.2D);
        emp.setPrazoMeses(12);
        emp.setValorParcela(valorEmprestimo / 12);
        emp.setDataContratacao(LocalDate.now());
        emp.setStatus("Pendente");
        return emp;
    }

    public Fatura fecharFatura() {
        Fatura fatura = new Fatura();
        fatura.setFaturaId(1L);
        fatura.setCartao(cartaoConta);
        fatura.setDataFechamento(LocalDate.now());
        fatura.setDataVencimento(LocalDate.now().plusDays(10));
        fatura.setValorTotal(500D);
        fatura.setStatusPagamento("Pendente");
        fatura.setValorMinimo(150D);
        return fatura;
    }
}
