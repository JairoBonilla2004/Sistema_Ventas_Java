package controlador;

import modelo.ProductoDAO;
import vista.PnlGestionarProductos;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerGestionarProducto {
    
    private PnlGestionarProductos pnlGestionarProductos;
    private ProductoDAO productoDAO;

    public ControllerGestionarProducto(PnlGestionarProductos pnlGestionarProductos, ProductoDAO productoDAO) {
        this.pnlGestionarProductos = pnlGestionarProductos;
        this.productoDAO = productoDAO;
    }
    
    
}
