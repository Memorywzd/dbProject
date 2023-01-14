package design.DAO;

import design.model.Project;

import java.util.List;

public interface AbstractAttendanceDAO {
    List<String> getProjectList();

    boolean addProject(Project newProject);

    boolean attendProject(String projectID, String studentID);

    boolean updateProjectStudentID(String projectID, String studentID);
}
