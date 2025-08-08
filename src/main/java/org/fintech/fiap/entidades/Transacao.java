package org.fintech.fiap.entidades;

import java.time.Instant;

public class Transacao {
    private Long transacaoId;
    private Conta contaOrigem;
    private Conta contaDestino;
    private Double valor;
    private Instant dataAbertura;
    private String tipoTransacao;
    private String status;
    private String descricao;
    private String referenciaExterna;

    public Transacao() {
    }

    public Transacao(Long transacaoId, Conta contaOrigem, Conta contaDestino, Double valor, Instant dataAbertura, String tipoTransacao, String status, String descricao, String referenciaExterna) {
        this.transacaoId = transacaoId;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataAbertura = dataAbertura;
        this.tipoTransacao = tipoTransacao;
        this.status = status;
        this.descricao = descricao;
        this.referenciaExterna = referenciaExterna;
    }

    public Long getTransacaoId() {
        return transacaoId;
    }

    public void setTransacaoId(Long transacaoId) {
        this.transacaoId = transacaoId;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Instant getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Instant dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getReferenciaExterna() {
        return referenciaExterna;
    }

    public void setReferenciaExterna(String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }

    @Override
    public String toString() {
        return "Transacao{" + "transacaoId=" + transacaoId + ", contaOrigem=" + contaOrigem + ", contaDestino=" + contaDestino + ", valor=" + valor + ", dataAbertura=" + dataAbertura + ", tipoTransacao='" + tipoTransacao + '\'' + ", status='" + status + '\'' + ", descricao='" + descricao + '\'' + ", referenciaExterna='" + referenciaExterna + '\'' + '}';
    }
}
