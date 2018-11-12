package Negocio.Persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class DAOxml extends DAOG {
    
    public DAOxml(){ }
    
    /**
     * Método para guardar datos en archivos externos.
     * @param datos objeto con la información a guardar
     * @return estado final del guardado
     */
    @Override
    public boolean guardar(Object datos){
        //Si no es texto no se guarda
        if(!(datos instanceof String)){
            return false;
        }
        
        //Cast del texto
        String texto = (String) datos;
        
        int numeroPagina = getLastIndex();
        //Un -1 quiere decir que hubo error
        if(numeroPagina == -1) return false;
        else numeroPagina += 1;
        
        String filepath = "src/Bitacora/diario.xml";
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            
            Document document;
            try{
                document = documentBuilder.parse(filepath);
            }catch(FileNotFoundException e){
                document = documentBuilder.newDocument();
            }
            
            if(!document.hasChildNodes()){
                // Elemento root Diario
                Element root = document.createElement("Bitácora");
                document.appendChild(root);
            }
            
            //--------------PROCESO DE GUARDADO
            
            // Obtener el elemento root
            Node data= document.getFirstChild();

            // Elemento bitacora
            Element diario = document.createElement("Diario");
            data.appendChild(diario);

            diario.setAttribute("Página", String.valueOf(numeroPagina));

            // Texto encriptado
            Element textoEncriptado = document.createElement("Texto");
            textoEncriptado.appendChild(document.createTextNode(texto));
            diario.appendChild(textoEncriptado);                                      
            
            
            // escribe el contenido a un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException | IOException | SAXException ex) {
            return false;
        }
        return true;            
    }
    
    /**
     * Retorna el índice del último diario en el xml
     * @return Número del último índice creado
     */
    public int getLastIndex(){
        XPath xpath = XPathFactory.newInstance().newXPath();
        Document doc;
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse("src/Bitacora/diario.xml");
            
            String index;
            index = xpath.evaluate("//Bitácora/Diario[last()]/@Página", doc);

            return Integer.parseInt(index);
        } catch (ParserConfigurationException | SAXException | IOException | 
                XPathExpressionException ex) {
            return 0;
        }
    }
    
    /**
     * Obtiene el texto encriptado de una página específica
     * @param dato Número de página
     * @return Texto encriptado en la página [indice]
     */
    @Override
    public String consultar(Object dato){
        int indice;
        
        if(!(dato instanceof Integer)) return "";
        else indice = (Integer) dato;
        
        XPath xpath = XPathFactory.newInstance().newXPath();
        Document doc;
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse("src/Bitacora/diario.xml");
            
            String texto;
            texto = xpath.evaluate("//Bitácora/Diario["+ indice +"]/Texto", doc);

            return texto;
        } catch (ParserConfigurationException | SAXException | IOException | 
                XPathExpressionException ex) {
            System.out.println("Se cayó " + ex.getMessage());
            return "";
        }
    }
}
