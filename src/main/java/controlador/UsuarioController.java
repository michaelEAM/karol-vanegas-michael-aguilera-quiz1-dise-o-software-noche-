/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import dto.MotocicletaDTO;
import repository.UsuarioRepository;
import java.sql.SQLException;
import java.util.List;
import service.UsuarioService;
import dto.UsuarioDTO;
        

/**
 *
 * @author Probook
 */
public class UsuarioController {
    
     private UsuarioRepository usuarioRepository;
     UsuarioService usuarioService;

    public UsuarioController() {
        usuarioRepository = new UsuarioRepository();
          usuarioService = new UsuarioService(); // Inicializa el servicio
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
    
    public List<UsuarioDTO> obtenerUsuarios() throws SQLException {
    // Llamar al servicio para obtener todas las motocicletas
    return usuarioService.obtenerTodas(); // Suponiendo que tienes este método en tu servicio
}
      public boolean registrarUsuario(String nombreUsuario, String password) {
        try {
            return usuarioService.registrarUsuario(nombreUsuario, password);  // Llamamos al servicio de usuario para registrar
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // En caso de error con la base de datos, retornamos false
        }
    }
      
       public void eliminarUsuario(int id) throws SQLException {
        usuarioService.eliminar(id);
    }
    
}
