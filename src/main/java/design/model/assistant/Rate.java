package design.model.assistant;

public class Rate {
    private int rateID;
    private String rateAssistantID;
    private String rateSelf;
    private String rateTeacher;
    private boolean isTeacherRated;
    private int rateResult;

    public int getRateID() {
        return rateID;
    }

    public void setRateID(int rateID) {
        this.rateID = rateID;
    }

    public String getRateAssistantID() {
        return rateAssistantID;
    }

    public void setRateAssistantID(String rateAssistantID) {
        this.rateAssistantID = rateAssistantID;
    }

    public String getRateSelf() {
        return rateSelf;
    }

    public void setRateSelf(String rateSelf) {
        this.rateSelf = rateSelf;
    }

    public String getRateTeacher() {
        return rateTeacher;
    }

    public void setRateTeacher(String rateTeacher) {
        this.rateTeacher = rateTeacher;
    }

    public boolean isTeacherRated() {
        return isTeacherRated;
    }

    public void setTeacherRated(boolean teacherRated) {
        isTeacherRated = teacherRated;
    }

    public int getRateResult() {
        return rateResult;
    }

    public void setRateResult(int rateResult) {
        this.rateResult = rateResult;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rateSelf='" + rateSelf + '\'' +
                ", rateTeacher='" + rateTeacher + '\'' +
                '}';
    }
}
