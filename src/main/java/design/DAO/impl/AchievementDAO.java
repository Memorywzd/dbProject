package design.DAO.impl;

import design.DAO.AbstractAchievementDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AchievementDAO extends DAO implements AbstractAchievementDAO {
    /**
     * @param params
     * @return
     */
    @Override
    public boolean addAward(Map<String, String> params) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO awards (achievementID, awardName, awardLevel, awardRanking, " +
                "awardPublishTime, awardAttachment, achievementStudentID, isMentorValid, isAdminValid) " +
                "VALUES (?, ?, ?, ?, ?, ?, ? ,?, ?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, params.get("achievementID"));
            stmt.setString(2, params.get("awardName"));
            stmt.setString(3, params.get("awardLevel"));
            stmt.setString(4, params.get("awardRanking"));
            stmt.setString(5, params.get("awardPublishTime"));
            stmt.setString(6, params.get("awardAttachment"));
            stmt.setString(7, params.get("achievementStudentID"));
            stmt.setBoolean(8, false);
            stmt.setBoolean(9, false);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param params
     * @return
     */
    @Override
    public boolean addPaper(Map<String, String> params) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO papers (achievementID, paperName, paperPublication, paperStatus, " +
                "paperPublishTime, paperIndex, paperBelong, paperAttachment, isMentorValid, isAdminValid, achievementStudentID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, params.get("achievementID"));
            stmt.setString(2, params.get("paperName"));
            stmt.setString(3, params.get("paperPublication"));
            stmt.setString(4, params.get("paperStatus"));
            stmt.setString(5, params.get("paperPublishTime"));
            stmt.setString(6, params.get("paperIndex"));
            stmt.setString(7, params.get("paperBelong"));
            stmt.setString(8, params.get("paperAttachment"));
            stmt.setBoolean(9, false);
            stmt.setBoolean(10, false);
            stmt.setString(11, params.get("achievementStudentID"));
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param params
     * @return
     */
    @Override
    public boolean addPatent(Map<String, String> params) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO patents (achievementID, patentName, patentType, patentID, patentPublishTime, " +
                "patentState, patentContribution, patentAttachment, isMentorValid, isAdminValid, achievementStudentID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, params.get("achievementID"));
            stmt.setString(2, params.get("patentName"));
            stmt.setString(3, params.get("patentType"));
            stmt.setString(4, params.get("patentID"));
            stmt.setString(5, params.get("patentPublishTime"));
            stmt.setString(6, params.get("patentState"));
            stmt.setString(7, params.get("patentContribution"));
            stmt.setString(8, params.get("patentAttachment"));
            stmt.setBoolean(9, false);
            stmt.setBoolean(10, false);
            stmt.setString(11, params.get("achievementStudentID"));
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param params
     * @return
     */
    @Override
    public boolean addPlatform(Map<String, String> params) {
PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO platforms (achievementID, platformName, platformServiceOffice, " +
                "platformPublishTime, platformContribution, platformAttachment, isMentorValid, isAdminValid, achievementStudentID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, params.get("achievementID"));
            stmt.setString(2, params.get("platformName"));
            stmt.setString(3, params.get("platformServiceOffice"));
            stmt.setString(4, params.get("platformPublishTime"));
            stmt.setString(5, params.get("platformContribution"));
            stmt.setString(6, params.get("platformAttachment"));
            stmt.setBoolean(7, false);
            stmt.setBoolean(8, false);
            stmt.setString(9, params.get("achievementStudentID"));
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param params
     * @return
     */
    @Override
    public boolean addReport(Map<String, String> params) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO reports (achievementID, reportName, reportType, reportServiceOffice, " +
                "reportPublishTime, reportContribution, reportAttachment, isMentorValid, isAdminValid, achievementStudentID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, params.get("achievementID"));
            stmt.setString(2, params.get("reportName"));
            stmt.setString(3, params.get("reportType"));
            stmt.setString(4, params.get("reportServiceOffice"));
            stmt.setString(5, params.get("reportPublishTime"));
            stmt.setString(6, params.get("reportContribution"));
            stmt.setString(7, params.get("reportAttachment"));
            stmt.setBoolean(8, false);
            stmt.setBoolean(9, false);
            stmt.setString(10, params.get("achievementStudentID"));
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param params
     * @return
     */
    @Override
    public boolean addStandard(Map<String, String> params) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO standards (achievementID, standardName, standardLevel, " +
                "standardPublishTime, standardAttachment, isMentorValid, isAdminValid, achievementStudentID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ? ,?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, params.get("achievementID"));
            stmt.setString(2, params.get("standardName"));
            stmt.setString(3, params.get("standardLevel"));
            stmt.setString(4, params.get("standardPublishTime"));
            stmt.setString(5, params.get("standardAttachment"));
            stmt.setBoolean(6, false);
            stmt.setBoolean(7, false);
            stmt.setString(8, params.get("achievementStudentID"));
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param params
     * @return
     */
    @Override
    public boolean addTextbook(Map<String, String> params) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO textbooks (achievementID, textbookName, textbookPublishHouse, " +
                "textbookPublishTime, textbookContribution, textbookAttachment, isMentorValid, isAdminValid, achievementStudentID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, params.get("achievementID"));
            stmt.setString(2, params.get("textbookName"));
            stmt.setString(3, params.get("textbookPublishHouse"));
            stmt.setString(4, params.get("textbookPublishTime"));
            stmt.setString(5, params.get("textbookContribution"));
            stmt.setString(6, params.get("textbookAttachment"));
            stmt.setBoolean(7, false);
            stmt.setBoolean(8, false);
            stmt.setString(9, params.get("achievementStudentID"));
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param studentID
     * @return
     */
    @Override
    public List<String> getAchievementList(String studentID) {
        List<String> achievementList = new ArrayList<>();
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM achievements " +
                "WHERE achievementStudentID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String temp = rs.getString("achievementID") +
                        " " + rs.getString("achievementName") +
                        " " + rs.getString("achievementType");
                achievementList.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return achievementList;
    }

    @Override
    public List<String> getAchievementListAll() {
        List<String> achievementList = new ArrayList<>();
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM achievements";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String temp = rs.getString("achievementID") +
                        " " + rs.getString("achievementName") +
                        " " + rs.getString("achievementType");
                achievementList.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return achievementList;
    }

    /**
     * @param type
     * @param achievementID
     * @param isValid
     * @return
     */
    @Override
    public boolean updateAchievementMentorValid(String type, String achievementID, boolean isValid) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "UPDATE " + type + "s SET isMentorValid = ? " +
                "WHERE achievementID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1, isValid);
            stmt.setString(2, achievementID);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    @Override
    public boolean updateAchievementAdminValid(String achievementID, boolean isValid) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "UPDATE awards SET isMentorValid = ? " +
                "WHERE achievementID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            if(isValid)
                stmt.setInt(1, 1);
            else
                stmt.setInt(1, 0);
            stmt.setString(2, achievementID);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }
}
