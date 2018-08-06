package com.java.dao;

import com.java.Controller.ConnectToDatabase;
import com.java.models.Master;

import java.sql.*;

public class MasterDaoImpl implements MasterDao {

    private final Connection conn = ConnectToDatabase.createConnection();
    private final String SQL_CREATE_USER = "INSERT INTO sherpa.Master (userName) VALUES (?)";
    private final String SQL_GET_USER = "SELECT userName FROM sherpa.Master WHERE id=?";

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
     * @param master We pass a master Object to the method
     * @return Returns the user ID if exist. Otherwise returns -1 (Invalid Index)
     */
    @Override
    public int getExistingUser(Master master) {
        try (PreparedStatement statement = conn.prepareStatement(SQL_GET_USER)){
            statement.setInt(1, master.getId());
            try (ResultSet rs = statement.executeQuery()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
    }
