package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import modelo.UsuarioDAO;
import vista.PnlNuevoEmpleado;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerPnlNuevoEmpleado implements MouseListener {

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
        this.pnlNuevoEmpleado.getBtnGuardar().addMouseListener(this);
    }

    public void iniciar() {
        cambiarColorTextos();
        this.pnlNuevoEmpleado.getBtnGuardar().setVisible(false);
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
            this.pnlNuevoEmpleado.getLblCedulaEmpleado().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaContraseña() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlNuevoEmpleado.getLblCedulaEmpleado().setIcon(icono);
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

    public ImageIcon activarVistoVerde() {
        java.net.URL imageURL = getClass().getResource("/img/greenSeen.png");
        ImageIcon icono = null;
        if (imageURL != null) {
            icono = new ImageIcon(imageURL);
        }
        return icono;
    }

    public void validarDatos() {
        if (this.pnlNuevoEmpleado.getTxtNombreEmpleado().getText().equals("Ingrese el nombre del empleado") || this.pnlNuevoEmpleado.getTxtNombreEmpleado().getText().isEmpty()) {
            mostrarImagenAlertaNombre();
        } else {
            mostrarImagenBlancaNombre();
        }

        if (this.pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().equals("Ingrese el nombre del empleado") || this.pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().isEmpty()) {
            mostrarImagenAlertaApellido();
        } else {
            mostrarImagenBlancaApellido();
        }

        if (this.pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().equals("Ingrese el nombre de usuario") || this.pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().isEmpty()) {
            mostrarImagenAlertaUsuario();
        } else {
            mostrarImagenBlancaUsuario();
        }

        if (this.pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().equals("Ingrese la cédula del empleado") || this.pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().isEmpty()) {
            mostrarImagenAlertaCedulaEmpleado();
        } else {
            mostrarImagenBlancaCedulaEmpleado();
        }

        if (this.pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().equals("*******************************") || this.pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().isEmpty()) {
            mostrarImagenAlertaContraseña();
        } else {
            mostrarImagenBlancaContraseña();
        }

        if (this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().equals("Ingrese el número de teléfono") || this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().isEmpty()) {
            mostrarImagenAlertaTelefono();
        } else {
            mostrarImagenBlancaTelefono();
        }

        if (this.pnlNuevoEmpleado.getTxtNombreEmpleado().getText().equals("Ingrese su nombre") || this.pnlNuevoEmpleado.getTxtNombreEmpleado().getText().isBlank()
                || this.pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().equals("Ingrese el apellido del usuario") || this.pnlNuevoEmpleado.getTxtApellidoEmpleado().getText().isBlank()
                || this.pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().equals("Ingrese el nombre de usuario") || this.pnlNuevoEmpleado.getTxtUsuarioEmpleado().getText().isBlank()
                || this.pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().equals("*******************************") || this.pnlNuevoEmpleado.getPswContraseniaEmpleado().getText().isBlank()
                || this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().equals("Ingrese su número de telefono") || this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().isBlank()
                || this.pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().equals("Ingrese el número de cédula") || this.pnlNuevoEmpleado.getTxtCedulaEmpleado().getText().isBlank()) {
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

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
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

}
