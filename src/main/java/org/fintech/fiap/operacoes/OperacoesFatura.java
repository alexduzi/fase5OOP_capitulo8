package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.entidades.ItemFatura;
import org.fintech.fiap.interfaces.IOperacoesFatura;

import java.time.LocalDate;

public class OperacoesFatura extends OperacoesBase implements IOperacoesFatura {

    public OperacoesFatura(Conta conta) {
        super(conta);
    }

    @Override
    public void executarOperacao() {
        logOperacao("OPERAÇÕES FATURA", "Sistema de faturas ativo para " + getInfoConta());
    }

    @Override
    public void adicionarItemFatura(Long faturaId, String descricao, Double valor) {
        if (!validarConta()) return;

        logOperacao("ITEM FATURA", String.format("Fatura ID: %d - %s: R$ %.2f", faturaId, descricao, valor));
    }

    @Override
    public void pagarFatura(Long faturaId, Double valor) {
        if (!validarConta()) return;

        logOperacao("PAGAMENTO", String.format("Fatura ID: %d - Valor pago: R$ %.2f", faturaId, valor));
    }

    @Override
    public void consultarFatura(Long faturaId) {
        if (!validarConta()) return;

        logOperacao("CONSULTA", String.format("Consultando fatura ID: %d", faturaId));
    }

    @Override
    public ItemFatura criarItemFatura(String descricao, Double valor) {
        if (!validarConta()) return null;

        logOperacao("NOVO ITEM", String.format("%s - R$ %.2f", descricao, valor));

        ItemFatura item = new ItemFatura();
        item.setItemId(1L);
        item.setDescricao(descricao);
        item.setValor(valor);
        item.setDataCompra(LocalDate.now());
        item.setParcela(1);
        item.setTotalParcelas(1);

        return item;
    }
}