package com.sherpa.dao;

import com.sherpa.connector.ConnectToDatabase;
import com.sherpa.models.Details;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailsDaoImpl implements DetailsDao {

    private final Connection conn = ConnectToDatabase.createConnection();
    private final String SQL_CREATE_DETAILS = "INSERT INTO sherpa.Detalle (cp, ciudad, user_id) VALUES (?, ?, ?)";
    private final String SQL_GET_DETAILS = "SELECT * FROM Sherpa.Detalle WHERE user_id = ?";

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

    @Override
    public List<Details> getDetailsForUser(int id) {
        try (PreparedStatement statement = conn.prepareStatement(SQL_GET_DETAILS)){
            statement.setString(1, Integer.toString(id));
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()){
                    List<Details> resultList = new ArrayList<>();
                    while (rs.next()){
                        Details d = new Details();
                        d.setUserID(rs.getInt("user_id"));
                        d.setId(rs.getInt("id"));
                        d.setCity(rs.getString("ciudad"));
                        d.setPostCode(rs.getString("cp"));
                        resultList.add(d);
                    }
                    return resultList;
                }
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
