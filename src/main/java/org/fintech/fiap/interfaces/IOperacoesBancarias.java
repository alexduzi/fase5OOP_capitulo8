package org.fintech.fiap.interfaces;

import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.excecoes.SaldoException;

public interface IOperacoesBancarias extends IOperacoes {
    void depositar(Conta contaDestino, Double valor);

    Double sacar(Double valor) throws SaldoException;

    void transferir(Conta contaDestino, Double valor) throws SaldoException;
}
