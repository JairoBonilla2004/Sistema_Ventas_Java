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
public class ControllerPnlNuevoEmpleado implements MouseListener{
    
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
    }
    public void iniciar(){
        cambiarColorTextos();
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

        if (this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().equals("Ingrese el numero de teléfono") || this.pnlNuevoEmpleado.getTxtTelefonoEmpleado().getText().isEmpty()) {
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

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
