package modelo;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class Administrador extends Usuario{
    
    private String cargo;
    private double sueldo;
    public Administrador(String id, String nombre, String Apellido, String nombre_usuario, String contraseña, int telefono, String cargo, double sueldo){
        super(id, nombre, Apellido, nombre_usuario, contraseña, telefono);
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public Administrador(String cargo, double sueldo, String nombre, String Apellido, String nombre_usuario, String contraseña, int telefono) {
        super(nombre, Apellido, nombre_usuario, contraseña, telefono);
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public Administrador(String nombre_usuario, String contraseña) {
        super(nombre_usuario, contraseña);
    }
    
    public Administrador(){
        
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Administrador{" + "cargo=" + cargo + ", sueldo=" + sueldo + '}';
    }
    
}
