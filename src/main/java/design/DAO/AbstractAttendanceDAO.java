package design.DAO;

import design.model.attendance.Attendance;
import design.model.attendance.Project;

import java.util.List;

public interface AbstractAttendanceDAO {
    List<String> getProjectList();

    boolean addProject(Project newProject);

    boolean updateAttendance(Attendance newAttendance);

    boolean addAttendanceByID(String projectID, String studentID);
}
