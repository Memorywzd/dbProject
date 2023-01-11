package app;

public interface AbstractStudentApp {
    //区分专硕、学硕、博士
    void getStudentType();

    //助教工作
    void getAssistantStatus();

    void getAssistantCourseList();

    void applyVolunteer();

    void getAssistantRateStatus();

    void applyAssistantRate();

    //学术交流
    void getAcademicExchangeStatus();

    void submitAcademicExchange();

    void applyAcademicExchangeStatistics();

    //参与项目
    void getAttendProjectStatus();

    void submitAttendProject();

    //成果认定
    void submitAchievement();
}
