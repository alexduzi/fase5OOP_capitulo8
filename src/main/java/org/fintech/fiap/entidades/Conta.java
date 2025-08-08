package org.fintech.fiap.entidades;

import org.fintech.fiap.entidades.base.ContaBase;

import java.time.LocalDate;

public class Conta extends ContaBase {

    public Conta() {
        super();
    }

    public Conta(Long contaId, Cliente cliente, String numeroConta, String tipoConta,
                 Double saldo, LocalDate dataAbertura, boolean statusAtiva,
                 String agencia, Double limiteCredito) {
        super();
        this.setId(contaId);
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.setAtivo(statusAtiva);
        this.agencia = agencia;
        this.limiteCredito = limiteCredito;
    }

    // Métodos auxiliares para compatibilidade
    public Long getContaId() {
        return getId();
    }

    public void setContaId(Long contaId) {
        setId(contaId);
    }

    public boolean isStatusAtiva() {
        return isAtivo();
    }

    public void setStatusAtiva(boolean statusAtiva) {
        setAtivo(statusAtiva);
    }

    @Override
    public String toString() {
        return "Conta{" +
               "contaId=" + getId() +
               ", cliente=" + (cliente != null ? cliente.getNome() : "null") +
               ", numeroConta='" + numeroConta + '\'' +
               ", tipoConta='" + tipoConta + '\'' +
               ", saldo=" + saldo +
               ", dataAbertura=" + dataAbertura +
               ", statusAtiva=" + isAtivo() +
               ", agencia='" + agencia + '\'' +
               ", limiteCredito=" + limiteCredito +
               '}';
    }
}