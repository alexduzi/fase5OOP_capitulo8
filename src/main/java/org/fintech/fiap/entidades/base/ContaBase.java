package org.fintech.fiap.entidades.base;

import org.fintech.fiap.entidades.Cliente;
import org.fintech.fiap.interfaces.IContaBancaria;

import java.time.LocalDate;

public abstract class ContaBase extends EntidadeBase implements IContaBancaria {
    protected Cliente cliente;
    protected String numeroConta;
    protected String tipoConta;
    protected Double saldo;
    protected LocalDate dataAbertura;
    protected String agencia;
    protected Double limiteCredito;

    public ContaBase() {
        super();
        this.saldo = 0.0;
        this.dataAbertura = LocalDate.now();
    }

    @Override
    public void validarEntidade() {
        validarSaldo();
        if (numeroConta == null || numeroConta.trim().isEmpty()) {
            throw new IllegalArgumentException("Número da conta é obrigatório");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente é obrigatório");
        }
    }

    @Override
    public void validarSaldo() {
        if (saldo < 0 && (limiteCredito == null || Math.abs(saldo) > limiteCredito)) {
            throw new IllegalArgumentException("Saldo não pode ser negativo além do limite");
        }
    }

    @Override
    public void atualizarSaldo(Double valor) {
        this.saldo += valor;
        atualizarDataModificacao();
        validarSaldo();
    }

    @Override
    public String getDescricaoEntidade() {
        return String.format("Conta %s do cliente %s", numeroConta, cliente != null ? cliente.getNome() : "N/A");
    }

    // Getters e Setters
    @Override
    public Double getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
        atualizarDataModificacao();
    }

    @Override
    public String getNumeroConta() {
        return numeroConta;
    }

    @Override
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
        atualizarDataModificacao();
    }

    @Override
    public String getTipoConta() {
        return tipoConta;
    }

    @Override
    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
        atualizarDataModificacao();
    }

    // Getters e Setters específicos
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        atualizarDataModificacao();
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
        atualizarDataModificacao();
    }

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
        atualizarDataModificacao();
    }
}