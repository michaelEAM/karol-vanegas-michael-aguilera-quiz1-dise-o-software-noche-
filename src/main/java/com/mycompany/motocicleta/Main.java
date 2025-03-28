
import vista.Login;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Probook
 */
public class Main {
    
    public static void main (String[] args) {
        // Aquí puedes inicializar y mostrar la ventana de Login u otras operaciones iniciales
        System.out.println("Iniciando la aplicación...");

        // Si quieres lanzar la clase Login (o cualquier otra ventana principal de tu aplicación)
        Login loginWindow = new Login(); // Crear una instancia de la clase Login

        loginWindow.setVisible(true); // Mostrar la ventana
    }
    
}
