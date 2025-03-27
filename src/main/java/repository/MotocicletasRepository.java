/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import database.DatabaseConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import dto.MotocicletaDTO;
import database.DatabaseConfig;
import java.sql.PreparedStatement;

import java.sql.SQLException;

/**
 *
 * @author Probook
 */
public class MotocicletasRepository {

    public MotocicletaDTO buscarPorId(int id) throws SQLException {// Recibe un parámetro id de tipo int que se utiliza para buscar al cliente.
        String query = "SELECT * FROM motocicleta WHERE id = " + id;// Esta es la consulta SQL que se ejecutará en la base de datos.
        //clientes cuyo campo id sea igual al valor de la variable id que se pasa como parámetro al método.
        try (Connection connection = DatabaseConfig.getConnection(); // Usa la conexión de Database
                 Statement statement = connection.createStatement();// El objeto Statement que se usa para ejecutar la consulta SQL.
                 ResultSet resultSet = statement.executeQuery(query)) {//El objeto ResultSet que contiene los datos recuperados de la consulta SQL.
            if (resultSet.next()) {
                return new MotocicletaDTO(
                        resultSet.getInt("id"),
                        resultSet.getString("marca"),
                        resultSet.getString("cilindraje"),
                        resultSet.getString("precio"),
                        resultSet.getString("color")
                );
            } else {
                return null;
            }
        }
    }

    public void guardar(MotocicletaDTO motocicleta) throws SQLException { // Este es un método público llamado save, que acepta un objeto de tipo ClientesDTO como parámetro. El tipo ClientesDTO es un objeto que probablemente contiene la información de un cliente (como nombre, teléfono, dirección y correo).
        String query = "INSERT INTO motocicleta (marca,cilindraje,precio,color) VALUES ('"
                +//La consulta INSERT INTO se usa para insertar una nueva fila en la tabla clientes de la base de datos. Los valores que se van a insertar son obtenidos del objeto cliente usando sus métodos getNombre(), getTelefono(), getDireccion() y getCorreo().
                //La variable query es una cadena de texto que contiene la consulta SQL para insertar datos en la tabla clientes de la base de datos. 
                motocicleta.getMarca() + "', '"
                + motocicleta.getCilindraje() + "', '"
                + motocicleta.getPrecio() + "', '"
                + motocicleta.getColor() + "')";
        try (Connection connection = DatabaseConfig.getConnection(); // Usa la conexión de DatabaseConfig
                 Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);//
        }
    }

    public void actualizar(MotocicletaDTO motocicleta) throws SQLException {
   String query = "UPDATE motocicleta SET marca = ?, cilindraje = ?, precio = ?, color = ? WHERE id = ?";

    try (Connection connection = DatabaseConfig.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

        // Establecer los valores de los parámetros
        statement.setString(1, motocicleta.getMarca());
        statement.setString(2, motocicleta.getCilindraje());
        statement.setString(3, motocicleta.getPrecio());
        statement.setString(4, motocicleta.getColor());
        statement.setInt(5, motocicleta.getId()); // ID de la motocicleta que se desea actualizar

        // Ejecutar la consulta
        int rowsAffected = statement.executeUpdate();

        // Verificar cuántas filas se vieron afectadas
        if (rowsAffected > 0) {
            System.out.println("Motocicleta actualizada correctamente.");
        } else {
            System.out.println("No se encontró una motocicleta con el ID proporcionado.");
        }
    } catch (SQLException e) {
        // Manejar excepciones de SQL
        System.err.println("Error al actualizar la motocicleta: " + e.getMessage());
        throw e; // Volver a lanzar la excepción para que pueda ser manejada en otro lugar
    }
    }

    public void eliminar(int id) throws SQLException {
         String query = "DELETE FROM motocicleta WHERE id = ?"; // Usamos el marcador de posición "?"

    try (Connection connection = DatabaseConfig.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

        // Establecer el valor del parámetro en la consulta
        statement.setInt(1, id); // El primer "?" corresponde al parámetro ID

        // Ejecutar la consulta de eliminación
        statement.executeUpdate();
    }
}
}
