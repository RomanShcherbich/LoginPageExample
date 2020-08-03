package service;

import database.Connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterService {
    public static String registerUser(String userName, String userPassword) throws SQLException {
        Connect connection = new Connect();

        String sql = "INSERT INTO `servletapi`.`users` (`name`, `password`) " +
                "VALUES (?,?);";
        PreparedStatement statement = connection.connection.prepareStatement(sql);
        statement.setString(1, userName);
        statement.setString(2, userPassword);
        statement.executeUpdate();
        statement.close();
        connection.connection.close();

        return "User success added";
    }
}
