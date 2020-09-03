/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@SessionScoped
public class LoginMysql {

    /**
     * Creates a new instance of LoginMySql
     */
    public LoginMysql() {
    }

    /* public static boolean validar(String clave, String nombre, String precio, String cantidad) {
        Connection conexion = null;
        PreparedStatement sql = null;

        try {

            conexion = AccesoBD.getConexion();

            sql = conexion.prepareStatement("select * from producto");
            sql.setString(1, clave);
            sql.setString(2, nombre);
            sql.setString(3, precio);
            sql.setString(4, cantidad);
            ResultSet respuesta = null;

            respuesta = sql.executeQuery();

            if (respuesta.next()) {
                return true;
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

    } */

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
