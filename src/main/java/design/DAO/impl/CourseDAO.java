package design.DAO.impl;

import design.DAO.AbstractCourseDAO;
import design.model.assistant.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO extends DAO implements AbstractCourseDAO {
    /**
     * @return
     */
    @Override
    public List<String> getCourseList() {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM courses";
        List<String> courseList = new ArrayList<>();
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Course tempCourse = new Course();
                tempCourse.setCourseID(rs.getString("courseID"));
                tempCourse.setCourseName(rs.getString("courseName"));
                tempCourse.setCourseHour(rs.getInt("courseHour"));
                tempCourse.setCourseSelectedNum(rs.getInt("courseSelectedNum"));
                tempCourse.setCourseTarget(rs.getInt("courseTarget"));
                tempCourse.setCourseType(rs.getInt("courseType"));
                tempCourse.setCourseTime(rs.getString("courseTime"));
                tempCourse.setCoursePriority(rs.getInt("coursePriority"));
                courseList.add(tempCourse.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return courseList;
    }

    /**
     * @param courseID
     * @param priority
     * @return
     */
    @Override
    public boolean editCoursePriorityByID(String courseID, int priority) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "UPDATE courses SET coursePriority = ? WHERE courseID = ?";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, priority);
            stmt.setString(2, courseID);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }

    /**
     * @param newCourse
     * @return
     */
    @Override
    public boolean addCourse(Course newCourse) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "INSERT INTO courses VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newCourse.getCourseID());
            stmt.setString(2, newCourse.getCourseName());
            stmt.setInt(3, newCourse.getCourseHour());
            stmt.setInt(4, newCourse.getCourseSelectedNum());
            stmt.setInt(5, newCourse.getCourseTarget());
            stmt.setInt(6, newCourse.getCourseType());
            stmt.setString(7, newCourse.getCourseTime());
            stmt.setInt(8, newCourse.getCoursePriority());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return closeAll(conn, stmt, null);
    }
}
