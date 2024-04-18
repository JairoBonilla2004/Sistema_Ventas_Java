package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.CategoriaDAO;
import vista.PnlGestionarCategorias;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerGestionarCategorias implements MouseListener, KeyListener{
    
    private final PnlGestionarCategorias pnlGestionarCategorias;
    private final CategoriaDAO categoriaDAO;
    private final DefaultTableModel modelo;

    public ControllerGestionarCategorias(PnlGestionarCategorias pnlGestionarCategorias, CategoriaDAO categoriaDAO) {
        this.pnlGestionarCategorias = pnlGestionarCategorias;
        this.categoriaDAO = categoriaDAO;
        this.pnlGestionarCategorias.getTxtBuscarNombreCategoria().addKeyListener(this);
        this.pnlGestionarCategorias.getTxtBuscarNombreCategoria().addMouseListener(this);
        this.pnlGestionarCategorias.getBtnBauscar().addMouseListener(this);
        modelo = new DefaultTableModel();
    }
    
    public  void iniciar(){
        inicializarNombresTabla();
        llenarTabla();
    }
    
       public void animaciones() {
        this.pnlGestionarCategorias.getTxtBuscarNombreCategoria().setBackground(Color.WHITE);
        this.pnlGestionarCategorias.getTxtBuscarNombreCategoria().setBackground(Color.WHITE);
        this.pnlGestionarCategorias.getTxtBuscarNombreCategoria().setEnabled(false);
        this.pnlGestionarCategorias.getTxtID1().setBackground(Color.WHITE);
        this.pnlGestionarCategorias.getTxtID1().setEnabled(false);
        this.pnlGestionarCategorias.getBtnBauscar().setEnabled(false);
    }

    public void mostrarImagenAlerta() {
        java.net.URL imageURL = getClass().getResource("/img/alert.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlGestionarCategorias.getLblAlertaUsuario().setIcon(icono);
        }
    }

    public void mostrarImagenVerde() {
        java.net.URL imageURL = getClass().getResource("/img/greenSeen.png");
        if (imageURL != null) {
            ImageIcon icono = new ImageIcon(imageURL);
            this.pnlGestionarCategorias.getLblAlertaUsuario().setIcon(icono);
        }
    }

    public void inicializarNombresTabla() {
        String nombres[] = {"ID", "CATEGORIAS"};
        modelo.setColumnIdentifiers(nombres);
        this.pnlGestionarCategorias.getTblCategorias().setModel(modelo);
        this.pnlGestionarCategorias.getTblCategorias().setDefaultEditor(Object.class, null);
        this.pnlGestionarCategorias.getTblCategorias().setFocusable(false);

    }

    public String obtenerCategoriatlbSeleccionada() {
        this.pnlGestionarCategorias.getTxtCategoria().setEnabled(true);
        int filaSeleccionada = this.pnlGestionarCategorias.getTblCategorias().getSelectedRow();
        if (filaSeleccionada >= 0) {
            Object categoria = this.pnlGestionarCategorias.getTblCategorias().getValueAt(filaSeleccionada, 1);
            if (categoria != null) {
                return categoria.toString();
            }
        }
        return null;
    }

    public int obtenerIdSeleccionado() {
        this.pnlGestionarCategorias.getTxtID1().setEnabled(true);
        int filaSeleccionada = this.pnlGestionarCategorias.getTblCategorias().getSelectedRow();
        int idObtenido = -1;
        if (filaSeleccionada >= 0) {
            Object id = this.pnlGestionarCategorias.getTblCategorias().getValueAt(filaSeleccionada, 0);
            if (id != null) {
                idObtenido = Integer.parseInt(id.toString());
            }
        }
        return idObtenido;
    }

    public void llenarTabla() {
        List<Categoria> categorias = categoriaDAO.extraerCategorias();
        System.out.println(categorias);
        for (Categoria c : categorias) {
            Object object[] = {c.getId(), c.getCategoria()};
            modelo.addRow(object);
        }
        this.pnlGestionarCategorias.getTblCategorias().setSelectionBackground(new Color(255, 204, 204));
        this.pnlGestionarCategorias.getTblCategorias().setModel(modelo);
        this.pnlGestionarCategorias.getTblCategorias().setForeground(Color.BLACK);
        this.pnlGestionarCategorias.getTblCategorias().setShowGrid(true); // Muestra la cuadrícula
        this.pnlGestionarCategorias.getTblCategorias().setShowVerticalLines(true); // Muestra las líneas verticales de la cuadrícula
        this.pnlGestionarCategorias.getTblCategorias().setGridColor(Color.BLACK); // Establece el color de las líneas de la cuadrícula
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
    
    
}
