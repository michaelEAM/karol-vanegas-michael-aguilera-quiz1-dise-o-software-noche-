/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import exception.InvalidDataException;
import java.sql.SQLException;
import repository.MotocicletasRepository;
import dto.MotocicletaDTO;
import validadotor.userValidador;

public class MotocicletaService {

    private MotocicletasRepository motocicletasRepository = new MotocicletasRepository();

    public MotocicletaDTO obtener(int id) throws SQLException {
        return motocicletasRepository.buscarPorId(id);//  este es el metodo que me busca la lista 
    }

    public void createMotocicleta(String marca, String cilindraje, String precio, String color) throws SQLException, InvalidDataException {
        // Validar los datos del cliente
        if (!userValidador.validateNombre(marca)) {
            throw new InvalidDataException("El nombre del cliente es inválido");
        }

        // Crear el cliente y guardarlo
        MotocicletaDTO motocicletaDTO = new MotocicletaDTO(0, marca, cilindraje, precio, color);
        motocicletasRepository.guardar(motocicletaDTO);//save(cliente): Es un método que guarda el objeto cliente en la base de datos. Es probable que clientesRepository esté utilizando un marco de persistencia como JPA (Java Persistence API) o algún tipo de repositorio personalizado.
    }

    public void actualizar(int id, String marca, String cilindraje, String precio, String color) throws SQLException, InvalidDataException {
        if (!userValidador.validateNombre(marca)) {
            throw new InvalidDataException("Invalid user data");
        }
        MotocicletaDTO motocicletaDTO = new MotocicletaDTO(id, marca, cilindraje, precio, color);
        motocicletasRepository.actualizar(motocicletaDTO);
    }

    public void eliminar(int id) throws SQLException {
        motocicletasRepository.eliminar(id);
    }

}
