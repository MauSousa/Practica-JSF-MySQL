package Controlador;

import java.io.IOException;
import javax.faces.context.FacesContext;

public class AdministrarVistas {

    public void verificarArchivo(int interfaz) {
        try {
            Interfaces catalogo = new Interfaces();
            FacesContext.getCurrentInstance().getExternalContext().redirect(catalogo.obtenerNombreInterfaz(interfaz));
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }
}
