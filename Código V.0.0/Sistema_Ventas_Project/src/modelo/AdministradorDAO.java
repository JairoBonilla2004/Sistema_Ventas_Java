package modelo;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
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
public class AdministradorDAO implements PersonaDAO<Administrador> {

    private final MongoCollection<Document> collection;

    public AdministradorDAO() {
        DBConexion dBConexion = DBConexion.getInstance("Sistema_Ventas");
        collection = dBConexion.getDatabase().getCollection("Administradores");
    }

    public boolean verificarCamposCorrectosUsuario(Administrador administrador) {
        Document filtro = new Document("$and", Arrays.asList(
                new Document("administrador", administrador.getNombre_usuario()),
                new Document("contraseña", administrador.getContraseña())));
        MongoCursor<Document> cursor = collection.find(filtro).iterator();
        while (cursor.hasNext()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean enviarPesonasDB(Administrador administrador) {
        boolean respuesta = false;
        try {
            Document document = new Document("nombre", administrador.getNombre())
                    .append("administrador", administrador.getNombre_usuario())
                    .append("contraseña", administrador.getContraseña())
                    .append("telefono", administrador.getTelefono())
                    .append("cargo", administrador.getCargo())
                    .append("sueldo", administrador.getSueldo())
                    .append("apellido", administrador.getApellido())
                    .append("cedula", administrador.getCedula());

            collection.insertOne(document);
            respuesta = true;
        } catch (MongoException mongoException) {
            System.out.println("No se pudo enviar los administradores: " + mongoException);
        }
        return respuesta;
    }

    @Override
    public <TypeBusqueda> boolean verificarPersonaExistente(String keyBusqueda, TypeBusqueda user_administrador) {
        boolean respuesta = false;
        try {
            Document filtro = new Document(keyBusqueda, user_administrador);
            MongoCursor<Document> cursor = collection.find(filtro).iterator();
            respuesta = cursor.hasNext();
        } catch (MongoException mongoException) {
            System.out.println("No se pudo realizar la consulta: " + mongoException);
        }
        return respuesta;
    }

    @Override
    public List<Administrador> extraerPersonas() {
        List<Administrador> administradores = new ArrayList<>();
        try {
            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Document documento_administrador = cursor.next();
                Administrador administrador = new Administrador(
                        documento_administrador.getObjectId("_id").toString(),
                        documento_administrador.getString("nombre"),
                        documento_administrador.getString("apellido"),
                        documento_administrador.getString("administrador"),
                        documento_administrador.getString("contraseña"),
                        documento_administrador.getString("telefono"),
                        documento_administrador.getString("cargo"),
                        documento_administrador.getDouble("sueldo"));
                administrador.setCedula(documento_administrador.getString("cedula"));
                administradores.add(administrador);

            }
        } catch (MongoException mongoException) {
            System.out.println("No se pudo extraer los administradores " + mongoException);
        }
        return administradores;
    }

    @Override
    public List<Administrador> buscarPersonasPorTextoRegEx(String textoBuscado) {
        List<Administrador> administradores = new ArrayList<>();
        try {
            Bson filtroRegex = Filters.or(
                    Filters.regex("nombre", "^" + textoBuscado, "i"));
            MongoCursor<Document> cursor = collection.find(filtroRegex).iterator();
            while (cursor.hasNext()) {
                Document documento_administrador = cursor.next();
                Administrador administrador = new Administrador(
                        documento_administrador.getObjectId("_id").toString(),
                        documento_administrador.getString("nombre"),
                        documento_administrador.getString("apellido"),
                        documento_administrador.getString("administrador"),
                        documento_administrador.getString("contraseña"),
                        documento_administrador.getString("telefono"),
                        documento_administrador.getString("cargo"),
                        documento_administrador.getDouble("sueldo"));
                administrador.setCedula(documento_administrador.getString("cedula"));
                administradores.add(administrador);
            }

        } catch (MongoException mongoException) {
            System.out.println("No se pudo extrar los administradores de la base de datos " + mongoException);
        }
        return administradores;
    }

    @Override
    public <Type> Administrador extraerPersonaID(String keybusqueda, Type id) {
        Administrador administrador = null;
        try {
            Document filtro = new Document(keybusqueda, id);
            MongoCursor<Document> cursor = collection.find(filtro).iterator();
            if (cursor.hasNext()) {
                Document document_database = cursor.next();
                administrador = new Administrador(
                        document_database.getString("cargo"),
                        document_database.getDouble("sueldo"),
                        document_database.getString("nombre"),
                        document_database.getString("apellido"),
                        document_database.getString("administrador"),
                        document_database.getString("contraseña"),
                        document_database.getString("telefono"));
                administrador.setCedula(document_database.getString("cedula"));

            }

        } catch (MongoException mongoException) {
            System.out.println("no se pudo extrar el Administrador: " + mongoException);
        }
        return administrador;
    }

    @Override
    public boolean actualizarDatos(Administrador administrador) {
        boolean respuesta = false;
        try {
            Document filtro = new Document("_id", administrador.getObjectID());
            MongoCursor<Document> cursor = collection.find(filtro).iterator();
            if (cursor.hasNext()) {
                Document datos_actualizar = new Document("$set", new Document(
                        "nombre", administrador.getNombre())
                        .append("apellido", administrador.getApellido())
                        .append("administrador", administrador.getNombre_usuario())
                        .append("telefono", administrador.getTelefono())
                        .append("cargo", administrador.getCargo())
                        .append("sueldo", administrador.getSueldo())
                .append("cedula", administrador.getCedula()));
                UpdateResult updateResult = collection.updateOne(filtro, datos_actualizar);
                if(updateResult.getModifiedCount()>=1){
                    respuesta = true;
                }
            }
        } catch (MongoException mongoException) {
            System.out.println("No se pudo actualizar los datos del administrador" + mongoException);
        }
        return respuesta;
    }

    public boolean actualizarContraseñaAdministrador(String id, String nueva_contraseña) {
        boolean respuesta = false;
        try {
            ObjectId objectId = new ObjectId(id);
            Document filtro = new Document("_id", objectId);
            MongoCursor<Document> cursor = collection.find(filtro).iterator();
            if (cursor.hasNext()) {
                Document administrador_acturalizado = new Document("$set", new Document(
                        "contraseña", nueva_contraseña));
                collection.updateOne(filtro, administrador_acturalizado);
                respuesta = true;
            }

        } catch (MongoException mongoException) {
            System.out.println("No se pudo actualizar la contraseña " + mongoException);
        }
        return respuesta;
    }

    @Override
    public boolean eliminarPersona(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String buscarAdministradorPorNombreYapellido(String nombre, String apellido) {
        String cedula = null;
        Administrador administrador;
        try {
            Document document = new Document("$and", Arrays.asList(new Document("nombre", nombre),
                    new Document("apellido", apellido)));
            MongoCursor<Document> cursor = collection.find(document).iterator();
            if (cursor.hasNext()) {
                Document documentDB = cursor.next();
                administrador = new Administrador();
                administrador.setNombre_usuario(documentDB.getString("administrador"));
                cedula = administrador.getNombre_usuario();
            }

        } catch (MongoException e) {
            System.out.println("No se puedo extraer el cliente porque " + e);
        }
        return cedula;
    }

    public <TypoBusqueda> Administrador buscarAdministradorPorUsuario(String keybusqueda, TypoBusqueda userAdministrador) {
        Document filtro = new Document(keybusqueda, userAdministrador);
        Administrador administrador =null;
        try {
            MongoCursor<Document> cursor = collection.find(filtro).iterator();
            if(cursor.hasNext()){
                administrador = new Administrador();
                Document documento = cursor.next();
                administrador.setObject(documento.getObjectId("_id"));
                administrador.setNombre_usuario(documento.getString("administrador"));
            }
        } catch (MongoException e) {
            System.out.println("No se pudo buscar el administrador "+e);
        }
        return administrador;
    }

   

}
