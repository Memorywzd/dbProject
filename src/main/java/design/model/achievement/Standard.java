package design.model.achievement;

public class Standard {
    private String achievementID;   //成果ID
    private String standardName;
    private String standardLevel;
    private String standardPublishTime;
    private String standardAttachment;

    public String getAchievementID() {
        return achievementID;
    }

    public void setAchievementID(String achievementID) {
        this.achievementID = achievementID;
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
}
