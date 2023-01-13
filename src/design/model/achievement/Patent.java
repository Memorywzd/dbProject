package design.model.achievement;

public class Patent {
    private String patentName;
    private String patentType;
    private String patentID;
    private String patentPublishTime;
    private String patentState;
    private int patentContribution;
    private String patentAttachment;

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
}
