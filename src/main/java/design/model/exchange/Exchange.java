package design.model.exchange;

public class Exchange {
    private String exchangeID;          //交流项目ID
    private String exchangeStudentID;   //交流项目学生ID
    private String exchangeSubjectID;   //交流项目学科ID
    private String exchangeName;        //交流项目名称
    private String exchangeLocation;    //交流项目地点
    private String exchangeTime;        //交流项目时间
    private String exchangeReportName;  //交流项目报告名称
    private String exchangeImagePath;   //交流项目图片路径
    private String exchangeNote;        //交流项目备注
    private boolean isMentorValid;      //交流项目导师有效
    private boolean isLeaderValid;      //交流学科负责人有效

    public Exchange(String exchangeID, String exchangeStudentID, String exchangeSubjectID, String exchangeName, String exchangeLocation, String exchangeTime, String exchangeReportName, String exchangeImagePath, String exchangeNote, boolean isMentorValid, boolean isLeaderValid) {
        this.exchangeID = exchangeID;
        this.exchangeStudentID = exchangeStudentID;
        this.exchangeSubjectID = exchangeSubjectID;
        this.exchangeName = exchangeName;
        this.exchangeLocation = exchangeLocation;
        this.exchangeTime = exchangeTime;
        this.exchangeReportName = exchangeReportName;
        this.exchangeImagePath = exchangeImagePath;
        this.exchangeNote = exchangeNote;
        this.isMentorValid = isMentorValid;
        this.isLeaderValid = isLeaderValid;
    }

    public String getExchangeID() {
        return exchangeID;
    }

    public void setExchangeID(String exchangeID) {
        this.exchangeID = exchangeID;
    }

    public String getExchangeStudentID() {
        return exchangeStudentID;
    }

    public void setExchangeStudentID(String exchangeStudentID) {
        this.exchangeStudentID = exchangeStudentID;
    }

    public String getExchangeSubjectID() {
        return exchangeSubjectID;
    }

    public void setExchangeSubjectID(String exchangeSubjectID) {
        this.exchangeSubjectID = exchangeSubjectID;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getExchangeLocation() {
        return exchangeLocation;
    }

    public void setExchangeLocation(String exchangeLocation) {
        this.exchangeLocation = exchangeLocation;
    }

    public String getExchangeTime() {
        return exchangeTime;
    }

    public void setExchangeTime(String exchangeTime) {
        this.exchangeTime = exchangeTime;
    }

    public String getExchangeReportName() {
        return exchangeReportName;
    }

    public void setExchangeReportName(String exchangeReportName) {
        this.exchangeReportName = exchangeReportName;
    }

    public String getExchangeImagePath() {
        return exchangeImagePath;
    }

    public void setExchangeImagePath(String exchangeImagePath) {
        this.exchangeImagePath = exchangeImagePath;
    }

    public String getExchangeNote() {
        return exchangeNote;
    }

    public void setExchangeNote(String exchangeNote) {
        this.exchangeNote = exchangeNote;
    }

    public boolean isMentorValid() {
        return isMentorValid;
    }

    public void setMentorValid(boolean mentorValid) {
        isMentorValid = mentorValid;
    }

    public boolean isLeaderValid() {
        return isLeaderValid;
    }

    public void setLeaderValid(boolean leaderValid) {
        isLeaderValid = leaderValid;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "exchangeName='" + exchangeName + '\'' +
                ", exchangeLocation='" + exchangeLocation + '\'' +
                ", exchangeTime='" + exchangeTime + '\'' +
                ", exchangeReportName='" + exchangeReportName + '\'' +
                ", exchangeImagePath='" + exchangeImagePath + '\'' +
                ", exchangeNote='" + exchangeNote + '\'' +
                ", isMentorValid=" + isMentorValid +
                ", isLeaderValid=" + isLeaderValid +
                '}';
    }
}
