package design.model.user;

public class Student {
    private int studentType;    //0:专硕 1:学硕 2:博士
    private String studentId;   //学号,用户名
    private String studentName; //姓名
    private int sex;            //性别 0:男 1:女
    private String MentorId;    //导师工号
    private String password;    //密码
    public final int role = 0;           //角色 0:学生 1:教师 2:管理员

    public int getStudentType() {
        return studentType;
    }

    public void setStudentType(int studentType) {
        this.studentType = studentType;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMentorId() {
        return MentorId;
    }

    public void setMentorId(String mentorId) {
        MentorId = mentorId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
