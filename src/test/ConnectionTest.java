package test;

import design.DAO.impl.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest implements AbstractConnectionTest {
    public void testConnection() {
        DAO dao = new DAO();
        //Connection conn = dao.getConnection();
        Connection conn;
        try {
            conn = dao.getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (conn != null) {
            System.out.println("Connection is successful.");
        } else {
            System.out.println("Connection is failed.");
        }
    }
}
