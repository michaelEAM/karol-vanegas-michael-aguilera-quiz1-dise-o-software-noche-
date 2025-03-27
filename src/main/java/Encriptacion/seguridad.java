/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encriptacion;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author Probook
 */
public class seguridad {
 
  
           public static String encriptarPassword(String password) throws NoSuchAlgorithmException {
        // Crear un objeto MessageDigest con el algoritmo SHA-256
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        // Realizar el "digest" de la contraseña
        byte[] hash = messageDigest.digest(password.getBytes());

        // Convertir el resultado a un valor hexadecimal
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        // Retornar la contraseña encriptada
        return sb.toString();
    }
    
}
