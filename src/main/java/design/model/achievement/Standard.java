package design.model.achievement;

public class Standard {
    private String achievementID;   //成果ID
    private String achievementStudentID; //学生ID
    private String standardName;
    private String standardLevel;
    private String standardPublishTime;
    private String standardAttachment;

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

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getStandardLevel() {
        return standardLevel;
    }

    public void setStandardLevel(String standardLevel) {
        this.standardLevel = standardLevel;
    }

    public String getStandardPublishTime() {
        return standardPublishTime;
    }

    public void setStandardPublishTime(String standardPublishTime) {
        this.standardPublishTime = standardPublishTime;
    }

    public String getStandardAttachment() {
        return standardAttachment;
    }

    public void setStandardAttachment(String standardAttachment) {
        this.standardAttachment = standardAttachment;
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
