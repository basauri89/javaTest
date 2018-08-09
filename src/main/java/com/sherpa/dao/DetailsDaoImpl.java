package com.sherpa.dao;

import com.sherpa.connector.ConnectToDatabase;
import com.sherpa.models.Details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DetailsDaoImpl implements DetailsDao {

    private final Connection conn = ConnectToDatabase.createConnection();
    private final String SQL_CREATE_DETAILS = "INSERT INTO sherpa.Detalle (cp, ciudad, user_id) VALUES (?, ?, ?)";

    @Override
    public void createUserDetails(Details details) {
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_DETAILS, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, details.getPostCode());
            pstmt.setString(2,details.getCity());
            pstmt.setInt(3,details.getUserID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
