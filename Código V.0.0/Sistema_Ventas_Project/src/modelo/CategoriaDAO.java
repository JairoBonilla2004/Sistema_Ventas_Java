
package modelo;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import utils.DBConexion;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class CategoriaDAO {
    
    private final MongoCollection<Document> categoriaCollection;
    
    public CategoriaDAO(){
        DBConexion dBConexion = DBConexion.getInstance("Sistema_Ventas");
        categoriaCollection = dBConexion.getDatabase().getCollection("categoria");
    }
}
