package dashboard.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Alex on 02/04/2017.
 * Provides static method getConnection(), separating this concern from the other classes.
 */
public class Database {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/dhagylfk"
                    , "dhagylfk", "Fh4qfTEeD0iiKelxcdpaSwK-kGhMk3fv");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la bbdd: ");
            e.printStackTrace();
            return null;
        }
    }
}
