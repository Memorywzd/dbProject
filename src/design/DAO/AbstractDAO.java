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

    /**
     * 使用Druid连接池
     *
     * @return 连接池
     * 未解决：动态管理连接，is流的关流问题
     */
    DataSource getDataSource();

    /**
     * 获取Druid数据库连接
     *
     * @return 数据库连接
     */
    Connection getDruidConnection();


}
