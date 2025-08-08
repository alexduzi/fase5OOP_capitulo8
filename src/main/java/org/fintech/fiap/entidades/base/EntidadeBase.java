package org.fintech.fiap.entidades.base;

import java.time.LocalDateTime;

public abstract class EntidadeBase {
    protected Long id;
    protected LocalDateTime dataCriacao;
    protected LocalDateTime dataAtualizacao;
    protected boolean ativo;

    public EntidadeBase() {
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
        this.ativo = true;
    }

    public EntidadeBase(Long id) {
        this();
        this.id = id;
    }

    public abstract String getDescricaoEntidade();

    public abstract void validarEntidade();

    protected void atualizarDataModificacao() {
        this.dataAtualizacao = LocalDateTime.now();
    }

    // Getters e Setters comuns
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        atualizarDataModificacao();
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
        atualizarDataModificacao();
    }

    @Override
    public String toString() {
        return String.format("%s{id=%d, ativo=%s, criacao=%s}", getClass().getSimpleName(), id, ativo, dataCriacao);
    }
}
