package Modelo;

import Controlador.Productos;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import Controlador.Productos;

@ManagedBean

public class MostrarProducto implements Serializable {

    private static final long serialVersionUID = 6081417964063918994L;
    
    
    public List<Productos> getProductos() throws ClassNotFoundException, SQLException {

        Connection connect = null;

        String url = "jdbc:mysql://localhost:3306/productos";

        String username = "root";
        String password = "root";

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection(url, username, password);
            // System.out.println("Connection established"+connect);

        } catch (SQLException ex) {
            System.out.println("in exec");
            System.out.println(ex.getMessage());
        }

        List<Productos> visualizar_lista = new ArrayList<Productos>();
        PreparedStatement pstmt = connect.prepareStatement("select clave, nombre, precio, cantidad from producto");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            Productos visual = new Productos();
            visual.setClave(rs.getString("clave"));
            visual.setNombre(rs.getString("nombre"));
            visual.setPrecio(rs.getString("precio"));
            visual.setCantidad(rs.getString("cantidad"));

            visualizar_lista.add(visual);

        }
        

        // close resources
        rs.close();
        pstmt.close();
        connect.close();

        return visualizar_lista;

    }

}
