package servlets;

import lombok.SneakyThrows;
import service.LoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class LoginServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.getWriter().write(
                LoginService.searchUserAndWriteResult(request.getParameter("name"), request.getParameter("password"))
        );
    }
}


