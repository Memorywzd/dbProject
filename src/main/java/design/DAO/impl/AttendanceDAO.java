package design.DAO.impl;

import design.DAO.AbstractAttendanceDAO;
import design.model.attendance.Attendance;
import design.model.attendance.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO extends DAO implements AbstractAttendanceDAO {
    /**
     * @return
     */
    @Override
    public List<String> getProjectList() {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<String> projectList = new ArrayList<>();
        try{
            conn = getDruidConnection();
            String sql = "select * from attendances";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Attendance tempProject = new Attendance();
                tempProject.setAttendanceID(rs.getInt("attendanceID"));
                tempProject.setAttendanceProjectID(rs.getString("attendanceProjectID"));
                tempProject.setAttendanceStudentID(rs.getString("attendanceStudentID"));
                tempProject.setAttendanceTime(rs.getString("attendanceTime"));
                tempProject.setAttendanceTask(rs.getString("attendanceTask"));
                tempProject.setAttendanceFund(rs.getDouble("attendanceFund"));
                tempProject.setMentorValid(rs.getBoolean("isMentorValid"));
                tempProject.setLeaderValid(rs.getBoolean("isLeaderValid"));
                projectList.add(tempProject.toString());
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return projectList;
    }

    /**
     * @param newProject
     * @return
     */
    @Override
    public boolean addProject(Project newProject) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "insert into projects values(?,?,?,?,?,?)";
        try{
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newProject.getProjectID());
            stmt.setString(2, newProject.getProjectSubjectID());
            stmt.setString(3, newProject.getProjectMentorID());
            stmt.setString(4, newProject.getProjectType());
            stmt.setString(5, newProject.getProjectName());
            stmt.setDouble(6, newProject.getProjectFund());
            stmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param newAttendance
     * @return
     */
    @Override
    public boolean updateAttendance(Attendance newAttendance) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "update attendances set " +
                "attendanceTime = ?, attendanceTask = ? " +
                "where attendanceID = ?";
        try{
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newAttendance.getAttendanceTime());
            stmt.setString(2, newAttendance.getAttendanceTask());
            stmt.setInt(3, newAttendance.getAttendanceID());
            stmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param projectID
     * @param studentID
     * @return
     */
    @Override
    public boolean addAttendanceByID(String projectID, String studentID, double fund) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "insert into attendances values(?,?,?,?,?,?,?)";
        try{
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, projectID);
            stmt.setString(2, studentID);
            stmt.setString(3, null);
            stmt.setString(4, null);
            stmt.setDouble(5, fund);
            stmt.setBoolean(6, false);
            stmt.setBoolean(7, false);
            stmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param id
     * @param valid
     * @return
     */
    @Override
    public boolean reviewAttendance(String id, boolean valid) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "update attendances set isLeaderValid = ? where attendanceID = ?";
        try{
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            if(valid)
                stmt.setInt(1, 1);
            else
                stmt.setInt(1, 0);
            stmt.setString(2, id);
            stmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }
}
