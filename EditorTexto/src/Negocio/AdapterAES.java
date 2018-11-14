/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.AES;
import Negocio.Persistencia.DAOxml;
import java.util.Base64;

/**
 *
 * @author Berrocal
 */
public class AdapterAES implements IEncriptable {
    
    private final AES aes;
    private final DAOxml xml;
    
    public AdapterAES(){
        aes = new AES();
        xml = new DAOxml();
    }
    
    /**
     * Encripta un texto y lo guarda en persistencia
     * Lo almacena en Base64
     * @param llave Llave de 64 bytes para encriptar
     * @param texto String normal a encriptar
     * @return resultado de la desencriptacion
     */
    @Override
    public boolean encriptar(String llave, String texto){
        setLlave(llave);
        
        String encriptado = aes.Encrypt(texto);
        String base64 = Base64.getEncoder().encodeToString(encriptado.getBytes());
        
        //guarda el resultado en un xml
        boolean guardado = xml.guardar(base64);
        
        return !encriptado.isEmpty() && guardado;
    }
    
    /**
     * Desencripta un texto
     * @param llave Llave de 64 bytes para desencriptar
     * @param texto string en Base64
     * @return resultado de la desencriptacion
     */
    @Override
    public String desencriptar(String llave, String texto){
        setLlave(llave);
        
        byte[] strBytes = Base64.getDecoder().decode(texto);
        String noBase64 = new String(strBytes);
        
        String claro = aes.Decrypt(noBase64);
        
        return claro;
    }
    
    /**
     * Establece la llave con la que se va a encriptar/desencriptar
     * un texto
     * @param llave Llave de 16 bytes 
     */
    @Override
    public void setLlave(String llave){
        aes.setKey(llave);
    }
    
}
