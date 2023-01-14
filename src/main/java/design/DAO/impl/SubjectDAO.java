package design.DAO.impl;

import design.DAO.AbstractSubjectDAO;
import design.model.user.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends DAO implements AbstractSubjectDAO {
    /**
     * @return
     */
    @Override
    public List<String> getSubjectList() {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<String> subjectList = new ArrayList<>();
        String sql = "select * from subjects";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Subject tempSubject = new Subject();
                tempSubject.setSubjectID(rs.getString("subjectID"));
                tempSubject.setSubjectName(rs.getString("subjectName"));
                subjectList.add(tempSubject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        closeAll(conn, stmt, rs);
        return subjectList;
    }

    /**
     * @param newSubject
     * @return
     */
    @Override
    public boolean addSubject(Subject newSubject) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String sql = "insert into subjects(subjectID, subjectName) values(?, ?)";
        try {
            conn = getDruidConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newSubject.getSubjectID());
            stmt.setString(2, newSubject.getSubjectName());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        closeAll(conn, stmt, null);
        return true;
    }
}
