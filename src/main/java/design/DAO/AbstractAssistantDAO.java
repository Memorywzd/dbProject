package design.DAO;

import design.model.assistant.Assistant;
import design.model.assistant.Rate;

import java.util.List;

public interface AbstractAssistantDAO {

    boolean addVolunteer(Assistant newAssistantVolunteer);

    boolean addAssistantRate(Rate applyRate);

    List<String> getVolunteerListByCourseID(String courseID);

    boolean addAssistantByVolunteerID(String assistantID);

    List<Assistant> getAssistantsByAssistantTeacherID(String assistantTeacherID);

    List<String> getRateListByTeacherID(String courseID);

    boolean updateAssistantRate(String rateID, String newRate);
}
