
package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Administrador;
import modelo.AdministradorDAO;
import vista.PnlGestionarAdministradores;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerGestionarAdministradores implements MouseListener, KeyListener{
    private final PnlGestionarAdministradores pnlGestionarAdministradores;
    private final AdministradorDAO administradorDAO;
    private  Administrador administrador;
    private final DefaultTableModel modelo_tabla = new DefaultTableModel();
    public ControllerGestionarAdministradores(PnlGestionarAdministradores pnlGestionarAdministradores, AdministradorDAO administradorDAO, Administrador administrador) {
        this.pnlGestionarAdministradores = pnlGestionarAdministradores;
        this.administradorDAO = administradorDAO;
        this.administrador = administrador;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    public void inicializarDatos(){
        pnlGestionarAdministradores.getTxtBuscarAdministradores().setBackground(Color.WHITE);
        inicializarNombresTablas();
        llenarTabla();
        
    }
    public void llenarTabla() {
        List<Administrador> administradores = administradorDAO.extraerPersonas();
        for (Administrador a : administradores) {
            Object fila[] = {a.getId(), a.getNombre(), a.getApellido(), a.getNombre_usuario(), a.getTelefono(), a.getCargo(), a.getSueldo()};
            modelo_tabla.addRow(fila);
        }
        pnlGestionarAdministradores.getTblAdministradores().setModel(modelo_tabla);
        pnlGestionarAdministradores.getTblAdministradores().setSelectionBackground(new Color(255, 204, 204));
        pnlGestionarAdministradores.getTblAdministradores().setForeground(Color.BLACK);
        pnlGestionarAdministradores.getTblAdministradores().setShowGrid(true); // Muestra la cuadrícula
        pnlGestionarAdministradores.getTblAdministradores().setShowVerticalLines(true); // Muestra las líneas verticales de la cuadrícula
        pnlGestionarAdministradores.getTblAdministradores().setGridColor(Color.BLACK); // Establece el color de las líneas de la cuadrícula
    }
    
    public void inicializarNombresTablas() {
        String nombres[] = {"ID", "NOMBRE", "APELLIDO", "ADMINISTRADOR", "TELEFONO", "CARGO", "SUELDO"};
        modelo_tabla.setColumnIdentifiers(nombres);
        pnlGestionarAdministradores.getTblAdministradores().setModel(modelo_tabla);
        pnlGestionarAdministradores.getTblAdministradores().setDefaultEditor(Object.class, null);
        pnlGestionarAdministradores.getTblAdministradores().setFocusable(false);
    }
    
    
    
}
