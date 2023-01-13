package design.DAO.impl;

import design.DAO.AbstractUserDAO;
import design.model.user.Teacher;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAO extends DAO implements AbstractUserDAO {
    @Override
    public List<String> getUserList() {
        return null;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        DAO dao = new DAO();
        Connection conn = dao.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO user (username, password, role) VALUES ('test', 'test', 'test')";
            stmt.executeUpdate(sql);
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
