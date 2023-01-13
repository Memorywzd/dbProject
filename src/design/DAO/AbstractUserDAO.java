package design.DAO;

import design.model.user.Student;
import design.model.user.Teacher;

import java.util.List;

public interface AbstractUserDAO {
    List<String> getUserList();

    void addTeacher(Teacher teacher);

    void addStudent(Student student);
}