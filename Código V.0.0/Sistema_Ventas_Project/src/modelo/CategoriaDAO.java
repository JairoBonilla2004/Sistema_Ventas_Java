
package modelo;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.List;
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
        categoriaCollection = dBConexion.getDatabase().getCollection("Categorias");
    }
    
        public List<Categoria> extraerCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            MongoCursor<Document> cursor = categoriaCollection.find().iterator();
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Categoria categoria = new Categoria(document.getInteger("id"), document.getString("categoria"));
                categorias.add(categoria);
            }
        } catch (MongoException mongoException) {
            System.out.println("No se pudo extraer las categorias " + mongoException);
        }
        return categorias;
    }
}
