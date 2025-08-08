package org.fintech.fiap.autenticacao;

public class Login {
    private String username;

    private String password;

    // Construtor padrão
    public Login() {
    }

    // Construtor com parâmetros
    public Login(String username, String password) {
        this.username = username;

        this.password = password;
    }

    public void doLogin() {
        // Lógica para realizar o login
        System.out.println("Realizando login para o usuário: " + username);

        System.out.println("Login realizado com sucesso!");
    }
}
