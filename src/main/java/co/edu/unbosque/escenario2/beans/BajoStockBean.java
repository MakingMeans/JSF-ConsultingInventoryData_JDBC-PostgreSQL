package co.edu.unbosque.escenario2.beans;

import co.edu.unbosque.escenario2.dao.ElementoDAO;
import co.edu.unbosque.escenario2.model.Elemento;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("bajoStockBean")
@RequestScoped
public class BajoStockBean implements Serializable {
    private List<Elemento> productos;

    public void cargar() {
        ElementoDAO dao = new ElementoDAO();
        productos = dao.productosBajoStock();
    }

    public List<Elemento> getProductos(){ return productos; }
}
