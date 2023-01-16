package design.DAO;

import design.model.user.Subject;

import java.util.List;

public interface AbstractSubjectDAO {
    List<String> getSubjectList();
    boolean addSubject(Subject newSubject);
}
