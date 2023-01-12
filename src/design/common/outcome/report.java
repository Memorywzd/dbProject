package design.common.outcome;

import java.sql.Date;

public class report {

    private String reportNam;
    private String reportType;
    private String reportServiceOffice;
    private Date reportTime;
    private int reportContribution;
    private String reportAttachment;

    public String getReportNam() {
        return reportNam;
    }

    public void setReportNam(String reportNam) {
        this.reportNam = reportNam;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportServiceOffice() {
        return reportServiceOffice;
    }

    public void setReportServiceOffice(String reportServiceOffice) {
        this.reportServiceOffice = reportServiceOffice;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public int getReportContribution() {
        return reportContribution;
    }

    public void setReportContribution(int reportContribution) {
        this.reportContribution = reportContribution;
    }

    public String getReportAttachment() {
        return reportAttachment;
    }

    public void setReportAttachment(String reportAttachment) {
        this.reportAttachment = reportAttachment;
    }


}
