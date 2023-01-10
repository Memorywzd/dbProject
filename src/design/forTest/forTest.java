package design.forTest;

import design.DAO.DAO;

import java.sql.Connection;

public class forTest implements AbstractForTest {
    public void testConnection() {
        DAO dao = new DAO();
        Connection conn = dao.getConnection();
        if (conn != null) {
            System.out.println("Connection is successful.");
        } else {
            System.out.println("Connection is failed.");
        }
    }
}
