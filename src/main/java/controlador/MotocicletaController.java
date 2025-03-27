/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import service.MotocicletaService;
import java.sql.SQLException;
import exception.InvalidDataException;
import dto.MotocicletaDTO;
/**
 *
 * @author Probook
 */
public class MotocicletaController {
    
      private MotocicletaService motocicletaService;

    public MotocicletaController() {
        motocicletaService = new MotocicletaService();
    }

    // Método para crear motocicleta
    public void createMotocicleta(String marca, String cilindraje, String precio, String color) throws SQLException, InvalidDataException {
        motocicletaService.createMotocicleta(marca, cilindraje, precio, color);
    }

    // Método para obtener motocicleta por ID
    public MotocicletaDTO obtenerMotocicleta(int id) throws SQLException {
          // Llamamos al servicio para obtener la motocicleta por su ID
    MotocicletaDTO motocicletaDTO = motocicletaService.obtener(id);

    // Si la motocicleta se encuentra, la retornamos, sino retornamos null.
    if (motocicletaDTO != null) {
        return motocicletaDTO;  // Devolvemos el objeto MotocicletaDTO
    } else {
        return null;  // Si no se encuentra, devolvemos null
    }
    }

    // Método para actualizar motocicleta
    public void actualizarMotocicleta(int id, String marca, String cilindraje, String precio, String color) throws SQLException, InvalidDataException {
        motocicletaService.actualizar(id, marca, cilindraje, precio, color);
    }

    // Método para eliminar motocicleta
    public void eliminarMotocicleta(int id) throws SQLException {
        motocicletaService.eliminar(id);
    }
    
}
