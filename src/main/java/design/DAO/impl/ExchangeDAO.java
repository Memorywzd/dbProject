package design.DAO.impl;

import design.DAO.AbstractExchangeDAO;
import design.model.exchange.Exchange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExchangeDAO extends DAO implements AbstractExchangeDAO {
    /**
     * @return
     */
    @Override
    public List<String> getAcademicExchangeList() {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<String> exchangeList = new ArrayList<>();
        String sql = "SELECT * FROM exchanges";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Exchange tempExchange = new Exchange(
                        rs.getString("exchangeID"),
                        rs.getString("exchangeStudentID"),
                        rs.getString("exchangeSubjectID"),
                        rs.getString("exchangeName"),
                        rs.getString("exchangeLocation"),
                        rs.getString("exchangeTime"),
                        rs.getString("exchangeReportName"),
                        rs.getString("exchangeImagePath"),
                        rs.getString("exchangeNote"),
                        rs.getBoolean("isMentorValid"),
                        rs.getBoolean("isLeaderValid")
                );
                exchangeList.add(tempExchange.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return exchangeList;
    }

    /**
     * @param newExchange
     * @return
     */
    @Override
    public boolean addExchange(Exchange newExchange) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO exchanges" +
                " (exchangeStudentID, exchangeSubjectID, exchangeName, exchangeLocation, exchangeTime, exchangeReportName, exchangeImagePath, exchangeNote,isMentorValid,isLeaderValid) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, newExchange.getExchangeID());
            stmt.setString(1, newExchange.getExchangeStudentID());
            stmt.setString(2, newExchange.getExchangeSubjectID());
            stmt.setString(3, newExchange.getExchangeName());
            stmt.setString(4, newExchange.getExchangeLocation());
            stmt.setString(5, newExchange.getExchangeTime());
            stmt.setString(6, newExchange.getExchangeReportName());
            stmt.setString(7, newExchange.getExchangeImagePath());
            stmt.setString(8, newExchange.getExchangeNote());
            stmt.setBoolean(9, newExchange.isMentorValid());
            stmt.setBoolean(10, newExchange.isLeaderValid());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param exchangeID
     * @return
     */
    @Override
    public boolean applyAcademicExchangeStatistics(String exchangeID, String studentID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO exchangeStatistics VALUES(?,?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, exchangeID);
            stmt.setString(2, studentID);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param exchangeID
     * @return
     */
    @Override
    public boolean updateExchangeMentorValid(String exchangeID, boolean isMentorValid) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "UPDATE exchanges SET isMentorValid = ? WHERE exchangeID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            if(isMentorValid){
                stmt.setString(1, "1");
            }else{
                stmt.setString(1, "0");
            }
            stmt.setString(2, exchangeID);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param exchangeID
     * @return
     */
    @Override
    public boolean updateExchangeLeaderValid(String exchangeID, boolean isLeaderValid) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "UPDATE exchanges SET isLeaderValid = ? WHERE exchangeID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            if(isLeaderValid){
                stmt.setInt(1, 1);
            }else{
                stmt.setInt(1, 0);
            }
            stmt.setString(2, exchangeID);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }
}
