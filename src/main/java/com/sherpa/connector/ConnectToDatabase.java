package com.sherpa.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectToDatabase {

    private final static String DB = "jdbc:mysql://localhost:3306/Sherpa?useSSL=false&allowPublicKeyRetrieval=true";
    private final static String user = "root";
    private final static String pswd = "zewikSDK001!";


    public static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB, user, pswd);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
