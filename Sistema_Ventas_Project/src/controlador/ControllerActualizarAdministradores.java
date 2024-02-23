/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import modelo.Administrador;
import modelo.AdministradorDAO;
import vista.PnlActualizarAdministradores;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerActualizarAdministradores {
    private PnlActualizarAdministradores pnlActualizarAdministradores;
    private AdministradorDAO administradorDAO;
    private String id;

    public ControllerActualizarAdministradores(PnlActualizarAdministradores pnlActualizarAdministradores, AdministradorDAO administradorDAO, String id) {
        this.pnlActualizarAdministradores = pnlActualizarAdministradores;
        this.administradorDAO = administradorDAO;
        this.id = id;
    }
    
    public void extraerDatosAdministrador() {
        Administrador nuevo_administrador = administradorDAO.extraerPersonaID(id);
        String telefono = String.valueOf(nuevo_administrador.getTelefono());
        String sueldo = String.valueOf(nuevo_administrador.getSueldo());
        pnlActualizarAdministradores.getTxtAdministrador().setText(nuevo_administrador.getNombre_usuario());
        pnlActualizarAdministradores.getTxtApellido().setText(nuevo_administrador.getApellido());
        pnlActualizarAdministradores.getTxtNombre().setText(nuevo_administrador.getNombre());
        pnlActualizarAdministradores.getTxtTelefono().setText(telefono);
        pnlActualizarAdministradores.getTxtCargo().setText(nuevo_administrador.getCargo());
        pnlActualizarAdministradores.getTxtSueldo().setText(sueldo);
        cambiarColeresLetras(Color.BLACK);
    }
    
    public void cambiarColorTextos(Color color) {
        pnlActualizarAdministradores.getTxtAdministrador().setBackground(color);
        pnlActualizarAdministradores.getTxtApellido().setBackground(color);
        pnlActualizarAdministradores.getTxtNombre().setBackground(color);
        pnlActualizarAdministradores.getTxtTelefono().setBackground(color);
        pnlActualizarAdministradores.getTxtCargo().setBackground(color);
        pnlActualizarAdministradores.getTxtSueldo().setBackground(color);
    }
    
    public void cambiarColeresLetras(Color color) {
        pnlActualizarAdministradores.getTxtAdministrador().setForeground(color);
        pnlActualizarAdministradores.getTxtApellido().setForeground(color);
        pnlActualizarAdministradores.getTxtNombre().setForeground(color);
        pnlActualizarAdministradores.getTxtTelefono().setForeground(color);
        pnlActualizarAdministradores.getTxtCargo().setForeground(color);
        pnlActualizarAdministradores.getTxtSueldo().setForeground(color);
    }
    
}
