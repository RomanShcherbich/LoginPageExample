import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.sql.*;

public class sqlTest {

    @SneakyThrows
    public void sqlTest() {
        String nameValue = "sqlTestNamrterte";
        String passValue = "fsrtetrd";
        String url = "jdbc:mysql://localhost/servletapi";
        String username = "root";
        String password = "MySQL";
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "INSERT INTO `servletapi`.`users` (`name`, `password`) " +
                     "VALUES (?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nameValue);
        statement.setString(2, passValue);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }


}
