package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Conta;

public class OperacoesRelatorio extends OperacoesBase {

    public OperacoesRelatorio(Conta conta) {
        super(conta);
    }

    @Override
    public void executarOperacao() {
        logOperacao("OPERAÇÕES RELATÓRIO", "Sistema de relatórios ativo para " + getInfoConta());
    }

    public void gerarExtratoPeriodo(String dataInicio, String dataFim) {
        if (!validarConta()) return;

        logOperacao("EXTRATO PERÍODO", String.format("Período: %s a %s", dataInicio, dataFim));
    }

    public void gerarRelatorioInvestimentos() {
        if (!validarConta()) return;

        logOperacao("RELATÓRIO INVESTIMENTOS", "Relatório de carteira de investimentos gerado");
    }

    public void gerarRelatorioCredito() {
        if (!validarConta()) return;

        logOperacao("RELATÓRIO CRÉDITO", "Relatório de operações de crédito gerado");
    }

    public void gerarComprovanteTransacao(Long transacaoId) {
        if (!validarConta()) return;

        logOperacao("COMPROVANTE", String.format("Comprovante da transação ID: %d gerado", transacaoId));
    }
}