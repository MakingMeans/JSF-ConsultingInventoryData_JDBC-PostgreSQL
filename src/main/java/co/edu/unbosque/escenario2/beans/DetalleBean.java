package co.edu.unbosque.escenario2.beans;

import co.edu.unbosque.escenario2.dao.ElementoDAO;
import co.edu.unbosque.escenario2.model.Elemento;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Map;

@Named("detalleBean")
@ViewScoped
public class DetalleBean implements Serializable {
    private int id;
    private Elemento elemento;

    public void cargar() {
        if (elemento != null) return;
        if (id == 0) {
            Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            if (params.containsKey("id")) {
                try { id = Integer.parseInt(params.get("id")); } catch (NumberFormatException ignored) {}
            }
        }
        if (id > 0) {
            ElementoDAO dao = new ElementoDAO();
            elemento = dao.obtenerPorId(id);
        }
    }

    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }
    public Elemento getElemento(){ return elemento; }
}
