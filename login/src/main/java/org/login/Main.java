package org.login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginSystem loginSystem = new LoginSystem();

        while (true) {
            System.out.println("\n=== Sistema de Login ===");
            System.out.println("1. Login");
            System.out.println("2. Cadastro");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            if (choice == 1) { // Login
                System.out.print("Usuário: ");
                String username = scanner.nextLine();

                System.out.print("Senha: ");
                String password = scanner.nextLine();

                if (loginSystem.authenticate(username, password)) {
                    System.out.println("Login bem-sucedido! Bem-vindo, " + username);
                } else {
                    System.out.println("Usuário ou senha inválidos!");
                }
            } else if (choice == 2) { // Cadastro
                System.out.print("Escolha um nome de usuário: ");
                String username = scanner.nextLine();

                System.out.print("Escolha uma senha: ");
                String password = scanner.nextLine();

                if (loginSystem.registerUser(username, password)) {
                    System.out.println("Usuário cadastrado com sucesso!");
                } else {
                    System.out.println("Falha no cadastro. Tente novamente.");
                }
            } else if (choice == 3) { // Sair
                System.out.println("Saindo do sistema. Até logo!");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
