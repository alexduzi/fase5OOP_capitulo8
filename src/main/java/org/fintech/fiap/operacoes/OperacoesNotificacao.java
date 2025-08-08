package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.entidades.Notificacao;
import org.fintech.fiap.interfaces.IOperacoesNotificacao;

import java.time.Instant;

public class OperacoesNotificacao extends OperacoesBase implements IOperacoesNotificacao {

    public OperacoesNotificacao(Conta conta) {
        super(conta);
    }

    @Override
    public void executarOperacao() {
        logOperacao("OPERAÇÕES NOTIFICAÇÃO", "Sistema de notificações ativo para " + getInfoConta());
    }

    @Override
    public void enviarNotificacao(String tipo, String mensagem) {
        if (!validarConta()) return;

        logOperacao("ENVIO", String.format("Tipo: %s - Mensagem: %s", tipo, mensagem));
    }

    @Override
    public void marcarComoLida(Long notificacaoId) {
        logOperacao("LEITURA", String.format("Notificação ID: %d marcada como lida", notificacaoId));
    }

    @Override
    public void listarNotificacoes() {
        if (!validarConta()) return;

        logOperacao("LISTAGEM", String.format("Listando notificações para %s", conta.getCliente().getNome()));
    }

    @Override
    public Notificacao criarNotificacao(String tipo, String mensagem) {
        if (!validarConta()) return null;

        logOperacao("CRIAÇÃO", String.format("Nova notificação: %s", tipo));

        Notificacao notificacao = new Notificacao();
        notificacao.setNotificacaoId(1L);
        notificacao.setCliente(conta.getCliente());
        notificacao.setTipo(tipo);
        notificacao.setMensagem(mensagem);
        notificacao.setDataHora(Instant.now());
        notificacao.setLida(false);

        return notificacao;
    }
}