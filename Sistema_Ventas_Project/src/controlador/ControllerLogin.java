package controlador;

import java.awt.Color;
import java.awt.HeadlessException;
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
import vista.FrmLogin;

/**
 *
 * @author ACER
 */
public class ControllerLogin implements MouseListener, KeyListener{
    
    private UsuarioDAO usuarioDAO;
    private FrmLogin frmLogin;

    public ControllerLogin(UsuarioDAO usuarioDAO, FrmLogin frmLogin) {
        this.usuarioDAO = usuarioDAO;
        this.frmLogin = frmLogin;
        this.frmLogin.getTxtUsuario().addMouseListener(this);
        this.frmLogin.getPswContraseña().addMouseListener(this);
        this.frmLogin.getTxtUsuario().addKeyListener(this);
        this.frmLogin.getPswContraseña().addKeyListener(this);
        this.frmLogin.getBtnIniciar_Sesion().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == frmLogin.getBtnIniciar_Sesion()){
            verificarUsuarioContraseñaCorrectos();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == frmLogin.getTxtUsuario()){
            vaciarCamposUsuario();
        }
        if(e.getSource() == frmLogin.getPswContraseña()){
            vaciarCampoContraseña();
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
        if(e.getSource() == frmLogin.getTxtUsuario()){
            validarDatos();
        }
        
        if(e.getSource() == frmLogin.getPswContraseña()){
            validarDatos();
        }
    }
    
    public void vaciarCamposUsuario(){
        if (frmLogin.getTxtUsuario().getText().equals("Ingrese su nombre de usuario")) {
            frmLogin.getTxtUsuario().setText("");
            frmLogin.getTxtUsuario().setForeground(Color.BLACK);
        }
        if (frmLogin.getPswContraseña().getText().equals("")) {
            frmLogin.getPswContraseña().setForeground(Color.GRAY);
            frmLogin.getPswContraseña().setText("**************************");

        }
    }
    
    public void vaciarCampoContraseña(){
        if (frmLogin.getPswContraseña().getText().equals("**************************")) {
            frmLogin.getPswContraseña().setText("");
            frmLogin.getPswContraseña().setForeground(Color.BLACK);
        }
        if (frmLogin.getTxtUsuario().getText().equals("")) {
            frmLogin.getTxtUsuario().setForeground(Color.GRAY);
            frmLogin.getTxtUsuario().setText("Ingrese su nombre de usuario");
        }
    }
    
        public void verificarUsuarioContraseñaCorrectos() {
        Usuario usuario = new Usuario(frmLogin.getTxtUsuario().getText(), frmLogin.getPswContraseña().getText());
        Administrador administrador = new Administrador(frmLogin.getTxtUsuario().getText(), frmLogin.getPswContraseña().getText());
        AdministradorDAO administradorDAO = new AdministradorDAO();
        boolean respuestaUsuario = usuarioDAO.verificarCamposCorrectosUsuarioAdministrador(usuario);
        boolean respuestaAdministrador = administradorDAO.verificarCamposCorrectosUsuario(administrador);
        if (respuestaUsuario) {
            frmLogin.setVisible(false);
           // FrmMenu frmMenu = new FrmMenu(txtUsuario.getText());
          //  frmMenu.setVisible(true);
        } else {
            if (respuestaAdministrador) {
                frmLogin.setVisible (false);
            //    FrmMenu frmMenu = new FrmMenu(txtUsuario.getText());
              //  frmMenu.setVisible(true);
            }
        }

        if (respuestaUsuario == false && respuestaAdministrador == false) {
            try {
                JOptionPane.showMessageDialog(null, "USUARIO O CONTRAASEÑA INCORRECTA", "MESSAGE", JOptionPane.ERROR_MESSAGE);
                eliminarCaracteres();
                validarDatos();
            } catch (HeadlessException e) {
                System.out.println("excepción: " + e);
            }
        }
    }

    public void eliminarCaracteres() {
        frmLogin.getTxtUsuario().setForeground(Color.GRAY);
        frmLogin.getPswContraseña().setForeground(Color.GRAY);
        frmLogin.getTxtUsuario().setText("Ingrese su nombre de usuario");
        frmLogin.getPswContraseña().setText("**************************");
    }
    
        public void validarDatos() {
        if (frmLogin.getTxtUsuario().getText().isEmpty() || frmLogin.getTxtUsuario().getText().equals("Ingrese su nombre de usuario")) {
            frmLogin.getLblUsuario().setText("Campo Obligatorio");
            mostrarImagenAlertaUsuario();
        } else {
            frmLogin.getLblUsuario().setText("");
            mostrarImagenBlancaUsuario();
        }

        if (frmLogin.getPswContraseña().getText().equals("**************************") || frmLogin.getPswContraseña().getText().isEmpty()) {
            mostrarImagenAlertaContraseña();
            frmLogin.getLblContraseña().setText("Campo Obligatorio");
        } else {
            frmLogin.getLblContraseña().setText("");
            mostrarImagenBlancaContraseña();
        }

        if (frmLogin.getTxtUsuario().getText().isEmpty() || frmLogin.getTxtUsuario().getText().equals("Ingrese su nombre de usuario")
                || frmLogin.getPswContraseña().getText().equals("**************************") || frmLogin.getPswContraseña().getText().isEmpty()) {
            frmLogin.getBtnIniciar_Sesion().setEnabled(false);
        } else {
            frmLogin.getBtnIniciar_Sesion().setEnabled(true);
        }
    }
    
    public void mostrarImagenAlertaUsuario() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            frmLogin.getLblAlertaUsuario().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaUsuario() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            frmLogin.getLblAlertaUsuario().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaContraseña() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            frmLogin.getLblAlertaContraseña().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaContraseña() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            frmLogin.getLblAlertaContraseña().setIcon(icono);
        }
    }    
    
    public void iniciarFRM(){
        frmLogin.setLocationRelativeTo(null);
    }
    
    
}
