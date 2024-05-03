package controlador;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.ProductoDAO;
import vista.PnlGestionarProductos;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerGestionarProducto {

    private final PnlGestionarProductos pnlGestionarProductos;
    private final ProductoDAO productoDAO;
    private  DefaultTableModel modelo = new DefaultTableModel();

    public ControllerGestionarProducto(PnlGestionarProductos pnlGestionarProductos, ProductoDAO productoDAO) {
        this.pnlGestionarProductos = pnlGestionarProductos;
        this.productoDAO = productoDAO;
    }

    public void inicializar() {
        inicializarNombresTabla();
        llenarTabla();
    }

    public void inicializarNombresTabla() {
        String nombres[] = {"ID", "NOMBRE", "CANTIDAD", "PRECIO", "FECHA DE CADUCIDAD", "IVA", "CATEGORIA"};
        modelo.setColumnIdentifiers(nombres);
        this.pnlGestionarProductos.getTblProducto().setModel(modelo);
        this.pnlGestionarProductos.getTblProducto().setDefaultEditor(Object.class, null);
        this.pnlGestionarProductos.getTblProducto().setFocusable(false);
        this.pnlGestionarProductos.getTblProducto().setSelectionBackground(new Color(255, 204, 204));
    }

    public void llenarTabla() {
        List<Producto> productos = productoDAO.obtenerTodosProductosDB();
        for (Producto p : productos) {
            String iva = ivaPorcentaje(p);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fecha_caducidad = simpleDateFormat.format(p.getFechaCaducidad());
            Object fila[] = {p.getId(), p.getNombre(), p.getCantidad(), p.getPrecio(), fecha_caducidad, iva, p.getCategoria().getCategoria()};
            modelo.addRow(fila);
        }
        this.pnlGestionarProductos.getTblProducto().setModel(modelo);
        animaciontabla();
    }

    public static String ivaPorcentaje(Producto p) {
        String iva_texto = null;
        switch (p.getIva()) {

            case 0: {
                iva_texto = "Producto sin IVA";

                break;
            }

            case 12: {
                iva_texto = "12 %";
                break;
            }

            case 13: {
                iva_texto = "13 %";
                break;
            }

            case 14: {
                iva_texto = "14 %";
                break;
            }

            case 15: {
                iva_texto = "15 %";
            }

        }
        return iva_texto;

    }

    public void animaciontabla() {
        this.pnlGestionarProductos.getTblProducto().setForeground(Color.BLACK);
        this.pnlGestionarProductos.getTblProducto().setShowGrid(true); // Muestra la cuadrícula
        this.pnlGestionarProductos.getTblProducto().setShowVerticalLines(true); // Muestra las líneas verticales de la cuadrícula
        this.pnlGestionarProductos.getTblProducto().setGridColor(Color.BLACK); // Establece el color de las líneas de la cuadrícula

    }

}
