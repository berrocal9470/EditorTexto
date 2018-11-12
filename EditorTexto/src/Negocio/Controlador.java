package Negocio;

import java.util.Arrays;

/**
 *
 * @author Berrocal
 */
public class Controlador {
    
    private GestorAES gestorAES;
    
    public Controlador(){
        gestorAES = new GestorAES();
    }
    
    public String encriptar(String llave, String texto){
        boolean encriptado = gestorAES.encriptar(llave, texto);
        
        if(encriptado){
            return gestorAES.consultarUltimoTexto();
        }else{
            return "Error al encriptar";
        }
    }
    
    public String desencriptar(String llave, String texto){
        String desencriptado = gestorAES.desencriptar(llave, texto);
        return desencriptado;
    }
    
    public String consultar(int numero){
        return gestorAES.consultar(numero);
    }
    
}
