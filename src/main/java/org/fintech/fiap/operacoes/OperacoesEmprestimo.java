package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.entidades.ParcelaEmprestimo;

import java.time.LocalDate;

public class OperacoesEmprestimo extends OperacoesBase {

    public OperacoesEmprestimo(Conta conta) {
        super(conta);
    }

    @Override
    public void executarOperacao() {
        logOperacao("OPERAÇÕES EMPRÉSTIMO", "Sistema de empréstimos ativo para " + getInfoConta());
    }

    public void pagarParcela(Long parcelaId, Double valor) {
        if (!validarConta()) return;

        logOperacao("PAGAMENTO PARCELA", String.format("Parcela ID: %d - Valor: R$ %.2f", parcelaId, valor));
    }

    public void consultarParcelas(Long emprestimoId) {
        if (!validarConta()) return;

        logOperacao("CONSULTA PARCELAS", String.format("Empréstimo ID: %d", emprestimoId));
    }

    public ParcelaEmprestimo gerarParcela(Long emprestimoId, Integer numeroParcela, Double valor) {
        if (!validarConta()) return null;

        logOperacao("GERAÇÃO PARCELA", String.format("Empréstimo ID: %d - Parcela %d", emprestimoId, numeroParcela));

        ParcelaEmprestimo parcela = new ParcelaEmprestimo();
        parcela.setParcelaId(1L);
        parcela.setNumeroParcela(numeroParcela);
        parcela.setValorParcela(valor);
        parcela.setDataVencimento(LocalDate.now().plusMonths(numeroParcela));
        parcela.setStatusPagamento("Pendente");

        return parcela;
    }

    public void quitarEmprestimo(Long emprestimoId) {
        if (!validarConta()) return;

        logOperacao("QUITAÇÃO", String.format("Empréstimo ID: %d quitado antecipadamente", emprestimoId));
    }
}