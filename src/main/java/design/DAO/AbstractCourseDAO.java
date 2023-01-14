package design.DAO;

import design.model.assistant.Course;

import java.util.List;

public interface AbstractCourseDAO {
    List<String> getCourseList();

    boolean editCoursePriorityByID(String courseID, int priority);

    boolean addCourse(Course newCourse);
}
