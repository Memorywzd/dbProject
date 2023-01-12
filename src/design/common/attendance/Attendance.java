package design.common.attendance;

import java.sql.Date;

public class Attendance {
    private int attendanceID;
    private int attendanceType;
    private String attendanceName;
    private Date attendanceTime ;
    private String attendanceTask;
    private String attendanceBudget;

    public int getattendanceID() {
        return attendanceID;
    }

    public void setattendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public int getattendanceType() {
        return attendanceType;
    }

    public void setrateAssistantID(int attendanceType) {this.attendanceType= attendanceType;}

    public String getattendanceName() {
        return attendanceName;
    }

    public void setattendanceName(String attendanceName) {
        this.attendanceName = attendanceName;
    }

    public Date getattendanceTime() {
        return attendanceTime;
    }

    public void setattendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public String getattendanceTask() {
        return attendanceTask;
    }

    public void setattendanceTask(String attendanceTask) {
        this.attendanceTask = attendanceTask;
    }
    public String getAttendanceBudget() {return attendanceBudget;}
    public void setAttendanceBudget(String attendanceBudget) {this.attendanceBudget = attendanceBudget;}
}
