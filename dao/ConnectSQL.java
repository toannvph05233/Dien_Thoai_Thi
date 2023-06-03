package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSQL {
    public static Connection getGetConnect() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=dienthoai;";
        String username = "sa";
        String password = "12345678";
        return DriverManager.getConnection(url, username, password);
    }


}
