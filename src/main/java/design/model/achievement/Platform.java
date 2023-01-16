package design.model.achievement;

public class Platform {
    private String achievementID;   //成果ID
    private String achievementStudentID;   //平台学生ID
    private String platformName;
    private String platformServiceOffice;
    private String platformPublishTime;
    private int platformContribution;
    private String platformAttachment;
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

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformServiceOffice() {
        return platformServiceOffice;
    }

    public void setPlatformServiceOffice(String platformServiceOffice) {
        this.platformServiceOffice = platformServiceOffice;
    }

    public String getPlatformPublishTime() {
        return platformPublishTime;
    }

    public void setPlatformPublishTime(String platformPublishTime) {
        this.platformPublishTime = platformPublishTime;
    }

    public int getPlatformContribution() {
        return platformContribution;
    }

    public void setPlatformContribution(int platformContribution) {
        this.platformContribution = platformContribution;
    }

    public String getPlatformAttachment() {
        return platformAttachment;
    }

    public void setPlatformAttachment(String platformAttachment) {
        this.platformAttachment = platformAttachment;
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
