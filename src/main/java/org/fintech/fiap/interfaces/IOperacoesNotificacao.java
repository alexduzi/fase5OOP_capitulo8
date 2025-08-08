package org.fintech.fiap.interfaces;

import org.fintech.fiap.entidades.Notificacao;

public interface IOperacoesNotificacao extends IOperacoes {
    void enviarNotificacao(String tipo, String mensagem);

    void marcarComoLida(Long notificacaoId);

    void listarNotificacoes();

    Notificacao criarNotificacao(String tipo, String mensagem);
}