package design.DAO.impl;

import design.DAO.AbstractUserDAO;
import design.model.exchange.Exchange;
import design.model.user.Student;
import design.model.user.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UserDAO extends DAO implements AbstractUserDAO {

    String getIdentity(String userRole,String userType)
    {
        String identity = null;
        switch (userRole){
            case "0"->identity = "student";
            case "1"->{
                if (Objects.equals(userType, "0"))
                    identity = "teacher";
                else
                    identity = "mentor";
            }
            case "2"->{
                if (Objects.equals(userType, "0"))
                    identity = "admin";
                else
                    identity = "leader";
            }
        }
        return identity;
    }

    /**
     * @return
     */
    @Override
    public List<String> getUserList() {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<String> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String tempUser = "用户名：" + rs.getString("userID") +
                        " 用户姓名：" + rs.getString("username") +
                        " 身份：" + getIdentity(rs.getString("userRole"),
                        rs.getString("userType"));
                userList.add(tempUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return userList;
    }

    /**
     * @param teacher
     * @return
     */
    @Override
    public boolean addTeacher(Teacher teacher) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO teachers" +
                "(teacherID,teacherType,teacherName,teacherSex,teacherSubjectID,Password) " +
                "VALUES(?,?,?,?,?,?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, teacher.getTeacherID());
            stmt.setInt(2, teacher.getTeacherType());
            stmt.setString(3, teacher.getTeacherName());
            stmt.setInt(4, teacher.getTeacherSex());
            stmt.setString(5, teacher.getTeacherSubjectID());
//            stmt.setString(6, teacher.getTeacherContact());
            stmt.setString(6, teacher.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param student
     * @return
     */
    @Override
    public boolean addStudent(Student student) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO students" +
                "(studentID,studentType,studentName,studentSex,studentSubjectID, " +
                "studentMentorId,studentAssistantStatus,studentAssistantRateStatus," +
                "studentExchangeNum,password) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getStudentID());
            stmt.setInt(2, student.getStudentType());
            stmt.setString(3, student.getStudentName());
            stmt.setInt(4, student.getStudentSex());
            stmt.setString(5, student.getStudentSubjectID());
            stmt.setString(6, student.getStudentMentorId());
            stmt.setBoolean(7, student.isStudentAssistantStatus());
            stmt.setBoolean(8, student.isStudentAssistantRateStatus());
            stmt.setInt(9, student.getStudentExchangeNum());
            stmt.setString(10, student.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param studentID
     * @param mentorID
     * @return
     */
    @Override
    public boolean updateMentorIDWithStudentID(String studentID, String mentorID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "UPDATE students SET studentMentorId = ? WHERE studentID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, mentorID);
            stmt.setString(2, studentID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @return
     */
    @Override
    public List<String> getMentorListBySubjectID(String subjectID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<String> mentorList = new ArrayList<>();
        String sql = "SELECT * FROM teachers WHERE teacherType = 1 AND teacherSubjectID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, subjectID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String tempMentor = "导师ID：" + rs.getString("teacherID") +
                        " 导师姓名：" + rs.getString("teacherName");
                mentorList.add(tempMentor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return mentorList;
    }

    /**
     * @return
     */
    @Override
    public List<String> getStudentListBySubjectID(String subjectID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<String> studentList = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE studentSubjectID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, subjectID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String tempStudent = "学生ID：" + rs.getString("studentID") +
                        " 学生姓名：" + rs.getString("studentName");
                studentList.add(tempStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return studentList;
    }

    /**
     * @param studentID
     * @return
     */
    @Override
    public boolean getAssistantStatus(String studentID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean flag = false;
        String sql = "SELECT studentAssistantStatus FROM students WHERE studentID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                flag = rs.getBoolean("studentAssistantStatus");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAll(conn, stmt, rs);
        return flag;
    }

    /**
     * @param studentID
     * @return
     */
    @Override
    public boolean getAssistantRateStatus(String studentID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean flag = false;
        String sql = "SELECT studentAssistantRateStatus FROM students WHERE studentID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                flag = rs.getBoolean("studentAssistantRateStatus");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeAll(conn, stmt, rs);
        return flag;
    }

    /**
     * @param studentID
     * @return
     */
    @Override
    public List<String> getAcademicExchangeStatus(String studentID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<String> exchangeList = new ArrayList<>();
        String sql = "SELECT * FROM exchanges WHERE exchangeStudentID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);
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
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return exchangeList;
    }

    /**
     * @param studentID
     * @return
     */
    @Override
    public List<String> getAttendProjectStatus(String studentID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<String> projectList = new ArrayList<>();
        String sql = "SELECT projectID, projectType, projectName, attendanceTime, " +
                "attendanceTask, attendanceFund, isMentorValid, isLeaderValid " +
                "FROM attendances, projects " +
                "WHERE projectID = attendanceProjectID AND attendanceStudentID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String tempProject = "项目ID：" + rs.getString("projectID") +
                        " 项目类型：" + rs.getString("projectType") +
                        " 项目名称：" + rs.getString("projectName") +
                        " 参与时间：" + rs.getString("attendanceTime") +
                        " 参与任务：" + rs.getString("attendanceTask") +
                        " 参与经费：" + rs.getString("attendanceFund") +
                        " 导师是否认定：" + rs.getBoolean("isMentorValid") +
                        " 负责人是否认定：" + rs.getBoolean("isLeaderValid");
                projectList.add(tempProject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return projectList;
    }

    /**
     * @param mentorID
     * @return
     */
    @Override
    public List<String> getStudentListByMentorID(String mentorID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<String> studentList = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE studentMentorID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, mentorID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String tempStudent = "学生ID：" + rs.getString("studentID") +
                        " 学生姓名：" + rs.getString("studentName");
                studentList.add(tempStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return studentList;
    }

    /**
     * @return
     */
    @Override
    public int getVolunteerNumber() {
        PreparedStatement stmt = null;
        Connection conn = null;
        int number = 0;
        String sql = "SELECT volunteerNumber FROM requirements";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                number = rs.getInt("volunteerNumber");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        closeAll(conn, stmt, null);
        return number;
    }

    /**
     * @return
     */
    @Override
    public double getProjectFounding() {
        PreparedStatement stmt = null;
        Connection conn = null;
        double founding = 0;
        String sql = "SELECT projectFounding FROM requirements";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                founding = rs.getDouble("projectFounding");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        closeAll(conn, stmt, null);
        return founding;
    }

    /**
     * @return
     */
    @Override
    public int getAcademicExchange() {
        PreparedStatement stmt = null;
        Connection conn = null;
        int exchange = 0;
        String sql = "SELECT academicExchange FROM requirements";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                exchange = rs.getInt("academicExchange");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        closeAll(conn, stmt, null);
        return exchange;
    }

    /**
     * @param num
     * @return
     */
    @Override
    public boolean editVolunteerNumber(int num) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "UPDATE requirements SET volunteerNumber = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, num);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param num
     * @return
     */
    @Override
    public boolean editProjectFounding(double num) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "UPDATE requirements SET projectFounding = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, num);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param num
     * @return
     */
    @Override
    public boolean editAcademicExchange(int num) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "UPDATE requirements SET academicExchange = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, num);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }
}
