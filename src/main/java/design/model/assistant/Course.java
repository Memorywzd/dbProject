package design.model.assistant;

public class Course {
    private String courseID;
    private String courseName;
    private int courseHour;
    private int courseSelectedNum;
    private int courseTarget;
    private int courseType;
    private String courseTime;
    private int coursePriority;

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(int courseHour) {
        this.courseHour = courseHour;
    }

    public int getCourseSelectedNum() {
        return courseSelectedNum;
    }

    public void setCourseSelectedNum(int courseSelectedNum) {
        this.courseSelectedNum = courseSelectedNum;
    }

    public int getCourseTarget() {
        return courseTarget;
    }

    public void setCourseTarget(int courseTarget) {
        this.courseTarget = courseTarget;
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(int courseType) {
        this.courseType = courseType;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public int getCoursePriority() {
        return coursePriority;
    }

    public void setCoursePriority(int coursePriority) {
        this.coursePriority = coursePriority;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseHour=" + courseHour +
                ", courseSelectedNum=" + courseSelectedNum +
                ", courseTarget=" + courseTarget +
                ", courseType=" + courseType +
                ", courseTime='" + courseTime + '\'' +
                ", coursePriority=" + coursePriority +
                '}';
    }
}
