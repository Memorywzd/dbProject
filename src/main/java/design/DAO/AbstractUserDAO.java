package design.DAO;

import design.model.user.Student;
import design.model.user.Teacher;

import java.util.List;

public interface AbstractUserDAO {
    List<String> getUserList();

    boolean addTeacher(Teacher teacher);

    boolean addStudent(Student student);

    boolean updateMentorIDWithStudentID(String studentID, String mentorID);

    List<String> getMentorListBySubjectID(String subjectID);

    List<String> getStudentListBySubjectID(String subjectID);

    boolean getAssistantStatus(String studentID);

    boolean getAssistantRateStatus(String studentID);

    List<String> getAcademicExchangeStatus(String studentID);

    List<String> getAttendProjectStatus(String studentID);

    List<String> getStudentListByMentorID(String mentorID);

    int getVolunteerNumber();

    double getProjectFounding();

    int getAcademicExchange();

    boolean editVolunteerNumber(int num);

    boolean editProjectFounding(double num);

    boolean editAcademicExchange(int num);

    //Student getStudentByStudentID(String studentID);
}