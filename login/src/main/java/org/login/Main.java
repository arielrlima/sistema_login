package org.login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginSystem loginSystem = new LoginSystem();

        System.out.println("=== Sistema de Login ===");
        System.out.print("Usuário: ");
        String username = scanner.nextLine();

        System.out.print("Senha: ");
        String password = scanner.nextLine();

        if (loginSystem.authenticate(username, password)) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + username);
        } else {
            System.out.println("Usuário ou senha inválidos!");
        }

        scanner.close();
    }
}