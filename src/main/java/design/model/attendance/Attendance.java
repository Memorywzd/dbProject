package design.model.attendance;

public class Attendance {
    private int attendanceID;
    private String attendanceProjectID;
    private String attendanceStudentID;
    private String attendanceTime;
    private String attendanceTask;
    private double attendanceFund;
    private boolean isMentorValid;      //交流项目导师有效
    private boolean isLeaderValid;      //交流学科负责人有效

    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public String getAttendanceProjectID() {
        return attendanceProjectID;
    }

    public void setAttendanceProjectID(String attendanceProjectID) {
        this.attendanceProjectID = attendanceProjectID;
    }

    public String getAttendanceStudentID() {
        return attendanceStudentID;
    }

    public void setAttendanceStudentID(String attendanceStudentID) {
        this.attendanceStudentID = attendanceStudentID;
    }

    public String getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(String attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public String getAttendanceTask() {
        return attendanceTask;
    }

    public void setAttendanceTask(String attendanceTask) {
        this.attendanceTask = attendanceTask;
    }

    public double getAttendanceFund() {
        return attendanceFund;
    }

    public void setAttendanceFund(double attendanceFund) {
        this.attendanceFund = attendanceFund;
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
}
