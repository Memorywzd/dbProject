package design.model.user;

public class Admin {
    private String adminID;     //管理员工号
    private int adminType;      //管理员类型 0:研究生培养管理员 1:学科负责人
    private String adminName;   //管理员姓名
    private String password;    //密码
    public final int role = 2;  //角色 0:学生 1:教师 2:管理员

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public int getAdminType() {
        return adminType;
    }

    public void setAdminType(int adminType) {
        this.adminType = adminType;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
