package design.DAO.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import design.DAO.AbstractDAO;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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

    @Override
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

    @Override
    public Connection getDruidConnection() {
        Connection conn = null;
        try {
            conn = getDataSource().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
