/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author mario
 */

import conexao.Conexao;
import model.Usuario;
import java.sql.*;

public class UsuarioDAO {

    public boolean cadastrar(Usuario u) {
        String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getSenha());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                return false; // usuário já existe
            }
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }

    public Usuario login(String usuario, String senha) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println("Erro no login: " + e.getMessage());
        }
        return null;
    }

    public boolean atualizarSenha(String usuario, String novaSenha) {
        String sql = "UPDATE usuarios SET senha = ? WHERE usuario = ?";
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, novaSenha);
            ps.setString(2, usuario);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar senha: " + e.getMessage());
            return false;
        }
    }

    public boolean existeUsuario(String usuario) {
        String sql = "SELECT 1 FROM usuarios WHERE usuario = ?";
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }
}