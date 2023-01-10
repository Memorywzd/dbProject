package design.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
