package design.model.achievement;

public class Paper {
    private String magazineName;
    private String state;
    private String publicTime;
    private String index;
    private String paperDatabase;
    private String attachmentFile;

    private String achievementID;   //成果ID

    public String getAchievementID() {
        return achievementID;
    }

    public void setAchievementID(String achievementID) {
        this.achievementID = achievementID;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(String publicTime) {
        this.publicTime = publicTime;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPaperDatabase() {
        return paperDatabase;
    }

    public void setPaperDatabase(String paperDatabase) {
        this.paperDatabase = paperDatabase;
    }

    public String getAttachmentFile() {
        return attachmentFile;
    }

    public void setAttachmentFile(String attachmentFile) {
        this.attachmentFile = attachmentFile;
    }
}
