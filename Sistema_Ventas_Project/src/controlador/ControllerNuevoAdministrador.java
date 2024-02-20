package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import modelo.Administrador;
import modelo.AdministradorDAO;
import vista.PnlNuevoAdministrador;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public final class ControllerNuevoAdministrador implements MouseListener, KeyListener {

    private final PnlNuevoAdministrador pnlNuevoAdministrador;
    private AdministradorDAO administradorDAO;
    private Administrador administrador;

    public ControllerNuevoAdministrador(PnlNuevoAdministrador pnlNuevoAdministrador, AdministradorDAO administradorDAO, Administrador administrador) {
        this.pnlNuevoAdministrador = pnlNuevoAdministrador;
        this.administradorDAO = administradorDAO;
        this.administrador = administrador;
        inicializarMauseAndKeyListener();

    }

    public void inicializarMauseAndKeyListener() {
        this.pnlNuevoAdministrador.getTxtNombre().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtApellido().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtNombreUsuario().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtNombreUsuario().addKeyListener(this);
        this.pnlNuevoAdministrador.getTxtCargo().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtCargo().addKeyListener(this);
        this.pnlNuevoAdministrador.getTxtCedula().addMouseListener(this);
        this.pnlNuevoAdministrador.getPswContrasenia().addMouseListener(this);
        this.pnlNuevoAdministrador.getPswContrasenia().addKeyListener(this);
        this.pnlNuevoAdministrador.getTxtSueldo().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtTelefono().addMouseListener(this);
        this.pnlNuevoAdministrador.getTxtNombre().addKeyListener(this);
        this.pnlNuevoAdministrador.getTxtApellido().addKeyListener(this);
        this.pnlNuevoAdministrador.getTxtCedula().addKeyListener(this);
        this.pnlNuevoAdministrador.getTxtTelefono().addKeyListener(this);
        this.pnlNuevoAdministrador.getTxtSueldo().addKeyListener(this);
    }

    public void iniciarComponentes() {
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

    void vaciarLblTextoValidaciones() {
        pnlNuevoAdministrador.getLblTextoAlertaApellido().setText("");
        pnlNuevoAdministrador.getLblTextoAlertaCedula().setText("");
        pnlNuevoAdministrador.getLblAlertaTextoTelefono().setText("");
        pnlNuevoAdministrador.getLblTextoAlertaNombre().setText("");

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource() == pnlNuevoAdministrador.getTxtNombre()) {
            vaciarLblTextoValidaciones();
            animmacionTextoNombre();
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtApellido()) {
            vaciarLblTextoValidaciones();
            animacionTextoApellido();
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtNombreUsuario()) {
            vaciarLblTextoValidaciones();
            animacionTextoUsuarioAdministrador();
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtCedula()) {
            vaciarLblTextoValidaciones();
            animacionTextoCedula();
        }
        if (e.getSource() == pnlNuevoAdministrador.getTxtTelefono()) {
            vaciarLblTextoValidaciones();
            animacionTextoTelefono();
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtCargo()) {
            vaciarLblTextoValidaciones();
            animmacionTextoCargo();
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtSueldo()) {
            vaciarLblTextoValidaciones();
            animacionTextoSueldo();
        }

        if (e.getSource() == pnlNuevoAdministrador.getPswContrasenia()) {
            vaciarLblTextoValidaciones();
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

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == pnlNuevoAdministrador.getTxtNombre()) {
            char c = e.getKeyChar();
            if (!Character.isLetter(c) && c != 8) {
                e.consume();
                pnlNuevoAdministrador.getLblTextoAlertaNombre().setForeground(Color.red);
                pnlNuevoAdministrador.getLblTextoAlertaNombre().setText("Solo se permiten caracteres");

            } else {
                pnlNuevoAdministrador.getLblTextoAlertaNombre().setText("");
            }
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtApellido()) {
            char c = e.getKeyChar();
            if (!Character.isLetter(c) && c != 8) {
                e.consume();
                pnlNuevoAdministrador.getLblTextoAlertaApellido().setForeground(Color.red);
                pnlNuevoAdministrador.getLblTextoAlertaApellido().setText("Solo se permiten caracteres");
            } else {
                pnlNuevoAdministrador.getLblTextoAlertaApellido().setText("");
            }

        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtCedula()) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c) && c != 8) {
                e.consume();
                pnlNuevoAdministrador.getLblTextoAlertaCedula().setForeground(Color.red);
                pnlNuevoAdministrador.getLblTextoAlertaCedula().setText("Solo se permiten dígitos");
                mostrarImagenAlertaCedula();
            } else {
                pnlNuevoAdministrador.getLblTextoAlertaCedula().setText("");
                mostrarImagenBlancaCedula();
                if (pnlNuevoAdministrador.getTxtCedula().getText().length() >= 10) {
                    e.consume();
                    pnlNuevoAdministrador.getLblTextoAlertaCedula().setForeground(Color.red);
                    pnlNuevoAdministrador.getLblTextoAlertaCedula().setText("La cédula debe tener solo 10 dígitos");
                    mostrarImagenAlertaCedula();
                } else {
                    mostrarImagenBlancaCedula();
                }
            }

        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtTelefono()) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c) && c != 8) {
                e.consume();
                pnlNuevoAdministrador.getLblAlertaTextoTelefono().setForeground(Color.red);
                pnlNuevoAdministrador.getLblAlertaTextoTelefono().setText("Solo se permiten dígitos");
            } else {
                pnlNuevoAdministrador.getLblAlertaTextoTelefono().setText("");
                if (pnlNuevoAdministrador.getTxtTelefono().getText().length() >= 10) {
                    e.consume();
                    pnlNuevoAdministrador.getLblAlertaTextoTelefono().setForeground(Color.red);
                    pnlNuevoAdministrador.getLblAlertaTextoTelefono().setText("La teléfono debe tener solo 10 dígitos");
                }
            }
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtSueldo()) {
            char c = e.getKeyChar();
            if (Character.isSpaceChar(c)) {
                e.consume();
            }
        }
    }

    public boolean esSueldoValido(String sueldo) {
        boolean puntoEncontrado = false;

        if (sueldo.isEmpty()) {
            return false;
        }

        for (int i = 0; i < sueldo.length(); i++) {
            char c = sueldo.charAt(i);
            if (!Character.isDigit(c) && c != '.') {
                return false; // Carácter no válido encontrado
            }
            if (c == '.') {
                if (puntoEncontrado || i == 0 || i == sueldo.length() - 1) {
                    return false; // Más de un punto o punto al principio o al final encontrado
                }
                puntoEncontrado = true;
            }
        }

        return true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == pnlNuevoAdministrador.getTxtSueldo()) {
            validarDatos();
            if (!esSueldoValido(pnlNuevoAdministrador.getTxtSueldo().getText())) {
                pnlNuevoAdministrador.getLblAlertaTextoSueldo().setForeground(Color.red);
                pnlNuevoAdministrador.getLblAlertaTextoSueldo().setText("El sueldo no tiene el formato correcto");
            }else{
                pnlNuevoAdministrador.getLblAlertaTextoSueldo().setText("");
            }
        }
        if (e.getSource() == pnlNuevoAdministrador.getTxtNombre()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtApellido()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtNombreUsuario()) {
            validarDatos();
        }
        if (e.getSource() == pnlNuevoAdministrador.getTxtCedula()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtCargo()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtCargo()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtSueldo()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoAdministrador.getPswContrasenia()) {
            validarDatos();
        }

        if (e.getSource() == pnlNuevoAdministrador.getTxtTelefono()) {
            validarDatos();
        }

    }

    public void mostrarImagenAlertaUsuario() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaUsuario().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaUsuario() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaUsuario().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaContraseña() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaContraseña().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaContraseña() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaContraseña().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaNombre() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaNombre().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaNombre() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaNombre().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaApellido() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaApellido().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaApellido() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaApellido().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaTelefono() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaTelefono().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaTelefono() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaTelefono().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaCargo() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaCargo().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaCargo() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaCargo().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaSueldo() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaSueldo().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaSueldo() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaSueldo().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaCedula() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaCedula().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaCedula() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png"); //ruta de la imagen a cargar
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlNuevoAdministrador.getLblAlertaCedula().setIcon(icono);
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
        if (pnlNuevoAdministrador.getTxtNombre().getText().equals("Ingrese su nombre") || pnlNuevoAdministrador.getTxtNombre().getText().isEmpty()) {
            mostrarImagenAlertaNombre();
        } else {
            mostrarImagenBlancaNombre();
        }

        if (pnlNuevoAdministrador.getTxtApellido().getText().equals("Ingrese el apellido del usuario") || pnlNuevoAdministrador.getTxtApellido().getText().isEmpty()) {
            mostrarImagenAlertaApellido();
        } else {
            mostrarImagenBlancaApellido();
        }

        if (pnlNuevoAdministrador.getTxtCedula().getText().equals("Ingrese la cédula del Administrador") || pnlNuevoAdministrador.getTxtCedula().getText().isEmpty()) {
            mostrarImagenAlertaCedula();
        } else {
            mostrarImagenBlancaCedula();
        }

        if (pnlNuevoAdministrador.getTxtNombreUsuario().getText().equals("Ingrese el nombre del administrador") || pnlNuevoAdministrador.getTxtNombreUsuario().getText().isEmpty()) {
            mostrarImagenAlertaUsuario();
        } else {
            mostrarImagenBlancaUsuario();
        }

        if (pnlNuevoAdministrador.getPswContrasenia().getText().equals("*******************************") || pnlNuevoAdministrador.getPswContrasenia().getText().isEmpty()) {
            mostrarImagenAlertaContraseña();
        } else {
            mostrarImagenBlancaContraseña();
        }

        if (pnlNuevoAdministrador.getTxtTelefono().getText().equals("Ingrese su número de telefono") || pnlNuevoAdministrador.getTxtTelefono().getText().isEmpty()) {
            mostrarImagenAlertaTelefono();
        } else {
            mostrarImagenBlancaTelefono();
        }

        if (pnlNuevoAdministrador.getTxtCargo().getText().equals("Ingrese su cargo en la empresa") || pnlNuevoAdministrador.getTxtCargo().getText().isEmpty()) {
            mostrarImagenAlertaCargo();
        } else {
            mostrarImagenBlancaCargo();
        }

        if (pnlNuevoAdministrador.getTxtSueldo().getText().equals("Sueldo del Administrador") || pnlNuevoAdministrador.getTxtSueldo().getText().isEmpty()) {
            mostrarImagenAlertaSueldo();
        } else {
            mostrarImagenBlancaSueldo();
        }

        if (pnlNuevoAdministrador.getTxtNombre().getText().equals("Ingrese su nombre") || pnlNuevoAdministrador.getTxtNombre().getText().isEmpty()
                || pnlNuevoAdministrador.getTxtApellido().getText().equals("Ingrese el apellido del usuario") || pnlNuevoAdministrador.getTxtApellido().getText().isEmpty()
                || pnlNuevoAdministrador.getTxtNombreUsuario().getText().equals("Ingrese el nombre del administrador") || pnlNuevoAdministrador.getTxtNombreUsuario().getText().isEmpty()
                || pnlNuevoAdministrador.getPswContrasenia().getText().equals("*******************************") || pnlNuevoAdministrador.getPswContrasenia().getText().isEmpty()
                || pnlNuevoAdministrador.getTxtTelefono().getText().equals("Ingrese su número de telefono") || pnlNuevoAdministrador.getTxtTelefono().getText().isEmpty()
                || pnlNuevoAdministrador.getTxtCargo().getText().equals("Ingrese su cargo en la empresa") || pnlNuevoAdministrador.getTxtCargo().getText().isEmpty()
                || pnlNuevoAdministrador.getTxtSueldo().getText().equals("Sueldo del Administrador") || pnlNuevoAdministrador.getTxtSueldo().getText().isEmpty()
                || pnlNuevoAdministrador.getTxtCedula().getText().equals("Ingrese la cédula del Administrador") || pnlNuevoAdministrador.getTxtCedula().getText().isEmpty()
                || !pnlNuevoAdministrador.getLblAlertaTextoSueldo().getText().isEmpty()) {
            pnlNuevoAdministrador.getBtnGuardar().setEnabled(false);

        } else {
            pnlNuevoAdministrador.getBtnGuardar().setEnabled(true);
        }

    }

}
