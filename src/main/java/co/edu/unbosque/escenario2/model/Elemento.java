package co.edu.unbosque.escenario2.model;

public class Elemento {

    private int id;
    private String skuElemnto;
    private String nmbreElemnto;
    private String loteElemnto;

    private Categoria ctgriaElemnto;

    private short undElemnto;
    private int exstnciaElemnto;
    private String prsntacionElemnto;
    private String lbrtorioElemnto;
    private String cntroladoElemnto;
    private int bdgaElemnto;
    private double precioVentaAc;
    private double precioVentaAn;
    private double costoVenta;
    private double mrgenUtldad;
    private String tieneIva;
    private int stockMinimo;
    private int stockMaximo;
    private String estdoElemnto;
    
    public Elemento() {
    }

    public Elemento(int id, String skuElemnto, String nmbreElemnto, String loteElemnto, Categoria ctgriaElemnto, short undElemnto, int exstnciaElemnto, String prsntacionElemnto, String lbrtorioElemnto, String cntroladoElemnto, int bdgaElemnto, double precioVentaAc, double precioVentaAn, double costoVenta, double mrgenUtldad, String tieneIva, int stockMinimo, int stockMaximo, String estdoElemnto) {
        this.id = id;
        this.skuElemnto = skuElemnto;
        this.nmbreElemnto = nmbreElemnto;
        this.loteElemnto = loteElemnto;
        this.ctgriaElemnto = ctgriaElemnto;
        this.undElemnto = undElemnto;
        this.exstnciaElemnto = exstnciaElemnto;
        this.prsntacionElemnto = prsntacionElemnto;
        this.lbrtorioElemnto = lbrtorioElemnto;
        this.cntroladoElemnto = cntroladoElemnto;
        this.bdgaElemnto = bdgaElemnto;
        this.precioVentaAc = precioVentaAc;
        this.precioVentaAn = precioVentaAn;
        this.costoVenta = costoVenta;
        this.mrgenUtldad = mrgenUtldad;
        this.tieneIva = tieneIva;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.estdoElemnto = estdoElemnto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkuElemnto() {
        return skuElemnto;
    }

    public void setSkuElemnto(String skuElemnto) {
        this.skuElemnto = skuElemnto;
    }

    public String getNmbreElemnto() {
        return nmbreElemnto;
    }

    public void setNmbreElemnto(String nmbreElemnto) {
        this.nmbreElemnto = nmbreElemnto;
    }

    public String getLoteElemnto() {
        return loteElemnto;
    }

    public void setLoteElemnto(String loteElemnto) {
        this.loteElemnto = loteElemnto;
    }

    public Categoria getCtgriaElemnto() {
        return ctgriaElemnto;
    }

    public void setCtgriaElemnto(Categoria ctgriaElemnto) {
        this.ctgriaElemnto = ctgriaElemnto;
    }

    public short getUndElemnto() {
        return undElemnto;
    }

    public void setUndElemnto(short undElemnto) {
        this.undElemnto = undElemnto;
    }

    public int getExstnciaElemnto() {
        return exstnciaElemnto;
    }

    public void setExstnciaElemnto(int exstnciaElemnto) {
        this.exstnciaElemnto = exstnciaElemnto;
    }

    public String getPrsntacionElemnto() {
        return prsntacionElemnto;
    }

    public void setPrsntacionElemnto(String prsntacionElemnto) {
        this.prsntacionElemnto = prsntacionElemnto;
    }

    public String getLbrtorioElemnto() {
        return lbrtorioElemnto;
    }

    public void setLbrtorioElemnto(String lbrtorioElemnto) {
        this.lbrtorioElemnto = lbrtorioElemnto;
    }

    public String getCntroladoElemnto() {
        return cntroladoElemnto;
    }

    public void setCntroladoElemnto(String cntroladoElemnto) {
        this.cntroladoElemnto = cntroladoElemnto;
    }

    public int getBdgaElemnto() {
        return bdgaElemnto;
    }

    public void setBdgaElemnto(int bdgaElemnto) {
        this.bdgaElemnto = bdgaElemnto;
    }

    public double getPrecioVentaAc() {
        return precioVentaAc;
    }

    public void setPrecioVentaAc(double precioVentaAc) {
        this.precioVentaAc = precioVentaAc;
    }

    public double getPrecioVentaAn() {
        return precioVentaAn;
    }

    public void setPrecioVentaAn(double precioVentaAn) {
        this.precioVentaAn = precioVentaAn;
    }

    public double getCostoVenta() {
        return costoVenta;
    }

    public void setCostoVenta(double costoVenta) {
        this.costoVenta = costoVenta;
    }

    public double getMrgenUtldad() {
        return mrgenUtldad;
    }

    public void setMrgenUtldad(double mrgenUtldad) {
        this.mrgenUtldad = mrgenUtldad;
    }

    public String getTieneIva() {
        return tieneIva;
    }

    public void setTieneIva(String tieneIva) {
        this.tieneIva = tieneIva;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public String getEstdoElemnto() {
        return estdoElemnto;
    }

    public void setEstdoElemnto(String estdoElemnto) {
        this.estdoElemnto = estdoElemnto;
    }
    
    
}
