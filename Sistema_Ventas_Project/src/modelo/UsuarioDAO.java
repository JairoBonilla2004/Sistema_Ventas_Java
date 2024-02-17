package modelo;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import utils.DBConexion;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class UsuarioDAO implements PersonaDAO<Usuario> {

    private final MongoCollection<Document> usuarioCollection;

    public UsuarioDAO() {
        DBConexion dBConexion = DBConexion.getInstance("Sistema_Ventas");//instancia el 
        usuarioCollection = dBConexion.getDatabase().getCollection("Usuarios");//mediante la coleccion yo puedo manipular los datos
    }

    
    public boolean verificarCamposCorrectosUsuarioAdministrador(Usuario usuario) {
        //paso 1 creamos el documento
        Document filtro = new Document("$and", Arrays.asList(
                new Document("usuario", usuario.getNombre_usuario()),
                new Document("contraseña", usuario.getContraseña())
        ));

        MongoCursor<Document> cursor = usuarioCollection.find(filtro).iterator();//MongoCursor obtiene TODOS los documentos que conicidan con la búsqueda
        //se ejecutará mientras haya documentos disponibles en el cursor. 
        while (cursor.hasNext()) {//.hasNext() NO MUEVE EL CURSOR SOLO verifica si existe mas de un documento con respencto a esa consulta devuelve true o false

            return true; // Devuelve true si las credenciales son correctas
        }
        return false; // Devuelve false si las credenciales no son correctas o el usuario no se encontró

    }

    @Override
    public boolean enviarPesonasDB(Usuario usuario) {
        boolean respuesta = false;
        try {
            Document nuevoDocumento_usuario = new Document("nombre", usuario.getNombre())
                    .append("apellido", usuario.getApellido())
                    .append("usuario", usuario.getNombre_usuario())
                    .append("contraseña", usuario.getContraseña())
                    .append("telefono", usuario.getTelefono())
                    .append("cedula", usuario.getCedula());
                    
            usuarioCollection.insertOne(nuevoDocumento_usuario);
            respuesta = true;
        } catch (MongoException e) {
            System.out.println("Error al enviar el usuario a la base de datos porque " + e);
        }
        return respuesta;
    }

    @Override
    public boolean verificarPersonaExistente(String keyBusqueda, String usuario) {
        boolean respuesta = true;
        Document filtro = new Document(keyBusqueda, usuario);
        MongoCursor<Document> cursor = usuarioCollection.find(filtro).iterator();
        try {
            respuesta = cursor.hasNext();//rettorna true si existe un usuario con ese nombre
        } catch (MongoException e) {
            System.out.println(e);
        }
        return respuesta;
    }

    @Override
    public List<Usuario> extraerPersonas() {
        List<Usuario> usuarios = new ArrayList<>();
        MongoCursor<Document> cursor = usuarioCollection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document documentos_dataBase = cursor.next();//mueve al primer Documento

                Usuario usuario = new Usuario(
                        documentos_dataBase.getString("cedula"),
                        documentos_dataBase.getString("nombre"),
                        documentos_dataBase.getString("apellido"),
                        documentos_dataBase.getString("usuario"),
                        documentos_dataBase.getString("contraseña"),
                        documentos_dataBase.getInteger("telefono"));
                usuarios.add(usuario);
            }
        } catch (MongoException mongoException) {
            System.out.println("No se pudo extaer los usuarios de la base de datos: " + mongoException);
        }
        return usuarios;
    }

    @Override
    public List<Usuario> buscarPersonasPorTextoRegEx(String textoBuscado) {
        List<Usuario> usuarios = new ArrayList<>();
        // Crear una expresión regular (regex) para buscar el texto en los campos de nombre y apellido
        Bson filtroRegex = Filters.or(
                Filters.regex("nombre", "^" + textoBuscado, "i") // "^" para que coincida al inicio
        );
        try (MongoCursor<Document> cursor = usuarioCollection.find(filtroRegex).iterator()) {
            while (cursor.hasNext()) {
                Document documento = cursor.next();
                Usuario usuario = new Usuario(
                        documento.getObjectId("_id").toString(),
                        documento.getString("nombre"),
                        documento.getString("apellido"),
                        documento.getString("usuario"),
                        documento.getString("contraseña"),
                        documento.getInteger("telefono")
                );
                usuarios.add(usuario);
            }
        }

        return usuarios;
    }

    @Override
    public Usuario extraerPersonaID(String id) {
        Usuario usuario = null;

        try {
            ObjectId objectId = new ObjectId(id);
            Document filtro = new Document("_id", objectId);

            MongoCursor<Document> cursor = usuarioCollection.find(filtro).iterator();

            if (cursor.hasNext()) {
                Document documentoUsuario = cursor.next();
                usuario = new Usuario(
                        documentoUsuario.getString("nombre"),
                        documentoUsuario.getString("apellido"),
                        documentoUsuario.getString("usuario"),
                        documentoUsuario.getString("contraseña"),
                        documentoUsuario.getInteger("telefono")
                );
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ID no válido: " + id);
        } catch (MongoException e) {
            System.out.println("Error al extraer el usuario: " + e);
        }

        return usuario;
    }

    @Override
    public boolean actualizarDatos(Usuario user) {
        boolean respuesta = false;
        try {
            ObjectId objectId = new ObjectId(user.getId());
            Document filtro = new Document("_id", objectId);
            MongoCursor<Document> cursor = usuarioCollection.find(filtro).iterator();
            if (cursor.hasNext()) {
                // Construir el documento con los campos a actualizar
                Document documento = new Document("$set", new Document("nombre", user.getNombre())
                        .append("apellido", user.getApellido())
                        .append("usuario", user.getNombre_usuario())
                        .append("contraseña", user.getContraseña())
                        .append("telefono", user.getTelefono()));
                usuarioCollection.updateOne(filtro, documento);
                respuesta = true;
            }

        } catch (MongoException mongoException) {
            System.out.println("No se pudo actualizar los datos: " + mongoException
            );

        }
        return respuesta;
    }

    @Override
    public boolean eliminarPersona(String id) {
        boolean respuesta = false;
        try {
            ObjectId objectId = new ObjectId(id);
            Document filtro = new Document("_id", objectId);
            MongoCursor<Document> cursor = usuarioCollection.find(filtro).iterator();
            if (cursor.hasNext()) {
                usuarioCollection.deleteOne(filtro);
                respuesta = true;
            }

        } catch (MongoException e) {
            System.out.println("No se pudo eliminar" + e);
        }
        return respuesta;
    }

}
