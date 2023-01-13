package design.controller;

import java.util.List;

public interface AbstractTeacherController {
    //区分授课教师和导师
    int getTeacherType();

    //授课教师
    List<String> getCourseList();

    void submitCourse();

    List<String> getVolunteerList();

    void selectAssistant();

    List<String> getRateList();

    void rateAssistant();

    //导师
    List<String> getAcademicExchangeList();

    void rateAcademicExchange();

    List<String> getProjectList();

    void getAttendStatus();

    void assignProject();

    List<String> getAchievementList();

    void reviewAchievement();

}
