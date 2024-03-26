package modelo;

import java.util.List;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 * @param <T>
 */
public interface PersonaDAO<T> {
    
    public  boolean enviarPesonasDB(T tipo);

    public  <TypeBusqueda> boolean verificarPersonaExistente(String keyBusqueda, TypeBusqueda typeBusqueda);

    public  List<T> extraerPersonas();

    public  List<T> buscarPersonasPorTextoRegEx(String texto);

    public  <TypeBusqueda>T extraerPersonaID(String keyBusqueda, TypeBusqueda typeBuskeda);

    public  boolean actualizarDatos(T tipo);
    
    public  boolean  eliminarPersona(String dato);
    
}
