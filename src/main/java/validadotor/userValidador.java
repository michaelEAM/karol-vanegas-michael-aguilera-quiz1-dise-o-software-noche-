/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadotor;

/**
 *
 * @author Probook
 */
public class userValidador {

    public static boolean validateNombre(String nombre) { // si el nombre es null debuelve false
        return nombre != null && !nombre.trim().isEmpty();  //name.trim(): Este método elimina los espacios en blanco (blancos, tabulaciones, etc.)
    }

    public static boolean validateEmail(String email) {
        return email != null && email.contains("@"); // El método contains("@") verifica si el correo electrónico contiene el carácter @.
    }

}
