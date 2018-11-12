package Negocio.Persistencia;

public abstract class DAOG {
    
    /**
     * Método para guardar datos en archivos externos.
     * @param datos objeto con la información a guardar
     * @return true guardó, false no guardó
     */
    public abstract boolean guardar(Object datos);
    
    /**
     * Obtiene el texto guardaro en un archivo
     * @param filtro Filtro de búsqueda
     * @return Texto guardado según el filtro
     */
    public abstract String consultar(Object filtro);
    
}