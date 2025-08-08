package org.fintech.fiap.entidades;

import java.time.LocalDate;

public class ItemFatura {
    private Long itemId;
    private Fatura fatura;
    private Transacao transacao;
    private Double valor;
    private String descricao;
    private LocalDate dataCompra;
    private Integer parcela;
    private Integer totalParcelas;

    public ItemFatura() {}

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public Integer getTotalParcelas() {
        return totalParcelas;
    }

    public void setTotalParcelas(Integer totalParcelas) {
        this.totalParcelas = totalParcelas;
    }

    @Override
    public String toString() {
        return "ItemFatura{" +
               "itemId=" + itemId +
               ", fatura=" + fatura +
               ", transacao=" + transacao +
               ", valor=" + valor +
               ", descricao='" + descricao + '\'' +
               ", dataCompra=" + dataCompra +
               ", parcela=" + parcela +
               ", totalParcelas=" + totalParcelas +
               '}';
    }
}
