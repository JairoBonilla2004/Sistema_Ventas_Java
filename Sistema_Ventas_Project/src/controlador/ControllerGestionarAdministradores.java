package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Administrador;
import modelo.AdministradorDAO;
import org.bson.types.ObjectId;
import vista.PnlActualizarAdministradores;
import vista.PnlGestionarAdministradores;
import vista.PnlNuevoAdministrador;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerGestionarAdministradores implements MouseListener, KeyListener {

    private final PnlGestionarAdministradores pnlGestionarAdministradores;
    private final AdministradorDAO administradorDAO;
    private final DefaultTableModel modelo_tabla = new DefaultTableModel();
    private  ObjectId objectId = null;

    public ControllerGestionarAdministradores(PnlGestionarAdministradores pnlGestionarAdministradores, AdministradorDAO administradorDAO) {
        this.pnlGestionarAdministradores = pnlGestionarAdministradores;
        this.administradorDAO = administradorDAO;
        this.pnlGestionarAdministradores.getTxtBuscarAdministradores().addMouseListener(this);
        this.pnlGestionarAdministradores.getTblAdministradores().addMouseListener(this);
        this.pnlGestionarAdministradores.getTxtBuscarAdministradores().addKeyListener(this);
        this.pnlGestionarAdministradores.getBtnNuevoUsuario().addMouseListener(this);
        this.pnlGestionarAdministradores.getBtnActualizar().addMouseListener(this);
    }
    
    public void setObjectID(ObjectId objectId){
        this.objectId = objectId;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == pnlGestionarAdministradores.getBtnNuevoUsuario()) {
            añadirNuevoUsuario();
        }
        if (e.getSource() == pnlGestionarAdministradores.getBtnActualizar()) {
            mostrarPnlActualizacionAdministrador();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == pnlGestionarAdministradores.getTxtBuscarAdministradores()) {
            animacionTextoBusqueda();
        }
        if (e.getSource() == pnlGestionarAdministradores.getTblAdministradores()) {
            String nombre_fila = obtenerCampoFilaSeleccionado(1);
            pnlGestionarAdministradores.getTxtBuscarAdministradores().setForeground(Color.BLACK);
            pnlGestionarAdministradores.getTxtBuscarAdministradores().setText(nombre_fila);
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
        if (e.getSource() == pnlGestionarAdministradores.getTxtBuscarAdministradores()) {
            buscarAdministrador();
        }
    }

    public void inicializarDatos() {
        pnlGestionarAdministradores.getTxtBuscarAdministradores().setBackground(Color.WHITE);
        inicializarNombresTablas();
        llenarTabla();

    }

    public void llenarTabla() {
        List<Administrador> administradores = administradorDAO.extraerPersonas();
        for (Administrador a : administradores) {
            Object fila[] = {a.getCedula(), a.getNombre(), a.getApellido(), a.getNombre_usuario(), a.getTelefono(), a.getCargo(), a.getSueldo()};
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
        String nombres[] = {"CÉDULA", "NOMBRE", "APELLIDO", "ADMINISTRADOR", "TELEFONO", "CARGO", "SUELDO"};
        modelo_tabla.setColumnIdentifiers(nombres);
        pnlGestionarAdministradores.getTblAdministradores().setModel(modelo_tabla);
        pnlGestionarAdministradores.getTblAdministradores().setDefaultEditor(Object.class, null);
        pnlGestionarAdministradores.getTblAdministradores().setFocusable(false);
    }

    public void animacionTextoBusqueda() {
        if (pnlGestionarAdministradores.getTxtBuscarAdministradores().getText().equals("Ingrese el nombre del administrador que desea buscar")) {
            pnlGestionarAdministradores.getTxtBuscarAdministradores().setText("");
            pnlGestionarAdministradores.getTxtBuscarAdministradores().setForeground(Color.BLACK);
        }
    }

    public String obtenerCampoFilaSeleccionado(int columna) {
        int filaSeleccionada = pnlGestionarAdministradores.getTblAdministradores().getSelectedRow();
        if (filaSeleccionada >= 0) {
            Object nombreAdministrador = pnlGestionarAdministradores.getTblAdministradores().getValueAt(filaSeleccionada, columna);
            if (nombreAdministrador != null) {
                return nombreAdministrador.toString();
            }
        }
        return null;
    }

    public void buscarAdministrador() {
        vaciarTabla(modelo_tabla);
        List<Administrador> administradoresDB = administradorDAO.buscarPersonasPorTextoRegEx(pnlGestionarAdministradores.getTxtBuscarAdministradores().getText());
        for (Administrador a : administradoresDB) {
            Object[] fila = {a.getId(), a.getNombre(), a.getApellido(), a.getNombre_usuario(), a.getTelefono(), a.getCargo(), a.getSueldo()};
            modelo_tabla.addRow(fila);
        }
        pnlGestionarAdministradores.getTblAdministradores().setModel(modelo_tabla);
    }

    public void vaciarTabla(DefaultTableModel modeloTabla) {
        modeloTabla.setRowCount(0); // Vaciar la tabla
    }

    public void añadirNuevoUsuario() {
        boolean respuesta = administradorDAO.verificarPersonaExistente("administrador", pnlGestionarAdministradores.getNombreUsuario());
        if (respuesta) {
            PnlNuevoAdministrador pnlNuevoAdministrador = new PnlNuevoAdministrador();
            pnlNuevoAdministrador.setSize(1000, 600);
            pnlNuevoAdministrador.setLocation(0, 0);
            pnlGestionarAdministradores.getPnlContenido().removeAll();
            pnlGestionarAdministradores.getPnlContenido().add(pnlNuevoAdministrador, BorderLayout.CENTER);
            pnlGestionarAdministradores.getPnlContenido().revalidate();
            pnlGestionarAdministradores.getPnlContenido().repaint();
            Administrador administrador = new Administrador();
            ControllerNuevoAdministrador controllerNuevoAdministrador = new ControllerNuevoAdministrador(pnlNuevoAdministrador, administradorDAO, administrador);
            controllerNuevoAdministrador.iniciarComponentes();
        } else {
            JOptionPane.showMessageDialog(null, "SOLO LOS ADMINISTRADORES PUEDEN AÑADIR NUEVOS ADIMINISTRADORES", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void mostrarPnlActualizacionAdministrador() {
        String id = ontenerCedulaSeleccionada();
        String usuario_administrador = obtenerCampoFilaSeleccionado(3);
        Administrador administrador = administradorDAO.buscarAdministradorPorUsuario(usuario_administrador);
        System.out.println("administrador"+administrador.getObjectID()+"  usuario que ingresó"+objectId);
        if ((id != null) && (usuario_administrador != null)) {
            if (objectId.equals(administrador.getObjectID())) {
                PnlActualizarAdministradores pnlActualizarAdministrador = new PnlActualizarAdministradores();
                pnlActualizarAdministrador.setSize(1000, 600);
                pnlActualizarAdministrador.setLocation(0, 0);
                pnlGestionarAdministradores.getPnlContenido().removeAll();
                pnlGestionarAdministradores.getPnlContenido().add(pnlActualizarAdministrador, BorderLayout.CENTER);
                pnlGestionarAdministradores.getPnlContenido().revalidate();
                pnlGestionarAdministradores.getPnlContenido().repaint();

            } else {
                JOptionPane.showMessageDialog(null, "NO ES PERMITIDO MODIFICAR LOS DATOS DE OTROS ADMINISTRADORES", "MESSAGE", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA DE LA TABLA", "MESSAGE", JOptionPane.ERROR_MESSAGE);
        }

    }

    public String ontenerCedulaSeleccionada() {
        int filaSeleccionada = pnlGestionarAdministradores.getTblAdministradores().getSelectedRow();
        if (filaSeleccionada >= 0) {
            Object id = pnlGestionarAdministradores.getTblAdministradores().getValueAt(filaSeleccionada, 0);
            if (id != null) {
                return id.toString();
            }
        }
        return null;

    }

}
