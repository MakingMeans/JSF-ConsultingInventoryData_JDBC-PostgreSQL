package co.edu.unbosque.escenario2.beans;

import co.edu.unbosque.escenario2.dao.ReporteDAO;
import co.edu.unbosque.escenario2.model.ProductosMasVendidos;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("reporteBean")
@RequestScoped
public class ReporteBean implements Serializable {
    private int mes = 1;
    private List<ProductosMasVendidos> resultados;

    public void generar() {
        ReporteDAO dao = new ReporteDAO();
        resultados = dao.productosMasVendidos(mes, 50);
    }

    public int getMes(){ return mes; }
    public void setMes(int mes){ this.mes = mes; }
    public List<ProductosMasVendidos> getResultados(){ return resultados; }
}
