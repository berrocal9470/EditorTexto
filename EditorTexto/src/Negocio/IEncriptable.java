/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Berrocal
 */
public interface IEncriptable {
    
    public boolean encriptar(String llave, String texto);
    
    public String desencriptar(String llave, String texto);
    
    public void setLlave(String llave);
}
