/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import modelo.UsuarioDAO;
import vista.PnlNuevoEmpleado;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerPnlNuevoEmpleado {
    
    private final PnlNuevoEmpleado pnlNuevoEmpleado;
    private final UsuarioDAO usuarioDAO;

    public ControllerPnlNuevoEmpleado(PnlNuevoEmpleado pnlNuevoEmpleado, UsuarioDAO usuarioDAO) {
        this.pnlNuevoEmpleado = pnlNuevoEmpleado;
        this.usuarioDAO = usuarioDAO;
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
    
    
    
}
