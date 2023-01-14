package design.controller.impl;

import design.DAO.impl.DAOFactory;
import design.controller.AbstractStudentController;
import design.model.Exchange;
import design.model.assistant.Assistant;
import design.model.assistant.Rate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("student")

public class StudentController implements AbstractStudentController {
    /**
     * @return
     */
    @Override
    public boolean getAssistantStatus(@RequestParam("studentID") String studentID) {
        return DAOFactory.getDAO().getUserDAO().getAssistantStatus(studentID);
    }

    /**
     * @return
     */
    @Override
    public List<String> getAssistantCourseList() {
        return DAOFactory.getDAO().getCourseDAO().getCourseList();
    }

    /**
     *
     */
    @Override
    public boolean applyVolunteer(Assistant newAssistantVolunteer) {
        return DAOFactory.getDAO().getAssistantDAO().addVolunteer(newAssistantVolunteer);
    }

    /**
     * @return
     */
    @Override
    public boolean getAssistantRateStatus(@RequestParam("studentID") String studentID) {
        return DAOFactory.getDAO().getUserDAO().getAssistantRateStatus(studentID);
    }

    /**
     *
     */
    @Override
    public boolean applyAssistantRate(Rate applyRate) {
        return DAOFactory.getDAO().getAssistantDAO().addAssistantRate(applyRate);
    }

    /**
     * @return
     */
    @Override
    public List<String> getAcademicExchangeStatus(@RequestParam("studentID") String studentID) {
        return DAOFactory.getDAO().getUserDAO().getAcademicExchangeStatus(studentID);
    }

    /**
     *
     */
    @Override
    public boolean submitAcademicExchange(Exchange newExchange) {
        return DAOFactory.getDAO().getExchangeDAO().addExchange(newExchange);
    }

    /**
     * @param exchangeID
     * @return
     */
    @Override
    public boolean applyAcademicExchangeStatistics(String exchangeID) {
        return DAOFactory.getDAO().getExchangeDAO().applyAcademicExchangeStatistics(exchangeID);
    }

    /**
     * @param studentID
     * @return
     */
    @Override
    public List<String> getAttendProjectStatus(String studentID) {
        return DAOFactory.getDAO().getUserDAO().getAttendProjectStatus(studentID);
    }

    /**
     * @param newProject
     * @return
     */
    @Override
    public boolean submitAttendProject(
            @RequestParam("projectID") String projectID,
            @RequestParam("studentID") String studentID
    ) {
        return DAOFactory.getDAO().getAttendanceDAO().attendProject(projectID, studentID);
    }

    /**
     * @param newAchievement
     * @return
     */
    @Override
    public boolean submitAchievement(Map<String, String> params) {
        if (params.get("type").equals("award")) {
            return DAOFactory.getDAO().getAchievementDAO().addAward(params);
        } else if (params.get("type").equals("paper")) {
            return DAOFactory.getDAO().getAchievementDAO().addPaper(params);
        } else if (params.get("type").equals("patent")) {
            return DAOFactory.getDAO().getAchievementDAO().addPatent(params);
        } else if (params.get("type").equals("platform")) {
            return DAOFactory.getDAO().getAchievementDAO().addPlatform(params);
        } else if (params.get("type").equals("report")) {
            return DAOFactory.getDAO().getAchievementDAO().addReport(params);
        } else if (params.get("type").equals("standard")) {
            return DAOFactory.getDAO().getAchievementDAO().addStandard(params);
        } else if (params.get("type").equals("textbook")) {
            return DAOFactory.getDAO().getAchievementDAO().addTextbook(params);
        }
        return false;
    }
}
