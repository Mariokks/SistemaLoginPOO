/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package conexao;

/**
 *
 * @author mario
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_login?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // COLOQUE SUA SENHA DO MySQL AQUI

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco: " + e.getMessage());
        }
    }
}