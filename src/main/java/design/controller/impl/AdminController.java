package design.controller.impl;

import design.DAO.impl.DAOFactory;
import design.controller.AbstractAdminController;
import design.model.Project;
import design.model.user.Student;
import design.model.user.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")

public class AdminController implements AbstractAdminController {
    /**
     * @return
     */
    @Override
    public List<String> getSystemUserList() {
        return DAOFactory.getDAO().getUserDAO().getUserList();
    }

    /**
     * @return
     */
    @Override
    public List<String> getSystemCourseList() {
        return DAOFactory.getDAO().getCourseDAO().getCourseList();
    }

    /**
     * @return
     */
    @Override
    public List<String> getSystemProjectList() {
        return DAOFactory.getDAO().getAttendanceDAO().getProjectList();
    }

    /**
     * @return
     */
    @Override
    public List<String> getSystemAcademicExchangeList() {
        return DAOFactory.getDAO().getExchangeDAO().getAcademicExchangeList();
    }

    /**
     * @return
     */
    @Override
    public List<String> getSystemSubjectList() {
        return DAOFactory.getDAO().getSubjectDAO().getSubjectList();
    }

    /**
     *
     */
    @Override
    public boolean reviewInfo() {
        return false;
    }

    /**
     *
     */
    @Override
    public boolean addTeacherUser(Teacher newTeacher) {
        return DAOFactory.getDAO().getUserDAO().addTeacher(newTeacher);
    }

    /**
     *
     */
    @Override
    public boolean addStudentUser(Student newStudent) {
        return DAOFactory.getDAO().getUserDAO().addStudent(newStudent);
    }

    /**
     *
     */
    @Override
    public boolean bindMentorWithStudent(
            @RequestParam(value = "studentID") String studentID,
            @RequestParam(value = "mentorID") String mentorID
    ) {
        return DAOFactory.getDAO().getUserDAO().updateMentorIDWithStudentID(studentID, mentorID);
    }

    /**
     *
     */
    @Override
    public boolean assignProject(Project newProject) {
        return DAOFactory.getDAO().getAttendanceDAO().addProject(newProject);
    }

    //学科负责人
    /**
     *
     */
    @Override
    public boolean editCourseList(
            @RequestParam(value = "courseID") String courseID,
            @RequestParam(value = "priority") int priority
    ) {
        return DAOFactory.getDAO().getCourseDAO().editCoursePriorityByID(courseID, priority);
    }

    /**
     * @return
     */
    @Override
    public List<String> getMentorListBySubjectID(@RequestParam(value = "subjectID") String subjectID) {
        return DAOFactory.getDAO().getUserDAO().getMentorListBySubjectID(subjectID);
    }

    /**
     * @return
     */
    @Override
    public List<String> getStudentListBySubjectID(@RequestParam(value = "subjectID") String subjectID) {
        return DAOFactory.getDAO().getUserDAO().getStudentListBySubjectID(subjectID);
    }
}
