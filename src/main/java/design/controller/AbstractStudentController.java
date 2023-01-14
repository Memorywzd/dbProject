package design.controller;

import design.model.Exchange;
import design.model.Project;
import design.model.assistant.Assistant;
import design.model.assistant.Rate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface AbstractStudentController {
    //助教工作
    @GetMapping("getAssistantStatus")
    boolean getAssistantStatus(@RequestParam("studentID") String studentID);

    @GetMapping("getAssistantCourseList")
    List<String> getAssistantCourseList();

    @PostMapping("applyVolunteer")
    boolean applyVolunteer(Assistant newAssistantVolunteer);

    @GetMapping("getAssistantRateStatus")
    boolean getAssistantRateStatus(@RequestParam("studentID") String studentID);

    @PostMapping("applyAssistantRate")
    boolean applyAssistantRate(Rate applyRate);

    //学术交流
    @GetMapping("getAcademicExchangeStatus")
    List<String> getAcademicExchangeStatus(@RequestParam("studentID") String studentID);

    @PostMapping("getAcademicExchangeList")
    boolean submitAcademicExchange(Exchange newExchange);

    @GetMapping("getAcademicExchangeList")
    boolean applyAcademicExchangeStatistics(@RequestParam("exchangeID") String exchangeID);

    //参与项目
    @GetMapping("getProjectStatus")
    List<String> getAttendProjectStatus(@RequestParam("studentID") String studentID);

    @PostMapping("getProjectList")
    boolean submitAttendProject(
            @RequestParam("projectID") String projectID,
            @RequestParam("studentID") String studentID
    );

    //成果认定
    @PostMapping("getAchievementStatus")
    boolean submitAchievement(@RequestParam Map<String, String> newAchievement);
}
