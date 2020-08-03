package service;

import database.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginService {
    public static String searchUserAndWriteResult(String userName, String userPassword) throws SQLException {
        Connect connection = new Connect();
        Statement statement = connection.connection.createStatement();


        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE name="
                + userName +
                " AND password=" + userPassword);

        if(!resultSet.first()) {
            connection.connection.close();
            return "This user not found!";
        }
        else {
            resultSet.next();
            connection.connection.close();
            return resultSet.getString(1) + " - Name\n" + resultSet.getString(1) + " - Password";
        }
    }
}
