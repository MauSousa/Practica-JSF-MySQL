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
public class AccesoBD {
    
 private static Connection conexion = null;
    private static String servidor = "127.0.0.1";
    private static String  basedatos = "productos";
    private static String usuario = "root";
    private static String clave = "root";
    private static String ruta = "";
    
    public AccesoBD() {
        
    }    
    public static Connection getConexion()
    {
      try{
            Class.forName("com.mysql.jdbc.Driver");
            ruta = "jdbc:mysql://" + servidor + "/" + basedatos;
            conexion = DriverManager.getConnection(ruta,usuario,clave);
            System.out.println("listo1");
        }
        catch(SQLException | ClassNotFoundException  e)
        {
         System.out.println(e);
         System.out.println("listo2");
        }     
      return conexion;  
    }            
}