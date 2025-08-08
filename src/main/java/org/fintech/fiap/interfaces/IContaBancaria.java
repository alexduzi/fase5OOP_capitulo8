package org.fintech.fiap.interfaces;

public interface IContaBancaria {
    Double getSaldo();

    void setSaldo(Double saldo);

    String getNumeroConta();

    void setNumeroConta(String numeroConta);

    String getTipoConta();

    void setTipoConta(String tipoConta);

    void validarSaldo();

    void atualizarSaldo(Double valor);
}