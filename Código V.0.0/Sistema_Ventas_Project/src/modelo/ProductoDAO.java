
package modelo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import org.bson.Document;
import utils.DBConexion;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ProductoDAO {
    
    private final MongoCollection<Document> productoCollection;
    
    public ProductoDAO(){
        productoCollection = DBConexion.getInstance("Sistema_Ventas").getDatabase().getCollection("Productos");
        
    }
    
    public Categoria obtenerCategoria(Document documento_catergoria){
        Categoria categoria = new Categoria(documento_catergoria.getInteger("id"), documento_catergoria.getString("categoria"));
        return categoria;
        
    }
    
    public ArrayList<Producto> obtenerTodosProductosDB(){
        MongoCursor<Document> cursor = productoCollection.find().iterator();
        ArrayList<Producto> productos = new ArrayList<>();
        while(cursor.hasNext()){
            Document producto_document = cursor.next();
            Document categoriaDB_document = producto_document.get("Categoria", Document.class);
            Categoria categoria = obtenerCategoria(categoriaDB_document);
            Producto producto = new Producto(producto_document.getString("nombre"),
                    producto_document.getInteger("cantidad"), 
                    producto_document.getDouble("precio"),
                    producto_document.getDate("fecha_caducidad"), 
                    producto_document.getInteger("iva"),categoria );
            productos.add(producto);
        }
        return productos;
    }
    
}
