package org.fintech.fiap.entidades;

import java.time.LocalDate;

public class Conta {
    private Long contaId;
    private Cliente cliente;
    private String numeroConta;
    private String tipoConta;
    private Double saldo;
    private LocalDate dataAbertura;
    private boolean statusAtiva;
    private String agencia;
    private Double limiteCredito;

    public Conta() {}

    public Conta(Long contaId, Cliente cliente, String numeroConta, String tipoConta, Double saldo, LocalDate dataAbertura, boolean statusAtiva, String agencia, Double limiteCredito) {
        this.contaId = contaId;
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.statusAtiva = statusAtiva;
        this.agencia = agencia;
        this.limiteCredito = limiteCredito;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public boolean isStatusAtiva() {
        return statusAtiva;
    }

    public void setStatusAtiva(boolean statusAtiva) {
        this.statusAtiva = statusAtiva;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public String toString() {
        return "Conta{" +
               "contaId=" + contaId +
               ", cliente=" + cliente.getNome() +
               ", numeroConta='" + numeroConta + '\'' +
               ", tipoConta='" + tipoConta + '\'' +
               ", saldo=" + saldo +
               ", dataAbertura=" + dataAbertura +
               ", statusAtiva=" + statusAtiva +
               ", agencia='" + agencia + '\'' +
               ", limiteCredito=" + limiteCredito +
               '}';
    }
}
