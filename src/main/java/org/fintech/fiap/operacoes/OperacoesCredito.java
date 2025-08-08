package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Cartao;
import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.entidades.Emprestimo;
import org.fintech.fiap.entidades.Fatura;
import org.fintech.fiap.interfaces.IOperacoesCredito;

import java.time.LocalDate;
import java.util.Random;

public class OperacoesCredito extends OperacoesBase implements IOperacoesCredito {
    private Double valorEmprestimo;
    private Cartao cartaoConta;

    public OperacoesCredito(Conta conta, Cartao cartaoConta) {
        super(conta);
        this.valorEmprestimo = 1000.0 + new Random().nextDouble() * 4000.0; // Valor entre 1000 e 5000
        this.cartaoConta = cartaoConta;
    }

    @Override
    public void executarOperacao() {
        logOperacao("OPERAÇÕES CRÉDITO", "Sistema de crédito ativo para " + getInfoConta());
    }

    @Override
    public Emprestimo contratarEmprestimo() {
        if (!validarConta()) return null;

        logOperacao("CONTRATAÇÃO EMPRÉSTIMO", String.format("Valor: R$ %.2f", valorEmprestimo));

        Emprestimo emp = new Emprestimo();
        emp.setEmprestimoId(1L);
        emp.setCliente(conta.getCliente());
        emp.setConta(conta);
        emp.setValorEmprestimo(valorEmprestimo);
        emp.setTaxaJuros(0.02); // 2% ao mês
        emp.setPrazoMeses(12);
        emp.setValorParcela(valorEmprestimo / 12);
        emp.setDataContratacao(LocalDate.now());
        emp.setStatus("Ativo");

        return emp;
    }

    @Override
    public Fatura fecharFatura() {
        if (!validarConta()) return null;

        logOperacao("FECHAMENTO FATURA", "Fatura fechada para processamento");

        Fatura fatura = new Fatura();
        fatura.setFaturaId(1L);
        fatura.setCartao(cartaoConta);
        fatura.setDataFechamento(LocalDate.now());
        fatura.setDataVencimento(LocalDate.now().plusDays(10));
        fatura.setValorTotal(500.0);
        fatura.setStatusPagamento("Pendente");
        fatura.setValorMinimo(50.0);

        return fatura;
    }
}