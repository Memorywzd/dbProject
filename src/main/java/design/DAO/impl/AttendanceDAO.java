package design.DAO.impl;

import design.DAO.AbstractAttendanceDAO;
import design.model.Project;

import java.util.List;

public class AttendanceDAO extends DAO implements AbstractAttendanceDAO {
    /**
     * @return
     */
    @Override
    public List<String> getProjectList() {
        return null;
    }

    /**
     * @param newProject
     * @return
     */
    @Override
    public boolean addProject(Project newProject) {
        return false;
    }
}
