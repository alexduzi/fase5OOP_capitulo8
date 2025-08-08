package org.fintech.fiap;

import org.fintech.fiap.autenticacao.Login;
import org.fintech.fiap.entidades.*;
import org.fintech.fiap.excecoes.SaldoException;
import org.fintech.fiap.operacoes.OperacoesBancarias;
import org.fintech.fiap.operacoes.OperacoesCliente;
import org.fintech.fiap.operacoes.OperacoesCredito;
import org.fintech.fiap.operacoes.OperacoesInvestimento;
import org.fintech.fiap.operacoes.OperacoesTransacoes;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA FINTECH ===\n");

        // 1. Criando clientes mock
        Cliente cliente1 = new Cliente(1L, "João Silva", "123.456.789-00", "joao.silva@email.com", "(11) 98765-4321", LocalDate.of(1985, 5, 15), "Rua das Flores, 123 - São Paulo/SP", LocalDate.now(), true, "senha123");

        Cliente cliente2 = new Cliente(2L, "Maria Santos", "987.654.321-00", "maria.santos@email.com", "(11) 91234-5678", LocalDate.of(1990, 8, 22), "Av. Paulista, 456 - São Paulo/SP", LocalDate.now(), true, "senha456");

        // 2. Testando cadastro de clientes
        System.out.println("=== CADASTRO DE CLIENTES ===");
        OperacoesCliente operacoesCliente = new OperacoesCliente();
        operacoesCliente.cadastrarCliente(cliente1);
        operacoesCliente.cadastrarCliente(cliente2);
        System.out.println();

        // 3. Criando contas mock
        Conta conta1 = new Conta(1L, cliente1, "12345-6", "Conta Corrente", 1500.0, LocalDate.now().minusMonths(6), true, "001", 2000.0);

        Conta conta2 = new Conta(2L, cliente2, "65432-1", "Conta Poupança", 800.0, LocalDate.now().minusMonths(3), true, "001", 1000.0);

        System.out.println("=== CONTAS CRIADAS ===");
        System.out.println(conta1);
        System.out.println(conta2);
        System.out.println();

        // 4. Testando autenticação
        System.out.println("=== SISTEMA DE LOGIN ===");
        Login login1 = new Login(cliente1.getEmail(), cliente1.getSenha());
        Login login2 = new Login(cliente2.getEmail(), cliente2.getSenha());
        login1.doLogin();
        login2.doLogin();
        System.out.println();

        // 5. Testando operações bancárias
        System.out.println("=== OPERAÇÕES BANCÁRIAS ===");
        OperacoesBancarias operacoesBancarias = new OperacoesBancarias(conta1);

        // Testando depósito
        System.out.println("--- Depósito ---");
        operacoesBancarias.depositar(conta2, 300.0);
        System.out.println("Novo saldo da conta2: " + conta2.getSaldo());
        System.out.println();

        // Testando saque
        System.out.println("--- Saque ---");
        try {
            Double valorSacado = operacoesBancarias.sacar(200.0);
            System.out.println("Valor sacado: R$ " + String.format("%.2f", valorSacado));
        } catch (SaldoException e) {
            System.out.println("Erro no saque: " + e.getMessage());
        }
        System.out.println();

        // Testando transferência
        System.out.println("--- Transferência ---");
        try {
            operacoesBancarias.transferir(conta2, 500.0);
            System.out.println("Novo saldo da conta1: " + conta1.getSaldo());
            System.out.println("Novo saldo da conta2: " + conta2.getSaldo());
        } catch (SaldoException e) {
            System.out.println("Erro na transferência: " + e.getMessage());
        }
        System.out.println();

        // Testando saque com saldo insuficiente
        System.out.println("--- Teste de Saldo Insuficiente ---");
        try {
            operacoesBancarias.sacar(2000.0);
        } catch (SaldoException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        System.out.println();

        // 6. Criando cartão e testando operações de crédito
        Cartao cartao1 = new Cartao(1L, conta1, "1234 5678 9012 3456", cliente1.getNome(), LocalDate.now().plusYears(5), "123", true, "Crédito", 3000.0);

        System.out.println("=== OPERAÇÕES DE CRÉDITO ===");
        OperacoesCredito operacoesCredito = new OperacoesCredito(conta1, cartao1);

        // Contratando empréstimo
        System.out.println("--- Contratação de Empréstimo ---");
        Emprestimo emprestimo = operacoesCredito.contratarEmprestimo();
        System.out.println("Empréstimo contratado:");
        System.out.println("ID: " + emprestimo.getEmprestimoId());
        System.out.println("Cliente: " + emprestimo.getCliente().getNome());
        System.out.println("Valor: R$ " + String.format("%.2f", emprestimo.getValorEmprestimo()));
        System.out.println("Taxa de Juros: " + (emprestimo.getTaxaJuros() * 100) + "%");
        System.out.println("Prazo: " + emprestimo.getPrazoMeses() + " meses");
        System.out.println("Valor da Parcela: R$ " + String.format("%.2f", emprestimo.getValorParcela()));
        System.out.println();

        // Fechando fatura
        System.out.println("--- Fechamento de Fatura ---");
        Fatura fatura = operacoesCredito.fecharFatura();
        System.out.println("Fatura fechada:");
        System.out.println("ID: " + fatura.getFaturaId());
        System.out.println("Cartão: " + fatura.getCartao().getNumeroCartao());
        System.out.println("Data Fechamento: " + fatura.getDataFechamento());
        System.out.println("Data Vencimento: " + fatura.getDataVencimento());
        System.out.println("Valor Total: R$ " + String.format("%.2f", fatura.getValorTotal()));
        System.out.println("Valor Mínimo: R$ " + String.format("%.2f", fatura.getValorMinimo()));
        System.out.println("Status: " + fatura.getStatusPagamento());
        System.out.println();

        // 7. Testando operações de investimento
        System.out.println("=== OPERAÇÕES DE INVESTIMENTO ===");
        OperacoesInvestimento operacoesInvestimento = new OperacoesInvestimento(conta1);

        // Simulando investimento
        System.out.println("--- Simulação de Investimento ---");
        operacoesInvestimento.simularInvestimento("CDB", 1000.0);
        System.out.println();

        // Realizando investimento
        System.out.println("--- Realizar Investimento ---");
        Investimento investimento = operacoesInvestimento.realizarInvestimento("CDB", 1000.0);
        System.out.println("Investimento criado:");
        System.out.println("ID: " + investimento.getInvestimentoId());
        System.out.println("Tipo: " + investimento.getTipoInvstimento());
        System.out.println("Valor: R$ " + String.format("%.2f", investimento.getValorAplicado()));
        System.out.println("Cliente: " + investimento.getCliente().getNome());
        System.out.println("Status: " + investimento.getStatus());
        System.out.println();

        // Consultando investimentos
        System.out.println("--- Consultar Carteira ---");
        operacoesInvestimento.consultarInvestimentos();
        System.out.println();

        // Resgatando investimento
        System.out.println("--- Resgate de Investimento ---");
        operacoesInvestimento.resgateInvestimento(investimento.getInvestimentoId());
        System.out.println();

        // 8. Testando operações de transações
        System.out.println("=== EXTRATO DE TRANSAÇÕES ===");
        OperacoesTransacoes operacoesTransacoes = new OperacoesTransacoes();
        operacoesTransacoes.imprimeTransacoes();
        System.out.println();

        // 9. Criando outros objetos mock para demonstrar o modelo
        System.out.println("=== OUTROS OBJETOS DO SISTEMA ===");

        // Investimento mock para demonstrar
        Investimento investimentoMock = new Investimento(1L, cliente1, "CDB", 5000.0, 0.08, LocalDate.now().minusMonths(2), LocalDate.now().plusYears(2), "Ativo");
        System.out.println("Investimento mock criado: " + investimentoMock.getTipoInvstimento() + " - Valor: R$ " + String.format("%.2f", investimentoMock.getValorAplicado()));

        // Notificação
        Notificacao notificacao = new Notificacao(1L, cliente1, "Transação", "Transferência realizada com sucesso", java.time.Instant.now(), false);
        System.out.println("Notificação criada: " + notificacao.getMensagem());

        // Parcela de empréstimo
        ParcelaEmprestimo parcela = new ParcelaEmprestimo(1L, emprestimo, 1, emprestimo.getValorParcela(), LocalDate.now().plusMonths(1), null, "Pendente");
        System.out.println("Primeira parcela do empréstimo: R$ " + String.format("%.2f", parcela.getValorParcela()) + " - Vencimento: " + parcela.getDataVencimento());

        System.out.println("\n=== FIM DA DEMONSTRAÇÃO ===");
    }
}