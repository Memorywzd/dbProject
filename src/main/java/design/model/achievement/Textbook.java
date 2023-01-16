package design.model.achievement;

public class Textbook {
    private String achievementID;   //成果ID
    private String achievementStudentID; //学生ID
    private String textbookName;
    private String textbookPublishHouse;
    private String textbookPublishTime;
    private int textbookContribution;
    private String textbookAttachment;
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

    public String getTextbookName() {
        return textbookName;
    }

    public void setTextbookName(String textbookName) {
        this.textbookName = textbookName;
    }

    public String getTextbookPublishHouse() {
        return textbookPublishHouse;
    }

    public void setTextbookPublishHouse(String textbookPublishHouse) {
        this.textbookPublishHouse = textbookPublishHouse;
    }

    public String getTextbookPublishTime() {
        return textbookPublishTime;
    }

    public void setTextbookPublishTime(String textbookPublishTime) {
        this.textbookPublishTime = textbookPublishTime;
    }

    public int getTextbookContribution() {
        return textbookContribution;
    }

    public void setTextbookContribution(int textbookContribution) {
        this.textbookContribution = textbookContribution;
    }

    public String getTextbookAttachment() {
        return textbookAttachment;
    }

    public void setTextbookAttachment(String textbookAttachment) {
        this.textbookAttachment = textbookAttachment;
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
