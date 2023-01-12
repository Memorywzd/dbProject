package design.common.project;

import java.sql.Date;

public class project {
    private String studentID;
    private String studentName;
    private String subject;
    private String projectID;
    private String projectType;
    private String projectName;
    private Date projectStartDate;
    private Date projectFinishDate;
    private String job;
    private int projectFund;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectKind() {
        return projectType;
    }

    public void setProjectKind(String projectKind) {
        this.projectType = projectKind;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Date getProjectFinishDate() {
        return projectFinishDate;
    }

    public void setProjectFinishDate(Date projectFinishDate) {
        this.projectFinishDate = projectFinishDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getProjectFund() {
        return projectFund;
    }

    public void setProjectFund(int projectFund) {
        this.projectFund = projectFund;
    }


}
