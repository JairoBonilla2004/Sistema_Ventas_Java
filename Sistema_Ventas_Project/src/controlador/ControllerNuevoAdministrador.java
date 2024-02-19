package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Administrador;
import modelo.AdministradorDAO;
import vista.PnlNuevoAdministrador;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerNuevoAdministrador implements MouseListener{
    
    private PnlNuevoAdministrador pnlNuevoAdministrador;
    private AdministradorDAO administradorDAO;
    private Administrador administrador;

    public ControllerNuevoAdministrador(PnlNuevoAdministrador pnlNuevoAdministrador, AdministradorDAO administradorDAO, Administrador administrador) {
        this.pnlNuevoAdministrador = pnlNuevoAdministrador;
        this.administradorDAO = administradorDAO;
        this.administrador = administrador;
        this.pnlNuevoAdministrador.getTxtNombre().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtApellido().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtNombreUsuario().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtCargo().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtCedula().addMouseListener(this);
        this.pnlNuevoAdministrador.getPswContrasenia().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtSueldo().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtTelefono().addMouseListener(this);
    }
    
    public void iniciarComponentes(){
        pnlNuevoAdministrador.getTxtNombre().setBackground(Color.WHITE);
        pnlNuevoAdministrador.getTxtApellido().setBackground(Color.WHITE);
        pnlNuevoAdministrador.getTxtNombreUsuario().setBackground(Color.WHITE);
        pnlNuevoAdministrador.getTxtCargo().setBackground(Color.WHITE);
        pnlNuevoAdministrador.getTxtCedula().setBackground(Color.WHITE);
        pnlNuevoAdministrador.getPswContrasenia().setBackground(Color.WHITE);
        pnlNuevoAdministrador.getTxtSueldo().setBackground(Color.WHITE);
        pnlNuevoAdministrador.getTxtTelefono().setBackground(Color.WHITE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == pnlNuevoAdministrador.getTxtNombre()){
            animmacionTextoNombre();
        }
        
        if(e.getSource() == pnlNuevoAdministrador.getTxtApellido()){
            animacionTextoApellido();
        }
        
        if(e.getSource() == pnlNuevoAdministrador.getTxtNombreUsuario()){
            animacionTextoUsuarioAdministrador();
        }
        
        if(e.getSource() == pnlNuevoAdministrador.getTxtCedula()){
            animacionTextoCedula();
        }
        if(e.getSource() == pnlNuevoAdministrador.getTxtTelefono()){
            animacionTextoTelefono();
        }
        
        if(e.getSource() == pnlNuevoAdministrador.getTxtCargo()){
            animmacionTextoCargo();
        }
        
        if(e.getSource() == pnlNuevoAdministrador.getTxtSueldo()){
            animacionTextoSueldo();
        }
        
        if(e.getSource() == pnlNuevoAdministrador.getPswContrasenia()){
            animmacionPswContraseña();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
     public void animmacionTextoNombre() {
        if (pnlNuevoAdministrador.getTxtNombre().getText().equals("Ingrese su nombre")) {
            pnlNuevoAdministrador.getTxtNombre().setText("");
            pnlNuevoAdministrador.getTxtNombre().setForeground(Color.BLACK);
        }

        if (pnlNuevoAdministrador.getTxtApellido().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtApellido().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlNuevoAdministrador.getTxtNombreUsuario().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombreUsuario().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombreUsuario().setText("Ingrese el nombre del administrador");
        }

        if (pnlNuevoAdministrador.getPswContrasenia().getText().isEmpty()) {
            pnlNuevoAdministrador.getPswContrasenia().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getPswContrasenia().setText("*******************************");
        }

        if (pnlNuevoAdministrador.getTxtTelefono().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtTelefono().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtTelefono().setText("Ingrese su número de telefono");
        }

        if (pnlNuevoAdministrador.getTxtCargo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCargo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }

        if (pnlNuevoAdministrador.getTxtSueldo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtSueldo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtSueldo().setText("Sueldo del Administrador");

        }

        if (pnlNuevoAdministrador.getTxtCedula().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCedula().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCedula().setText("Ingrese la cédula del Administrador");
        }
    }

    public void animacionTextoApellido() {
        if (pnlNuevoAdministrador.getTxtApellido().getText().equals("Ingrese el apellido del usuario")) {
            pnlNuevoAdministrador.getTxtApellido().setText("");
            pnlNuevoAdministrador.getTxtApellido().setForeground(Color.BLACK);
        }

        if (pnlNuevoAdministrador.getTxtNombre().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombre().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombre().setText("Ingrese su nombre");
        }

        if (pnlNuevoAdministrador.getTxtNombreUsuario().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombreUsuario().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombreUsuario().setText("Ingrese el nombre del administrador");
        }

        if (pnlNuevoAdministrador.getPswContrasenia().getText().isEmpty()) {
            pnlNuevoAdministrador.getPswContrasenia().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getPswContrasenia().setText("*******************************");
        }

        if (pnlNuevoAdministrador.getTxtTelefono().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtTelefono().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtTelefono().setText("Ingrese su número de telefono");
        }

        if (pnlNuevoAdministrador.getTxtCargo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCargo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }

        if (pnlNuevoAdministrador.getTxtSueldo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtSueldo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtSueldo().setText("Sueldo del Administrador");
        }

        if (pnlNuevoAdministrador.getTxtCedula().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCedula().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCedula().setText("Ingrese la cédula del Administrador");
        }
    }

    public void animacionTextoUsuarioAdministrador() {
        if (pnlNuevoAdministrador.getTxtNombreUsuario().getText().equals("Ingrese el nombre del administrador")) {
            pnlNuevoAdministrador.getTxtNombreUsuario().setText("");
            pnlNuevoAdministrador.getTxtNombreUsuario().setForeground(Color.BLACK);
        }

        if (pnlNuevoAdministrador.getTxtNombre().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombre().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombre().setText("Ingrese su nombre");
        }

        if (pnlNuevoAdministrador.getTxtApellido().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtApellido().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlNuevoAdministrador.getPswContrasenia().getText().isEmpty()) {
            pnlNuevoAdministrador.getPswContrasenia().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getPswContrasenia().setText("*******************************");
        }

        if (pnlNuevoAdministrador.getTxtTelefono().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtTelefono().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtTelefono().setText("Ingrese su número de telefono");
        }

        if (pnlNuevoAdministrador.getTxtCargo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCargo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }

        if (pnlNuevoAdministrador.getTxtSueldo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtSueldo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtSueldo().setText("Sueldo del Administrador");

        }

        if (pnlNuevoAdministrador.getTxtCedula().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCedula().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCedula().setText("Ingrese la cédula del Administrador");
        }

    }

    public void animmacionPswContraseña() {
        if (pnlNuevoAdministrador.getPswContrasenia().getText().equals("*******************************")) {
            pnlNuevoAdministrador.getPswContrasenia().setText("");
            pnlNuevoAdministrador.getPswContrasenia().setForeground(Color.BLACK);
        }

        if (pnlNuevoAdministrador.getTxtApellido().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtApellido().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlNuevoAdministrador.getTxtNombreUsuario().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombreUsuario().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombreUsuario().setText("Ingrese el nombre del administrador");
        }

        if (pnlNuevoAdministrador.getTxtNombre().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombre().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombre().setText("Ingrese su nombre");
        }

        if (pnlNuevoAdministrador.getTxtTelefono().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtTelefono().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtTelefono().setText("Ingrese su número de telefono");
        }

        if (pnlNuevoAdministrador.getTxtCargo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCargo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }
        if (pnlNuevoAdministrador.getTxtSueldo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtSueldo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtSueldo().setText("Sueldo del Administrador");
        }

        if (pnlNuevoAdministrador.getTxtCedula().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCedula().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCedula().setText("Ingrese la cédula del Administrador");
        }
    }

    public void animmacionTextoCargo() {
        if (pnlNuevoAdministrador.getTxtCargo().getText().equals("Ingrese su cargo en la empresa")) {
            pnlNuevoAdministrador.getTxtCargo().setText("");
            pnlNuevoAdministrador.getTxtCargo().setForeground(Color.BLACK);
        }

        if (pnlNuevoAdministrador.getTxtNombre().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombre().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombre().setText("Ingrese su nombre");
        }

        if (pnlNuevoAdministrador.getTxtApellido().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtApellido().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlNuevoAdministrador.getTxtNombreUsuario().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombreUsuario().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombreUsuario().setText("Ingrese el nombre del administrador");
        }

        if (pnlNuevoAdministrador.getTxtTelefono().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtTelefono().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtTelefono().setText("Ingrese su número de telefono");
        }

        if (pnlNuevoAdministrador.getPswContrasenia().getText().isEmpty()) {
            pnlNuevoAdministrador.getPswContrasenia().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getPswContrasenia().setText("*******************************");
        }

        if (pnlNuevoAdministrador.getTxtSueldo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtSueldo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtSueldo().setText("Sueldo del Administrador");

        }

        if (pnlNuevoAdministrador.getTxtCedula().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCedula().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCedula().setText("Ingrese la cédula del Administrador");
        }
    }

    public void animacionTextoTelefono() {
        if (pnlNuevoAdministrador.getTxtTelefono().getText().equals("Ingrese su número de telefono")) {
            pnlNuevoAdministrador.getTxtTelefono().setText("");
            pnlNuevoAdministrador.getTxtTelefono().setForeground(Color.BLACK);
        }

        if (pnlNuevoAdministrador.getTxtNombre().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombre().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombre().setText("Ingrese su nombre");
        }

        if (pnlNuevoAdministrador.getTxtApellido().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtApellido().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlNuevoAdministrador.getPswContrasenia().getText().isEmpty()) {
            pnlNuevoAdministrador.getPswContrasenia().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getPswContrasenia().setText("*******************************");
        }

        if (pnlNuevoAdministrador.getTxtNombreUsuario().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombreUsuario().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombreUsuario().setText("Ingrese el nombre del administrador");
        }

        if (pnlNuevoAdministrador.getTxtCargo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCargo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }

        if (pnlNuevoAdministrador.getTxtSueldo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtSueldo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtSueldo().setText("Sueldo del Administrador");

        }

        if (pnlNuevoAdministrador.getTxtCedula().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCedula().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCedula().setText("Ingrese la cédula del Administrador");
        }
    }

    public void animacionTextoSueldo() {
        if (pnlNuevoAdministrador.getTxtSueldo().getText().equals("Sueldo del Administrador")) {
            pnlNuevoAdministrador.getTxtSueldo().setText("");
            pnlNuevoAdministrador.getTxtSueldo().setForeground(Color.BLACK);
        }

        if (pnlNuevoAdministrador.getTxtNombre().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombre().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombre().setText("Ingrese su nombre");
        }
        
        if (pnlNuevoAdministrador.getTxtTelefono().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtTelefono().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtTelefono().setText("Ingrese su número de telefono");
        }

        if (pnlNuevoAdministrador.getTxtApellido().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtApellido().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlNuevoAdministrador.getPswContrasenia().getText().isEmpty()) {
            pnlNuevoAdministrador.getPswContrasenia().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getPswContrasenia().setText("*******************************");
        }

        if (pnlNuevoAdministrador.getTxtNombreUsuario().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombreUsuario().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombreUsuario().setText("Ingrese el nombre del administrador");
        }

        if (pnlNuevoAdministrador.getTxtCargo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCargo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }
        

        if (pnlNuevoAdministrador.getTxtCedula().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCedula().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCedula().setText("Ingrese la cédula del Administrador");
        }

    }
    
    public void animacionTextoCedula() {
        if (pnlNuevoAdministrador.getTxtCedula().getText().equals("Ingrese la cédula del Administrador")) {
            pnlNuevoAdministrador.getTxtCedula().setText("");
            pnlNuevoAdministrador.getTxtCedula().setForeground(Color.BLACK);
        }

        if (pnlNuevoAdministrador.getTxtSueldo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtSueldo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtSueldo().setText("Sueldo del Administrador");

        }

        if (pnlNuevoAdministrador.getTxtNombre().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombre().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombre().setText("Ingrese su nombre");
        }

        if (pnlNuevoAdministrador.getTxtApellido().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtApellido().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlNuevoAdministrador.getPswContrasenia().getText().isEmpty()) {
            pnlNuevoAdministrador.getPswContrasenia().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getPswContrasenia().setText("*******************************");
        }

        if (pnlNuevoAdministrador.getTxtNombreUsuario().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtNombreUsuario().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtNombreUsuario().setText("Ingrese el nombre del administrador");
        }

        if (pnlNuevoAdministrador.getTxtCargo().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtCargo().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }

        if (pnlNuevoAdministrador.getTxtTelefono().getText().isEmpty()) {
            pnlNuevoAdministrador.getTxtTelefono().setForeground(Color.GRAY);
            pnlNuevoAdministrador.getTxtTelefono().setText("Ingrese su número de telefono");
        }

    }

    
            
    
}
