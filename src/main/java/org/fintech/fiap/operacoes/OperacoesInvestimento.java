package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.entidades.Investimento;
import org.fintech.fiap.interfaces.IOperacoesInvestimento;

import java.time.LocalDate;

public class OperacoesInvestimento extends OperacoesBase implements IOperacoesInvestimento {

    public OperacoesInvestimento(Conta conta) {
        super(conta);
    }

    @Override
    public void executarOperacao() {
        logOperacao("OPERAÇÕES INVESTIMENTO", "Sistema de investimentos ativo para " + getInfoConta());
    }

    @Override
    public Investimento realizarInvestimento(String tipoInvestimento, Double valorAplicacao) {
        if (!validarConta()) return null;

        logOperacao("INVESTIMENTO", String.format("%s - Valor: R$ %.2f", tipoInvestimento, valorAplicacao));

        Investimento investimento = new Investimento();
        investimento.setInvestimentoId(1L);
        investimento.setCliente(conta.getCliente());
        investimento.setTipoInvstimento(tipoInvestimento);
        investimento.setValorAplicado(valorAplicacao);
        investimento.setRentabilidade(0.10);
        investimento.setDataAplicacao(LocalDate.now());
        investimento.setDataVencimento(LocalDate.now().plusYears(1));
        investimento.setStatus("Ativo");

        return investimento;
    }

    @Override
    public void resgateInvestimento(Long investimentoId) {
        if (!validarConta()) return;

        logOperacao("RESGATE", String.format("Investimento ID: %d resgatado", investimentoId));
    }

    @Override
    public void consultarInvestimentos() {
        if (!validarConta()) return;

        logOperacao("CONSULTA", String.format("Carteira de investimentos de %s", conta.getCliente().getNome()));
    }

    @Override
    public void simularInvestimento(String tipoInvestimento, Double valorAplicacao) {
        if (!validarConta()) return;

        double rentabilidadeProjetada = valorAplicacao * 0.10; // 10% ao ano
        logOperacao("SIMULAÇÃO", String.format("%s - Aplicação: R$ %.2f - Projeção 12 meses: R$ %.2f",
                tipoInvestimento, valorAplicacao, valorAplicacao + rentabilidadeProjetada));
    }
}