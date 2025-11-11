package co.edu.unbosque.escenario2.model;

import java.time.Instant;

public class Factura {
    private Short id;
    private Short idCliente;
    private Short idTpoFctura;
    private Instant fchaFctura;
    private Integer vlorBrto;
    private Integer vlorDscto;
    private Integer vlorImpsto;
    private Integer vlorNto;
    private Integer sldoFctura;
    private String estdoFctura;
    
    public Factura() {
    }

    public Factura(Short id, Short idCliente, Short idTpoFctura, Instant fchaFctura, Integer vlorBrto, Integer vlorDscto, Integer vlorImpsto, Integer vlorNto, Integer sldoFctura, String estdoFctura) {
        this.id = id;
        this.idCliente = idCliente;
        this.idTpoFctura = idTpoFctura;
        this.fchaFctura = fchaFctura;
        this.vlorBrto = vlorBrto;
        this.vlorDscto = vlorDscto;
        this.vlorImpsto = vlorImpsto;
        this.vlorNto = vlorNto;
        this.sldoFctura = sldoFctura;
        this.estdoFctura = estdoFctura;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Short idCliente) {
        this.idCliente = idCliente;
    }

    public Short getIdTpoFctura() {
        return idTpoFctura;
    }

    public void setIdTpoFctura(Short idTpoFctura) {
        this.idTpoFctura = idTpoFctura;
    }

    public Instant getFchaFctura() {
        return fchaFctura;
    }

    public void setFchaFctura(Instant fchaFctura) {
        this.fchaFctura = fchaFctura;
    }

    public Integer getVlorBrto() {
        return vlorBrto;
    }

    public void setVlorBrto(Integer vlorBrto) {
        this.vlorBrto = vlorBrto;
    }

    public Integer getVlorDscto() {
        return vlorDscto;
    }

    public void setVlorDscto(Integer vlorDscto) {
        this.vlorDscto = vlorDscto;
    }

    public Integer getVlorImpsto() {
        return vlorImpsto;
    }

    public void setVlorImpsto(Integer vlorImpsto) {
        this.vlorImpsto = vlorImpsto;
    }

    public Integer getVlorNto() {
        return vlorNto;
    }

    public void setVlorNto(Integer vlorNto) {
        this.vlorNto = vlorNto;
    }

    public Integer getSldoFctura() {
        return sldoFctura;
    }

    public void setSldoFctura(Integer sldoFctura) {
        this.sldoFctura = sldoFctura;
    }

    public String getEstdoFctura() {
        return estdoFctura;
    }

    public void setEstdoFctura(String estdoFctura) {
        this.estdoFctura = estdoFctura;
    }
    
    

}