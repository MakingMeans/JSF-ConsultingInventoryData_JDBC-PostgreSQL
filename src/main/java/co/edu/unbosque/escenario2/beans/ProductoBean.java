package co.edu.unbosque.escenario2.beans;

import co.edu.unbosque.escenario2.dao.ElementoDAO;
import co.edu.unbosque.escenario2.model.Elemento;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("productoBean")
@RequestScoped
public class ProductoBean implements Serializable {
    private String query;
    private String categoria;
    private Double minPrice;
    private List<Elemento> resultados;
    private int page = 0;
    private final int pageSize = 20;

    public void buscar() {
        ElementoDAO dao = new ElementoDAO();
        resultados = dao.buscar(query, categoria, minPrice, pageSize, page * pageSize);
    }

    public void next() { page++; buscar(); }
    public void prev() { if (page > 0) { page--; buscar(); } }

    // getters/setters
    public String getQuery(){ return query; }
    public void setQuery(String q){ this.query = q; }
    public String getCategoria(){ return categoria; }
    public void setCategoria(String c){ this.categoria = c; }
    public Double getMinPrice(){ return minPrice; }
    public void setMinPrice(Double p){ this.minPrice = p; }
    public List<Elemento> getResultados(){ return resultados; }
    public int getPage(){ return page; }
}
