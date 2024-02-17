/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import controlador.ControllerLogin;
import modelo.UsuarioDAO;
import vista.FrmLogin;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class Main {
    public static void main(String[] args) {
        FlatMaterialLighterIJTheme.setup();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        FrmLogin frmLogin = new FrmLogin();
        ControllerLogin controllerLogin = new ControllerLogin(usuarioDAO, frmLogin);
        controllerLogin.iniciarFRM();
        frmLogin.setVisible(true);
    }
    
}
