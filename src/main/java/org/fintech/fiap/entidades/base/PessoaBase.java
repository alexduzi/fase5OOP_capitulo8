package org.fintech.fiap.entidades.base;

import org.fintech.fiap.interfaces.IPessoa;

import java.time.LocalDate;

public abstract class PessoaBase extends EntidadeBase implements IPessoa {
    protected String nome;
    protected String cpf;
    protected String email;
    protected String telefone;
    protected LocalDate dataNascimento;
    protected String endereco;

    public PessoaBase() {
        super();
    }

    public PessoaBase(Long id, String nome, String cpf, String email) {
        super(id);
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    @Override
    public void validarEntidade() {
        validarCpf();
        validarEmail();
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
    }

    @Override
    public void validarCpf() {
        if (cpf == null || cpf.length() != 14) {
            throw new IllegalArgumentException("CPF deve ter formato XXX.XXX.XXX-XX");
        }
    }

    @Override
    public void validarEmail() {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email deve ser válido");
        }
    }

    // Getters e Setters
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
        atualizarDataModificacao();
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
        atualizarDataModificacao();
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
        atualizarDataModificacao();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        atualizarDataModificacao();
    }

    @Override
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        atualizarDataModificacao();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
        atualizarDataModificacao();
    }
}