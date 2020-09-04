package Controlador;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Regresar {
    
    private String regresar;
    
    
    Vista vista_index = new Vista();
    
    public void volver(){
        vista_index.vista2();
    }

    /**
     * @return the regresar
     */
    public String getRegresar() {
        return regresar;
    }

    /**
     * @param regresar the regresar to set
     */
    public void setRegresar(String regresar) {
        this.regresar = regresar;
    }
    
}
