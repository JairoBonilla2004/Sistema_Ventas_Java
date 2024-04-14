package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AdministradorDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import org.bson.types.ObjectId;
import vista.PnlActualizarEmpleados;
import vista.PnlGestionarEmpleados;
import vista.PnlNuevoEmpleado;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public final class ControllerGestionarEmpleados implements KeyListener, MouseListener {

    private final PnlGestionarEmpleados pnlGestionarEmpleados;
    private final UsuarioDAO usuarioDAO;
    private final DefaultTableModel modeloTabla = new DefaultTableModel();
    private ObjectId objectId;

    public ControllerGestionarEmpleados(PnlGestionarEmpleados pnlGestionarEmpleados, UsuarioDAO usuarioDAO) {
        this.pnlGestionarEmpleados = pnlGestionarEmpleados;
        this.usuarioDAO = usuarioDAO;
        this.pnlGestionarEmpleados.getTxtBuscarEmpleado().addKeyListener(this);
        this.pnlGestionarEmpleados.getTxtBuscarEmpleado().addMouseListener(this);
        this.pnlGestionarEmpleados.getBtnEliminar().addMouseListener(this);
        this.pnlGestionarEmpleados.getTblEmpleados().addMouseListener(this);
        this.pnlGestionarEmpleados.getBtnNuevoUsuario().addMouseListener(this);
        this.pnlGestionarEmpleados.getBtnActualizar().addMouseListener(this);
    }

    public void iniciar() {
        pnlGestionarEmpleados.getTxtBuscarEmpleado().setBackground(Color.WHITE);
        inicializarNombresTabla();
        llenarDatosTabla();
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }
    

    public void inicializarNombresTabla() {

        String nombres[] = {"CÉDULA", "NOMBRE", "APELLIDO", "USUARIO", "TELEFONO", "SUELDO"};
        modeloTabla.setColumnIdentifiers(nombres);
        pnlGestionarEmpleados.getTblEmpleados().setModel(modeloTabla);
        pnlGestionarEmpleados.getTblEmpleados().setDefaultEditor(Object.class, null);
        pnlGestionarEmpleados.getTblEmpleados().setFocusable(false);//Para que no aparezcan las casillas de color negro
        pnlGestionarEmpleados.getTblEmpleados().setSelectionBackground(new Color(255, 204, 204));

    }

    public String obtenerNombreSeleccionado() {
        int filaSeleccionada = pnlGestionarEmpleados.getTblEmpleados().getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtener el valor de la celda correspondiente a la columna "Nombre"
            Object valorNombre = pnlGestionarEmpleados.getTblEmpleados().getValueAt(filaSeleccionada, 1); // 0 es el índice de la columna "Nombre"
            if (valorNombre != null) {
                return valorNombre.toString();
            }
        }
        return null; // Retornar null si no se seleccionó ninguna fila o si el valor es nulo
    }

    public String obtenerCedulaSeleccionado() {
        int filaSeleccionada = pnlGestionarEmpleados.getTblEmpleados().getSelectedRow();

        if (filaSeleccionada >= 0) {
            Object id = pnlGestionarEmpleados.getTblEmpleados().getValueAt(filaSeleccionada, 0);
            if (id != null) {
                return id.toString();
            }
        }
        return null;
    }

    public ImageIcon activarVistoVerde() {
        java.net.URL imageURL = getClass().getResource("/img/greenSeen.png");
        ImageIcon icono = null;
        if (imageURL != null) {
            icono = new ImageIcon(imageURL);
        }
        return icono;
    }

    public String obtenerUsuario() {
        int filaSeleccionada = pnlGestionarEmpleados.getTblEmpleados().getSelectedRow();
        if (filaSeleccionada >= 0) {
            Object usuario = pnlGestionarEmpleados.getTblEmpleados().getValueAt(filaSeleccionada, 3);
            if (usuario != null) {
                return usuario.toString();
            }
        }
        return null;
    }

    public void llenarDatosTabla() {
        List<Usuario> usuarios = usuarioDAO.extraerPersonas();
        for (Usuario u : usuarios) {
            Object object[] = {u.getCedula(), u.getNombre(), u.getApellido(), u.getNombre_usuario(), u.getTelefono(), u.getSueldoEmpleado()};
            modeloTabla.addRow(object);
        }
        pnlGestionarEmpleados.getTblEmpleados().setModel(modeloTabla);
        pnlGestionarEmpleados.getTblEmpleados().setForeground(Color.BLACK);
        pnlGestionarEmpleados.getTblEmpleados().setShowGrid(true); // Muestra la cuadrícula
        pnlGestionarEmpleados.getTblEmpleados().setShowVerticalLines(true); // Muestra las líneas verticales de la cuadrícula
        pnlGestionarEmpleados.getTblEmpleados().setGridColor(Color.BLACK); // Establece el color de las líneas de la cuadrícula
    }

    public void vaciarTabla(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Vaciar la tabla
    }

    public void llenarDatosTblMedianteBusqueda() {
        vaciarTabla(modeloTabla);
        List<Usuario> usuarios = usuarioDAO.buscarPersonasPorTextoRegEx(pnlGestionarEmpleados.getTxtBuscarEmpleado().getText());
        for (Usuario u : usuarios) {
            Object object[] = {u.getCedula(), u.getNombre(), u.getApellido(), u.getNombre_usuario(), u.getTelefono()};
            modeloTabla.addRow(object);
        }
        pnlGestionarEmpleados.getTblEmpleados().setModel(modeloTabla);
    }

    public void eliminarUsuarios() {
        int fila = pnlGestionarEmpleados.getTblEmpleados().getSelectedRow();
        String id = obtenerCedulaSeleccionado();
        if (id != null) {
            int respuesta = JOptionPane.showConfirmDialog(null, " ¿Está seguro de que desea eliminar este Empleado?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                if (usuarioDAO.eliminarPersona(id)) {
                    JOptionPane.showMessageDialog(
                            null,
                            "   EMPLEADO ELIMINADO CON ÉXITO",
                            "CONFIRMACIÓN",
                            JOptionPane.INFORMATION_MESSAGE,
                            activarVistoVerde());
                    modeloTabla.removeRow(fila);
                    pnlGestionarEmpleados.getTxtBuscarEmpleado().setForeground(Color.GRAY);
                    pnlGestionarEmpleados.getTxtBuscarEmpleado().setText("Ingrese el nombre del empleado que desea buscar");

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA DE LA TABLA", "MESSAGE", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == pnlGestionarEmpleados.getTxtBuscarEmpleado()) {
            llenarDatosTblMedianteBusqueda();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == pnlGestionarEmpleados.getTblEmpleados()) {
            String nombre_seleccionado = obtenerNombreSeleccionado();
            pnlGestionarEmpleados.getTxtBuscarEmpleado().setForeground(Color.BLACK);
            pnlGestionarEmpleados.getTxtBuscarEmpleado().setText(nombre_seleccionado);
        }

        if (e.getSource() == pnlGestionarEmpleados.getBtnEliminar()) {
            if (!usuarioDAO.verificarPersonaExistente("usuario", pnlGestionarEmpleados.getNombreUsuario())) {
                eliminarUsuarios();
            } else {
                JOptionPane.showMessageDialog(null, "SOLO LOS ADMINISTRADORES TIENEN ACCESO A ESTA OPCION", "MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource() == pnlGestionarEmpleados.getBtnNuevoUsuario()){
            añadirNuevoEmpleado();
        }
        
        if(e.getSource() == pnlGestionarEmpleados.getBtnActualizar()){
            actualizarEmpleado();
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == pnlGestionarEmpleados.getTxtBuscarEmpleado()) {
            if (pnlGestionarEmpleados.getTxtBuscarEmpleado().getText().equals("Ingrese el nombre del empleado que desea buscar")) {
                pnlGestionarEmpleados.getTxtBuscarEmpleado().setText("");
                pnlGestionarEmpleados.getTxtBuscarEmpleado().setForeground(Color.GRAY);
            }
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

    public void añadirNuevoEmpleado() {
        PnlNuevoEmpleado pnlNuevoEmpleado = new PnlNuevoEmpleado();
        pnlNuevoEmpleado.setSize(1000, 600);
        pnlNuevoEmpleado.setLocation(0, 0);
        pnlGestionarEmpleados.getPnlContenido().removeAll();
        pnlGestionarEmpleados.getPnlContenido().add(pnlNuevoEmpleado, BorderLayout.CENTER);
        pnlGestionarEmpleados.getPnlContenido().revalidate();
        pnlGestionarEmpleados.getPnlContenido().repaint();
        ControllerPnlNuevoEmpleado controllerPnlNuevoEmpleado = new ControllerPnlNuevoEmpleado(pnlNuevoEmpleado, usuarioDAO);
        controllerPnlNuevoEmpleado.iniciar();
    }
    
    public String obtenerCampoFilaSeleccionado(int columna) {
        int filaSeleccionada = pnlGestionarEmpleados.getTblEmpleados().getSelectedRow();
        if (filaSeleccionada >= 0) {
            Object nombreAdministrador = pnlGestionarEmpleados.getTblEmpleados().getValueAt(filaSeleccionada, columna);
            if (nombreAdministrador != null) {
                return nombreAdministrador.toString();
            }
        }
        return null;
    }
    
    public void actualizarEmpleado(){
        String id = obtenerCedulaSeleccionado();
        String usuario = obtenerUsuario();
        if ((id != null) && (usuario != null)) {
            AdministradorDAO administradorDAO = new AdministradorDAO();
            Usuario usuerTablaSeleccionada = usuarioDAO.buscarEmpleadoPorUsuario(obtenerCampoFilaSeleccionado(3));
            boolean administradorExistente = administradorDAO.verificarPersonaExistente("_id",objectId);
            if (objectId.equals(usuerTablaSeleccionada.getObjectId()) || (administradorExistente == true)) {
                PnlActualizarEmpleados pnlActualizarUsuarios = new PnlActualizarEmpleados();
                pnlActualizarUsuarios.setSize(1000, 600);
                pnlActualizarUsuarios.setLocation(0, 0);
                pnlGestionarEmpleados.getPnlContenido().removeAll();
                pnlGestionarEmpleados.getPnlContenido().add(pnlActualizarUsuarios, BorderLayout.CENTER);
                pnlGestionarEmpleados.getPnlContenido().revalidate();
                pnlGestionarEmpleados.getPnlContenido().repaint();
                ControllerActualizarEmpleado controllerActualizarEmpleado = new ControllerActualizarEmpleado(pnlActualizarUsuarios, usuarioDAO);
                controllerActualizarEmpleado.iniciar(usuerTablaSeleccionada.getObjectId());
                controllerActualizarEmpleado.setObjectIDInicioSecion(objectId);

            } else {
                JOptionPane.showMessageDialog(null, "NO ES PERMITIDO MODIFICAR LOS DATOS DE OTROS EMPLEADOS", "MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA DE LA TABLA", "MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }
}
