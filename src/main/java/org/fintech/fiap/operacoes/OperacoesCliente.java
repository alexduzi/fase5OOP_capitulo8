package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Cliente;

public class OperacoesCliente {
    public OperacoesCliente() {

    }

    public void cadastrarCliente(Cliente cliente) {
        System.out.println(String.format("Cliente %s cadastrado com sucesso!", cliente.getNome()));
    }
}
