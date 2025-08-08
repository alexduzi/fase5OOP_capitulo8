package org.fintech.fiap.entidades;

import java.time.LocalDate;

public class Fatura {
    private Long faturaId;
    private Cartao cartao;
    private LocalDate dataFechamento;
    private LocalDate dataVencimento;
    private Double valorTotal;
    private String statusPagamento;
    private Double valorMinimo;

    public Fatura() {
    }

    public Fatura(Long faturaId, Cartao cartao, LocalDate dataFechamento, LocalDate dataVencimento, Double valorTotal, String statusPagamento, Double valorMinimo) {
        this.faturaId = faturaId;
        this.cartao = cartao;
        this.dataFechamento = dataFechamento;
        this.dataVencimento = dataVencimento;
        this.valorTotal = valorTotal;
        this.statusPagamento = statusPagamento;
        this.valorMinimo = valorMinimo;
    }

    public Long getFaturaId() {
        return faturaId;
    }

    public void setFaturaId(Long faturaId) {
        this.faturaId = faturaId;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    @Override
    public String toString() {
        return "Fatura{" +
               "faturaId=" + faturaId +
               ", cartao=" + cartao +
               ", dataFechamento=" + dataFechamento +
               ", dataVencimento=" + dataVencimento +
               ", valorTotal=" + valorTotal +
               ", statusPagamento='" + statusPagamento + '\'' +
               ", valorMinimo=" + valorMinimo +
               '}';
    }
}
