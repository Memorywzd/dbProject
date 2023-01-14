package design.model;

public class App {
    private String currentUserID;       //当前登录用户ID
    private int currentUserRole;        //当前登录用户角色 0:学生 1:教师 2:管理员
    private int currentUserType;        //当前登录用户类型 不同用户角色值不同含义
    private String userToken;           //用户token
    private boolean isTokenValid;       //token是否有效

    //系统要求相关
    private int maxVolunteerNum;        //最大志愿数
    private double minProjectFounding;  //最小项目经费
    private int minExchangeNum;         //最小交换次数

    public App() {
        this.currentUserID = null;
        this.currentUserRole = -1;
        this.currentUserType = -1;
        this.userToken = null;
        this.isTokenValid = false;
    }

    public boolean setLoginStatus(String currentUserID, int currentUserRole, int currentUserType, String userToken) {
        this.currentUserID = currentUserID;
        this.currentUserRole = currentUserRole;
        this.currentUserType = currentUserType;
        this.userToken = userToken;
        if (this.currentUserID != null &&
                this.currentUserRole != -1 &&
                this.currentUserType != -1 &&
                this.userToken != null) {
            isTokenValid = true;
            return true;
        } else {
            isTokenValid = false;
            return false;
        }
    }

    //getter for first 4 fields
    public String getCurrentUserID() {
        return currentUserID;
    }

    public int getCurrentUserRole() {
        return currentUserRole;
    }

    public int getCurrentUserType() {
        return currentUserType;
    }

    public String getUserToken() {
        return userToken;
    }

    //getter and setter for requirement fields

    public int getMaxVolunteerNum() {
        return maxVolunteerNum;
    }

    public void setMaxVolunteerNum(int maxVolunteerNum) {
        this.maxVolunteerNum = maxVolunteerNum;
    }

    public double getMinProjectFounding() {
        return minProjectFounding;
    }

    public void setMinProjectFounding(double minProjectFounding) {
        this.minProjectFounding = minProjectFounding;
    }

    public int getMinExchangeNum() {
        return minExchangeNum;
    }

    public void setMinExchangeNum(int minExchangeNum) {
        this.minExchangeNum = minExchangeNum;
    }
}
