package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.AdministradorDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.FrmCambiarContraseña;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerCambiarContrasenia implements MouseListener, KeyListener {

    private final FrmCambiarContraseña frmCambiarContraseña;
    private final AdministradorDAO administradorDAO;
    private final UsuarioDAO usuarioDAO;

    public ControllerCambiarContrasenia(FrmCambiarContraseña frmCambiarContraseña, AdministradorDAO administradorDAO, UsuarioDAO usuarioDAO) {
        this.frmCambiarContraseña = frmCambiarContraseña;
        this.administradorDAO = administradorDAO;
        this.usuarioDAO = usuarioDAO;
        this.frmCambiarContraseña.getPswContraseniaActual().addMouseListener(this);
        this.frmCambiarContraseña.getPswContraseniaAnterior().addMouseListener(this);
        this.frmCambiarContraseña.getPswContraseniaActual().addKeyListener(this);
        this.frmCambiarContraseña.getPswContraseniaAnterior().addKeyListener(this);
        this.frmCambiarContraseña.getBtnGuardar().addMouseListener(this);
    }

    public void iniciar(String typeClass) {
        cambiarColoresContraseña();
        extraerDatos(typeClass);
        frmCambiarContraseña.setDefaultCloseOperation(FrmCambiarContraseña.DISPOSE_ON_CLOSE);
        frmCambiarContraseña.getBtnGuardar().setEnabled(false);
        frmCambiarContraseña.setVisible(true);
    }

    public void cambiarColoresContraseña() {
        frmCambiarContraseña.getPswContraseniaAnterior().setBackground(Color.WHITE);
        frmCambiarContraseña.getPswContraseniaActual().setBackground(Color.WHITE);
    }

    public ImageIcon activarVistoVerde() {
        java.net.URL imageURL = getClass().getResource("/img/greenSeen.png");
        ImageIcon icono = null;
        if (imageURL != null) {
            icono = new ImageIcon(imageURL);
        }
        return icono;
    }

    public void extraerDatos(String typeClass) {
        if (typeClass.equals("Administrador")) {
            Administrador administrador = administradorDAO.extraerPersonaID("_id",frmCambiarContraseña.getObjectId());
            frmCambiarContraseña.getLblNombreApellido().setText(administrador.getNombre() + "  " + administrador.getApellido());
            frmCambiarContraseña.getLblCargo().setText("( " + administrador.getCargo() + " )");
        }
        if (typeClass.equals("Usuario")) {
            Usuario usuario = usuarioDAO.extraerPersonaID("_id",frmCambiarContraseña.getObjectId());
            frmCambiarContraseña.getLblNombreApellido().setText(usuario.getNombre() + "  " + usuario.getApellido());
            frmCambiarContraseña.getLblCargo().setText("EMPLEADO");
        }

    }

    public void mostrarImagenAlertaContraseñaActual() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            frmCambiarContraseña.getLblContrseñaActual().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaContraseñaActual() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            frmCambiarContraseña.getLblContrseñaActual().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaContraseñaAnterior() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            frmCambiarContraseña.getLblContrseñaAnterior().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaContraseñaAnterior() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            frmCambiarContraseña.getLblContrseñaAnterior().setIcon(icono);
        }
    }

    public void quitarCampos() {
        frmCambiarContraseña.getPswContraseniaActual().setText("********************");
        frmCambiarContraseña.getPswContraseniaAnterior().setText("********************");
        frmCambiarContraseña.getPswContraseniaActual().setForeground(Color.GRAY);
        frmCambiarContraseña.getPswContraseniaAnterior().setForeground(Color.GRAY);
    }

    public void guarDarContraseñaActual() {
        Administrador administrador = administradorDAO.extraerPersonaID("_id",frmCambiarContraseña.getObjectId());

        if (administrador.getContraseña().equals(frmCambiarContraseña.getPswContraseniaAnterior().getText())) {
            boolean respuesta = administradorDAO.actualizarContraseñaAdministrador(String.valueOf(frmCambiarContraseña.getObjectId()), frmCambiarContraseña.getPswContraseniaActual().getText());
            if (respuesta) {
                JOptionPane.showMessageDialog(
                        null,
                        "CONTRASEÑA ACTUALIZADA",
                        "MESSAGE",
                        JOptionPane.INFORMATION_MESSAGE,
                        activarVistoVerde());
                quitarCampos();
                validarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "LA CONTRASEÑA ANTIGUA ES INCORRECTA", "MESSAGE", JOptionPane.ERROR_MESSAGE);
            quitarCampos();
            validarCampos();
        }
    }

    public void validarCampos() {
        if (frmCambiarContraseña.getPswContraseniaActual().getText().equals("********************") || frmCambiarContraseña.getPswContraseniaActual().getText().isEmpty()) {
            mostrarImagenAlertaContraseñaActual();
        } else {
            mostrarImagenBlancaContraseñaActual();
        }

        if (frmCambiarContraseña.getPswContraseniaAnterior().getText().equals("********************") || frmCambiarContraseña.getPswContraseniaAnterior().getText().isEmpty()) {
            mostrarImagenAlertaContraseñaAnterior();
        } else {
            mostrarImagenBlancaContraseñaAnterior();
        }
        if (frmCambiarContraseña.getPswContraseniaActual().getText().equals("********************") || frmCambiarContraseña.getPswContraseniaActual().getText().isEmpty()
                || frmCambiarContraseña.getPswContraseniaAnterior().getText().equals("********************") || frmCambiarContraseña.getPswContraseniaAnterior().getText().isEmpty()) {
            frmCambiarContraseña.getBtnGuardar().setEnabled(false);
        } else {
            frmCambiarContraseña.getBtnGuardar().setEnabled(true);
        }

    }

    public void animacionTextoContraseñaAnterior() {
        if (frmCambiarContraseña.getPswContraseniaAnterior().getText().equals("********************") || frmCambiarContraseña.getPswContraseniaAnterior().getText().isEmpty()) {
            frmCambiarContraseña.getPswContraseniaAnterior().setText("");
            frmCambiarContraseña.getPswContraseniaAnterior().setForeground(Color.BLACK);
        }

        if (frmCambiarContraseña.getPswContraseniaActual().getText().isEmpty()) {
            frmCambiarContraseña.getPswContraseniaActual().setForeground(Color.GRAY);
            frmCambiarContraseña.getPswContraseniaActual().setText("********************");
        }

    }

    public void animacionTextoContraseñaActual() {
        if (frmCambiarContraseña.getPswContraseniaActual().getText().equals("********************") || frmCambiarContraseña.getPswContraseniaActual().getText().isEmpty()) {
            frmCambiarContraseña.getPswContraseniaActual().setText("");
            frmCambiarContraseña.getPswContraseniaActual().setForeground(Color.BLACK);
        }

        if (frmCambiarContraseña.getPswContraseniaAnterior().getText().isEmpty()) {
            frmCambiarContraseña.getPswContraseniaAnterior().setForeground(Color.GRAY);
            frmCambiarContraseña.getPswContraseniaAnterior().setText("********************");
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frmCambiarContraseña.getBtnGuardar()) {
            guarDarContraseñaActual();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == frmCambiarContraseña.getPswContraseniaAnterior()) {
            animacionTextoContraseñaAnterior();
        }

        if (e.getSource() == frmCambiarContraseña.getPswContraseniaActual()) {
            animacionTextoContraseñaActual();
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
        if (e.getSource() == frmCambiarContraseña.getPswContraseniaActual()) {
            validarCampos();
        }

        if (e.getSource() == frmCambiarContraseña.getPswContraseniaAnterior()) {
            validarCampos();
        }

    }

}
