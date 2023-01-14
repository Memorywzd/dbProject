package design.DAO;

public interface AbstractAppDAO {
    int getVolunteerNumber();

    double getProjectFounding();

    int getAcademicExchange();

    boolean editVolunteerNumber();

    boolean editProjectFounding();

    boolean editAcademicExchange();
}
