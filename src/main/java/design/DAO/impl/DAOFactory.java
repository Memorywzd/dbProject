package design.DAO.impl;

import design.DAO.*;
import design.controller.AbstractStudentController;

public class DAOFactory {
    private static final DAOFactory daoFactory;

    static {
        daoFactory = new DAOFactory();
    }

    private DAOFactory() {
    }

    public static DAOFactory getDAO() {
        return daoFactory;
    }

    public AbstractAssistantDAO getAssistantDAO() {
        return new AssistantDAO();
    }

    public AbstractCourseDAO getCourseDAO() {
        return new CourseDAO();
    }

    public AbstractExchangeDAO getExchangeDAO() {
        return new ExchangeDAO();
    }

    public AbstractAttendanceDAO getAttendanceDAO() {
        return new AttendanceDAO();
    }

    public AbstractAchievementDAO getAchievementDAO() {
        return new AchievementDAO();
    }

    public AbstractUserDAO getUserDAO() {
        return new UserDAO();
    }

    public AbstractSubjectDAO getSubjectDAO() {
        return new SubjectDAO();
    }
}
