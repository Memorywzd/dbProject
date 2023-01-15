package design.model.achievement;

public class Paper {
    private String achievementID;       //成果ID
    private String achievementStudentID;      //论文学生ID
    private String paperName;           //论文名称
    private String paperPublication;    //论文发表刊物名
    private String paperStatus;         //论文状态
    private String paperPublishTime;    //论文发表时间
    private String paperIndex;          //论文索引类型
    private String paperBelong;         //论文归属
    private String paperAttachment;     //论文扫描或PDF
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

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperPublication() {
        return paperPublication;
    }

    public void setPaperPublication(String paperPublication) {
        this.paperPublication = paperPublication;
    }

    public String getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(String paperStatus) {
        this.paperStatus = paperStatus;
    }

    public String getPaperPublishTime() {
        return paperPublishTime;
    }

    public void setPaperPublishTime(String paperPublishTime) {
        this.paperPublishTime = paperPublishTime;
    }

    public String getPaperIndex() {
        return paperIndex;
    }

    public void setPaperIndex(String paperIndex) {
        this.paperIndex = paperIndex;
    }

    public String getPaperBelong() {
        return paperBelong;
    }

    public void setPaperBelong(String paperBelong) {
        this.paperBelong = paperBelong;
    }

    public String getPaperAttachment() {
        return paperAttachment;
    }

    public void setPaperAttachment(String paperAttachment) {
        this.paperAttachment = paperAttachment;
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
