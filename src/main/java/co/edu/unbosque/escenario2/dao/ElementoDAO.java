package co.edu.unbosque.escenario2.dao;

import co.edu.unbosque.escenario2.model.Elemento;
import co.edu.unbosque.escenario2.model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElementoDAO {

    public List<Elemento> buscar(String query, String categoria, Double minPrice, int limit, int offset) {
        List<Elemento> lista = new ArrayList<>();
        String sql = """
            SELECT e.id, e.sku_elemnto, e.nmbre_elemnto, e.lote_elemnto, e.ctgria_elemnto,
                   e.und_elemnto, e.exstncia_elemnto, e.prsntacion_elemnto, e.lbrtorio_elemnto,
                   e.cntrolado_elemnto, e.bdga_elemnto, e.precio_venta_ac, e.precio_venta_an,
                   e.costo_venta, e.mrgen_utldad, e.tiene_iva, e.stock_minimo, e.stock_maximo, e.estdo_elmnto,
                   c.nmbre_ctgria, u.nmbre_undad
            FROM elemento e
            LEFT JOIN categoria_producto c ON e.ctgria_elemnto = c.id
            LEFT JOIN unidad u ON e.und_elemnto = u.id
            WHERE (? IS NULL OR e.nmbre_elemnto ILIKE ?)
              AND (? IS NULL OR c.nmbre_ctgria ILIKE ?)
              AND (? IS NULL OR e.precio_venta_ac >= ?)
            ORDER BY e.id
            LIMIT ? OFFSET ?
        """;

        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // query param
            if (query == null || query.isBlank()) {
                ps.setNull(1, Types.VARCHAR);
                ps.setNull(2, Types.VARCHAR);
            } else {
                ps.setString(1, query);
                ps.setString(2, "%" + query + "%");
            }
            // categoria param
            if (categoria == null || categoria.isBlank()) {
                ps.setNull(3, Types.VARCHAR);
                ps.setNull(4, Types.VARCHAR);
            } else {
                ps.setString(3, categoria);
                ps.setString(4, "%" + categoria + "%");
            }
            // minPrice param
            if (minPrice == null) {
                ps.setNull(5, Types.DOUBLE);
                ps.setNull(6, Types.DOUBLE);
            } else {
                ps.setDouble(5, minPrice);
                ps.setDouble(6, minPrice);
            }
            ps.setInt(7, limit);
            ps.setInt(8, offset);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Elemento e = new Elemento();
                    e.setId(rs.getInt("id"));
                    e.setSkuElemnto(rs.getString("sku_elemnto"));
                    e.setNmbreElemnto(rs.getString("nmbre_elemnto"));
                    e.setLoteElemnto(rs.getString("lote_elemnto"));

                    int catId = rs.getInt("ctgria_elemnto");
                    if (!rs.wasNull()) {
                        Categoria cat = new Categoria();
                        cat.setId((short)catId);
                        cat.setNmbreCtgria(rs.getString("nmbre_ctgria"));
                        e.setCtgriaElemnto(cat);
                    }

                    short und = rs.getShort("und_elemnto");
                    if (!rs.wasNull()) {
                        e.setUndElemnto(und);
                    }

                    e.setExstnciaElemnto(rs.getInt("exstncia_elemnto"));
                    e.setPrsntacionElemnto(rs.getString("prsntacion_elemnto"));
                    e.setLbrtorioElemnto(rs.getString("lbrtorio_elemnto"));
                    e.setCntroladoElemnto(rs.getString("cntrolado_elemnto"));
                    e.setBdgaElemnto(rs.getInt("bdga_elemnto"));
                    e.setPrecioVentaAc(rs.getDouble("precio_venta_ac"));
                    e.setPrecioVentaAn(rs.getDouble("precio_venta_an"));
                    e.setCostoVenta(rs.getDouble("costo_venta"));
                    e.setMrgenUtldad(rs.getDouble("mrgen_utldad"));
                    e.setTieneIva(rs.getString("tiene_iva"));
                    e.setStockMinimo(rs.getInt("stock_minimo"));
                    e.setStockMaximo(rs.getInt("stock_maximo"));

                    e.setEstdoElemnto(rs.getString("estdo_elmnto"));

                    lista.add(e);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public Elemento obtenerPorId(int id) {
        String sql = """
            SELECT e.*, c.nmbre_ctgria, u.nmbre_undad
            FROM elemento e
            LEFT JOIN categoria_producto c ON e.ctgria_elemnto = c.id
            LEFT JOIN unidad u ON e.und_elemnto = u.id
            WHERE e.id = ?
        """;
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Elemento e = new Elemento();
                    e.setId(rs.getInt("id"));
                    e.setSkuElemnto(rs.getString("sku_elemnto"));
                    e.setNmbreElemnto(rs.getString("nmbre_elemnto"));
                    e.setLoteElemnto(rs.getString("lote_elemnto"));

                    int catId = rs.getInt("ctgria_elemnto");
                    if (!rs.wasNull()) {
                        Categoria cat = new Categoria();
                        cat.setId((short)catId);
                        cat.setNmbreCtgria(rs.getString("nmbre_ctgria"));
                        e.setCtgriaElemnto(cat);
                    }

                    short und = rs.getShort("und_elemnto");
                    if (!rs.wasNull()) e.setUndElemnto(und);

                    e.setExstnciaElemnto(rs.getInt("exstncia_elemnto"));
                    e.setPrsntacionElemnto(rs.getString("prsntacion_elemnto"));
                    e.setLbrtorioElemnto(rs.getString("lbrtorio_elemnto"));
                    e.setPrecioVentaAc(rs.getDouble("precio_venta_ac"));
                    e.setPrecioVentaAn(rs.getDouble("precio_venta_an"));
                    e.setCostoVenta(rs.getDouble("costo_venta"));
                    e.setMrgenUtldad(rs.getDouble("mrgen_utldad"));
                    e.setTieneIva(rs.getString("tiene_iva"));
                    e.setStockMinimo(rs.getInt("stock_minimo"));
                    e.setStockMaximo(rs.getInt("stock_maximo"));
                    e.setEstdoElemnto(rs.getString("estdo_elmnto"));
                    return e;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Elemento> productosBajoStock() {
        List<Elemento> lista = new ArrayList<>();
        String sql = "SELECT id, nmbre_elemnto, exstncia_elemnto, stock_minimo FROM elemento WHERE exstncia_elemnto < stock_minimo ORDER BY exstncia_elemnto ASC";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Elemento e = new Elemento();
                e.setId(rs.getInt("id"));
                e.setNmbreElemnto(rs.getString("nmbre_elemnto"));
                e.setExstnciaElemnto(rs.getInt("exstncia_elemnto"));
                e.setStockMinimo(rs.getInt("stock_minimo"));
                lista.add(e);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }
}
