package servlets;

import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/")
public class RegistrationServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/servletapi";
        String username = "root";
        String password = "MySQL";
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "INSERT INTO `servletapi`.`users` (`name`, `password`) " +
                     "VALUES (?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, request.getParameter("name"));
        statement.setString(2, request.getParameter("password"));
        statement.executeUpdate();
        statement.close();
        connection.close();
        response.sendRedirect(getServletContext().getContextPath());
    }

}
