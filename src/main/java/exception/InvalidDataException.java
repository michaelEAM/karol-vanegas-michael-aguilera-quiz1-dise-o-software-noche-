/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author Probook
 */
public class InvalidDataException extends Exception{
    
      public InvalidDataException(String message) {
        super(message); //  Llama al constructor de la clase base Exception con el mensaje de error
    }
    
}
