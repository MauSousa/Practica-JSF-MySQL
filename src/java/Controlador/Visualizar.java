package Controlador;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Visualizar {
    
    
    Vista vista = new Vista();
    
    public void verProductos(){
        
        
        vista.vista1();
    }
    
}
