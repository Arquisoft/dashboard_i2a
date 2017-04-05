package dashboard.persistence.impl;

import dashboard.dto.Category;
import dashboard.persistence.CategoryDao;
import dashboard.persistence.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alex on 04/04/2017.
 *
 */
public class CategoryDaoImpl implements CategoryDao {

    private Connection con = Database.getConnection();
    @Override
    public Category getCategoryById(int id) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = con.prepareStatement("SELECT * FROM PUBLIC.category WHERE ID=?");
            pst.setInt(1, id);

            rs = pst.executeQuery();
            if (rs.next()) {

                Integer idCategory = rs.getInt("id");
                String name = rs.getString("name");

                Category cat = new Category(idCategory, name);

                return cat;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
