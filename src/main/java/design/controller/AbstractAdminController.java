package design.controller;

import design.model.attendance.Project;
import design.model.user.Student;
import design.model.user.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
//GET /admin/getSystemUserList
public interface AbstractAdminController {
    //研究生培养管理员
    @GetMapping("getSystemUserList")
    List<String> getSystemUserList();

    @GetMapping("getSystemCourseList")
    List<String> getSystemCourseList();

    @GetMapping("getSystemProjectList")
    List<String> getSystemProjectList();

    @GetMapping("getSystemAcademicExchangeList")
    List<String> getSystemAcademicExchangeList();

    @GetMapping("getSystemSubjectList")
    List<String> getSystemSubjectList();

    @GetMapping("reviewInfo")
    boolean reviewInfo();

    @PostMapping("addTeacherUser")
    boolean addTeacherUser(Teacher addTeacher);

    @PostMapping("addStudentUser")
    boolean addStudentUser(Student newStudent);

    @GetMapping("bindMentorWithStudent")
    boolean bindMentorWithStudent(
            @RequestParam(value = "studentID") String studentID,
            @RequestParam(value = "mentorID") String mentorID
    );

    @PostMapping("assignProject")
    boolean assignProject(Project newProject);

    //学科负责人
    @GetMapping("editCourseList")
    boolean editCourseList(
            @RequestParam(value = "courseID") String courseID,
            @RequestParam(value = "priority") int priority
    );

    @GetMapping("getMentorList")
    List<String> getMentorListBySubjectID(@RequestParam(value = "subjectID") String subjectID);

    @GetMapping("getStudentList")
    List<String> getStudentListBySubjectID(@RequestParam(value = "subjectID") String subjectID);

    @GetMapping("getVolunteerNumber")
    int getVolunteerNumber();

    @GetMapping("getProjectFounding")
    double getProjectFounding();

    @GetMapping("getAcademicExchange")
    int getAcademicExchange();

    @GetMapping("editVolunteerNumber")
    boolean editVolunteerNumber(@RequestParam(value = "num") int num);

    @GetMapping("editProjectFounding")
    boolean editProjectFounding(@RequestParam(value = "num") double num);

    @GetMapping("editAcademicExchange")
    boolean editAcademicExchange(@RequestParam(value = "num") int num);
}
