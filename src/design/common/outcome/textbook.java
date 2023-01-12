package outcome;

import java.sql.Date;

public class textbook {
    private String textbookName;
    private String textbookPublishHouse;
    private Date textbookPublishTime;
    private int textbookContribution;
    private String textbookAttachment;

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

    public Date getTextbookPublishTime() {
        return textbookPublishTime;
    }

    public void setTextbookPublishTime(Date textbookPublishTime) {
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


}
