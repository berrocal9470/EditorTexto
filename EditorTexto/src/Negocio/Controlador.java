package Negocio;

import Negocio.Persistencia.DAOxml;
import java.util.Arrays;

/**
 *
 * @author Berrocal
 */
public class Controlador {
    
    private final AdapterAES adapterAES;
    private final DAOxml xml;
    
    public Controlador(){
        adapterAES = new AdapterAES();
        xml = new DAOxml();
    }
    
    /**
     * Llama al AdapterAES para encriptar un texto
     * @param llave Llave para encriptar
     * @param texto Texto a encriptar
     * @return Texto encriptado con la llave proporcionada
     */
    public String encriptar(String llave, String texto){
        boolean encriptado = adapterAES.encriptar(llave, texto);
        
        if(encriptado){
            return xml.consultar(xml.getLastIndex());
        }else{
            return "Error al encriptar";
        }
    }
    
    /**
     * Llama al AdapterAES para desencriptar un texto
     * @param llave Llave para desencriptar
     * @param texto Texto a desencriptar
     * @return Texto desencriptado con la llave proporcionada
     */
    public String desencriptar(String llave, String texto){
        String desencriptado = adapterAES.desencriptar(llave, texto);
        return desencriptado;
    }
    
    /**
     * Obtiene una página encriptada con el número identificador
     * @param numero Número de la página a encriptar
     * @return Texto encriptado de la página solicitada
     */
    public String consultar(int numero){
        return xml.consultar(numero);
    }
    
}
