package design.DAO.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import design.DAO.AbstractDAO;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DAO implements AbstractDAO {
    @Override
    public Connection getConnection() {
        String dsn = "jdbc:sqlserver://azhks.database.windows.net:1433;database=study;user=chisato@azhks;password=Takina0923;encrypt=true;trustServerCertificate=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dsn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用Druid连接池
     *
     * @return 连接池
     * 未解决：动态管理连接，is流的关流问题
     */
    public DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            //1. 创建Properties对象
            Properties properties = new Properties();
            //2. 将配置文件转换成字节输入流
            InputStream is = DAO.class.getClassLoader().getResourceAsStream("druid.properties");
            //3. 使用properties对象加载is
            properties.load(is);
            //druid底层是使用的工厂设计模式，去加载配置文件，创建DruidDataSource对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    /**
     * 获取Druid数据库连接
     *
     * @return 数据库连接
     */
    public Connection getDruidConnection() {
        Connection conn = null;
        try {
            conn = getDataSource().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean closeAll(Connection conn, PreparedStatement stmt, ResultSet resSet) {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
            if (resSet != null) resSet.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
