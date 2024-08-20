package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductosDAO {

    Connection conexion;

    public ProductosDAO() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }

    public List<Productos> listarProductos() {

        PreparedStatement ps;
        ResultSet rs;

        List<Productos> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT id, apellido, nombre, correo, cedula FROM registro");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                int cedula = rs.getInt("cedula");

                Productos producto = new Productos(id, apellido, nombre, correo, cedula);
                lista.add(producto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.toString());
            return null;
        }
    }

    public Productos mostarProducto(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Productos producto = null;

        List<Productos> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT id, apellido, nombre, cedula, correo FROM registro WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                int cedula = rs.getInt("cedula");

                producto = new Productos(id, apellido, nombre, correo, cedula);
            }
            return producto;
        } catch (SQLException e) {
            System.out.println("Error al mostrar producto: " + e.toString());
            return null;
        }
    }

    public boolean insertar(Productos producto) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO registro (apellido, nombre, correo, cedula) VALUES (?,?,?,?)");
            ps.setString(1, producto.getApellido());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getCorreo());
            ps.setInt(4, producto.getCedula());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.toString());
            return false;
        }
    }

    public boolean actualizar(Productos producto) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("UPDATE registro SET apellido=?, nombre=?, correo=?, cedula=? WHERE id=?");
            ps.setString(1, producto.getApellido());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getCorreo());
            ps.setInt(4, producto.getCedula());
            ps.setInt(5, producto.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean eliminar(int _id) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("DELETE FROM registro WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.toString());
            return false;
        }
    }

}
