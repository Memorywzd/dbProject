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
            String sql = "select * from projects";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Project tempProject = new Project();
                tempProject.setProjectID(rs.getString("projectID"));
                tempProject.setProjectSubjectID(rs.getString("projectSubjectID"));
                tempProject.setProjectMentorID(rs.getString("projectMentorID"));
                tempProject.setProjectType(rs.getString("projectType"));
                tempProject.setProjectName(rs.getString("projectName"));
                tempProject.setProjectFund(rs.getDouble("projectFund"));
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
                "attendanceTime = ?, attendanceTask = ?, attendanceFund = ? " +
                "where attendanceID = ?";
        try{
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newAttendance.getAttendanceTime());
            stmt.setString(2, newAttendance.getAttendanceTask());
            stmt.setDouble(3, newAttendance.getAttendanceFund());
            stmt.setInt(4, newAttendance.getAttendanceID());
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
    public boolean addAttendanceByID(String projectID, String studentID) {
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
            stmt.setString(5, null);
            stmt.setBoolean(6, false);
            stmt.setBoolean(7, false);
            stmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }
}
