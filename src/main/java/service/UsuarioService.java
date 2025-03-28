/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

<<<<<<< HEAD
import java.sql.SQLException;

import dto.UsuarioDTO;

import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

import repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;
=======


import database.DatabaseConfig;
import dto.MotocicletaDTO;
import exception.InvalidDataException;
import java.sql.SQLException;
import repository.MotocicletasRepository;
import dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import validadotor.userValidador;
import repository.UsuarioRepository;
/**
 *
 * @author Probook
 */
public class UsuarioService {
    
    
       private UsuarioRepository usuarioRepository;
>>>>>>> 8d70d34c0315ec0044720c3d791662a09f8f960c

    public UsuarioService() {
        usuarioRepository = new UsuarioRepository(); // Inicializamos el repositorio
    }

<<<<<<< HEAD
    public boolean registrarUsuario(String nombre_usuario, String password) throws SQLException {
        // Encriptar la contraseña antes de guardarla
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println("Contraseña encriptada: " + hashedPassword);  // Verifica que el valor está encriptado

        // Crear un objeto UsuarioDTO con la contraseña encriptada
        UsuarioDTO nuevoUsuario = new UsuarioDTO(0, nombre_usuario, hashedPassword); // Guardamos la contraseña encriptada

        // Llamamos al repositorio para guardar el usuario
        return usuarioRepository.guardarUsuario(nuevoUsuario);
    }
    // Método para validar un usuario con nombre de usuario y contraseña

=======
   public  boolean registrarUsuario(String nombre_usuario, String password) throws SQLException {
    // Encriptar la contraseña antes de guardarla
    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
    System.out.println("Contraseña encriptada: " + hashedPassword);  // Verifica que el valor está encriptado

    // Crear un objeto UsuarioDTO con la contraseña encriptada
    UsuarioDTO nuevoUsuario = new UsuarioDTO(0, nombre_usuario, hashedPassword); // Guardamos la contraseña encriptada

    // Llamamos al repositorio para guardar el usuario
    return usuarioRepository.guardarUsuario(nuevoUsuario);
}
  // Método para validar un usuario con nombre de usuario y contraseña
>>>>>>> 8d70d34c0315ec0044720c3d791662a09f8f960c
    public UsuarioDTO validarUsuario(String nombre_usuario, String password) throws SQLException {
        // Buscar al usuario por nombre de usuario
        UsuarioDTO usuario = usuarioRepository.buscarPorNombreUsuario(nombre_usuario);

        if (usuario != null && BCrypt.checkpw(password, usuario.getPassword())) {
            // Si el nombre de usuario existe y la contraseña es correcta, devolvemos el usuario
            return usuario;
        } else {
            // Si las credenciales no coinciden, devolvemos null
            return null;
        }
    }
<<<<<<< HEAD

    public List<UsuarioDTO> obtenerTodas() throws SQLException {
        // Llamar al repositorio para obtener todas las motocicletas
        return usuarioRepository.obtenerTodas(); // Este método debe devolver una lista de motocicletas
    }

    public void eliminar(int id) throws SQLException {
        usuarioRepository.eliminar(id);
    }

=======
    
    public List<UsuarioDTO> obtenerTodas() throws SQLException {
    // Llamar al repositorio para obtener todas las motocicletas
    return usuarioRepository.obtenerTodas(); // Este método debe devolver una lista de motocicletas
}
     public void eliminar(int id) throws SQLException {
        usuarioRepository.eliminar(id);
    }
    
>>>>>>> 8d70d34c0315ec0044720c3d791662a09f8f960c
}
