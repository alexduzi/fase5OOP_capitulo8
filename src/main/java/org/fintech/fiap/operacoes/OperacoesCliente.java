package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Cliente;
import org.fintech.fiap.interfaces.IOperacoes;

public class OperacoesCliente implements IOperacoes {

    public OperacoesCliente() {
    }

    @Override
    public void executarOperacao() {
        System.out.println("Sistema de operações de cliente ativo");
    }

    @Override
    public boolean validarOperacao() {
        return true;
    }

    public void cadastrarCliente(Cliente cliente) {
        System.out.println(String.format("Cliente %s cadastrado com sucesso!", cliente.getNome()));
    }
}