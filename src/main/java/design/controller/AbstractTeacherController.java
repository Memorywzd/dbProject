package design.controller;

import design.model.assistant.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AbstractTeacherController {
    //授课教师
    @GetMapping("getCourseList")
    List<String> getCourseList();

    @PostMapping("submitCourse")
    boolean addCourse(Course newCourse);

    @GetMapping("getVolunteerList")
    List<String> getVolunteerList(@RequestParam(value = "courseID") String courseID);

    @GetMapping("selectAssistant")
    boolean selectAssistant(@RequestParam(value = "volunteerID") String volunteerID);

    @GetMapping("getRateList")
    List<String> getRateList(@RequestParam(value = "teacherID") String courseID);

    @GetMapping("rateAssistant")
    boolean rateAssistant(
            @RequestParam(value = "rateID") String rateID,
            @RequestParam(value = "teacherRate") String teacherRate
    );

    //导师
    @GetMapping("getAcademicExchangeList")
    List<String> getAcademicExchangeList();

    @GetMapping("rateAcademicExchange")
    boolean rateAcademicExchange(
            @RequestParam(value = "exchangeID") String exchangeID,
            @RequestParam(value = "teacherRate") boolean teacherRate
    );

    @GetMapping("getProjectList")
    List<String> getProjectList();

    @GetMapping("getStudentListByMentorID")
    List<String> getStudentListByMentorID(@RequestParam(value = "mentorID") String mentorID);

    @GetMapping("assignProject")
    boolean assignProject(
            @RequestParam(value = "projectID") String projectID,
            @RequestParam(value = "studentID") String studentID,
            @RequestParam(value = "fund") double fund
    );

    @GetMapping("getAchievementList")
    List<String> getAchievementList(@RequestParam(value = "studentID") String studentID);

    @GetMapping("reviewAchievement")
    boolean reviewAchievement(
            @RequestParam(value = "type") String type,
            @RequestParam(value = "achievementID") String achievementID,
            @RequestParam(value = "isValid") boolean isValid
    );

}
