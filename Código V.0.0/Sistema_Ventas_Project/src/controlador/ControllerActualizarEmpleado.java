package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.PnlActualizarEmpleados;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerActualizarEmpleado implements MouseListener, KeyListener {

    private PnlActualizarEmpleados pnlActualizarEmpleados;
    private UsuarioDAO usuarioDAO;

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
    }

    public void iniciar(String cedula) {
        extrarDatosEmpleado(cedula);
        mostrarLetrasNegras();
        cambiarBackground();
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

    public void extrarDatosEmpleado(String cedula) {
        mostrarLetrasNegras();
        Usuario usuario = usuarioDAO.extraerPersonaID(cedula);
        pnlActualizarEmpleados.getTxtNombreEmpleado().setText(usuario.getNombre());
        pnlActualizarEmpleados.getTxtApellidoEmpleado().setText(usuario.getApellido());
        pnlActualizarEmpleados.getTxtTelefonoEmpleado().setText(usuario.getTelefono());
        pnlActualizarEmpleados.getTxtUsuarioEmpleado().setText(usuario.getNombre_usuario());
        pnlActualizarEmpleados.getTxtCedulaEmpleado().setText(usuario.getCedula());
        pnlActualizarEmpleados.getTxtSueldoEmpleado().setText(usuario.getSueldoEmpleado());
        
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
    }

}
