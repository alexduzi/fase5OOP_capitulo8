package org.fintech.fiap.interfaces;

import org.fintech.fiap.entidades.Cartao;

public interface IOperacoesCartao extends IOperacoes {
    Cartao criarCartao(String tipoCartao, Double limite);

    void bloquearCartao(Long cartaoId);

    void desbloquearCartao(Long cartaoId);

    void alterarLimite(Long cartaoId, Double novoLimite);
}