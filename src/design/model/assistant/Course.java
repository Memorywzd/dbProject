package design.model.assistant;

import java.sql.Date;

public class Course {
    private String courseID;
    private String courseName;
    private int courseHour;
    private int courseSelectedNum;
    private int courseTarget;
    private int courseType;
    private Date courseTime;

//    public Course(String courseID, String courseName, int courseHour, int courseSelectedNum,  int courseTarget, int courseType,Date courseTime) {
//        this.courseID = courseID;
//        this.courseName = courseName;
//        this.courseHour = courseHour;
//        this.courseSelectedNum = courseSelectedNum;
//        this.courseTarget = courseTarget;
//        this.courseType = courseType;
//        this.courseTime =courseTime;
//    }
//
//    @Override
//    public String toString() {
//        return "Course{" +
//                "courseID=" + courseID +
//                ", courseName='" + courseName + '\'' +
//                ", courseHour='" + courseHour + '\'' +
//                ", courseSelectedNum='" +courseSelectedNum + '\'' +
//                ", courseTarget=" + courseTarget +'\''+
//                ", courseType=" + courseType +'\''+
//                ",courseTime="+courseTime+'\''+
//                '}';
//    }

    public String getcourseID() {
        return courseID;
    }

    public void setcourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getcourseName() {
        return courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getcourseHour() {
        return courseHour;
    }

    public void setcourseHour(int courseHour) {
        this.courseHour = courseHour;
    }

    public int getcourseSelectedNum() {
        return courseSelectedNum;
    }

    public void setcourseSelectedNum(int courseSelectedNum) {
        this.courseSelectedNum = courseSelectedNum;
    }

    public int getcourseTarget() {
        return courseTarget;
    }

    public void setcourseTarget(int courseTarget) {
        this.courseTarget = courseTarget;
    }

    public int getcourseType() {
        return courseType;
    }

    public void setcourseType(int courseType) {
        this.courseType = courseType;
    }

    public Date getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Date courseTime) {
        this.courseTime = courseTime;
    }

}
