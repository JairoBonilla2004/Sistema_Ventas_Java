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
                    .append("cedula", usuario.getCedula())
                    .append("sueldo", usuario.getSueldoEmpleado());

            usuarioCollection.insertOne(nuevoDocumento_usuario);
            respuesta = true;
        } catch (MongoException e) {
            System.out.println("Error al enviar el usuario a la base de datos porque " + e);
        }
        return respuesta;
    }

    @Override
    public <TypeBusqueda> boolean verificarPersonaExistente(String keyBusqueda, TypeBusqueda typeBusqueda) {
        boolean respuesta = true;
        Document filtro = new Document(keyBusqueda, typeBusqueda);
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
                        documentos_dataBase.getString("telefono"));
                usuario.setSueldoEmpleado(documentos_dataBase.getDouble("sueldo"));
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
                        documento.getString("cedula"),
                        documento.getString("nombre"),
                        documento.getString("apellido"),
                        documento.getString("usuario"),
                        documento.getString("contraseña"),
                        documento.getString("telefono")
                );
                usuarios.add(usuario);
            }
        }

        return usuarios;
    }

    @Override
    public <TypeBusqueda> Usuario extraerPersonaID(String keyBusqueda, TypeBusqueda typeBusqueda) {
        Usuario usuario = null;

        try {
            Document filtro = null;
            if (keyBusqueda.equals("cedula")) {
                filtro = new Document("cedula", typeBusqueda);
            }
            if(keyBusqueda.equals("_id")){
                filtro = new Document("_id", typeBusqueda );
            }

            MongoCursor<Document> cursor = usuarioCollection.find(filtro).iterator();

            if (cursor.hasNext()) {
                Document documentoUsuario = cursor.next();
                usuario = new Usuario(
                        documentoUsuario.getString("nombre"),
                        documentoUsuario.getString("apellido"),
                        documentoUsuario.getString("usuario"),
                        documentoUsuario.getString("contraseña"),
                        documentoUsuario.getString("telefono")
                );
                usuario.setCedula(documentoUsuario.getString("cedula"));
                usuario.setSueldoEmpleado(documentoUsuario.getDouble("sueldo"));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ID no válido: " + keyBusqueda);
        } catch (MongoException e) {
            System.out.println("Error al extraer el usuario: " + e);
        }

        return usuario;
    }

    @Override
    public boolean actualizarDatos(Usuario user) {
        boolean respuesta = false;
        try {
            Document filtro = new Document("_id", user.getObjectId());
            MongoCursor<Document> cursor = usuarioCollection.find(filtro).iterator();
            if (cursor.hasNext()) {
                // Construir el documento con los campos a actualizar
                Document documento = new Document("$set", new Document("nombre", user.getNombre())
                        .append("apellido", user.getApellido())
                        .append("usuario", user.getNombre_usuario())
                        .append("telefono", user.getTelefono())
                        .append("cedula", user.getId())
                        .append("sueldo", user.getSueldoEmpleado()));
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
            Document filtro = new Document("cedula", id);
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
    
    public Usuario buscarEmpleadoPorUsuario(String nombreUsuario){
        Document filtro = new Document("usuario", nombreUsuario);
        Usuario usuario = null;
        MongoCursor<Document> cursor = usuarioCollection.find(filtro).iterator();
        if(cursor.hasNext()){
            Document documentoDB = cursor.next();
            usuario = new Usuario();
            usuario.setObjectId(documentoDB.getObjectId("_id"));
            usuario.setNombre_usuario(documentoDB.getString("usuario"));
        }
        return usuario;
    }

}
