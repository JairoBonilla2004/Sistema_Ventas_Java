package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.AdministradorDAO;
import modelo.UsuarioDAO;
import vista.FrmLogin;
import vista.FrmMenu;
import vista.PnlBienvenida;
import vista.PnlGestionarAdministradores;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public final class ControllerMenu implements  ActionListener{
    
    private final FrmMenu frmMenu;
    public ControllerMenu(FrmMenu frmMenu){
        this.frmMenu = frmMenu;
        this.frmMenu.getLblNombreUsuarioLoing().setText(this.frmMenu.getNombreDeUsuario());
        llenarLbl();
        this.frmMenu.getBtnIntroduccion().addActionListener(this);
        this.frmMenu.getBtnCerrarSesion().addActionListener(this);
        this.frmMenu.getBtnAdministrador().addActionListener(this);
    }
    
    public void iniciar(){
        frmMenu.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmMenu.getBtnIntroduccion()){
            iniciarPnlBienvenida();
        }
        
        if(e.getSource() == frmMenu.getBtnAdministrador()){
            verificarAdministrador();
        }
        
        if(e.getSource() == frmMenu.getBtnCerrarSesion()){
            frmMenu.setVisible(false);
            FrmLogin frmLogin = new FrmLogin();
            frmLogin.setVisible(true);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ControllerLogin controllerLogin = new ControllerLogin(usuarioDAO, frmLogin);
            controllerLogin.iniciarFRM();
        }
    }
    
    
    public void llenarLbl() {
        UsuarioDAO usuarioDAO= new UsuarioDAO();
        boolean usuarioExistente = usuarioDAO.verificarPersonaExistente("usuario",frmMenu.getNombreDeUsuario());
        if (usuarioExistente == true) {
            frmMenu.getLblCargo().setText("(EMPLEADO)");
        } else {
            frmMenu.getLblCargo().setText("(ADMINISTRADOR)");
        }
    }
    
    public void iniciarPnlBienvenida() {
        PnlBienvenida pnlBienvenida = new PnlBienvenida();
        pnlBienvenida.setSize(970, 510);
        pnlBienvenida.setLocation(0, 0);
        this.frmMenu.getPnlContenido().removeAll();
        this.frmMenu.getPnlContenido().add(pnlBienvenida, BorderLayout.CENTER);
        this.frmMenu.getPnlContenido().revalidate();
        this.frmMenu.getPnlContenido().repaint();
    }
    
    public void verificarAdministrador() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean usuarioExistente = usuarioDAO.verificarPersonaExistente("usuario",frmMenu.getNombreDeUsuario());
        if (usuarioExistente == true) {
            JOptionPane.showMessageDialog(null, "USTED ESTÁ REGISTRADO COMO EMPLEADO NO PUEDE ACCEDER A ESTA OPCIÓN", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
        } else {
            PnlGestionarAdministradores pnlAdministrador = new PnlGestionarAdministradores(frmMenu.getNombreDeUsuario());
            pnlAdministrador.setSize(1000, 600);
            pnlAdministrador.setLocation(0, 0);
            frmMenu.getPnlContenido().removeAll();
            frmMenu.getPnlContenido().add(pnlAdministrador, BorderLayout.CENTER);
            frmMenu.getPnlContenido().revalidate();
            frmMenu.getPnlContenido().repaint();
            AdministradorDAO administradorDAO = new AdministradorDAO();
            Administrador administrador = new Administrador();
            ControllerGestionarAdministradores controllerGestionarAdministradores = new ControllerGestionarAdministradores(pnlAdministrador, administradorDAO, administrador);
            controllerGestionarAdministradores.inicializarDatos();
        }
    }
    
}
