package org.fintech.fiap.entidades;

import java.time.LocalDate;

public class ParcelaEmprestimo {
    private Long parcelaId;
    private Emprestimo emprestimo;
    private Integer numeroParcela;
    private Double valorParcela;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private String statusPagamento;

    public ParcelaEmprestimo() {
    }

    public ParcelaEmprestimo(Long parcelaId, Emprestimo emprestimo, Integer numeroParcela, Double valorParcela, LocalDate dataVencimento, LocalDate dataPagamento, String statusPagamento) {
        this.parcelaId = parcelaId;
        this.emprestimo = emprestimo;
        this.numeroParcela = numeroParcela;
        this.valorParcela = valorParcela;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.statusPagamento = statusPagamento;
    }

    public Long getParcelaId() {
        return parcelaId;
    }

    public void setParcelaId(Long parcelaId) {
        this.parcelaId = parcelaId;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    @Override
    public String toString() {
        return "ParcelaEmprestimo{" + "parcelaId=" + parcelaId + ", emprestimo=" + emprestimo + ", numeroParcela=" + numeroParcela + ", valorParcela=" + valorParcela + ", dataVencimento=" + dataVencimento + ", dataPagamento=" + dataPagamento + ", statusPagamento='" + statusPagamento + '\'' + '}';
    }
}
