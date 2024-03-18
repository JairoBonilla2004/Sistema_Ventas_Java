package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.AdministradorDAO;
import modelo.ClienteDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.PnlNuevoEmpleado;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerPnlNuevoEmpleado implements MouseListener, KeyListener {

    private final PnlNuevoEmpleado pnlNuevoEmpleado;
    private final UsuarioDAO usuarioDAO;

    public ControllerPnlNuevoEmpleado(PnlNuevoEmpleado pnlNuevoEmpleado, UsuarioDAO usuarioDAO) {
        this.pnlNuevoEmpleado = pnlNuevoEmpleado;
        this.usuarioDAO = usuarioDAO;
        this.pnlNuevoEmpleado.getTxtNombreEmpleado().addMouseListener(this);
        this.pnlNuevoEmpleado.getTxtApellidoEmpleado().addMouseListener(this);
        this.pnlNuevoEmpleado.getTxtUsuarioEmpleado().addMouseListener(this);
        this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().addMouseListener(this);
        this.pnlNuevoEmpleado.getTxtCedulaEmpleado().addMouseListener(this);
        this.pnlNuevoEmpleado.getTxtSueldoEmpleado().addMouseListener(this);
        this.pnlNuevoEmpleado.getPswContraseniaEmpleado().addMouseListener(this);
        this.pnlNuevoEmpleado.getTxtNombreEmpleado().addKeyListener(this);
        this.pnlNuevoEmpleado.getTxtApellidoEmpleado().addKeyListener(this);
        this.pnlNuevoEmpleado.getTxtUsuarioEmpleado().addKeyListener(this);
        this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().addKeyListener(this);
        this.pnlNuevoEmpleado.getTxtCedulaEmpleado().addKeyListener(this);
        this.pnlNuevoEmpleado.getTxtSueldoEmpleado().addKeyListener(this);
        this.pnlNuevoEmpleado.getPswContraseniaEmpleado().addKeyListener(this);
        this.pnlNuevoEmpleado.getBtnGuardar().addKeyListener(this);
        this.pnlNuevoEmpleado.getBtnGuardar().addMouseListener(this);
    }

    public void iniciar() {
        cambiarColorTextos();
        validarDatos();
        this.pnlNuevoEmpleado.getBtnGuardar().setEnabled(false);
    }

    public void cambiarColorTextos() {
        pnlNuevoEmpleado.getTxtNombreEmpleado().setBackground(Color.WHITE);
        pnlNuevoEmpleado.getTxtCedulaEmpleado().setBackground(Color.WHITE);
        pnlNuevoEmpleado.getTxtUsuarioEmpleado().setBackground(Color.WHITE);
        pnlNuevoEmpleado.getTxtApellidoEmpleado().setBackground(Color.WHITE);
        pnlNuevoEmpleado.getTxtUsuarioEmpleado().setBackground(Color.WHITE);
        pnlNuevoEmpleado.getTxtTelefonoEmpleado().setBackground(Color.WHITE);
        pnlNuevoEmpleado.getTxtSueldoEmpleado().setBackground(Color.WHITE);
        pnlNuevoEmpleado.getPswContraseniaEmpleado().setBackground(Color.WHITE);
    }

    public void mostrarImagenAlertaUsuario() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaUsuario().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaUsuario() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaUsuario().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaCedulaEmpleado() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblCedulaEmpleado().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaCedulaEmpleado() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblCedulaEmpleado().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaContraseña() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaContraseña().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaContraseña() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaContraseña().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaNombre() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaNombre().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaNombre() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaNombre().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaApellido() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaApellido().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaApellido() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaApellido().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaTelefono() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaTelefono().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaTelefono() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaTelefono().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaSueldo() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaSueldo().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaSueldo() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblAlertaSueldo().setIcon(icono);
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

    public void validarDatos() {
        if (this.pnlNuevoEmpleado.getTxtNombreEmpleado().getText().equals("Ingrese el nombre del empleado") || this.pnlNuevoEmpleado.getTxtNombreEmpleado().getText().isBlank()) {
            mostrarImagenAlertaNombre();
        } else {
            mostrarImagenBlancaNombre();
        }

        if (this.pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().equals("Ingrese el apellido del empleado") || this.pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().isBlank()) {
            mostrarImagenAlertaApellido();
        } else {
            mostrarImagenBlancaApellido();
        }

        if (this.pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().equals("Ingrese el nombre de usuario") || this.pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().isBlank()) {
            mostrarImagenAlertaUsuario();
        } else {
            mostrarImagenBlancaUsuario();
        }

        if (this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().equals("Ingrese el número de teléfono") || this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().isBlank()) {
            mostrarImagenAlertaTelefono();
        } else {
            mostrarImagenBlancaTelefono();
        }

        if (this.pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().equals("Ingrese la cédula del empleado") || this.pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().isBlank()) {
            mostrarImagenAlertaCedulaEmpleado();
        } else {
            mostrarImagenBlancaCedulaEmpleado();
        }

        if (this.pnlNuevoEmpleado.getTxtSueldoEmpleado().getText().equals("Ingrese el sueldo del empleado") || this.pnlNuevoEmpleado.getTxtSueldoEmpleado().getText().isBlank()) {
            mostrarImagenAlertaSueldo();
        } else {
            mostrarImagenBlancaSueldo();
        }

        if (this.pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().equals("****************************") || this.pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().isEmpty()) {
            mostrarImagenAlertaContraseña();
        } else {
            mostrarImagenBlancaContraseña();
        }

        if (this.pnlNuevoEmpleado.getTxtNombreEmpleado().getText().equals("Ingrese el nombre del empleado") || this.pnlNuevoEmpleado.getTxtNombreEmpleado().getText().isBlank()
                || this.pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().equals("Ingrese el apellido del empleado") || this.pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().isBlank()
                || this.pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().equals("Ingrese el nombre de usuario") || this.pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().isBlank()
                || this.pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().equals("****************************") || this.pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().isBlank()
                || this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().equals("Ingrese el número de teléfono") || this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().isBlank()
                || this.pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().equals("Ingrese la cédula del empleado") || this.pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().isBlank()
                || this.pnlNuevoEmpleado.getTxtSueldoEmpleado().getText().equals("Ingrese el sueldo del empleado") || this.pnlNuevoEmpleado.getTxtSueldoEmpleado().getText().isBlank()
                || !pnlNuevoEmpleado.getLblAlertaTextoSueldo().getText().isEmpty()) {
            this.pnlNuevoEmpleado.getBtnGuardar().setEnabled(false);

        } else {
            this.pnlNuevoEmpleado.getBtnGuardar().setEnabled(true);
        }

    }

    public void animmacionTextoCedulaEmpleado() {
        if (pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().equals("Ingrese la cédula del empleado")) {
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setText("");
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setForeground(Color.BLACK);
        }

        if (pnlNuevoEmpleado.getTxtNombreEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtNombreEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        }

        if (pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }

        if (pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        }

        if (pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setText("****************************");
        }

        if (pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        }

        if (pnlNuevoEmpleado.getTxtSueldoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
        }
    }

    public void animacionTextoNombre() {
        if (pnlNuevoEmpleado.getTxtNombreEmpleado().getText().equals("Ingrese el nombre del empleado")) {
            pnlNuevoEmpleado.getTxtNombreEmpleado().setText("");
            pnlNuevoEmpleado.getTxtNombreEmpleado().setForeground(Color.BLACK);
        }

        if (pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        }

        if (pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }

        if (pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        }

        if (pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setText("****************************");
        }

        if (pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        }

        if (pnlNuevoEmpleado.getTxtSueldoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
        }
    }

    public void animacionTextoApellido() {
        if (pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().equals("Ingrese el apellido del empleado")) {
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setText("");
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setForeground(Color.BLACK);
        }

        if (pnlNuevoEmpleado.getTxtNombreEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtNombreEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        }

        if (pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        }

        if (pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        }

        if (pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setText("****************************");
        }

        if (pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        }

        if (pnlNuevoEmpleado.getTxtSueldoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
        }
    }

    public void animacionTextoTelefono() {
        if (pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().equals("Ingrese el número de teléfono")) {
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setText("");
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setForeground(Color.BLACK);
        }

        if (pnlNuevoEmpleado.getTxtNombreEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtNombreEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        }

        if (pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        }

        if (pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        }

        if (pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setText("****************************");
        }

        if (pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }

        if (pnlNuevoEmpleado.getTxtSueldoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
        }
    }

    public void animacionTextoUsuario() {
        if (pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().equals("Ingrese el nombre de usuario")) {
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setText("");
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setForeground(Color.BLACK);
        }

        if (pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        }

        if (pnlNuevoEmpleado.getTxtNombreEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtNombreEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        }

        if (pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        }

        if (pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setText("****************************");
        }

        if (pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }

        if (pnlNuevoEmpleado.getTxtSueldoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
        }
    }

    public void animacionTextoSueldo() {
        if (pnlNuevoEmpleado.getTxtSueldoEmpleado().getText().equals("Ingrese el sueldo del empleado")) {
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setText("");
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setForeground(Color.BLACK);
        }

        if (pnlNuevoEmpleado.getTxtNombreEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtNombreEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        }

        if (pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        }

        if (pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        }

        if (pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setText("****************************");
        }

        if (pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }

        if (pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        }
    }

    public void animacionTextoContrasenia() {
        if (pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().equals("****************************")) {
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setText("");
            pnlNuevoEmpleado.getPswContraseniaEmpleado().setForeground(Color.BLACK);
        }

        if (pnlNuevoEmpleado.getTxtSueldoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
        }

        if (pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        }

        if (pnlNuevoEmpleado.getTxtNombreEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtNombreEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        }

        if (pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        }

        if (pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        }

        if (pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }

        if (pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().isEmpty()) {
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        }
    }

    public void cambiarColorTextosGray() {
        pnlNuevoEmpleado.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
        pnlNuevoEmpleado.getTxtApellidoEmpleado().setForeground(Color.GRAY);
        pnlNuevoEmpleado.getTxtNombreEmpleado().setForeground(Color.GRAY);
        pnlNuevoEmpleado.getTxtTelefonoEmpleado().setForeground(Color.GRAY);
        pnlNuevoEmpleado.getPswContraseniaEmpleado().setForeground(Color.GRAY);
        pnlNuevoEmpleado.getTxtCedulaEmpleado().setForeground(Color.GRAY);
    }

    public void vaciarCampos() {
        pnlNuevoEmpleado.getTxtNombreEmpleado().setText("Ingrese el nombre del empleado");
        pnlNuevoEmpleado.getTxtApellidoEmpleado().setText("Ingrese el apellido del empleado");
        pnlNuevoEmpleado.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
        pnlNuevoEmpleado.getPswContraseniaEmpleado().setText("****************************");
        pnlNuevoEmpleado.getTxtTelefonoEmpleado().setText("Ingrese el número de teléfono");
        pnlNuevoEmpleado.getTxtCedulaEmpleado().setText("Ingrese la cédula del empleado");
        pnlNuevoEmpleado.getTxtSueldoEmpleado().setText("Ingrese el sueldo del empleado");
    }

    public void enviarDatosDb() {
        AdministradorDAO administradorDAO = new AdministradorDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        String telefono = pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText();
        Usuario usuario = new Usuario(pnlNuevoEmpleado.getTxtNombreEmpleado().getText(), pnlNuevoEmpleado.getTxtApellidoEmpleado().getText(), pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText(), pnlNuevoEmpleado.getPswContraseniaEmpleado().getText(), telefono);
        usuario.setCedula(pnlNuevoEmpleado.getTxtCedulaEmpleado().getText());
        boolean usuarioExistente = usuarioDAO.verificarPersonaExistente("usuario", pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().trim());
        boolean administradorExistente = administradorDAO.verificarPersonaExistente("administrador", pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().trim());
        if ((usuarioExistente == true) || (administradorExistente == true)) {
            JOptionPane.showMessageDialog(null, "ESTE NOMBRE DE USUARIO YA ESTÁ REGISTRADO EN USUARIOS O ADMINISTRADORES\n               DIGITE OTRO NOMBRE DE USUARIO!", "MESSAGE", JOptionPane.ERROR_MESSAGE);
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setForeground(Color.GRAY);
            pnlNuevoEmpleado.getTxtUsuarioEmpleado().setText("Ingrese el nombre de usuario");
            validarDatos();

        } else {
            boolean cedulaAdministradosExistente = administradorDAO.verificarPersonaExistente("cedula", pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().trim());
            boolean cedulaClienteExistente = clienteDAO.verificarPersonaExistente("cedula", pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().trim());
            boolean cedulaEmpleadoExistente = usuarioDAO.verificarPersonaExistente("cedula", pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().trim());
            if (cedulaAdministradosExistente == false && cedulaClienteExistente == false && cedulaEmpleadoExistente == false) {
                usuarioDAO.enviarPesonasDB(usuario);
                JOptionPane.showMessageDialog(
                        null,
                        "   USUARIO REGISTRADO CON ÉXITO",
                        "MESSAGE",
                        JOptionPane.INFORMATION_MESSAGE,
                        activarVistoVerde());
                cambiarColorTextosGray();
                vaciarCampos();
                validarDatos();
            } else {
                JOptionPane.showMessageDialog(null, "ESTA CÉDULA YA SE ENCUENTRA REGISTRADA", "ERROR", JOptionPane.ERROR_MESSAGE);
                pnlNuevoEmpleado.getTxtCedulaEmpleado().setText("");
                pnlNuevoEmpleado.getTxtCedulaEmpleado().setForeground(Color.BLACK);
                validarDatos();
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == pnlNuevoEmpleado.getBtnGuardar()) {
            enviarDatosDb();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == pnlNuevoEmpleado.getTxtApellidoEmpleado()) {
            pnlNuevoEmpleado.getLblTextoAlertaEmpleado().setText("");
            pnlNuevoEmpleado.getLblTextoApellido().setText("");
            pnlNuevoEmpleado.getLblTextoAlertaCedula().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoTelefono().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoSueldo().setText("");
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtNombreEmpleado()) {
            pnlNuevoEmpleado.getLblTextoAlertaEmpleado().setText("");
            pnlNuevoEmpleado.getLblTextoApellido().setText("");
            pnlNuevoEmpleado.getLblTextoAlertaCedula().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoTelefono().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoSueldo().setText("");
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtUsuarioEmpleado()) {
            pnlNuevoEmpleado.getLblTextoAlertaEmpleado().setText("");
            pnlNuevoEmpleado.getLblTextoApellido().setText("");
            pnlNuevoEmpleado.getLblTextoAlertaCedula().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoTelefono().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoSueldo().setText("");
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtCedulaEmpleado()) {
            pnlNuevoEmpleado.getLblTextoAlertaEmpleado().setText("");
            pnlNuevoEmpleado.getLblTextoApellido().setText("");
            pnlNuevoEmpleado.getLblTextoAlertaCedula().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoTelefono().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoSueldo().setText("");
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtSueldoEmpleado()) {
            pnlNuevoEmpleado.getLblTextoAlertaEmpleado().setText("");
            pnlNuevoEmpleado.getLblTextoApellido().setText("");
            pnlNuevoEmpleado.getLblTextoAlertaCedula().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoTelefono().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoSueldo().setText("");
        }

        if (e.getSource() == pnlNuevoEmpleado.getPswContraseniaEmpleado()) {
            pnlNuevoEmpleado.getLblTextoAlertaEmpleado().setText("");
            pnlNuevoEmpleado.getLblTextoApellido().setText("");
            pnlNuevoEmpleado.getLblTextoAlertaCedula().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoTelefono().setText("");
            pnlNuevoEmpleado.getLblAlertaTextoSueldo().setText("");
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtNombreEmpleado()) {
            animacionTextoNombre();
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtApellidoEmpleado()) {
            animacionTextoApellido();
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtUsuarioEmpleado()) {
            animacionTextoUsuario();
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtTelefonoEmpleado()) {
            animacionTextoTelefono();
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtCedulaEmpleado()) {
            animmacionTextoCedulaEmpleado();
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtSueldoEmpleado()) {
            animacionTextoSueldo();
        }

        if (e.getSource() == pnlNuevoEmpleado.getPswContraseniaEmpleado()) {
            animacionTextoContrasenia();
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
        if (e.getSource() == pnlNuevoEmpleado.getTxtNombreEmpleado()) {
            char c = e.getKeyChar();
            if (!Character.isLetter(c) && c != 8) {
                e.consume();
                pnlNuevoEmpleado.getLblTextoAlertaEmpleado().setForeground(Color.red);
                pnlNuevoEmpleado.getLblTextoAlertaEmpleado().setText("Solo se permiten caracteres");

            } else {
                pnlNuevoEmpleado.getLblTextoAlertaEmpleado().setText("");
            }
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtApellidoEmpleado()) {
            char c = e.getKeyChar();
            if (!Character.isLetter(c) && c != 8) {
                e.consume();
                pnlNuevoEmpleado.getLblTextoApellido().setForeground(Color.red);
                pnlNuevoEmpleado.getLblTextoApellido().setText("Solo se permiten caracteres");
            } else {
                pnlNuevoEmpleado.getLblTextoApellido().setText("");
            }
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtCedulaEmpleado()) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c) && c != 8) {
                e.consume();
                pnlNuevoEmpleado.getLblTextoAlertaCedula().setForeground(Color.red);
                pnlNuevoEmpleado.getLblTextoAlertaCedula().setText("Solo se permiten dígitos");
                mostrarImagenAlertaCedulaEmpleado();
            } else {
                pnlNuevoEmpleado.getLblTextoAlertaCedula().setText("");
                mostrarImagenBlancaCedulaEmpleado();
                if (pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().length() >= 10) {
                    e.consume();
                    pnlNuevoEmpleado.getLblTextoAlertaCedula().setForeground(Color.red);
                    pnlNuevoEmpleado.getLblTextoAlertaCedula().setText("La cédula debe tener solo 10 dígitos");
                    mostrarImagenAlertaCedulaEmpleado();
                } else {
                    mostrarImagenBlancaCedulaEmpleado();
                }
            }

        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtTelefonoEmpleado()) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c) && c != 8) {
                e.consume();
                pnlNuevoEmpleado.getLblAlertaTextoTelefono().setForeground(Color.red);
                pnlNuevoEmpleado.getLblAlertaTextoTelefono().setText("Solo se permiten dígitos");
            } else {
                pnlNuevoEmpleado.getLblAlertaTextoTelefono().setText("");
                if (pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().length() >= 10) {
                    e.consume();
                    pnlNuevoEmpleado.getLblAlertaTextoTelefono().setForeground(Color.red);
                    pnlNuevoEmpleado.getLblAlertaTextoTelefono().setText("La teléfono debe tener solo 10 dígitos");
                }
            }
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtSueldoEmpleado()) {
            char c = e.getKeyChar();
            if (Character.isSpaceChar(c)) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == pnlNuevoEmpleado.getTxtNombreEmpleado()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtApellidoEmpleado()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtUsuarioEmpleado()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtSueldoEmpleado()) {
            validarDatos();
            if (!ControllerNuevoAdministrador.esSueldoValido(pnlNuevoEmpleado.getTxtSueldoEmpleado().getText())) {
                pnlNuevoEmpleado.getLblAlertaTextoSueldo().setForeground(Color.red);
                pnlNuevoEmpleado.getLblAlertaTextoSueldo().setText("El sueldo no tiene el formato correcto");
            } else {
                pnlNuevoEmpleado.getLblAlertaTextoSueldo().setText("");
            }
            validarDatos();
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtTelefonoEmpleado()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtSueldoEmpleado()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoEmpleado.getTxtCedulaEmpleado()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoEmpleado.getPswContraseniaEmpleado()) {
            validarDatos();
        }
    }

}
