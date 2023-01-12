package design.common.outcome;

import java.sql.Date;

public class platform {
    private String platformName;
    private String platformServiceOffice;
    private Date platformPublishTime;
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

    public Date getPlatformPublishTime() {
        return platformPublishTime;
    }

    public void setPlatformPublishTime(Date platformPublishTime) {
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
