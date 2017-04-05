package dashboard.persistence.impl;

import dashboard.dto.User;
import dashboard.persistence.Database;
import dashboard.persistence.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class UserDaoImpl implements UserDao{

    private Connection con = Database.getConnection();
    @Override
    public User getUserById(int id) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = con.prepareStatement("SELECT * FROM PUBLIC.users WHERE ID=?");
            pst.setInt(1, id);

            rs = pst.executeQuery();
            if (rs.next()) {

                Integer idUser = rs.getInt("id");
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String password = rs.getString("password");
                String email = rs.getString("email");
                Date date = rs.getDate("nacimiento");
                String address = rs.getString("direccion");
                String nationality = rs.getString("nacionalidad");
                int polling = rs.getInt("polling");

                User user = new User(dni, nombre, apellidos, date, address, email, nationality, polling);
                user.setId(idUser);
                user.setPassword(password);

                return user;
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
