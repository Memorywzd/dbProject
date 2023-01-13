package design.controller;

import java.util.List;

public interface AbstractStudentController {
    //区分专硕、学硕、博士
    int getStudentType();

    //助教工作
    String getAssistantStatus();

    List<String> getAssistantCourseList();

    void applyVolunteer();

    String getAssistantRateStatus();

    void applyAssistantRate();

    //学术交流
    String getAcademicExchangeStatus();

    void submitAcademicExchange();

    void applyAcademicExchangeStatistics();

    //参与项目
    String getAttendProjectStatus();

    void submitAttendProject();

    //成果认定
    void submitAchievement();
}
