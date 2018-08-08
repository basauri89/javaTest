package java.com.sherpa.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectToDatabase {

    private final static String user = "root";
    private final static String pswd = "admin";


    public static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/Sherpa?useSSL=false";
            conn = DriverManager.getConnection(dbUrl, user, pswd);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
