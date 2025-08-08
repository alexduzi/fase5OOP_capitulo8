package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.excecoes.SaldoException;
import org.fintech.fiap.interfaces.IOperacoesBancarias;

public class OperacoesBancarias extends OperacoesBase implements IOperacoesBancarias {

    public OperacoesBancarias(Conta conta) {
        super(conta);
    }

    @Override
    public void executarOperacao() {
        logOperacao("OPERAÇÕES BANCÁRIAS", "Sistema bancário ativo para " + getInfoConta());
    }

    @Override
    public void depositar(Conta contaDestino, Double valor) {
        if (!validarOperacao()) return;

        StringBuilder sb = new StringBuilder();
        sb.append("Deposito para: ");
        sb.append(contaDestino.getCliente().getNome());
        sb.append(" Agencia: ");
        sb.append(contaDestino.getAgencia());
        sb.append(" Conta: ");
        sb.append(contaDestino.getNumeroConta());
        sb.append(" Valor: ");
        sb.append(String.format("%.2f", valor));

        logOperacao("DEPÓSITO", sb.toString());
        contaDestino.atualizarSaldo(valor);
    }

    @Override
    public Double sacar(Double valor) throws SaldoException {
        if (!validarOperacao()) return 0.0;

        if (!verificaSaldo(valor)) {
            throw new SaldoException("Saldo insuficiente!");
        }

        conta.atualizarSaldo(-valor);
        logOperacao("SAQUE", String.format("Valor sacado: R$ %.2f - Saldo atual: R$ %.2f", valor, conta.getSaldo()));

        return valor;
    }

    @Override
    public void transferir(Conta contaDestino, Double valor) throws SaldoException {
        if (!validarOperacao()) return;

        if (!verificaSaldo(valor)) {
            throw new SaldoException("Saldo insuficiente!");
        }

        conta.atualizarSaldo(-valor);
        contaDestino.atualizarSaldo(valor);

        logOperacao("TRANSFERÊNCIA", String.format("R$ %.2f transferido para conta %s", valor, contaDestino.getNumeroConta()));
    }

    private boolean verificaSaldo(Double valor) {
        double saldoDisponivel = conta.getSaldo() + (conta.getLimiteCredito() != null ? conta.getLimiteCredito() : 0);
        return saldoDisponivel >= valor;
    }
}