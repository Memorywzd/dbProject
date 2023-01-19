package design.controller.impl;

import design.DAO.impl.DAOFactory;
import design.controller.AbstractAdminController;
import design.model.attendance.Project;
import design.model.user.Admin;
import design.model.user.Student;
import design.model.user.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

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
     * @return
     */
    @Override
    public List<String> getRateList() {
        return DAOFactory.getDAO().getAssistantDAO().getRateList();
    }

    @Override
    public List<String> getAchievementList() {
        return DAOFactory.getDAO().getAchievementDAO().getAchievementListAll();
    }

    /**
     *
     */
    @Override
    public boolean reviewInfo(
            @RequestParam("id") String id,
            @RequestParam("valid") int Valid,
            @RequestParam("type") String type
    ) {
        boolean valid;
        if(Valid == 1){
            valid = true;
        }else{
            valid = false;
        }
        if(Objects.equals(type, "attendance")){
            return DAOFactory.getDAO().getAttendanceDAO().reviewAttendance(id, valid);
        }
        else if(Objects.equals(type, "exchange")){
            return DAOFactory.getDAO().getExchangeDAO().updateExchangeLeaderValid(id, valid);
        }
        else if(Objects.equals(type, "rate")){
            return DAOFactory.getDAO().getAssistantDAO().reviewRate(id, valid);
        }
        else if(Objects.equals(type, "achievement")){
            return DAOFactory.getDAO().getAchievementDAO().updateAchievementAdminValid(id, valid);
        }
        else{
            return false;
        }
    }

    /**
     * @param newAdmin
     * @return
     */
    @Override
    public boolean addLeaderUser(Admin newAdmin) {
        return DAOFactory.getDAO().getUserDAO().addLeaderUser(newAdmin);
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

    /**
     * @return
     */
    @Override
    public int getVolunteerNumber() {
        return DAOFactory.getDAO().getUserDAO().getVolunteerNumber();
    }

    /**
     * @return
     */
    @Override
    public double getProjectFounding() {
        return DAOFactory.getDAO().getUserDAO().getProjectFounding();
    }

    /**
     * @return
     */
    @Override
    public int getAcademicExchange() {
        return DAOFactory.getDAO().getUserDAO().getAcademicExchange();
    }

    /**
     * @return
     */
    @Override
    public boolean editVolunteerNumber(@RequestParam(value = "num") int num) {
        return DAOFactory.getDAO().getUserDAO().editVolunteerNumber(num);
    }

    /**
     * @return
     */
    @Override
    public boolean editProjectFounding(@RequestParam(value = "num") double num) {
        return DAOFactory.getDAO().getUserDAO().editProjectFounding(num);
    }

    /**
     * @return
     */
    @Override
    public boolean editAcademicExchange(@RequestParam(value = "num") int num) {
        return DAOFactory.getDAO().getUserDAO().editAcademicExchange(num);
    }
}
