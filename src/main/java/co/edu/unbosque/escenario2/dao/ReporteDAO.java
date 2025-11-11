package co.edu.unbosque.escenario2.dao;

import co.edu.unbosque.escenario2.model.ProductosMasVendidos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {

    public List<ProductosMasVendidos> productosMasVendidos(int mes, int limite) {
        List<ProductosMasVendidos> out = new ArrayList<>();
        String sql = """
            SELECT e.id, e.nmbre_elemnto AS nombre, SUM(fd.cntdad_elemnto) AS total_vendido
            FROM factura_detalle fd
            JOIN factura f ON fd.id_factura = f.id
            JOIN elemento e ON fd.id_elemnto = e.id
            WHERE EXTRACT(MONTH FROM f.fcha_fctura) = ?
            GROUP BY e.id, e.nmbre_elemnto
            ORDER BY total_vendido DESC
            LIMIT ?
        """;
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, mes);
            ps.setInt(2, limite);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ProductosMasVendidos dto = new ProductosMasVendidos();
                    dto.setId(rs.getInt("id"));
                    dto.setNombre(rs.getString("nombre"));
                    dto.setTotalVendido(rs.getInt("total_vendido"));
                    out.add(dto);
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return out;
    }
}
