package design.model.achievement;

public class Award {
    private String achievementID;   //成果ID
    private String achievementStudentID; //学生ID
    private String awardName;
    private String awardLevel;
    private String awardRanking;
    private String awardPublishTime;
    private String awardAttachment;

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

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    public String getAwardRanking() {
        return awardRanking;
    }

    public void setAwardRanking(String awardRanking) {
        this.awardRanking = awardRanking;
    }

    public String getAwardPublishTime() {
        return awardPublishTime;
    }

    public void setAwardPublishTime(String awardPublishTime) {
        this.awardPublishTime = awardPublishTime;
    }

    public String getAwardAttachment() {
        return awardAttachment;
    }

    public void setAwardAttachment(String awardAttachment) {
        this.awardAttachment = awardAttachment;
    }
}
