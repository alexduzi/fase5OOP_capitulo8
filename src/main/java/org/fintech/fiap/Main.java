package org.fintech.fiap;

import org.fintech.fiap.autenticacao.Login;
import org.fintech.fiap.entidades.*;
import org.fintech.fiap.excecoes.SaldoException;
import org.fintech.fiap.interfaces.*;
import org.fintech.fiap.operacoes.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA FINTECH - ARQUITETURA ORIENTADA A OBJETOS ===\n");

        // 1. Criando clientes com entidades abstraídas
        Cliente cliente1 = new Cliente(1L, "João Silva", "123.456.789-00", "joao.silva@email.com",
                "(11) 98765-4321", LocalDate.of(1985, 5, 15), "Rua das Flores, 123 - São Paulo/SP",
                LocalDate.now(), true, "senha123");

        Cliente cliente2 = new Cliente(2L, "Maria Santos", "987.654.321-00", "maria.santos@email.com",
                "(11) 91234-5678", LocalDate.of(1990, 8, 22), "Av. Paulista, 456 - São Paulo/SP",
                LocalDate.now(), true, "senha456");

        // Validando entidades
        System.out.println("=== VALIDAÇÃO DE ENTIDADES ===");
        try {
            cliente1.validarEntidade();
            cliente2.validarEntidade();
            System.out.println("Todos os clientes validados com sucesso!");
            System.out.println("Cliente 1: " + cliente1.getDescricaoEntidade());
            System.out.println("Cliente 2: " + cliente2.getDescricaoEntidade());
        } catch (Exception e) {
            System.out.println("Erro na validação: " + e.getMessage());
        }
        System.out.println();

        // 2. Testando operações de cliente usando interface
        System.out.println("=== OPERAÇÕES DE CLIENTE (INTERFACE) ===");
        IOperacoes operacoesCliente = new OperacoesCliente();
        operacoesCliente.executarOperacao();
        ((OperacoesCliente) operacoesCliente).cadastrarCliente(cliente1);
        ((OperacoesCliente) operacoesCliente).cadastrarCliente(cliente2);
        System.out.println();

        // 3. Criando contas com validação
        Conta conta1 = new Conta(1L, cliente1, "12345-6", "Conta Corrente", 2500.0,
                LocalDate.now().minusMonths(6), true, "001", 2000.0);
        Conta conta2 = new Conta(2L, cliente2, "65432-1", "Conta Poupança", 1200.0,
                LocalDate.now().minusMonths(3), true, "001", 1000.0);

        System.out.println("=== CONTAS VALIDADAS ===");
        try {
            conta1.validarEntidade();
            conta2.validarEntidade();
            System.out.println("Conta 1: " + conta1.getDescricaoEntidade());
            System.out.println("Conta 2: " + conta2.getDescricaoEntidade());
        } catch (Exception e) {
            System.out.println("Erro na validação da conta: " + e.getMessage());
        }
        System.out.println();

        // 4. Demonstrando polimorfismo com lista de operações
        System.out.println("=== POLIMORFISMO - EXECUTANDO TODAS AS OPERAÇÕES ===");
        List<IOperacoes> todasOperacoes = Arrays.asList(
                new OperacoesBancarias(conta1),
                new OperacoesCredito(conta1, null),
                new OperacoesInvestimento(conta1),
                new OperacoesCartao(conta1),
                new OperacoesNotificacao(conta1),
                new OperacoesFatura(conta1),
                new OperacoesEmprestimo(conta1),
                new OperacoesRelatorio(conta1),
                new OperacoesTransacoes()
        );

        for (IOperacoes operacao : todasOperacoes) {
            operacao.executarOperacao();
        }
        System.out.println();

        // 5. Testando operações bancárias com interface
        System.out.println("=== OPERAÇÕES BANCÁRIAS (INTERFACE) ===");
        IOperacoesBancarias opBancarias = new OperacoesBancarias(conta1);
        opBancarias.executarOperacao();

        System.out.println("--- Depósito ---");
        opBancarias.depositar(conta2, 300.0);
        System.out.println("Novo saldo conta2: R$ " + String.format("%.2f", conta2.getSaldo()));

        System.out.println("--- Saque ---");
        try {
            Double valorSacado = opBancarias.sacar(200.0);
            System.out.println("Valor sacado: R$ " + String.format("%.2f", valorSacado));
        } catch (SaldoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();

        // 6. Operações de cartão
        System.out.println("=== OPERAÇÕES DE CARTÃO ===");
        IOperacoesCartao opCartao = new OperacoesCartao(conta1);
        opCartao.executarOperacao();

        Cartao cartao1 = opCartao.criarCartao("Crédito", 3000.0);
        opCartao.alterarLimite(cartao1.getCartaoId(), 5000.0);
        opCartao.bloquearCartao(cartao1.getCartaoId());
        opCartao.desbloquearCartao(cartao1.getCartaoId());
        System.out.println();

        // 7. Operações de crédito
        System.out.println("=== OPERAÇÕES DE CRÉDITO ===");
        IOperacoesCredito opCredito = new OperacoesCredito(conta1, cartao1);
        opCredito.executarOperacao();

        Emprestimo emprestimo = opCredito.contratarEmprestimo();
        Fatura fatura = opCredito.fecharFatura();
        System.out.println("Empréstimo ID: " + emprestimo.getEmprestimoId());
        System.out.println("Fatura ID: " + fatura.getFaturaId());
        System.out.println();

        // 8. Operações de investimento
        System.out.println("=== OPERAÇÕES DE INVESTIMENTO ===");
        IOperacoesInvestimento opInvestimento = new OperacoesInvestimento(conta1);
        opInvestimento.executarOperacao();

        opInvestimento.simularInvestimento("CDB", 1000.0);
        Investimento investimento = opInvestimento.realizarInvestimento("CDB", 1000.0);
        opInvestimento.consultarInvestimentos();
        opInvestimento.resgateInvestimento(investimento.getInvestimentoId());
        System.out.println();

        // 9. Operações de notificação
        System.out.println("=== OPERAÇÕES DE NOTIFICAÇÃO ===");
        IOperacoesNotificacao opNotificacao = new OperacoesNotificacao(conta1);
        opNotificacao.executarOperacao();

        Notificacao notificacao = opNotificacao.criarNotificacao("Transação", "PIX recebido");
        opNotificacao.enviarNotificacao("Sistema", "Bem-vindo ao sistema!");
        opNotificacao.listarNotificacoes();
        opNotificacao.marcarComoLida(notificacao.getNotificacaoId());
        System.out.println();

        // 10. Operações de fatura
        System.out.println("=== OPERAÇÕES DE FATURA ===");
        IOperacoesFatura opFatura = new OperacoesFatura(conta1);
        opFatura.executarOperacao();

        ItemFatura item = opFatura.criarItemFatura("Compra Supermercado", 150.0);
        opFatura.adicionarItemFatura(fatura.getFaturaId(), "Posto de Gasolina", 200.0);
        opFatura.consultarFatura(fatura.getFaturaId());
        opFatura.pagarFatura(fatura.getFaturaId(), 350.0);
        System.out.println();

        // 11. Operações de empréstimo
        System.out.println("=== OPERAÇÕES DE EMPRÉSTIMO ===");
        OperacoesEmprestimo opEmprestimo = new OperacoesEmprestimo(conta1);
        opEmprestimo.executarOperacao();

        ParcelaEmprestimo parcela = opEmprestimo.gerarParcela(emprestimo.getEmprestimoId(), 1, 250.0);
        opEmprestimo.consultarParcelas(emprestimo.getEmprestimoId());
        opEmprestimo.pagarParcela(parcela.getParcelaId(), 250.0);
        opEmprestimo.quitarEmprestimo(emprestimo.getEmprestimoId());
        System.out.println();

        // 12. Operações de relatório
        System.out.println("=== OPERAÇÕES DE RELATÓRIO ===");
        OperacoesRelatorio opRelatorio = new OperacoesRelatorio(conta1);
        opRelatorio.executarOperacao();

        opRelatorio.gerarExtratoPeriodo("01/07/2025", "31/07/2025");
        opRelatorio.gerarRelatorioInvestimentos();
        opRelatorio.gerarRelatorioCredito();
        opRelatorio.gerarComprovanteTransacao(123L);
        System.out.println();

        // 13. Operações de transações
        System.out.println("=== OPERAÇÕES DE TRANSAÇÕES ===");
        OperacoesTransacoes opTransacoes = new OperacoesTransacoes();
        opTransacoes.executarOperacao();
        opTransacoes.imprimeTransacoes();
        System.out.println();

        // 14. Demonstrando autenticação
        System.out.println("=== SISTEMA DE AUTENTICAÇÃO ===");
        Login login1 = new Login(cliente1.getEmail(), cliente1.getSenha());
        Login login2 = new Login(cliente2.getEmail(), cliente2.getSenha());
        login1.doLogin();
        login2.doLogin();
        System.out.println();

        // 15. Resumo do sistema
        System.out.println("=== RESUMO DO SISTEMA ===");
        System.out.println("Total de clientes: 2");
        System.out.println("Total de contas: 2");
        System.out.println("Total de operações implementadas: 9");
        System.out.println("Arquitetura: Orientada a Objetos com Interfaces e Abstrações");
        System.out.println("Padrões utilizados: Template Method, Strategy, Factory Method");

        System.out.println("\n=== FIM DA DEMONSTRAÇÃO ===");
    }
}