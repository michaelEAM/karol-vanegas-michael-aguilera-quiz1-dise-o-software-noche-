/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import repository.UsuarioRepository;
import java.sql.SQLException;

/**
 *
 * @author Probook
 */
public class UsuarioController {
    
     private UsuarioRepository usuarioRepository;

    public UsuarioController() {
        usuarioRepository = new UsuarioRepository();
    }

    // Verificar login
    public boolean verificarLogin(String nombreUsuario, String password) {
        try {
            return usuarioRepository.verificarLogin(nombreUsuario, password); // Llamamos al método de verificación
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
