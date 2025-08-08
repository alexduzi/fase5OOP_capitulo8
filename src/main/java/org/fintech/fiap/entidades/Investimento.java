package org.fintech.fiap.entidades;

import java.time.LocalDate;

public class Investimento {
    private Long investimentoId;
    private Cliente cliente;
    private String tipoInvstimento;
    private Double valorAplicado;
    private Double rentabilidade;
    private LocalDate dataAplicacao;
    private LocalDate dataVencimento;
    private String status;

    public Investimento() {}

    public Investimento(Long investimentoId, Cliente cliente, String tipoInvstimento, Double valorAplicado, Double rentabilidade, LocalDate dataAplicacao, LocalDate dataVencimento, String status) {
        this.investimentoId = investimentoId;
        this.cliente = cliente;
        this.tipoInvstimento = tipoInvstimento;
        this.valorAplicado = valorAplicado;
        this.rentabilidade = rentabilidade;
        this.dataAplicacao = dataAplicacao;
        this.dataVencimento = dataVencimento;
        this.status = status;
    }

    public Long getInvestimentoId() {
        return investimentoId;
    }

    public void setInvestimentoId(Long investimentoId) {
        this.investimentoId = investimentoId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoInvstimento() {
        return tipoInvstimento;
    }

    public void setTipoInvstimento(String tipoInvstimento) {
        this.tipoInvstimento = tipoInvstimento;
    }

    public Double getValorAplicado() {
        return valorAplicado;
    }

    public void setValorAplicado(Double valorAplicado) {
        this.valorAplicado = valorAplicado;
    }

    public Double getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(Double rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Investimento{" +
               "investimentoId=" + investimentoId +
               ", cliente=" + cliente +
               ", tipoInvstimento='" + tipoInvstimento + '\'' +
               ", valorAplicado=" + valorAplicado +
               ", rentabilidade=" + rentabilidade +
               ", dataAplicacao=" + dataAplicacao +
               ", dataVencimento=" + dataVencimento +
               ", status='" + status + '\'' +
               '}';
    }
}
