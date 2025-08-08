package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.interfaces.IOperacoes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class OperacoesBase implements IOperacoes {
    protected Conta conta;
    protected final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public OperacoesBase() {
    }

    public OperacoesBase(Conta conta) {
        this.conta = conta;
    }

    @Override
    public boolean validarOperacao() {
        return validarConta();
    }

    protected void logOperacao(String tipoOperacao, String detalhes) {
        System.out.println(String.format("[%s] %s: %s", LocalDateTime.now().format(dateFormatter), tipoOperacao.toUpperCase(), detalhes));
    }

    protected String getInfoConta() {
        if (conta == null) {
            return "Conta não informada";
        }
        return String.format("Cliente: %s - Conta: %s", conta.getCliente().getNome(), conta.getNumeroConta());
    }

    protected boolean validarConta() {
        if (conta == null) {
            System.out.println("Erro: Conta não foi informada para a operação.");
            return false;
        }
        if (!conta.isAtivo()) {
            System.out.println("Erro: Conta inativa para operações.");
            return false;
        }
        return true;
    }

    // Getters e Setters
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}