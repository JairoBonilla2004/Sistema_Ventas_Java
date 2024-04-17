package controlador;

import modelo.CategoriaDAO;
import vista.PnlGestionarCategorias;

/**
 *
 * @author Jairo Smith Bonilla Hidalgo
 */
public class ControllerGestionarCategorias {
    
    private PnlGestionarCategorias pnlGestionarCategorias;
    private CategoriaDAO categoriaDAO;

    public ControllerGestionarCategorias(PnlGestionarCategorias pnlGestionarCategorias, CategoriaDAO categoriaDAO) {
        this.pnlGestionarCategorias = pnlGestionarCategorias;
        this.categoriaDAO = categoriaDAO;
    }
    
    
}
