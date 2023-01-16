package design.model.achievement;

public class Patent {
    private String achievementID;   //成果ID
    private String achievementStudentID; //专利学生ID
    private String patentName;
    private String patentType;
    private String patentID;
    private String patentPublishTime;
    private String patentState;
    private int patentContribution;
    private String patentAttachment;
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

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getPatentID() {
        return patentID;
    }

    public void setPatentID(String patentID) {
        this.patentID = patentID;
    }

    public String getPatentPublishTime() {
        return patentPublishTime;
    }

    public void setPatentPublishTime(String patentPublishTime) {
        this.patentPublishTime = patentPublishTime;
    }

    public String getPatentState() {
        return patentState;
    }

    public void setPatentState(String patentState) {
        this.patentState = patentState;
    }

    public int getPatentContribution() {
        return patentContribution;
    }

    public void setPatentContribution(int patentContribution) {
        this.patentContribution = patentContribution;
    }

    public String getPatentAttachment() {
        return patentAttachment;
    }

    public void setPatentAttachment(String patentAttachment) {
        this.patentAttachment = patentAttachment;
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
