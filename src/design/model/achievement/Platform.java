package design.model.achievement;

public class Platform {
    private String platformName;
    private String platformServiceOffice;
    private String platformPublishTime;
    private int platformContribution;
    private String platformAttachment;

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
}
