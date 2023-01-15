package design.DAO;

import design.model.LoginStatus;

public interface AbstractAppDAO {

    boolean addLoginStatus(LoginStatus newLoginStatus);

    String login(String username, String password, int role);

    boolean auth(String token, int role);

}
