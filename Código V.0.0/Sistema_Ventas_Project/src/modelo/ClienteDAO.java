
package modelo;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.List;
import org.bson.Document;
import utils.DBConexion;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ClienteDAO implements PersonaDAO<Cliente>{
    
    private MongoCollection<Document> collection;
    
    public ClienteDAO(){
        DBConexion dBConexion = DBConexion.getInstance("Sistema_Ventas");
        collection = dBConexion.getDatabase().getCollection("Cliente");
    }


    @Override
    public <TypeBusqueda> boolean verificarPersonaExistente(String keyBusqueda, TypeBusqueda typeBusqueda) {
        boolean respuesta = false;
        try {
            
            Document filtro = new Document(keyBusqueda, typeBusqueda);
            MongoCursor<Document> cursor = collection.find(filtro).iterator();
            respuesta = cursor.hasNext();

        } catch (MongoException e) {
            System.out.println("No se pudo verificar si el cliente ya está registrado es: " + e);
        }
        return respuesta;
    }

    @Override
    public boolean enviarPesonasDB(Cliente tipo) {
    }

    @Override
    public List<Cliente> extraerPersonas() {
    }

    @Override
    public List<Cliente> buscarPersonasPorTextoRegEx(String texto) {
    }

    @Override
    public <TypeBusqueda> Cliente extraerPersonaID(String keyBusqueda, TypeBusqueda typeBuskeda) {
    }

    @Override
    public boolean actualizarDatos(Cliente tipo) {
    }

    @Override
    public boolean eliminarPersona(String dato) {
    }

}
