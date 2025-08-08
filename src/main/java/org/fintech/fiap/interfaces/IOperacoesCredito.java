package org.fintech.fiap.interfaces;

import org.fintech.fiap.entidades.Emprestimo;
import org.fintech.fiap.entidades.Fatura;

public interface IOperacoesCredito extends IOperacoes {
    Emprestimo contratarEmprestimo();

    Fatura fecharFatura();
}
