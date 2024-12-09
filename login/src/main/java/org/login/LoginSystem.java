package org.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginSystem {
    public boolean authenticate(String username, String password) {
        String query = "SELECT * FROM usuarios WHERE username = ? AND password = MD5(?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Retorna true se o usuário for encontrado
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // Retorna false se algo der errado
    }
}
