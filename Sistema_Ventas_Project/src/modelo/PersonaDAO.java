package modelo;

import java.util.List;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public interface PersonaDAO<T> {
    
    public  boolean enviarPesonasDB(T tipo);

    public  boolean verificarPersonaExistente(String keyBusqueda, String tipoBusqueda);

    public  List<T> extraerPersonas();

    public  List<T> buscarPersonasPorTextoRegEx(String texto);

    public  T extraerPersonaID(String id);

    public  boolean actualizarDatos(T tipo);
    
    public  boolean  eliminarPersona(String dato);
    
}
