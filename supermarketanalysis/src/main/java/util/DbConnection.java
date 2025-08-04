package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
        public static Connection getConnection() throws SQLException {
            String url=Property.get("db.url");
            String user=Property.get("db.user");
            String password=Property.get("db.password");
            return DriverManager.getConnection(url,user,password);
        }
    }

