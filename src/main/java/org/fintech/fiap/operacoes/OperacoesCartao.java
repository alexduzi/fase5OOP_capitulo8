package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Cartao;
import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.interfaces.IOperacoesCartao;

import java.time.LocalDate;

public class OperacoesCartao extends OperacoesBase implements IOperacoesCartao {

    public OperacoesCartao(Conta conta) {
        super(conta);
    }

    @Override
    public void executarOperacao() {
        logOperacao("OPERAÇÕES CARTÃO", "Sistema de cartões ativo para " + getInfoConta());
    }

    @Override
    public Cartao criarCartao(String tipoCartao, Double limite) {
        if (!validarConta()) return null;

        logOperacao("CRIAÇÃO CARTÃO", String.format("Tipo: %s - Limite: R$ %.2f", tipoCartao, limite));

        Cartao cartao = new Cartao();
        cartao.setCartaoId(1L);
        cartao.setConta(conta);
        cartao.setNumeroCartao("1234 5678 9012 3456");
        cartao.setNomeImpresso(conta.getCliente().getNome());
        cartao.setDataExpiracao(LocalDate.now().plusYears(5));
        cartao.setCvv("123");
        cartao.setAtivo(true);
        cartao.setTipoCartao(tipoCartao);
        cartao.setLimite(limite);

        return cartao;
    }

    @Override
    public void bloquearCartao(Long cartaoId) {
        logOperacao("BLOQUEIO", String.format("Cartão ID: %d bloqueado", cartaoId));
    }

    @Override
    public void desbloquearCartao(Long cartaoId) {
        logOperacao("DESBLOQUEIO", String.format("Cartão ID: %d desbloqueado", cartaoId));
    }

    @Override
    public void alterarLimite(Long cartaoId, Double novoLimite) {
        logOperacao("ALTERAÇÃO LIMITE", String.format("Cartão ID: %d - Novo limite: R$ %.2f", cartaoId, novoLimite));
    }
}