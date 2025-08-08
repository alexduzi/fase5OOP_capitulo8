package org.fintech.fiap.operacoes;

import org.fintech.fiap.interfaces.IOperacoes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OperacoesTransacoes implements IOperacoes {

    public OperacoesTransacoes() {
    }

    @Override
    public void executarOperacao() {
        System.out.println("Sistema de transações ativo");
    }

    @Override
    public boolean validarOperacao() {
        return true;
    }

    public void imprimeTransacoes() {
        System.out.println(String.format("Imprimindo transações do dia: %s", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        System.out.println("Débito efetuado no valor de R$ 200,00");
        System.out.println("Crédito recebido no valor de R$ 500,00");
        System.out.println("*********************************************");
    }
}