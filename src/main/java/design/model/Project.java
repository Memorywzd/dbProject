package design.model;

public class Project {
    private String projectID;
    private String projectSubjectID;
    private String projectMentorID;
    private String projectType;
    private String projectName;
    private double projectFund;

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectSubjectID() {
        return projectSubjectID;
    }

    public void setProjectSubjectID(String projectSubjectID) {
        this.projectSubjectID = projectSubjectID;
    }

    public String getProjectMentorID() {
        return projectMentorID;
    }

    public void setProjectMentorID(String projectMentorID) {
        this.projectMentorID = projectMentorID;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getProjectFund() {
        return projectFund;
    }

    public void setProjectFund(double projectFund) {
        this.projectFund = projectFund;
    }
}
