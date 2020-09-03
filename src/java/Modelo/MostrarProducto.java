package Modelo;

import Controlador.Visualizar;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class MostrarProducto implements Serializable {

    private static final long serialVersionUID = 6081417964063918994L;

    public List<Visualizar> getVisualizar() throws ClassNotFoundException, SQLException {

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

        List<Visualizar> visualizar_lista = new ArrayList<Visualizar>();
        PreparedStatement pstmt = connect
                .prepareStatement("select clave, nombre, precio, cantidad from producto");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            Visualizar visual = new Visualizar();
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
