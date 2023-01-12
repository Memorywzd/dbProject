package design.common.outcome;

import java.sql.Date;

public class standard {
    private String standardName;
    private String standardLevel;
    private Date standardPublishTime;
    private String standardAttachment;

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

    public Date getStandardPublishTime() {
        return standardPublishTime;
    }

    public void setStandardPublishTime(Date standardPublishTime) {
        this.standardPublishTime = standardPublishTime;
    }

    public String getStandardAttachment() {
        return standardAttachment;
    }

    public void setStandardAttachment(String standardAttachment) {
        this.standardAttachment = standardAttachment;
    }


}
