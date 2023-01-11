package app;

public interface AbstractTeacherApp {
    //区分授课教师和导师
    void getTeacherType();

    //授课教师
    void getCourseList();

    void submitCourse();

    void getVolunteerList();

    void selectAssistant();

    void getRateList();

    void rateAssistant();

    //导师
    void getAcademicExchangeList();

    void rateAcademicExchange();

    void getProjectList();

    void getAttendStatus();

    void assignProject();

    void getAchievementList();

    void reviewAchievement();

}
