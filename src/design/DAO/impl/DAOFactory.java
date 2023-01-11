package design.DAO.impl;

public class DAOFactory {
    private static final DAOFactory daoFactory;
    static {
        daoFactory = new DAOFactory();
    }

    private DAOFactory() {
    }

    public static DAOFactory getDAOInstance() {
        return daoFactory;
    }
}
