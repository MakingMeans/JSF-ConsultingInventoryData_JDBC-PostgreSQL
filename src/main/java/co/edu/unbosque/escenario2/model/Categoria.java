package co.edu.unbosque.escenario2.model;

public class Categoria {

    private short id;
    private String nmbreCtgria;
    private char estdo_ctgria;
    
    public Categoria() {
    }

    public Categoria(short id, String nmbreCtgria, char estdo_ctgria) {
        this.id = id;
        this.nmbreCtgria = nmbreCtgria;
        this.estdo_ctgria = estdo_ctgria;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getNmbreCtgria() {
        return nmbreCtgria;
    }

    public void setNmbreCtgria(String nmbreCtgria) {
        this.nmbreCtgria = nmbreCtgria;
    }

    public char getEstdo_ctgria() {
        return estdo_ctgria;
    }

    public void setEstdo_ctgria(char estdo_ctgria) {
        this.estdo_ctgria = estdo_ctgria;
    }
    
}
