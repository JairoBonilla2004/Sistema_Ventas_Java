/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.AdministradorDAO;
import vista.FrmMenu;
import vista.PnlActualizarAdministradores;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerActualizarAdministradores implements MouseListener{
    private PnlActualizarAdministradores pnlActualizarAdministradores;
    private AdministradorDAO administradorDAO;
    private String id;

    public ControllerActualizarAdministradores(PnlActualizarAdministradores pnlActualizarAdministradores, AdministradorDAO administradorDAO, String id) {
        this.pnlActualizarAdministradores = pnlActualizarAdministradores;
        this.administradorDAO = administradorDAO;
        this.id = id;
        this.pnlActualizarAdministradores.getBtnGuardar().addMouseListener(this);
    }
    
    public void iniciar(){
        cambiarColeresLetras(Color.GRAY);
        cambiarColorTextos(Color.WHITE);
        extraerDatosAdministrador();
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
        pnlActualizarAdministradores.getTxtCedula().setText(nuevo_administrador.getCedula());
        cambiarColeresLetras(Color.BLACK);
    }
    
    public void cambiarColorTextos(Color color) {
        pnlActualizarAdministradores.getTxtAdministrador().setBackground(color);
        pnlActualizarAdministradores.getTxtApellido().setBackground(color);
        pnlActualizarAdministradores.getTxtNombre().setBackground(color);
        pnlActualizarAdministradores.getTxtTelefono().setBackground(color);
        pnlActualizarAdministradores.getTxtCargo().setBackground(color);
        pnlActualizarAdministradores.getTxtSueldo().setBackground(color);
        pnlActualizarAdministradores.getTxtCedula().setBackground(color);
    }
    
    public void cambiarColeresLetras(Color color) {
        pnlActualizarAdministradores.getTxtAdministrador().setForeground(color);
        pnlActualizarAdministradores.getTxtApellido().setForeground(color);
        pnlActualizarAdministradores.getTxtNombre().setForeground(color);
        pnlActualizarAdministradores.getTxtTelefono().setForeground(color);
        pnlActualizarAdministradores.getTxtCargo().setForeground(color);
        pnlActualizarAdministradores.getTxtSueldo().setForeground(color);
        pnlActualizarAdministradores.getTxtCedula().setForeground(color);
    }
    
    public void cambiarLbl() {
        pnlActualizarAdministradores.getLblTituloNombre().setForeground(Color.BLACK);
        pnlActualizarAdministradores.getLblTituloAdministrador().setForeground(Color.BLACK);
        pnlActualizarAdministradores.getLblTituloApellido().setForeground(Color.BLACK);
        pnlActualizarAdministradores.getLblTituloTelefono().setForeground(Color.BLACK);
        pnlActualizarAdministradores.getLblTituloCargo().setForeground(Color.BLACK);
        pnlActualizarAdministradores.getLblTituloSueldo().setForeground(Color.BLACK);
    }
     public void mostrarImagenAlertaAdministrador() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaAdministrador().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaAdministrador() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaAdministrador().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaContraseña() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaTelefono().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaContraseña() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaTelefono().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaNombre() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaNombre().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaNombre() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaNombre().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaApellido() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaApellido().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaApellido() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaApellido().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaTelefono() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaTelefono().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaTelefono() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaTelefono().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaCargo() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaCargo().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaCargo() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaCargo().setIcon(icono);
        }
    }

    public void mostrarImagenAlertaSueldo() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaSueldo().setIcon(icono);
        }
    }

    public void mostrarImagenBlancaSueldo() {
        java.net.URL imageURL = getClass().getResource("/img/whiteSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            pnlActualizarAdministradores.getLblAlertaSueldo().setIcon(icono);
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
    public void animmacionTextoNombre() {
        if (pnlActualizarAdministradores.getTxtNombre().getText().equals("Ingrese su nombre")) {
            pnlActualizarAdministradores.getTxtNombre().setText("");
            pnlActualizarAdministradores.getTxtNombre().setForeground(Color.BLACK);
        }

        if (pnlActualizarAdministradores.getTxtApellido().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtApellido().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlActualizarAdministradores.getTxtAdministrador().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtAdministrador().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtAdministrador().setText("Ingrese el nombre del administrador");
        }

        if (pnlActualizarAdministradores.getTxtTelefono().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtTelefono().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtTelefono().setText("Ingrese su número de telefono");
        }

        if (pnlActualizarAdministradores.getTxtCargo().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtCargo().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }

        if (pnlActualizarAdministradores.getTxtSueldo().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtSueldo().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtSueldo().setText("Sueldo del Administrador");

        }
    }
    
        public void validarDatos() {
        if (pnlActualizarAdministradores.getTxtNombre().getText().equals("Ingrese su nombre") || pnlActualizarAdministradores.getTxtNombre().getText().isEmpty()) {
            mostrarImagenAlertaNombre();
        } else {
            mostrarImagenBlancaNombre();
        }

        if (pnlActualizarAdministradores.getTxtApellido().getText().equals("Ingrese el apellido del usuario") || pnlActualizarAdministradores.getTxtApellido().getText().isEmpty()) {
            mostrarImagenAlertaApellido();
        } else {
            mostrarImagenBlancaApellido();
        }

        if (pnlActualizarAdministradores.getTxtAdministrador().getText().equals("Ingrese el nombre del administrador") || pnlActualizarAdministradores.getTxtAdministrador().getText().isEmpty()) {
            mostrarImagenAlertaAdministrador();
        } else {
            mostrarImagenBlancaAdministrador();
        }

        if (pnlActualizarAdministradores.getTxtTelefono().getText().equals("Ingrese su número de telefono") || pnlActualizarAdministradores.getTxtTelefono().getText().isEmpty()) {
            mostrarImagenAlertaTelefono();
        } else {
            mostrarImagenBlancaTelefono();
        }

        if (pnlActualizarAdministradores.getTxtCargo().getText().equals("Ingrese su cargo en la empresa") || pnlActualizarAdministradores.getTxtCargo().getText().isEmpty()) {
            mostrarImagenAlertaCargo();
        } else {
            mostrarImagenBlancaCargo();
        }

        if (pnlActualizarAdministradores.getTxtSueldo().getText().equals("Sueldo del Administrador") || pnlActualizarAdministradores.getTxtSueldo().getText().isEmpty()) {
            mostrarImagenAlertaSueldo();
        } else {
            mostrarImagenBlancaSueldo();
        }

        if (pnlActualizarAdministradores.getTxtNombre().getText().equals("Ingrese su nombre") || pnlActualizarAdministradores.getTxtNombre().getText().isEmpty()
                || pnlActualizarAdministradores.getTxtApellido().getText().equals("Ingrese el apellido del usuario") || pnlActualizarAdministradores.getTxtApellido().getText().isEmpty()
                || pnlActualizarAdministradores.getTxtAdministrador().getText().equals("Ingrese el nombre del administrador") || pnlActualizarAdministradores.getTxtAdministrador().getText().isEmpty()
                || pnlActualizarAdministradores.getTxtTelefono().getText().equals("Ingrese su número de telefono") || pnlActualizarAdministradores.getTxtTelefono().getText().isEmpty()
                || pnlActualizarAdministradores.getTxtCargo().getText().equals("Ingrese su cargo en la empresa") || pnlActualizarAdministradores.getTxtCargo().getText().isEmpty()
                || pnlActualizarAdministradores.getTxtSueldo().getText().equals("Sueldo del Administrador") || pnlActualizarAdministradores.getTxtSueldo().getText().isEmpty()) {
            pnlActualizarAdministradores.getBtnGuardar().setEnabled(false);

        } else {
            pnlActualizarAdministradores.getBtnGuardar().setEnabled(true);
        }

    }


    public void animacionTextoApellido() {
        if (pnlActualizarAdministradores.getTxtApellido().getText().equals("Ingrese el apellido del usuario")) {
            pnlActualizarAdministradores.getTxtApellido().setText("");
            pnlActualizarAdministradores.getTxtApellido().setForeground(Color.BLACK);
        }

        if (pnlActualizarAdministradores.getTxtNombre().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtNombre().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtNombre().setText("Ingrese su nombre");
        }

        if (pnlActualizarAdministradores.getTxtAdministrador().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtAdministrador().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtAdministrador().setText("Ingrese el nombre del administrador");
        }

        if (pnlActualizarAdministradores.getTxtTelefono().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtTelefono().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtTelefono().setText("Ingrese su número de telefono");
        }

        if (pnlActualizarAdministradores.getTxtCargo().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtCargo().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }

        if (pnlActualizarAdministradores.getTxtSueldo().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtSueldo().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtSueldo().setText("Sueldo del Administrador");
        }
    }

    public void animacionTextoUsuarioAdministrador() {
        if (pnlActualizarAdministradores.getTxtAdministrador().getText().equals("Ingrese el nombre del administrador")) {
            pnlActualizarAdministradores.getTxtAdministrador().setText("");
            pnlActualizarAdministradores.getTxtAdministrador().setForeground(Color.BLACK);
        }

        if (pnlActualizarAdministradores.getTxtNombre().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtNombre().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtNombre().setText("Ingrese su nombre");
        }

        if (pnlActualizarAdministradores.getTxtApellido().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtApellido().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlActualizarAdministradores.getTxtTelefono().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtTelefono().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtTelefono().setText("Ingrese su número de telefono");
        }

        if (pnlActualizarAdministradores.getTxtCargo().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtCargo().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }

        if (pnlActualizarAdministradores.getTxtSueldo().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtSueldo().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtSueldo().setText("Sueldo del Administrador");
        }

    }

    public void animmacionTextoCargo() {
        if (pnlActualizarAdministradores.getTxtCargo().getText().equals("Ingrese su cargo en la empresa")) {
            pnlActualizarAdministradores.getTxtCargo().setText("");
            pnlActualizarAdministradores.getTxtCargo().setForeground(Color.BLACK);
        }

        if (pnlActualizarAdministradores.getTxtNombre().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtNombre().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtNombre().setText("Ingrese su nombre");
        }

        if (pnlActualizarAdministradores.getTxtApellido().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtApellido().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlActualizarAdministradores.getTxtTelefono().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtTelefono().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtTelefono().setText("Ingrese su número de telefono");
        }

        if (pnlActualizarAdministradores.getTxtSueldo().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtSueldo().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtSueldo().setText("Sueldo del Administrador");
        }
        
        if (pnlActualizarAdministradores.getTxtAdministrador().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtAdministrador().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtAdministrador().setText("Ingrese el nombre del administrador");
        }
    }
  
    public void animacionTextoTelefono() {
        if (pnlActualizarAdministradores.getTxtTelefono().getText().equals("Ingrese su número de telefono")) {
            pnlActualizarAdministradores.getTxtTelefono().setText("");
            pnlActualizarAdministradores.getTxtTelefono().setForeground(Color.BLACK);
        }
        
        if (pnlActualizarAdministradores.getTxtNombre().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtNombre().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtNombre().setText("Ingrese su nombre");
        }

        if (pnlActualizarAdministradores.getTxtApellido().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtApellido().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlActualizarAdministradores.getTxtCargo().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtCargo().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }

        if (pnlActualizarAdministradores.getTxtSueldo().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtSueldo().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtSueldo().setText("Sueldo del Administrador");
        }
        
        if (pnlActualizarAdministradores.getTxtAdministrador().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtAdministrador().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtAdministrador().setText("Ingrese el nombre del administrador");
        }

        
    }

    public void animacionTextoSueldo() {
        if (pnlActualizarAdministradores.getTxtSueldo().getText().equals("Sueldo del Administrador")) {
            pnlActualizarAdministradores.getTxtSueldo().setText("");
            pnlActualizarAdministradores.getTxtSueldo().setForeground(Color.BLACK);
        }
        
         if (pnlActualizarAdministradores.getTxtNombre().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtNombre().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtNombre().setText("Ingrese su nombre");
        }

        if (pnlActualizarAdministradores.getTxtApellido().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtApellido().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtApellido().setText("Ingrese el apellido del usuario");
        }

        if (pnlActualizarAdministradores.getTxtCargo().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtCargo().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtCargo().setText("Ingrese su cargo en la empresa");
        }

        if (pnlActualizarAdministradores.getTxtSueldo().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtSueldo().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtSueldo().setText("Sueldo del Administrador");
        }
        
        if (pnlActualizarAdministradores.getTxtAdministrador().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtAdministrador().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtAdministrador().setText("Ingrese el nombre del administrador");
        }
        
        if (pnlActualizarAdministradores.getTxtTelefono().getText().isEmpty()) {
            pnlActualizarAdministradores.getTxtTelefono().setForeground(Color.GRAY);
            pnlActualizarAdministradores.getTxtTelefono().setText("Ingrese su número de telefono");
        }

        
    }
    public void actualizar() {
        JLabel lbl = new JLabel();
        Administrador administrador = new Administrador();
        double sueldo = Double.parseDouble(pnlActualizarAdministradores.getTxtSueldo().getText());
        int telefono = Integer.parseInt(pnlActualizarAdministradores.getTxtTelefono().getText());
        administrador.setId(id);
        administrador.setNombre(pnlActualizarAdministradores.getTxtNombre().getText());
        administrador.setApellido(pnlActualizarAdministradores.getTxtApellido().getText());
        administrador.setNombre_usuario(pnlActualizarAdministradores.getTxtAdministrador().getText());
        administrador.setTelefono(telefono);
        administrador.setCargo(pnlActualizarAdministradores.getTxtCargo().getText());
        administrador.setSueldo(sueldo);
        boolean respuesta_actualizacion = administradorDAO.actualizarDatos(administrador);
        if (respuesta_actualizacion) {
            JOptionPane.showMessageDialog(
                    null,
                    "ADMINISTRADOR ACTUALIZADO CON ÉXITO",
                    "MESSAGE",
                    JOptionPane.INFORMATION_MESSAGE,
                    activarVistoVerde());
            lbl.setText(administrador.getNombre_usuario());
            FrmMenu frmMenu = FrmMenu.getInstance(lbl.getText());
            frmMenu.getLblNombreUsuarioLoing().setText(lbl.getText());
            frmMenu.getLblNombreUsuarioLoing().setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == pnlActualizarAdministradores.getBtnGuardar()){
            actualizar();
        }
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
