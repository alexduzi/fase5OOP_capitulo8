package org.fintech.fiap.interfaces;

import org.fintech.fiap.entidades.Investimento;

public interface IOperacoesInvestimento extends IOperacoes {
    Investimento realizarInvestimento(String tipoInvestimento, Double valorAplicacao);

    void resgateInvestimento(Long investimentoId);

    void consultarInvestimentos();

    void simularInvestimento(String tipoInvestimento, Double valorAplicacao);
}
