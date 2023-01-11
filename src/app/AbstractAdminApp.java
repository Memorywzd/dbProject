package app;

public interface AbstractAdminApp {
    //区分研究生培养管理员、学科负责人
    void getAdminType();

    //研究生培养管理员
    void getSystemUserList();

    void getSystemCourseList();

    void getSystemProjectList();

    void getSystemAcademicExchangeList();

    void reviewInfo();

    void addTeacherUser();

    void addStudentUser();

    void bindMentorWithStudent();

    void assignProject();

    void reviewAchievement();

    //学科负责人
    void getCourseList();

    void getVolunteerNumber();

    void getProjectFounding();

    void getAcademicExchange();

    void editCourseList();

    void editVolunteerNumber();

    void editProjectFounding();

    void editAcademicExchange();

    void getMentorList();

    void getStudentList();
}
