package org.fintech.fiap.entidades;

import java.time.LocalDate;

public class Cartao {
    private Long cartaoId;
    private Conta conta;
    private String numeroCartao;
    private String nomeImpresso;
    private LocalDate dataExpiracao;
    private String cvv;
    private boolean ativo;
    private String tipoCartao;
    private Double limite;

    public Cartao() {
    }

    public Cartao(Long cartaoId, Conta conta, String numeroCartao, String nomeImpresso, LocalDate dataExpiracao, String cvv, boolean ativo, String tipoCartao, Double limite) {
        this.cartaoId = cartaoId;
        this.conta = conta;
        this.numeroCartao = numeroCartao;
        this.nomeImpresso = nomeImpresso;
        this.dataExpiracao = dataExpiracao;
        this.cvv = cvv;
        this.ativo = ativo;
        this.tipoCartao = tipoCartao;
        this.limite = limite;
    }

    public Long getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(Long cartaoId) {
        this.cartaoId = cartaoId;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeImpresso() {
        return nomeImpresso;
    }

    public void setNomeImpresso(String nomeImpresso) {
        this.nomeImpresso = nomeImpresso;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "Cartao{" + "cartaoId=" + cartaoId + ", conta=" + conta + ", numeroCartao='" + numeroCartao + '\'' + ", nomeImpresso='" + nomeImpresso + '\'' + ", dataExpiracao=" + dataExpiracao + ", cvv='" + cvv + '\'' + ", ativo=" + ativo + ", tipoCartao='" + tipoCartao + '\'' + ", limite=" + limite + '}';
    }
}
