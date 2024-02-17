package modelo;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class Usuario {

    //Atributos
    protected String cedula;
    protected String nombre;
    protected String Apellido;
    protected String nombre_usuario;
    protected String contraseña;
    protected int telefono;
    

    public Usuario(String cedula, String nombre, String Apellido, String nombre_usuario, String contraseña, int telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.telefono = telefono;
    }

    public Usuario(String nombre, String Apellido, String nombre_usuario, String contraseña, int telefono) {
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.telefono = telefono;
    }

    public Usuario(String nombre, String Apellido, int telefono, String cedula) {
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public Usuario(String cedula, String nombre, String Apellido, int telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.telefono = telefono;
    }

    public Usuario() {

    }

    //Constructor que inicializa cada objeto
    public Usuario(String nombre_usuario, String contraseña) {
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
    }

    //Modificadores de acceso publicos
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getId() {
        return cedula;
    }

    public void setId(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre_usuario=" + nombre_usuario + ", contrase\u00f1a=" + contraseña + '}';
    }

}
