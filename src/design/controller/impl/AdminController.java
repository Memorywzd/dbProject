package design.controller.impl;

import design.DAO.impl.DAOFactory;
import design.controller.AbstractAdminController;
import design.model.user.Student;
import design.model.user.Teacher;

import java.util.List;

public class AdminController implements AbstractAdminController {
    /**
     * @return
     */
    @Override
    public int getAdminType() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public List<String> getSystemUserList() {
        List<String> userList;
        userList = DAOFactory.getDAO().getUserDAO().getUserList();
        return userList;
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
     *
     */
    @Override
    public void reviewInfo() {

    }

    /**
     *
     */
    @Override
    public void addTeacherUser() {
        Teacher newTeacher = new Teacher();
        newTeacher.setTeacherID("12345");
        //params
        DAOFactory.getDAO().getUserDAO().addTeacher(newTeacher);
        //web
    }

    /**
     *
     */
    @Override
    public void addStudentUser() {
        Student newStudent = new Student();
        DAOFactory.getDAO().getUserDAO().addStudent(newStudent);
    }

    /**
     *
     */
    @Override
    public void bindMentorWithStudent() {

    }

    /**
     *
     */
    @Override
    public void assignProject() {

    }

    }

    /**
     *
     */
    @Override
    public void reviewAchievement() {

    }

    /**
     * @return
     */
    @Override
    public int getVolunteerNumber() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public double getProjectFounding() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public int getAcademicExchange() {
        return 0;
    }

    /**
     *
     */
    @Override
    public void editCourseList() {

    }

    /**
     *
     */
    @Override
    public void editVolunteerNumber() {

    }

    /**
     *
     */
    @Override
    public void editProjectFounding() {

    }

    /**
     *
     */
    @Override
    public void editAcademicExchange() {

    }

    /**
     * @return
     */
    @Override
    public List<String> getMentorList() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<String> getStudentList() {
        return null;
    }
}
