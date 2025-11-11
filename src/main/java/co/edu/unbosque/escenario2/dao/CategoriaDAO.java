package co.edu.unbosque.escenario2.dao;

import co.edu.unbosque.escenario2.model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public List<Categoria> listar() {
        List<Categoria> out = new ArrayList<>();
        String sql = "SELECT id, nmbre_ctgria, estdo_ctgria FROM categoria_producto ORDER BY nmbre_ctgria";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getShort("id"));
                c.setNmbreCtgria(rs.getString("nmbre_ctgria"));
                c.setEstdo_ctgria(rs.getString("estdo_ctgria").charAt(0));
                out.add(c);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return out;
    }
}
