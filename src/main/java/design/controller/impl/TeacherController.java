package design.controller.impl;

import design.DAO.impl.DAOFactory;
import design.controller.AbstractTeacherController;
import design.model.assistant.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("teacher")

public class TeacherController implements AbstractTeacherController {
    /**
     * @return
     */
    @Override
    public List<String> getCourseList() {
        return DAOFactory.getDAO().getCourseDAO().getCourseList();
    }

    /**
     * @param newCourse 新课程
     * @return bool        是否添加成功
     */
    @Override
    public boolean addCourse(Course newCourse) {
        return DAOFactory.getDAO().getCourseDAO().addCourse(newCourse);
    }

    /**
     * @return
     */
    @Override
    public List<String> getVolunteerList(@RequestParam (value = "courseID") String courseID) {
        return DAOFactory.getDAO().getAssistantDAO().getVolunteerListByCourseID(courseID);
    }

    /**
     *
     */
    @Override
    public boolean selectAssistant(@RequestParam(value = "volunteerID") String volunteerID) {
        return DAOFactory.getDAO().getAssistantDAO().addAssistantByVolunteerID(volunteerID);
    }

    /**
     * @return
     */
    @Override
    public List<String> getRateList(@RequestParam (value = "teacherID") String teacherID) {
        return DAOFactory.getDAO().getAssistantDAO().getRateListByTeacherID(teacherID);
    }

    /**
     *
     */
    @Override
    public boolean rateAssistant(
            @RequestParam(value = "rateID") String rateID,
            @RequestParam(value = "teacherRate") String teacherRate
    ) {
        return DAOFactory.getDAO().getAssistantDAO().updateAssistantRate(rateID, teacherRate);
    }

    /**
     * @return
     */
    @Override
    public List<String> getAcademicExchangeList() {
        return DAOFactory.getDAO().getExchangeDAO().getAcademicExchangeList();
    }

    /**
     *
     */
    @Override
    public boolean rateAcademicExchange(
            @RequestParam(value = "exchangeID") String exchangeID,
            @RequestParam(value = "teacherRate") boolean isValid
    ) {
        return DAOFactory.getDAO().getExchangeDAO().updateExchangeMentorValid(exchangeID, isValid);
    }

    /**
     * @return
     */
    @Override
    public List<String> getProjectList() {
        return DAOFactory.getDAO().getAttendanceDAO().getProjectList();
    }

    /**
     * @param mentorID 导师ID
     * @return List<String>    学生列表
     */
    @Override
    public List<String> getStudentListByMentorID(@RequestParam(value = "mentorID") String mentorID) {
        return DAOFactory.getDAO().getUserDAO().getStudentListByMentorID(mentorID);
    }

    /**
     *
     */
    @Override
    public boolean assignProject(
            @RequestParam(value = "projectID") String projectID,
            @RequestParam(value = "studentID") String studentID,
            @RequestParam(value = "fund") double fund
    ) {
        return DAOFactory.getDAO().getAttendanceDAO().addAttendanceByID(projectID, studentID, fund);
    }

    /**
     * @return
     */
    @Override
    public List<String> getAchievementList(@RequestParam(value = "studentID") String studentID) {
        return DAOFactory.getDAO().getAchievementDAO().getAchievementList(studentID);
    }

    /**
     *
     */
    @Override
    public boolean reviewAchievement(
            @RequestParam(value = "type") String type,
            @RequestParam(value = "achievementID") String achievementID,
            @RequestParam(value = "isValid") boolean isValid
    ) {
        return DAOFactory.getDAO().getAchievementDAO().updateAchievementMentorValid(type, achievementID, isValid);
    }
}