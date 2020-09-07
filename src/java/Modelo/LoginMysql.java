package Modelo;

import javax.faces.bean.ManagedBean;
import java.sql.*;
import java.util.ArrayList;

@ManagedBean
public class LoginMysql {
    
    private static String clave;
    private static String nombre;
    private static String precio;
    private static String cantidad;
    
    public LoginMysql() {
    }

     public static boolean validar() {
        
        Connection conexion = null;
        PreparedStatement sql = null;

        try {

            conexion = AccesoBD.getConexion();

            sql = conexion.prepareStatement("select clave, nombre, precio, cantidad from producto");
            sql.setString(1, clave);
            sql.setString(2, nombre);
            sql.setString(3, precio);
            sql.setString(4, cantidad);
            ResultSet respuesta = null;

            respuesta = sql.executeQuery();

            while(respuesta.next()){
               
                    ArrayList<String> productos = new ArrayList<String>();
                    productos.add(respuesta.getString("clave"));
                    productos.add(respuesta.getString("nombre"));
                    productos.add(respuesta.getString("precio"));
                    productos.add(respuesta.getString("cantidad"));            
                
                
                
            }
        } catch (Exception e) {
            System.out.println("Error, no hay productos" + e.getMessage());
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception e) {
            }
        }
        return false;

    } 

    public static void agregar(String clave, String nombre, String precio, String cantidad) {
        Connection conexion = null;
        Statement sql;
        try {
            conexion = AccesoBD.getConexion();
            sql = conexion.createStatement();
            sql.executeUpdate("insert into producto (clave, nombre, precio, cantidad) values('" + clave + "','" + nombre + "','" + precio + "','" + cantidad + "');");
            System.out.println("Producto agregado");
        } catch (Exception e) {
            System.out.println("Error de insercion" + e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (Exception e) {
            }
        }

    }
}
