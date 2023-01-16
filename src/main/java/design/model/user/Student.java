package design.model.user;

public class Student {
    private String studentID;               //学号,用户名
    private int studentType;                //0:专硕 1:学硕 2:博士
    private String studentName;             //姓名
    private int studentSex;                 //性别 0:男 1:女
    private String studentSubjectID;        //学科ID
    private String studentMentorId;                //导师工号
    private boolean studentAssistantStatus;        //是否做过助教 0:否 1:是
    private boolean studentAssistantRateStatus;    //助教评价 0:未评价 1:已评价
    private int studentExchangeNum;                //交换次数
    private String password;                //密码
    public final int role = 0;              //角色 0:学生 1:教师 2:管理员

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getStudentType() {
        return studentType;
    }

    public void setStudentType(int studentType) {
        this.studentType = studentType;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(int studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentSubjectID() {
        return studentSubjectID;
    }

    public void setStudentSubjectID(String studentSubjectID) {
        this.studentSubjectID = studentSubjectID;
    }

    public String getStudentMentorId() {
        return studentMentorId;
    }

    public void setStudentMentorId(String studentMentorId) {
        this.studentMentorId = studentMentorId;
    }

    public boolean isStudentAssistantStatus() {
        return studentAssistantStatus;
    }

    public void setStudentAssistantStatus(boolean studentAssistantStatus) {
        this.studentAssistantStatus = studentAssistantStatus;
    }

    public boolean isStudentAssistantRateStatus() {
        return studentAssistantRateStatus;
    }

    public void setStudentAssistantRateStatus(boolean studentAssistantRateStatus) {
        this.studentAssistantRateStatus = studentAssistantRateStatus;
    }

    public int getStudentExchangeNum() {
        return studentExchangeNum;
    }

    public void setStudentExchangeNum(int studentExchangeNum) {
        this.studentExchangeNum = studentExchangeNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", sex=" + studentSex +
                ", MentorId='" + studentMentorId + '\'' +
                ", assistantStatus=" + studentAssistantStatus +
                ", assistantRateStatus=" + studentAssistantRateStatus +
                ", exchangeNum=" + studentExchangeNum +
                '}';
    }
}
