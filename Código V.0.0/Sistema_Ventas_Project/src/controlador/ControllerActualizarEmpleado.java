package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.AdministradorDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import org.bson.types.ObjectId;
import vista.FrmCambiarContraseña;
import vista.FrmMenu;
import vista.PnlActualizarEmpleados;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerActualizarEmpleado implements MouseListener, KeyListener {

    private PnlActualizarEmpleados pnlActualizarEmpleados;
    private UsuarioDAO usuarioDAO;
    private ObjectId objectIDInicioSecion;
    private ObjectId objectIdTablaSeleccionada;

    public ControllerActualizarEmpleado(PnlActualizarEmpleados pnlActualizarEmpleados, UsuarioDAO usuarioDAO) {
        this.pnlActualizarEmpleados = pnlActualizarEmpleados;
        this.usuarioDAO = usuarioDAO;
        this.pnlActualizarEmpleados.getTxtNombreEmpleado().addMouseListener(this);
        this.pnlActualizarEmpleados.getTxtApellidoEmpleado().addMouseListener(this);
        this.pnlActualizarEmpleados.getTxtUsuarioEmpleado().addMouseListener(this);
        this.pnlActualizarEmpleados.getTxtTelefonoEmpleado().addMouseListener(this);
        this.pnlActualizarEmpleados.getTxtCedulaEmpleado().addMouseListener(this);
        this.pnlActualizarEmpleados.getTxtSueldoEmpleado().addMouseListener(this);
        this.pnlActualizarEmpleados.getTxtNombreEmpleado().addKeyListener(this);
        this.pnlActualizarEmpleados.getTxtApellidoEmpleado().addKeyListener(this);
        this.pnlActualizarEmpleados.getTxtUsuarioEmpleado().addKeyListener(this);
        this.pnlActualizarEmpleados.getTxtTelefonoEmpleado().addKeyListener(this);
        this.pnlActualizarEmpleados.getTxtCedulaEmpleado().addKeyListener(this);
        this.pnlActualizarEmpleados.getTxtSueldoEmpleado().addKeyListener(this);
        this.pnlActualizarEmpleados.getBtnGuardar().addKeyListener(this);
        this.pnlActualizarEmpleados.getBtnGuardar().addMouseListener(this);
        this.pnlActualizarEmpleados.getBtnCambiarContrasenia().addMouseListener(this);
    }

    public ObjectId getObjectIDInicioSecion() {
        return objectIDInicioSecion;
    }

    public void setObjectIDInicioSecion(ObjectId objectIDInicioSecion) {
        this.objectIDInicioSecion = objectIDInicioSecion;
    }

    public ObjectId getObjectIdTablaSeleccionada() {
        return objectIdTablaSeleccionada;
    }

    public void setObjectIdTablaSeleccionada(ObjectId objectIdTablaSeleccionada) {
        this.objectIdTablaSeleccionada = objectIdTablaSeleccionada;
    }

    public void iniciar(ObjectId objectId) {
        this.objectIdTablaSeleccionada = objectId;
        extrarDatosEmpleado(objectId);
        mostrarLetrasNegras();
        cambiarBackground();
        validarDatos();
    }

    public void mostrarLetrasNegras() {
        pnlActualizarEmpleados.getTxtNombreEmpleado().setForeground(Color.BLACK);
        pnlActualizarEmpleados.getTxtApellidoEmpleado().setForeground(Color.BLACK);
        pnlActualizarEmpleados.getTxtTelefonoEmpleado().setForeground(Color.BLACK);
        pnlActualizarEmpleados.getTxtCedulaEmpleado().setForeground(Color.BLACK);
        pnlActualizarEmpleados.getTxtUsuarioEmpleado().setForeground(Color.BLACK);
        pnlActualizarEmpleados.getTxtSueldoEmpleado().setForeground(Color.BLACK);
    }

    public void cambiarBackground() {
        pnlActualizarEmpleados.getTxtNombreEmpleado().setBackground(Color.WHITE);
        pnlActualizarEmpleados.getTxtApellidoEmpleado().setBackground(Color.WHITE);
        pnlActualizarEmpleados.getTxtTelefonoEmpleado().setBackground(Color.WHITE);
        pnlActualizarEmpleados.getTxtCedulaEmpleado().setBackground(Color.WHITE);
        pnlActualizarEmpleados.getTxtUsuarioEmpleado().setBackground(Color.WHITE);
        pnlActualizarEmpleados.getTxtSueldoEmpleado().setBackground(Color.WHITE);
    }

    public void extrarDatosEmpleado(ObjectId cedula) {
        mostrarLetrasNegras();
        Usuario usuario = usuarioDAO.extraerPersonaID("_id", cedula);
        pnlActualizarEmpleados.getTxtNombreEmpleado().setText(usuario.getNombre());
        pnlActualizarEmpleados.getTxtApellidoEmpleado().setText(usuario.getApellido());
        pnlActualizarEmpleados.getTxtTelefonoEmpleado().setText(usuario.getTelefono());
        pnlActualizarEmpleados.getTxtUsuarioEmpleado().setText(usuario.getNombre_usuario());
        pnlActualizarEmpleados.getTxtCedulaEmpleado().setText(usuario.getCedula());
        pnlActualizarEmpleados.getTxtSueldoEmpleado().setText(String.valueOf(usuario.getSueldoEmpleado()));

    }

    public void animmacionTextoCedulaEmpleado() {
        if (pnlActualizarEmpleados.getTxtCedulaEmpleado().getText().equals("Ingrese la cédula del empleado")) {
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setText("");
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setForeground(Color.BLACK);
        }

        if (pnlActualizarEmpleados.getTxtNombreEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtNombreEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        }

        if (pnlActualizarEmpleados.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }

        if (pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        }

        if (pnlActualizarEmpleados.getTxtTelefonoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        }

        if (pnlActualizarEmpleados.getTxtSueldoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
        }
    }

    public void animacionTextoNombre() {
        if (pnlActualizarEmpleados.getTxtNombreEmpleado().getText().equals("Ingrese el nombre del empleado")) {
            pnlActualizarEmpleados.getTxtNombreEmpleado().setText("");
            pnlActualizarEmpleados.getTxtNombreEmpleado().setForeground(Color.BLACK);
        }

        if (pnlActualizarEmpleados.getTxtCedulaEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        }

        if (pnlActualizarEmpleados.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }

        if (pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        }

        if (pnlActualizarEmpleados.getTxtTelefonoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        }

        if (pnlActualizarEmpleados.getTxtSueldoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
        }
    }

    public void animacionTextoApellido() {
        if (pnlActualizarEmpleados.getTxtApellidoEmpleado().getText().equals("Ingrese el apellido del empleado")) {
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setText("");
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setForeground(Color.BLACK);
        }

        if (pnlActualizarEmpleados.getTxtNombreEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtNombreEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        }

        if (pnlActualizarEmpleados.getTxtCedulaEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        }

        if (pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        }

        if (pnlActualizarEmpleados.getTxtTelefonoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        }

        if (pnlActualizarEmpleados.getTxtSueldoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
        }
    }

    public void animacionTextoTelefono() {
        if (pnlActualizarEmpleados.getTxtTelefonoEmpleado().getText().equals("Ingrese el número de teléfono")) {
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setText("");
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setForeground(Color.BLACK);
        }

        if (pnlActualizarEmpleados.getTxtNombreEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtNombreEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        }

        if (pnlActualizarEmpleados.getTxtCedulaEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        }

        if (pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        }

        if (pnlActualizarEmpleados.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }

        if (pnlActualizarEmpleados.getTxtSueldoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
        }
    }

    public void animacionTextoUsuario() {
        if (pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().equals("Ingrese el nombre de usuario")) {
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setText("");
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setForeground(Color.BLACK);
        }

        if (pnlActualizarEmpleados.getTxtTelefonoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        }

        if (pnlActualizarEmpleados.getTxtNombreEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtNombreEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        }

        if (pnlActualizarEmpleados.getTxtCedulaEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        }

        if (pnlActualizarEmpleados.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }

        if (pnlActualizarEmpleados.getTxtSueldoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
        }
    }

    public void animacionTextoSueldo() {
        if (pnlActualizarEmpleados.getTxtSueldoEmpleado().getText().equals("Ingrese el sueldo del empleado")) {
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setText("");
            pnlActualizarEmpleados.getTxtSueldoEmpleado().setForeground(Color.BLACK);
        }

        if (pnlActualizarEmpleados.getTxtNombreEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtNombreEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        }

        if (pnlActualizarEmpleados.getTxtCedulaEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        }

        if (pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        }

        if (pnlActualizarEmpleados.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }

        if (pnlActualizarEmpleados.getTxtTelefonoEmpleado().getText().isEmpty()) {
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
            pnlActualizarEmpleados.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        }
    }

    public void cambiarColorTextosGray() {
        pnlActualizarEmpleados.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
        pnlActualizarEmpleados.getTxtApellidoEmpleado().setForeground(Color.GRAY);
        pnlActualizarEmpleados.getTxtNombreEmpleado().setForeground(Color.GRAY);
        pnlActualizarEmpleados.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
        pnlActualizarEmpleados.getTxtCedulaEmpleado().setForeground(Color.GRAY);
        pnlActualizarEmpleados.getTxtSueldoEmpleado().setForeground(Color.GRAY);
    }

    public void vaciarCampos() {
        pnlActualizarEmpleados.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        pnlActualizarEmpleados.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        pnlActualizarEmpleados.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        pnlActualizarEmpleados.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        pnlActualizarEmpleados.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        pnlActualizarEmpleados.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == pnlActualizarEmpleados.getBtnGuardar()) {
            actualizarDatos();
        }
        
        if(e.getSource() == pnlActualizarEmpleados.getBtnCambiarContrasenia()){
            inicairFrmCambiarContrasennia();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == pnlActualizarEmpleados.getTxtApellidoEmpleado()) {
            pnlActualizarEmpleados.getLblTextoAlertaEmpleado().setText("");
            pnlActualizarEmpleados.getLblTextoApellido().setText("");
            pnlActualizarEmpleados.getLblTextoAlertaCedula().setText("");
            pnlActualizarEmpleados.getLblAlertaTextoTelefono().setText("");
            pnlActualizarEmpleados.getLblAlertaTextoSueldo().setText("");
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtNombreEmpleado()) {
            pnlActualizarEmpleados.getLblTextoAlertaEmpleado().setText("");
            pnlActualizarEmpleados.getLblTextoApellido().setText("");
            pnlActualizarEmpleados.getLblTextoAlertaCedula().setText("");
            pnlActualizarEmpleados.getLblAlertaTextoTelefono().setText("");
            pnlActualizarEmpleados.getLblAlertaTextoSueldo().setText("");
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtUsuarioEmpleado()) {
            pnlActualizarEmpleados.getLblTextoAlertaEmpleado().setText("");
            pnlActualizarEmpleados.getLblTextoApellido().setText("");
            pnlActualizarEmpleados.getLblTextoAlertaCedula().setText("");
            pnlActualizarEmpleados.getLblAlertaTextoTelefono().setText("");
            pnlActualizarEmpleados.getLblAlertaTextoSueldo().setText("");
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtCedulaEmpleado()) {
            pnlActualizarEmpleados.getLblTextoAlertaEmpleado().setText("");
            pnlActualizarEmpleados.getLblTextoApellido().setText("");
            pnlActualizarEmpleados.getLblTextoAlertaCedula().setText("");
            pnlActualizarEmpleados.getLblAlertaTextoTelefono().setText("");
            pnlActualizarEmpleados.getLblAlertaTextoSueldo().setText("");
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtSueldoEmpleado()) {
            pnlActualizarEmpleados.getLblTextoAlertaEmpleado().setText("");
            pnlActualizarEmpleados.getLblTextoApellido().setText("");
            pnlActualizarEmpleados.getLblTextoAlertaCedula().setText("");
            pnlActualizarEmpleados.getLblAlertaTextoTelefono().setText("");
            pnlActualizarEmpleados.getLblAlertaTextoSueldo().setText("");
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtNombreEmpleado()) {
            animacionTextoNombre();
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtApellidoEmpleado()) {
            animacionTextoApellido();
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtUsuarioEmpleado()) {
            animacionTextoUsuario();
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtTelefonoEmpleado()) {
            animacionTextoTelefono();
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtCedulaEmpleado()) {
            animmacionTextoCedulaEmpleado();
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtSueldoEmpleado()) {
            animacionTextoSueldo();
        }

    }
    
    public void inicairFrmCambiarContrasennia(){
        FrmCambiarContraseña frmCambiarContraseña = new FrmCambiarContraseña(objectIdTablaSeleccionada);
        AdministradorDAO administradorDAO = new AdministradorDAO();
        ControllerCambiarContrasenia controllerCambiarContrasenia = new ControllerCambiarContrasenia(frmCambiarContraseña, administradorDAO, usuarioDAO, "Usuario");
        controllerCambiarContrasenia.iniciar("Usuario");
    }

    public void validarDatos() {
        if (this.pnlActualizarEmpleados.getTxtNombreEmpleado().getText().equals("Ingrese el nombre del empleado") || this.pnlActualizarEmpleados.getTxtNombreEmpleado().getText().isBlank()) {
            mostrarImagenAlertaNombre();
        } else {
            mostrarImagenBlancaNombre();
        }

        if (this.pnlActualizarEmpleados.getTxtApellidoEmpleado().getText().equals("Ingrese el apellido del empleado") || this.pnlActualizarEmpleados.getTxtApellidoEmpleado().getText().isBlank()) {
            mostrarImagenAlertaApellido();
        } else {
            mostrarImagenBlancaApellido();
        }

        if (this.pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().equals("Ingrese el nombre de usuario") || this.pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().isBlank()) {
            mostrarImagenAlertaUsuario();
        } else {
            mostrarImagenBlancaUsuario();
        }

        if (this.pnlActualizarEmpleados.getTxtTelefonoEmpleado().getText().equals("Ingrese el número de teléfono") || this.pnlActualizarEmpleados.getTxtTelefonoEmpleado().getText().isBlank()) {
            mostrarImagenAlertaTelefono();
        } else {
            mostrarImagenBlancaTelefono();
        }

        if (this.pnlActualizarEmpleados.getTxtCedulaEmpleado().getText().equals("Ingrese la cédula del empleado") || this.pnlActualizarEmpleados.getTxtCedulaEmpleado().getText().isBlank()) {
            mostrarImagenAlertaCedulaEmpleado();
        } else {
            mostrarImagenBlancaCedulaEmpleado();
        }

        if (this.pnlActualizarEmpleados.getTxtSueldoEmpleado().getText().equals("Ingrese el sueldo del empleado") || this.pnlActualizarEmpleados.getTxtSueldoEmpleado().getText().isBlank()) {
            mostrarImagenAlertaSueldo();
        } else {
            mostrarImagenBlancaSueldo();
        }

        if (this.pnlActualizarEmpleados.getTxtNombreEmpleado().getText().equals("Ingrese el nombre del empleado") || this.pnlActualizarEmpleados.getTxtNombreEmpleado().getText().isBlank()
                || this.pnlActualizarEmpleados.getTxtApellidoEmpleado().getText().equals("Ingrese el apellido del empleado") || this.pnlActualizarEmpleados.getTxtApellidoEmpleado().getText().isBlank()
                || this.pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().equals("Ingrese el nombre de usuario") || this.pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().isBlank()
                || this.pnlActualizarEmpleados.getTxtTelefonoEmpleado().getText().equals("Ingrese el número de teléfono") || this.pnlActualizarEmpleados.getTxtTelefonoEmpleado().getText().isBlank()
                || this.pnlActualizarEmpleados.getTxtCedulaEmpleado().getText().equals("Ingrese la cédula del empleado") || this.pnlActualizarEmpleados.getTxtCedulaEmpleado().getText().isBlank()
                || this.pnlActualizarEmpleados.getTxtSueldoEmpleado().getText().equals("Ingrese el sueldo del empleado") || this.pnlActualizarEmpleados.getTxtSueldoEmpleado().getText().isBlank()
                || !pnlActualizarEmpleados.getLblTextoSueldo().getText().isEmpty()) {
            this.pnlActualizarEmpleados.getBtnGuardar().setEnabled(false);

        } else {
            this.pnlActualizarEmpleados.getBtnGuardar().setEnabled(true);
        }

    }

    public ImageIcon activarVistoVerde() {
        java.net.URL imageURL = getClass().getResource("/img/greenSeen.png");
        ImageIcon icono = null;
        if (imageURL != null) {
            icono = new ImageIcon(imageURL);
        }
        return icono;
    }

    public void actualizar() {
        Usuario nuevoUsuario = new Usuario(pnlActualizarEmpleados.getTxtNombreEmpleado().getText(), pnlActualizarEmpleados.getTxtApellidoEmpleado().getText().trim(), pnlActualizarEmpleados.getTxtTelefonoEmpleado().getText().trim(), pnlActualizarEmpleados.getTxtCedulaEmpleado().getText().trim());
        nuevoUsuario.setNombre_usuario(pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().trim());
        nuevoUsuario.setObjectId(objectIdTablaSeleccionada);
        nuevoUsuario.setSueldoEmpleado(Double.valueOf(pnlActualizarEmpleados.getTxtSueldoEmpleado().getText()));
        nuevoUsuario.setId(pnlActualizarEmpleados.getTxtCedulaEmpleado().getText());
        usuarioDAO.actualizarDatos(nuevoUsuario);
        JOptionPane.showMessageDialog(
                null,
                "USUARIO ACTUALIZADO CON ÉXITO",
                "MESSAGE",
                JOptionPane.INFORMATION_MESSAGE,
                activarVistoVerde());
        if (usuarioDAO.verificarPersonaExistente("_id", objectIDInicioSecion)) {
            System.out.println("TRUE");
            JLabel lbl = new JLabel(nuevoUsuario.getNombre_usuario());
            FrmMenu frmMenu = FrmMenu.getInstance(lbl.getText());
            frmMenu.getLblNombreUsuarioLoing().setText(lbl.getText());
            frmMenu.getLblNombreUsuarioLoing().setVisible(true);
        }
    }

    public void actualizarDatos() {
        AdministradorDAO administradorDAO = new AdministradorDAO();
        String nombreUsuario = pnlActualizarEmpleados.getTxtUsuarioEmpleado().getText().trim();
        Usuario usuario = usuarioDAO.extraerPersonaID("_id",objectIdTablaSeleccionada);
        if (!nombreUsuario.equals(usuario.getNombre_usuario())) {
            boolean usuarioExistente = usuarioDAO.verificarPersonaExistente("usuario", nombreUsuario);
            boolean administradorExistente = administradorDAO.verificarPersonaExistente("administrador", nombreUsuario);
            if ((usuarioExistente == true) || (administradorExistente == true)) {
                JOptionPane.showMessageDialog(null, "ESTE NOMBRE DE USUARIO YA ESTÁ REGISTRADO EN USUARIOS O ADMINISTRADORES\n               DIGITE OTRO NOMBRE DE USUARIO!", "MESSAGE", JOptionPane.ERROR_MESSAGE);
                pnlActualizarEmpleados.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
                pnlActualizarEmpleados.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
                validarDatos();
            } else {
                actualizar();

            }
        } else {
            actualizar();
        }
    }

    public void mostrarImagenAlertaUsuario() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblAlertaUsuario().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaUsuario() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblAlertaUsuario().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaCedulaEmpleado() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblCedulaEmpleado().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaCedulaEmpleado() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblCedulaEmpleado().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaNombre() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblAlertaNombre().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaNombre() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblAlertaNombre().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaApellido() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblAlertaApellido().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaApellido() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblAlertaApellido().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaTelefono() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblAlertaTelefono().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaTelefono() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblAlertaTelefono().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaSueldo() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblAlertaSueldo().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaSueldo() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlActualizarEmpleados.getLblAlertaSueldo().setIcon(icono);
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == pnlActualizarEmpleados.getTxtNombreEmpleado()) {
            validarDatos();
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtApellidoEmpleado()) {
            validarDatos();
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtUsuarioEmpleado()) {
            validarDatos();
        }
        if (e.getSource() == pnlActualizarEmpleados.getTxtCedulaEmpleado()) {
            validarDatos();
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtTelefonoEmpleado()) {
            validarDatos();
        }

        if (e.getSource() == pnlActualizarEmpleados.getTxtSueldoEmpleado()) {
            validarDatos();
            if (!ControllerNuevoAdministrador.esSueldoValido(pnlActualizarEmpleados.getTxtSueldoEmpleado().getText())) {
                pnlActualizarEmpleados.getLblTextoSueldo().setForeground(Color.red);
                pnlActualizarEmpleados.getLblTextoSueldo().setText("El sueldo no tiene el formato correcto");
            } else {
                pnlActualizarEmpleados.getLblTextoSueldo().setText("");
            }
            validarDatos();
        }
        if (e.getSource() == pnlActualizarEmpleados.getTxtCedulaEmpleado()) {
            validarDatos();
        }
    }

}
