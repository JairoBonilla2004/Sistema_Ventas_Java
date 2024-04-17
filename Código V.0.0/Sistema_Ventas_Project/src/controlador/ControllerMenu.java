package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.AdministradorDAO;
import modelo.UsuarioDAO;
import vista.FrmLogin;
import vista.FrmMenu;
import vista.PnlBienvenida;
import vista.PnlGestionarAdministradores;
import vista.PnlGestionarCategorias;
import vista.PnlGestionarEmpleados;
import vista.PnlGestionarProductos;

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
        this.frmMenu.getBtnEmpleado().addActionListener(this);
        this.frmMenu.getBtnProducto().addActionListener(this);
        this.frmMenu.getBtnCategoria().addActionListener(this);
        iniciarPnlBienvenida();
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
        
        if(e.getSource() == frmMenu.getBtnEmpleado()){
            iniciarPnlEmpleado();
        }
        
        if(e.getSource() == frmMenu.getBtnCerrarSesion()){
            frmMenu.dispose();
            FrmMenu.reiniciarInstancia();
            FrmLogin frmLogin = new FrmLogin();
            frmLogin.setVisible(true);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ControllerLogin controllerLogin = new ControllerLogin(usuarioDAO, frmLogin);
            controllerLogin.iniciarFRM();
        }
        
        if(e.getSource() == frmMenu.getLblNombreUsuarioLoing()){
            frmMenu.getLblNombreUsuarioLoing().setVisible(true);
        }
        
        if(e.getSource() == frmMenu.getBtnProducto()){
            iniciarPnlGestionarProducto();
        }
        
        if(e.getSource() == frmMenu.getBtnCategoria()){
            iniciarPnlCategoria();
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
        pnlBienvenida.setSize(1000, 600);
        pnlBienvenida.setLocation(0, 0);
        this.frmMenu.getPnlContenido().removeAll();
        this.frmMenu.getPnlContenido().add(pnlBienvenida, BorderLayout.CENTER);
        this.frmMenu.getPnlContenido().revalidate();
        this.frmMenu.getPnlContenido().repaint();
    }
    
    public void iniciarPnlCategoria() {
        PnlGestionarCategorias pnlCategoria = new PnlGestionarCategorias();
        pnlCategoria.setSize(1000, 600);
        pnlCategoria.setLocation(0, 0);
        this.frmMenu.getPnlContenido().removeAll();
        this.frmMenu.getPnlContenido().add(pnlCategoria, BorderLayout.CENTER);
        this.frmMenu.getPnlContenido().revalidate();
        this.frmMenu.getPnlContenido().repaint();
    }
    
    public void iniciarPnlGestionarProducto() {
        PnlGestionarProductos pnlGestionarProductos = new PnlGestionarProductos();
        pnlGestionarProductos.setSize(1000, 600);
        pnlGestionarProductos.setLocation(0, 0);
        this.frmMenu.getPnlContenido().removeAll();
        this.frmMenu.getPnlContenido().add(pnlGestionarProductos, BorderLayout.CENTER);
        this.frmMenu.getPnlContenido().revalidate();
        this.frmMenu.getPnlContenido().repaint();
    }
    
    public void iniciarPnlEmpleado(){
        PnlGestionarEmpleados pnlGestionarUsuario = new PnlGestionarEmpleados(frmMenu.getNombreDeUsuario());
        pnlGestionarUsuario.setSize(1000, 600);
        pnlGestionarUsuario.setLocation(0, 0);
        frmMenu.getPnlContenido().removeAll();
        frmMenu.getPnlContenido().add(pnlGestionarUsuario, BorderLayout.CENTER);
        frmMenu.getPnlContenido().revalidate();
        frmMenu.getPnlContenido().repaint();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ControllerGestionarEmpleados controllerGestionarEmpleados = new ControllerGestionarEmpleados(pnlGestionarUsuario, usuarioDAO);
        controllerGestionarEmpleados.iniciar();
        controllerGestionarEmpleados.setObjectId(frmMenu.getObjectId());
    }
    
    public void verificarAdministrador() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean usuarioExistente = usuarioDAO.verificarPersonaExistente("usuario",frmMenu.getLblNombreUsuarioLoing().getText());
        if (usuarioExistente == true) {
            JOptionPane.showMessageDialog(null, "USTED ESTÁ REGISTRADO COMO EMPLEADO NO PUEDE ACCEDER A ESTA OPCIÓN", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
        } else {
            PnlGestionarAdministradores pnlAdministrador = new PnlGestionarAdministradores(frmMenu.getLblNombreUsuarioLoing().getText());
            pnlAdministrador.setSize(1000, 600);
            pnlAdministrador.setLocation(0, 0);
            frmMenu.getPnlContenido().removeAll();
            frmMenu.getPnlContenido().add(pnlAdministrador, BorderLayout.CENTER);
            frmMenu.getPnlContenido().revalidate();
            frmMenu.getPnlContenido().repaint();
            AdministradorDAO administradorDAO = new AdministradorDAO();
            ControllerGestionarAdministradores controllerGestionarAdministradores = new ControllerGestionarAdministradores(pnlAdministrador, administradorDAO);
            controllerGestionarAdministradores.inicializarDatos();
            controllerGestionarAdministradores.setObjectID(frmMenu.getObjectId());
        }
    }
    
}
