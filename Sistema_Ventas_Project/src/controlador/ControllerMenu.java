package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.UsuarioDAO;
import vista.FrmMenu;

/**
 *
 * @author ACER
 */
public final class ControllerMenu implements  ActionListener{
    
    private final FrmMenu frmMenu;
    public ControllerMenu(FrmMenu frmMenu){
        this.frmMenu = frmMenu;
        this.frmMenu.getLblNombreUsuarioLoing().setText(this.frmMenu.getNombreDeUsuario());
        llenarLbl();
        this.frmMenu.getBtnIntroduccion().addActionListener(this);
        this.frmMenu.getBtnAdministrador().addActionListener(this);
    }
    
    public void iniciar(){
        frmMenu.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmMenu.getBtnIntroduccion()){
            
        }
        
        if(e.getSource() == frmMenu.getBtnAdministrador()){
            
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
    
    
}
