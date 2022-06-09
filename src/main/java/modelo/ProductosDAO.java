package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class ProductosDAO {

    Connection con = null;

    public ProductosDAO() {
        con = Conexion.getConexion();
    }

    public List<Productos> listarProductos() {

        List<Productos> productos = null;

        try {
            // Consulta para traer los datos de la base de datos.
            PreparedStatement query = con.prepareStatement("SELECT * FROM productos");
            ResultSet response = query.executeQuery();
            System.out.println("Haciendo consulta.");

            productos = new ArrayList<>();

            while (response.next()) {

                int id = response.getInt("id");
                String codigo = response.getString("codigo");
                String nombre = response.getString("nombre");
                float precio = response.getFloat("precio");
                int existencia = response.getInt("existencia");

                Productos producto = new Productos(id, codigo, nombre, precio, existencia);

                productos.add(producto);

            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return productos;

    }

    public Productos buscarProducto(int id) {

        Productos producto = null;

        try {
            // Consulta para traer los datos de la base de datos.
            PreparedStatement query = con.prepareStatement("SELECT * FROM productos WHERE id = ?");
            query.setInt(1, id);
            ResultSet response = query.executeQuery();

            while (response.next()) {

                String codigo = response.getString("codigo");
                String nombre = response.getString("nombre");
                float precio = response.getFloat("precio");
                int existencia = response.getInt("existencia");

                producto = new Productos(id, codigo, nombre, precio, existencia);

            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return producto;

    }

    public boolean agregarProducto(Productos producto) {

        try {
            // Consulta para traer los datos de la base de datos.
            PreparedStatement query = con
                    .prepareStatement("INSERT INTO productos (codigo, nombre, precio, existencia) VALUES (?, ?, ?, ?)");
            query.setString(1, producto.getCodigo());
            query.setString(2, producto.getNombre());
            query.setFloat(3, producto.getPrecio());
            query.setInt(4, producto.getExistencia());

            query.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return false;

    }

    public boolean actualizarProducto(Productos producto) {

        try {
            // Consulta para traer los datos de la base de datos.
            PreparedStatement query = con
                    .prepareStatement(
                            "UPDATE productos SET codigo = ?, nombre = ?, precio = ?, existencia = ? WHERE id = ?");
            query.setString(1, producto.getCodigo());
            query.setString(2, producto.getNombre());
            query.setFloat(3, producto.getPrecio());
            query.setInt(4, producto.getExistencia());
            query.setInt(5, producto.getId());

            query.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return false;

    }

    public boolean eliminarProducto(int id) {

        try (PreparedStatement query = con.prepareStatement("DELETE FROM productos WHERE id = ?")) {
            query.setInt(1, id);
            query.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return false;
    }

}
