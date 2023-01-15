package design.DAO.impl;

import design.DAO.AbstractAppDAO;
import design.model.LoginStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class AppDAO extends DAO implements AbstractAppDAO {
    @Override
    public boolean addLoginStatus(LoginStatus newLoginStatus) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO loginStatus " +
                "(userID, password, userRole, userType, token, isTokenValid) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newLoginStatus.getUserID());
            stmt.setString(2, newLoginStatus.getPassword());
            stmt.setInt(3, newLoginStatus.getUserRole());
            stmt.setInt(4, newLoginStatus.getUserType());
            stmt.setString(5, newLoginStatus.getToken());
            stmt.setBoolean(6, newLoginStatus.isTokenValid());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    List<Integer> getSystemRole(int role) {
        return switch (role) {
            case 0 -> List.of(0, 0);
            case 1 -> List.of(1, 0);
            case 2 -> List.of(1, 1);
            case 3 -> List.of(2, 0);
            case 4 -> List.of(2, 1);
            default -> List.of();
        };
    }

    String getToken(int role) {
        return switch (role) {
            case 0 -> "student-token";
            case 1 -> "teacher-token";
            case 2 -> "mentor-token";
            case 3 -> "admin-token";
            case 4 -> "leader-token";
            default -> "";
        };
    }

    @Override
    public String login(String username, String password, int role) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String token = null;
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            if (stmt.executeQuery().next()) {
                List<Integer> list = getSystemRole(role);
                token = getToken(role);
                if (!auth(token,role)) {
                    addLoginStatus(new LoginStatus(
                            username, password, list.get(0),
                            list.get(1), token, true
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, null);
        return token;
    }

    @Override
    public boolean auth(String token, int role) {
        PreparedStatement stmt = null;
        Connection conn = null;
        boolean isTokenValid = false;
        String sql = "SELECT * FROM loginStatus WHERE token = ? AND userRole = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, token);
            stmt.setInt(2, role);
            if (stmt.executeQuery().next()) {
                isTokenValid = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return isTokenValid && closeAll(conn, stmt, null);
    }

}
