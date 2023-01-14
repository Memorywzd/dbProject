package design.DAO;

import design.model.Exchange;

import java.util.List;

public interface AbstractExchangeDAO {

    List<String> getAcademicExchangeList();

    boolean addExchange(Exchange newExchange);

    boolean applyAcademicExchangeStatistics(String exchangeID);

    boolean updateExchangeValid(String exchangeID);
}
