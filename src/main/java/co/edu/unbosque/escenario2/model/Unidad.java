package co.edu.unbosque.escenario2.model;

public class Unidad {
    private Short id;
    private String nmbreUndad;
    private String estdoUndad;
    
    public Unidad() {
    }

    public Unidad(Short id, String nmbreUndad, String estdoUndad) {
        this.id = id;
        this.nmbreUndad = nmbreUndad;
        this.estdoUndad = estdoUndad;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNmbreUndad() {
        return nmbreUndad;
    }

    public void setNmbreUndad(String nmbreUndad) {
        this.nmbreUndad = nmbreUndad;
    }

    public String getEstdoUndad() {
        return estdoUndad;
    }

    public void setEstdoUndad(String estdoUndad) {
        this.estdoUndad = estdoUndad;
    }
    
    

}