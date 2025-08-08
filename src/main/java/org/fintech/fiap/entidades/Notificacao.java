package org.fintech.fiap.entidades;

import java.time.Instant;

public class Notificacao {
    private Long notificacaoId;
    private Cliente cliente;
    private String tipo;
    private String mensagem;
    private Instant dataHora;
    private boolean lida;

    public Notificacao() {
    }

    public Notificacao(Long notificacaoId, Cliente cliente, String tipo, String mensagem, Instant dataHora, boolean lida) {
        this.notificacaoId = notificacaoId;
        this.cliente = cliente;
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.dataHora = dataHora;
        this.lida = lida;
    }

    public Long getNotificacaoId() {
        return notificacaoId;
    }

    public void setNotificacaoId(Long notificacaoId) {
        this.notificacaoId = notificacaoId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }

    @Override
    public String toString() {
        return "Notificacao{" +
               "notificacaoId=" + notificacaoId +
               ", cliente=" + cliente +
               ", tipo='" + tipo + '\'' +
               ", mensagem='" + mensagem + '\'' +
               ", dataHora=" + dataHora +
               ", lida=" + lida +
               '}';
    }
}
