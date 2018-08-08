package java.com.sherpa.dao;

import java.com.sherpa.Controller.ConnectToDatabase;
import java.com.sherpa.models.Master;

import java.sql.*;

public class MasterDaoImpl implements MasterDao {

    private final Connection conn;
    private final String SQL_CREATE_USER = "INSERT INTO sherpa.Master (userName) VALUES (?)";
    private final String SQL_GET_USER = "SELECT * FROM sherpa.Master WHERE userName=?";

    public MasterDaoImpl() {
        conn = ConnectToDatabase.createConnection();
    }

    @Override
    public int createUser(Master master) {
        try (PreparedStatement statement = conn.prepareStatement(SQL_CREATE_USER, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, master.getUserName());
            statement.executeUpdate();
            //Once the insert has been performed, we Can add the user Id to the master User
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    /***
     * Simple query Against the database In order to check if a User already exists
     * @param userName We pass a userName
     * @return Returns the user ID if exist. Otherwise returns -1 (Invalid Index)
     */
    @Override
    public int getExistingUser(String userName) {
        try (PreparedStatement statement = conn.prepareStatement(SQL_GET_USER)){
            statement.setString(1, userName);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()){
                    return rs.getInt(1);
                }
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
    }
