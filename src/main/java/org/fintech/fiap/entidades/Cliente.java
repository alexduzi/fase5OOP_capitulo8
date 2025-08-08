package org.fintech.fiap.entidades;

import java.time.LocalDate;

public class Cliente {
    private Long clienteId;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String endereco;
    private LocalDate dataCadastro;
    private boolean ativo;
    private String senha;

    public Cliente() {}

    public Cliente(Long clienteId, String nome, String cpf, String email, String telefone, LocalDate dataNascimento, String endereco, LocalDate dataCadastro, boolean ativo, String senha) {
        this.clienteId = clienteId;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
        this.senha = senha;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Cliente{" +
               "clienteId=" + clienteId +
               ", nome='" + nome + '\'' +
               ", cpf='" + cpf + '\'' +
               ", email='" + email + '\'' +
               ", telefone='" + telefone + '\'' +
               ", dataNascimento=" + dataNascimento +
               ", endereco='" + endereco + '\'' +
               ", dataCadastro=" + dataCadastro +
               ", ativo=" + ativo +
               ", senha='" + senha + '\'' +
               '}';
    }
}
