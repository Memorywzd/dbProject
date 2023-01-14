package design.DAO;

import javax.sql.DataSource;
import java.sql.Connection;

public interface AbstractDAO {
    /**
     * 获取数据库连接
     *
     * @return 数据库连接
     */
    Connection getConnection();

    /**
     * 关闭数据库连接
     *
     * @param conn 数据库连接
     */
    void closeConnection(Connection conn);
}
