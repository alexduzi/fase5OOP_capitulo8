package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.entidades.Investimento;

public class OperacoesInvestimento {
    private Conta conta;

    public OperacoesInvestimento(Conta conta) {
        this.conta = conta;
    }

    public Investimento realizarInvestimento(String tipoInvestimento, Double valorAplicacao) {
        System.out.println("Investimento realizado: " + tipoInvestimento + " - Valor: R$ " + String.format("%.2f", valorAplicacao));

        Investimento investimento = new Investimento();
        investimento.setInvestimentoId(1L);
        investimento.setCliente(conta.getCliente());
        investimento.setTipoInvstimento(tipoInvestimento);
        investimento.setValorAplicado(valorAplicacao);
        investimento.setRentabilidade(0.10);
        investimento.setStatus("Ativo");

        return investimento;
    }

    public void resgateInvestimento(Long investimentoId) {
        System.out.println("Resgate do investimento ID: " + investimentoId + " realizado com sucesso!");
    }

    public void consultarInvestimentos() {
        System.out.println("Consultando carteira de investimentos do cliente: " + conta.getCliente().getNome());
    }

    public void simularInvestimento(String tipoInvestimento, Double valorAplicacao) {
        System.out.println("Simulação de investimento: " + tipoInvestimento + " - Valor: R$ " + String.format("%.2f", valorAplicacao));
    }
}