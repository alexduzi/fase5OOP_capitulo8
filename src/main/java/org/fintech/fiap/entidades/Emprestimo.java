package org.fintech.fiap.entidades;

import java.time.LocalDate;

public class Emprestimo {
    private Long emprestimoId;
    private Cliente cliente;
    private Conta conta;
    private Double valorEmprestimo;
    private Double taxaJuros;
    private Integer prazoMeses;
    private Double valorParcela;
    private LocalDate dataContratacao;
    private String status;

    public Emprestimo() {
    }

    public Emprestimo(Long emprestimoId, Cliente cliente, Conta conta, Double valorEmprestimo, Double taxaJuros, int prazoMeses, Double valorParcela, LocalDate dataContratacao, String status) {
        this.emprestimoId = emprestimoId;
        this.cliente = cliente;
        this.conta = conta;
        this.valorEmprestimo = valorEmprestimo;
        this.taxaJuros = taxaJuros;
        this.prazoMeses = prazoMeses;
        this.valorParcela = valorParcela;
        this.dataContratacao = dataContratacao;
        this.status = status;
    }

    public Long getEmprestimoId() {
        return emprestimoId;
    }

    public void setEmprestimoId(Long emprestimoId) {
        this.emprestimoId = emprestimoId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(Double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(Double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public int getPrazoMeses() {
        return prazoMeses;
    }

    public void setPrazoMeses(int prazoMeses) {
        this.prazoMeses = prazoMeses;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "emprestimoId=" + emprestimoId + ", cliente=" + cliente + ", conta=" + conta + ", valorEmprestimo=" + valorEmprestimo + ", taxaJuros=" + taxaJuros + ", prazoMeses=" + prazoMeses + ", valorParcela=" + valorParcela + ", dataContratacao=" + dataContratacao + ", status='" + status + '\'' + '}';
    }
}
