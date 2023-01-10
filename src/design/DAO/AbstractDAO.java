package design.DAO;

import java.sql.Connection;

public interface AbstractDAO {
    Connection getConnection();     //连接数据库
}
