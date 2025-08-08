package org.fintech.fiap.interfaces;

import java.time.LocalDate;

public interface IPessoa {
    String getNome();

    void setNome(String nome);

    String getCpf();

    void setCpf(String cpf);

    String getEmail();

    void setEmail(String email);

    LocalDate getDataNascimento();

    void setDataNascimento(LocalDate dataNascimento);

    void validarCpf();

    void validarEmail();
}