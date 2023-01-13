package design.model.user;

public class Teacher {
    private String teacherID;           //教师工号
    private String teacherName;         //教师姓名
    private int teacherSex;             //教师性别 0:男 1:女
    private String teacherSubjectID;    //教师所教科目ID
    private int teacherType;            //教师类型 0:授课教师 1:导师
    private String teacherContact;      //教师联系方式
    private String password;    //密码
    public final int role = 1;           //角色 0:学生 1:教师 2:管理员

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(int teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherSubjectID() {
        return teacherSubjectID;
    }

    public void setTeacherSubjectID(String teacherSubjectID) {
        this.teacherSubjectID = teacherSubjectID;
    }

    public int getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(int teacherType) {
        this.teacherType = teacherType;
    }

    public String getTeacherContact() {
        return teacherContact;
    }

    public void setTeacherContact(String teacherContact) {
        this.teacherContact = teacherContact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
