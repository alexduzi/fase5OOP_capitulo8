package org.fintech.fiap.interfaces;

import org.fintech.fiap.entidades.ItemFatura;

public interface IOperacoesFatura extends IOperacoes {
    void adicionarItemFatura(Long faturaId, String descricao, Double valor);

    void pagarFatura(Long faturaId, Double valor);

    void consultarFatura(Long faturaId);

    ItemFatura criarItemFatura(String descricao, Double valor);
}