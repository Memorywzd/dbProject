package design.model.achievement;

public class Report {
    private String achievementID;   //成果ID
    private String achievementStudentID; //学生ID
    private String reportName;
    private String reportType;
    private String reportServiceOffice;
    private String reportPublishTime;
    private int reportContribution;
    private String reportAttachment;

    private boolean isMentorValid;      //导师是否确认
    private boolean isAdminValid;       //管理员是否确认

    public String getAchievementID() {
        return achievementID;
    }

    public void setAchievementID(String achievementID) {
        this.achievementID = achievementID;
    }

    public String getAchievementStudentID() {
        return achievementStudentID;
    }

    public void setAchievementStudentID(String achievementStudentID) {
        this.achievementStudentID = achievementStudentID;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportServiceOffice() {
        return reportServiceOffice;
    }

    public void setReportServiceOffice(String reportServiceOffice) {
        this.reportServiceOffice = reportServiceOffice;
    }

    public String getReportPublishTime() {
        return reportPublishTime;
    }

    public void setReportPublishTime(String reportPublishTime) {
        this.reportPublishTime = reportPublishTime;
    }

    public int getReportContribution() {
        return reportContribution;
    }

    public void setReportContribution(int reportContribution) {
        this.reportContribution = reportContribution;
    }

    public String getReportAttachment() {
        return reportAttachment;
    }

    public void setReportAttachment(String reportAttachment) {
        this.reportAttachment = reportAttachment;
    }

    public boolean isMentorValid() {
        return isMentorValid;
    }

    public void setMentorValid(boolean mentorValid) {
        isMentorValid = mentorValid;
    }

    public boolean isAdminValid() {
        return isAdminValid;
    }

    public void setAdminValid(boolean adminValid) {
        isAdminValid = adminValid;
    }
}
