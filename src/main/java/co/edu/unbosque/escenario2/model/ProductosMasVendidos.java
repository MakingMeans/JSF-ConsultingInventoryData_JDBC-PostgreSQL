package co.edu.unbosque.escenario2.model;

public class ProductosMasVendidos {
    private int id;
    private String nombre;
    private int totalVendido;
    
    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public int getTotalVendido(){ return totalVendido; }
    public void setTotalVendido(int v){ this.totalVendido = v; }
}
