package Controlador;

public class Vista {
   
    AdministrarVistas administradorArchivos;
    
    public Vista(){
        this.administradorArchivos = new AdministrarVistas();
    }
    
    public void vista0(){
        administradorArchivos.verificarArchivo(0);
        
    }
    public void vista1(){
        administradorArchivos.verificarArchivo(1);
        
    }
    public void vista2(){
        administradorArchivos.verificarArchivo(2);
        
    }
    public void vista3(){
        administradorArchivos.verificarArchivo(3);
        
    }
}
