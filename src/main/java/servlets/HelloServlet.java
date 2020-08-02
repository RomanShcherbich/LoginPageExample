package servlets;

import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String url = "jdbc:mysql://localhost/servletapi";
        String username = "root";
        String password = "MySQL";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();


        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE name="
                                                        + request.getParameter("name") +
                                                        " AND password=" + request.getParameter("password"));

        if(!resultSet.first()) {
            System.out.println("Nothing");
        }
        else {
            resultSet.next();
            System.out.println(resultSet.getString(1) + " - Name\n" + resultSet.getString(1) + " - Password");
        }

        connection.close();
    }

}


