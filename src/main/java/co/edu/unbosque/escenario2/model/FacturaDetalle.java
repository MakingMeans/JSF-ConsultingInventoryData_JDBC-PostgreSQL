package co.edu.unbosque.escenario2.model;
import java.math.BigDecimal;

public class FacturaDetalle {
    private Short id;
    private Factura idFactura;

    private Elemento idElemnto;
    private Integer cntdadElemnto;
    private BigDecimal prcioUntrio;
    private BigDecimal vlrDscto;
    private BigDecimal vlrImpsto;
    
    public FacturaDetalle() {
    }

    public FacturaDetalle(Short id, Factura idFactura, Elemento idElemnto, Integer cntdadElemnto, BigDecimal prcioUntrio, BigDecimal vlrDscto, BigDecimal vlrImpsto) {
        this.id = id;
        this.idFactura = idFactura;
        this.idElemnto = idElemnto;
        this.cntdadElemnto = cntdadElemnto;
        this.prcioUntrio = prcioUntrio;
        this.vlrDscto = vlrDscto;
        this.vlrImpsto = vlrImpsto;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Elemento getIdElemnto() {
        return idElemnto;
    }

    public void setIdElemnto(Elemento idElemnto) {
        this.idElemnto = idElemnto;
    }

    public Integer getCntdadElemnto() {
        return cntdadElemnto;
    }

    public void setCntdadElemnto(Integer cntdadElemnto) {
        this.cntdadElemnto = cntdadElemnto;
    }

    public BigDecimal getPrcioUntrio() {
        return prcioUntrio;
    }

    public void setPrcioUntrio(BigDecimal prcioUntrio) {
        this.prcioUntrio = prcioUntrio;
    }

    public BigDecimal getVlrDscto() {
        return vlrDscto;
    }

    public void setVlrDscto(BigDecimal vlrDscto) {
        this.vlrDscto = vlrDscto;
    }

    public BigDecimal getVlrImpsto() {
        return vlrImpsto;
    }

    public void setVlrImpsto(BigDecimal vlrImpsto) {
        this.vlrImpsto = vlrImpsto;
    }
    
    

}