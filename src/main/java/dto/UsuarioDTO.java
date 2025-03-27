/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Probook
 */
public class UsuarioDTO {

    private int id;
    private String nombre_usuario;
    private String password;

    public UsuarioDTO(int id, String nombre_usuario, String password) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
      // Método para encriptar la contraseña
    public String getHashedPassword() {
        return BCrypt.hashpw(this.password, BCrypt.gensalt()); // Encriptar la contraseña antes de almacenarla
    }

    // Método para verificar si la contraseña ingresada coincide con la encriptada
    public boolean checkPassword(String inputPassword) {
        return BCrypt.checkpw(inputPassword, this.password); // Verificar si la contraseña coincide
    }

}
