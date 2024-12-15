package org.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginSystem {

    // Método de autenticação (já existente)
    public boolean authenticate(String username, String password) {
        String query = "SELECT * FROM usuarios WHERE username = ? AND password = MD5(?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            return stmt.executeQuery().next(); // Retorna true se o usuário for encontrado
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Método para registrar novos usuários
    public boolean registerUser(String username, String password) {
        String query = "INSERT INTO usuarios (username, password) VALUES (?, MD5(?))";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            int rowsAffected = stmt.executeUpdate(); // Executa a inserção
            return rowsAffected > 0; // Retorna true se o registro for bem-sucedido
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // Código de erro para chave duplicada
                System.out.println("O nome de usuário já existe. Escolha outro.");
            } else {
                e.printStackTrace();
            }
        }

        return false; // Retorna false se algo der errado
    }
}
