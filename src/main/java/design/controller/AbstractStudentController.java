package design.controller;

import design.model.attendance.Attendance;
import design.model.exchange.Exchange;
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

    @PostMapping("submitAcademicExchange")
    boolean submitAcademicExchange(Exchange newExchange);

    @GetMapping("applyAcademicExchangeStatistics")
    boolean applyAcademicExchangeStatistics(
            @RequestParam("exchangeID") String exchangeID,
            @RequestParam("studentID") String studentID
    );

    //参与项目
    @GetMapping("getAttendProjectStatus")
    List<String> getAttendProjectStatus(@RequestParam("studentID") String studentID);

    @PostMapping("submitAttendProject")
    boolean submitAttendProject(Attendance newAttendance);

    //成果认定
    @PostMapping("submitAchievement")
    boolean submitAchievement(@RequestParam Map<String, String> newAchievement);

    @GetMapping("getVolunteerNumber")
    int getVolunteerNumber();

    @GetMapping("getProjectFounding")
    double getProjectFounding();

    @GetMapping("getAcademicExchange")
    int getAcademicExchange();
}
