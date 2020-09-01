package Controlador;

public class Interfaces {
    
    private String archivos[];
    
    public Interfaces(){
        archivos = new String[3];
        archivos[0] = "registra.xhtml";
        archivos[1] = "mostrar.xhtml";
        archivos[2] = "index.xhtml";
        
    }
    
    public String obtenerNombreInterfaz(int interfaz){
        
        return this.archivos[interfaz];
    }
    
}
