package database;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connect {
    public Connection connection;

    @SneakyThrows
    public Connect() {
        Class.forName("com.mysql.cj.jdbc.Driver");
        FileInputStream fileInputStream = new FileInputStream("connection.properties");
        Properties properties = new Properties ();
        properties.load(fileInputStream);
        String url = properties.getProperty("URL");
        String username = properties.getProperty("Uname");
        String password = properties.getProperty("password");
        this.connection = DriverManager.getConnection(url, username, password);
    }
}
