package design.config;

import design.DAO.impl.DAOFactory;

public class Auth {
    public static boolean auth(String token, int role) {
        return DAOFactory.getDAO().getAppDAO().auth(token, role);
    }
}
