/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import database.DatabaseConfig;
import dto.MotocicletaDTO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.UsuarioDTO;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import service.UsuariosService;

public class UsuarioRepository {

    // Método para guardar el usuario con la contraseña encriptada
    public boolean guardarUsuario(UsuarioDTO usuario) throws SQLException {
        String query = "INSERT INTO usuario (nombre_usuario, password) VALUES (?, ?)"; // Consulta SQL para insertar usuario

        String hashedPassword = usuario.getPassword(); // Encriptamos la contraseña antes de guardarla

        try (Connection conn = DatabaseConfig.getConnection(); // Obtenemos la conexión de DatabaseConfig
                 PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, usuario.getNombre_usuario()); // Seteamos el nombre de usuario
            ps.setString(2, hashedPassword); // Seteamos la contraseña encriptada

            int rowsAffected = ps.executeUpdate(); // Ejecutamos la consulta de inserción
            return rowsAffected > 0; // Retorna true si se ha insertado el usuario correctamente
        }
    }

    public List<UsuarioDTO> obtenerTodas() throws SQLException {
        String query = "SELECT * FROM usuario"; // Ajusta la consulta según tu base de datos

        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Crear un objeto usuaRIO y agregarlo a la lista
                UsuarioDTO usuarioDTO = new UsuarioDTO(
                        rs.getInt("id"),
                        rs.getString("nombre_usuario"),
                        rs.getString("password")
                );
                usuarioDTOs.add(usuarioDTO);
            }
        }
        return usuarioDTOs;
    }

    // Verificar si las credenciales son correctas al hacer login
    public boolean verificarLogin(String nombreUsuario, String password) throws SQLException {
        String query = "SELECT password FROM usuario WHERE nombre_usuario = ?"; // Consulta para obtener el hash de la contraseña

        try (Connection conn = DatabaseConfig.getConnection(); // Usamos la conexión de DatabaseConfig
                 PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, nombreUsuario); // Seteamos el nombre de usuario
            ResultSet rs = ps.executeQuery(); // Ejecutamos la consulta

            if (rs.next()) {
                String storedPasswordHash = rs.getString("password"); // Obtenemos el hash de la contraseña almacenada
                return BCrypt.checkpw(password, storedPasswordHash); // Comparamos la contraseña ingresada con la almacenada
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Retorna false si el login no es exitoso
    }

    public UsuarioDTO buscarPorId(int id) throws SQLException {// Recibe un parámetro id de tipo int que se utiliza para buscar al cliente.
        String query = "SELECT * FROM usuario WHERE id = " + id;// Esta es la consulta SQL que se ejecutará en la base de datos.
        //clientes cuyo campo id sea igual al valor de la variable id que se pasa como parámetro al método.
        try (Connection connection = DatabaseConfig.getConnection(); // Usa la conexión de Database
                 Statement statement = connection.createStatement();// El objeto Statement que se usa para ejecutar la consulta SQL.
                 ResultSet resultSet = statement.executeQuery(query)) {//El objeto ResultSet que contiene los datos recuperados de la consulta SQL.
            if (resultSet.next()) {
                return new UsuarioDTO(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre_usuario"),
                        resultSet.getString("password")
                );
            } else {
                return null;
            }
        }
    }

    public UsuarioDTO buscarPorNombreUsuario(String nombre_usuario) throws SQLException {
        String query = "SELECT * FROM usuario WHERE nombre_usuario = ?"; // Consulta SQL con un parámetro para el nombre de usuario

        try (Connection connection = DatabaseConfig.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nombre_usuario); // Seteamos el nombre de usuario para la búsqueda
            ResultSet resultSet = statement.executeQuery(); // Ejecutamos la consulta

            if (resultSet.next()) {
                // Si se encuentra el usuario, lo devolvemos como un objeto UsuarioDTO
                return new UsuarioDTO(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre_usuario"),
                        resultSet.getString("password")
                );
            } else {
                return null; // Si no se encuentra el usuario, retornamos null
            }
        }
    }

    public void eliminar(int id) throws SQLException {
        String query = "DELETE FROM usuario WHERE id = ?"; // Usamos el marcador de posición "?"

        try (Connection connection = DatabaseConfig.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            // Establecer el valor del parámetro en la consulta
            statement.setInt(1, id); // El primer "?" corresponde al parámetro ID

            // Ejecutar la consulta de eliminación
            statement.executeUpdate();
        }
    }

}
