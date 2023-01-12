package design.common.outcome;

import java.sql.Date;

public class paper {

    private String magazineName;
    private String state;
    private Date publicTime;
    private String index;
    private String paperDatabase;
    private String attachmentFile;

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

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
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
