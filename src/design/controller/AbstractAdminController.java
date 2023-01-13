package design.controller;

import java.util.List;

public interface AbstractAdminController {
    //区分研究生培养管理员、学科负责人
    int getAdminType();

    //研究生培养管理员
    List<String> getSystemUserList();

    List<String> getSystemCourseList();

    List<String> getSystemProjectList();

    List<String> getSystemAcademicExchangeList();

    List<String> getSystemSubjectList();

    void reviewInfo();

    void addTeacherUser();

    void addStudentUser();

    void bindMentorWithStudent();

    void assignProject();

    void reviewAchievement();

    //学科负责人
    int getVolunteerNumber();

    double getProjectFounding();

    int getAcademicExchange();

    void editCourseList();

    void editVolunteerNumber();

    void editProjectFounding();

    void editAcademicExchange();

    List<String> getMentorList();

    List<String> getStudentList();
}
