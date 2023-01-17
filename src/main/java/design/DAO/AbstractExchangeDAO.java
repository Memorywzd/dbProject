package design.DAO;

import design.model.exchange.Exchange;

import java.util.List;

public interface AbstractExchangeDAO {

    List<String> getAcademicExchangeList();

    boolean addExchange(Exchange newExchange);

    boolean applyAcademicExchangeStatistics(String exchangeID, String studentID);

    boolean updateExchangeMentorValid(String exchangeID, boolean isMentorValid);

    boolean updateExchangeLeaderValid(String exchangeID, boolean isLeaderValid);
}
