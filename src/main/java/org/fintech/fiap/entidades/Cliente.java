package org.fintech.fiap.entidades;

import org.fintech.fiap.entidades.base.PessoaBase;

import java.time.LocalDate;

public class Cliente extends PessoaBase {
    private LocalDate dataCadastro;
    private String senha;

    public Cliente() {
        super();
        this.dataCadastro = LocalDate.now();
    }

    public Cliente(Long clienteId, String nome, String cpf, String email, String telefone, LocalDate dataNascimento, String endereco, LocalDate dataCadastro, boolean ativo, String senha) {
        super(clienteId, nome, cpf, email);
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
        this.setAtivo(ativo);
        this.senha = senha;
    }

    @Override
    public String getDescricaoEntidade() {
        return String.format("Cliente: %s (CPF: %s)", nome, cpf);
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
        atualizarDataModificacao();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
        atualizarDataModificacao();
    }

    public Long getClienteId() {
        return getId();
    }

    public void setClienteId(Long clienteId) {
        setId(clienteId);
    }
}