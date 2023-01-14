package design.DAO;

import java.util.List;
import java.util.Map;

public interface AbstractAchievementDAO {

    boolean addAward(Map<String, String> params);

    boolean addPaper(Map<String, String> params);

    boolean addPatent(Map<String, String> params);

    boolean addPlatform(Map<String, String> params);

    boolean addReport(Map<String, String> params);

    boolean addStandard(Map<String, String> params);

    boolean addTextbook(Map<String, String> params);

    List<String> getAchievementList(String studentID);

    boolean updateAchievementValid(String type, String achievementID);
}