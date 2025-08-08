package org.fintech.fiap.operacoes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OperacoesTransacoes {
    public OperacoesTransacoes() {

    }

    public void imprimeTransacoes() {
        System.out.println(String.format("Imprimindo transações no dia de: ", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        System.out.println("Débito efetuado no valor de R$: 200,00");
        System.out.println("Crédito recebido no valor de R$: 500,00");
        System.out.println("*********************************************");
    }
}
