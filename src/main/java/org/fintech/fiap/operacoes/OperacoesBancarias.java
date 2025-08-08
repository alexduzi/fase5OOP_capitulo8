package org.fintech.fiap.operacoes;

import org.fintech.fiap.entidades.Conta;
import org.fintech.fiap.excecoes.SaldoException;

public class OperacoesBancarias {
    private Conta contaOrigem;

    public OperacoesBancarias(Conta conta) {
        contaOrigem = conta;
    }

    public void depositar(Conta contaDestino, Double valor) {
        StringBuilder sb = new StringBuilder();
        sb.append("Deposito para: ");
        sb.append(contaDestino.getCliente().getNome());
        sb.append(" Agencia: ");
        sb.append(contaDestino.getAgencia());
        sb.append(" Conta: ");
        sb.append(contaDestino.getNumeroConta());
        sb.append(" Valor: ");
        sb.append(String.format("%.2f", valor));
        System.out.println(sb);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
    }

    public Double sacar(Double valor) throws SaldoException {
        if (!verificaSaldo(valor)) {
            throw new SaldoException("Saldo insuficiente!");
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);

        System.out.println("Saldo atual: " + contaOrigem.getSaldo());

        return valor;
    }

    public void transferir(Conta contaDestino, Double valor) throws SaldoException {
        if (!verificaSaldo(valor)) {
            throw new SaldoException("Saldo insuficiente!");
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);

        contaDestino.setSaldo(contaDestino.getSaldo() + valor);

        System.out.println("Transferencia realizada!");

        System.out.println("Saldo atual: " + contaOrigem.getSaldo());
    }

    private boolean verificaSaldo(Double valor) {
        return contaOrigem.getSaldo() > valor;
    }
}
