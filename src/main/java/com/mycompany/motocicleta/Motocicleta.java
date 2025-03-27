/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.motocicleta;
import service.MotocicletaService;
import java.sql.SQLException;
import exception.InvalidDataException;
import java.util.Scanner;
import service.UsuarioService;
/**
 *
 * @author Probook
 */
public class Motocicleta {

    public static void main(String[] args) {
//     
        
         // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar nombre de usuario y contraseña
        System.out.print("Ingresa tu nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        
        System.out.print("Ingresa tu contraseña: ");
        String password = scanner.nextLine();
        
        // Crear una instancia de UsuarioService
        UsuarioService usuarioService = new UsuarioService();
        
        try {
            // Registrar el usuario
            boolean registrado = usuarioService.registrarUsuario(nombreUsuario, password);
            
            if (registrado) {
                System.out.println("Usuario registrado con éxito.");
            } else {
                System.out.println("Error al registrar el usuario. Intenta de nuevo.");
            }
        } catch (SQLException e) {
            // Si ocurre algún error con la base de datos
            System.out.println("Ocurrió un error al intentar registrar al usuario: " + e.getMessage());
        } catch (Exception e) {
            // Captura cualquier otro tipo de error
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            // Cerrar el scanner
            scanner.close();
        }
    }
}
