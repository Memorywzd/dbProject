package design.model.assistant;

public class Assistant {
    private String assistantID;         //助教工号
    private String assistantStudentID;  //助教学号
    private String assistantTeacherID;  //助教所属教师工号
    private String assistantCourseID;   //助教所属课程ID
    private int assistantRateID;     //助教评价ID

    public String getAssistantID() {
        return assistantID;
    }

    public void setAssistantID(String assistantID) {
        this.assistantID = assistantID;
    }

    public String getAssistantStudentID() {
        return assistantStudentID;
    }

    public void setAssistantStudentID(String assistantStudentID) {
        this.assistantStudentID = assistantStudentID;
    }

    public String getAssistantTeacherID() {
        return assistantTeacherID;
    }

    public void setAssistantTeacherID(String assistantTeacherID) {
        this.assistantTeacherID = assistantTeacherID;
    }

    public String getAssistantCourseID() {
        return assistantCourseID;
    }

    public void setAssistantCourseID(String assistantCourseID) {
        this.assistantCourseID = assistantCourseID;
    }

    public int getAssistantRateID() {
        return assistantRateID;
    }

    public void setAssistantRateID(int assistantRateID) {
        this.assistantRateID = assistantRateID;
    }
}
