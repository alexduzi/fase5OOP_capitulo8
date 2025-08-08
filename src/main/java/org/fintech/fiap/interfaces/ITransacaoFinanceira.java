package org.fintech.fiap.interfaces;

import java.time.Instant;

public interface ITransacaoFinanceira {
    Double getValor();

    void setValor(Double valor);

    Instant getDataTransacao();

    void setDataTransacao(Instant data);

    String getStatus();

    void setStatus(String status);

    void processarTransacao();
}