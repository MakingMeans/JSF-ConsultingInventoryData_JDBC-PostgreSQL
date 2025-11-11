package co.edu.unbosque.escenario2.dao;

import co.edu.unbosque.escenario2.model.Unidad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnidadDAO {
    public List<Unidad> listar() {
        List<Unidad> out = new ArrayList<>();
        String sql = "SELECT id, nmbre_undad, estdo_undad FROM unidad ORDER BY nmbre_undad";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Unidad u = new Unidad();
                u.setId(rs.getShort("id"));
                u.setNmbreUndad(rs.getString("nmbre_undad"));
                u.setEstdoUndad(rs.getString("estdo_undad"));
                out.add(u);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return out;
    }
}
