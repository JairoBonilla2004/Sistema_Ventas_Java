package utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class DBConexion {

    //Atributo que sirve para retornar la instancia de la clase
    private static DBConexion dBConexion = null;
    private MongoClient mongoClient = null;//necesitamos un MongoClient para establecer la coneccion
    private final String uri = "mongodb://localhost:27017";
    private MongoDatabase database = null;

    private DBConexion(String databaseName) {//paso 1: constructor privado
        try {
            MongoClientURI mongoClientURI = new MongoClientURI(uri);
            mongoClient = new MongoClient(mongoClientURI); //Abre una coneccion con la uri que le di
            database = mongoClient.getDatabase(databaseName); //establece la coneccion con el nombre de la base de datos
            System.out.println("Coneccion exitosa");
        } catch (MongoException mongoException) {
            System.out.println("No se pudo conectar a la base de datos porque " + mongoException);
        }
    }

    //método que devuelve la instancia
    public static DBConexion getInstance(String databaseName) {//retorna la instancia de la misma clase
        if (dBConexion == null) {
            dBConexion = new DBConexion(databaseName); //instanciamos mediante la clase
        }
        return dBConexion;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void cerrarConexion() {
        mongoClient.close();
    }

}
