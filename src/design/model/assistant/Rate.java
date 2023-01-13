package design.model.assistant;

public class Rate {
    private int rateID;
    private String rateAssistantID;
    private String rateSelf;
    private String rateTeacher;
    private int rateResult;

    public int getrateID() {
        return rateID;
    }

    public void setrateID(int rateID) {
        this.rateID = rateID;
    }

    public String getrateAssistantID() {
        return rateAssistantID;
    }

    public void setrateAssistantID(String rateAssistantID) {
        this.rateAssistantID = rateAssistantID;
    }

    public String getrateSelf() {
        return rateSelf;
    }

    public void setrateSelf(String rateSelf) {
        this.rateSelf = rateSelf;
    }

    public String getrateTeacher() {
        return rateTeacher;
    }

    public void setrateTeacher(String rateTeacher) {
        this.rateTeacher = rateTeacher;
    }

    public int getrateResult() {
        return rateResult;
    }

    public void setrateResult(int rateResult) {
        this.rateResult = rateResult;
    }

}
