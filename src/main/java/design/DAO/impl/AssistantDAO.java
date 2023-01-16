package design.DAO.impl;

import design.DAO.AbstractAssistantDAO;
import design.model.assistant.Assistant;
import design.model.assistant.Rate;
import design.model.user.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AssistantDAO extends DAO implements AbstractAssistantDAO {
    /**
     * @param newAssistantVolunteer
     * @return
     */
    @Override
    public boolean addVolunteer(Assistant newAssistantVolunteer) {
        String sql = "INSERT INTO assistantVolunteers " +
                "(volunteerStudentID, volunteerTeacherID, volunteerCourseID) " +
                "VALUES (?, ?, ?)";
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newAssistantVolunteer.getAssistantStudentID());
            stmt.setString(2, newAssistantVolunteer.getAssistantTeacherID());
            stmt.setString(3, newAssistantVolunteer.getAssistantCourseID());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param applyRate
     * @return
     */
    @Override
    public boolean addAssistantRate(Rate applyRate) {
        String sql = "INSERT INTO rates " +
                "(rateAssistantID, rateSelf, isTeacherRated) " +
                "VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, applyRate.getRateAssistantID());
            stmt.setString(2, applyRate.getRateSelf());
            stmt.setBoolean(3, false);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @return
     */
    @Override
    public List<String> getVolunteerListByCourseID(String courseID) {
        String sql = "SELECT * FROM students WHERE studentID =" +
                "(SELECT volunteerStudentID FROM assistantVolunteers WHERE volunteerCourseID = ?)";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conn = null;
        List<String> studentList = new ArrayList<>();
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, courseID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Student tempStudent = new Student();
                tempStudent.setStudentID(rs.getString("studentID"));
                tempStudent.setStudentName(rs.getString("studentName"));
                tempStudent.setStudentSex(rs.getInt("studentSex"));
                tempStudent.setStudentMentorId(rs.getString("studentMentorID"));
                tempStudent.setStudentAssistantStatus(rs.getBoolean("studentAssistantStatus"));
                tempStudent.setStudentAssistantRateStatus(rs.getBoolean("studentAssistantRateStatus"));
                tempStudent.setStudentExchangeNum(rs.getInt("studentExchangeNum"));
                studentList.add(tempStudent.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return studentList;
    }

    /**
     * @param volunteerID
     * @return
     */
    @Override
    public boolean addAssistantByVolunteerID(String volunteerID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO assistants " +
                "(assistantStudentID, assistantTeacherID, assistantCourseID) " +
                "SELECT volunteerStudentID, volunteerTeacherID, volunteerCourseID " +
                "FROM assistantVolunteers WHERE volunteerID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, volunteerID);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param assistantTeacherID
     * @return
     */
    @Override
    public List<Assistant> getAssistantsByAssistantTeacherID(String assistantTeacherID) {
        String sql = "SELECT * FROM assistants WHERE assistantTeacherID = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        List<Assistant> assistantList = new ArrayList<>();
        ResultSet rs = null;
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, assistantTeacherID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Assistant tempAssistant = new Assistant();
                tempAssistant.setAssistantID(rs.getString("assistantID"));
                tempAssistant.setAssistantStudentID(rs.getString("assistantStudentID"));
                tempAssistant.setAssistantTeacherID(rs.getString("assistantTeacherID"));
                tempAssistant.setAssistantCourseID(rs.getString("assistantCourseID"));
                tempAssistant.setAssistantRateID(rs.getInt("assistantRateID"));
                assistantList.add(tempAssistant);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return assistantList;
    }


    /**
     * @return
     */
    @Override
    public List<String> getRateListByTeacherID(String teacherID) {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection conn = null;
        List<String> rateList = new ArrayList<>();
        String sql = "SELECT studentName, courseName, rateSelf, rateTeacher " +
                "FROM rates " +
                "LEFT JOIN assistants a ON rateAssistantID = a.assistantID " +
                "LEFT JOIN students s1 ON s1.studentID = a.assistantStudentID " +
                "LEFT JOIN courses c1 on c1.courseID = a.assistantCourseID " +
                "WHERE rateAssistantID = " +
                "(SELECT assistantID FROM assistants WHERE assistantTeacherID = ?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, teacherID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String tempRate = "研究生姓名：" + rs.getString("studentName") + "助教课程名称： " +
                        rs.getString("courseName") + "助教工作自述： " +
                        rs.getString("rateSelf") + "授课教师评价： " +
                        rs.getString("rateTeacher");
                rateList.add(tempRate);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return rateList;
    }

    /**
     * @param rateID
     * @param newRate
     * @return
     */
    @Override
    public boolean updateAssistantRate(String rateID, String newRate) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "UPDATE rates SET rateTeacher = ? , isTeacherRated = 1 WHERE rateID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newRate);
            stmt.setString(2, rateID);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }
}
