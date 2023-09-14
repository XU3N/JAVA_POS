
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author XU3N
 */
public class DatabaseConnect {

    public static Connection dbconn() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/pos", "root", "");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("e");
            return null;
        }
    }
}
