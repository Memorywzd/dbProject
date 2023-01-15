package design.model;

public class LoginStatus {
    private String userID;              //当前登录用户ID
    private String password;            //当前登录用户密码
    private int userRole;               //当前登录用户角色 0:学生 1:教师 2:管理员
    private int userType;               //当前登录用户类型 不同用户角色值不同含义
    private String token;               //用户token
    private boolean isTokenValid;       //token是否有效

    public LoginStatus(String userID, String password, int userRole, int userType, String token, boolean isTokenValid) {
        this.userID = userID;
        this.password = password;
        this.userRole = userRole;
        this.userType = userType;
        this.token = token;
        this.isTokenValid = isTokenValid;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isTokenValid() {
        return isTokenValid;
    }

    public void setTokenValid(boolean tokenValid) {
        isTokenValid = tokenValid;
    }
}
