package servlets;

import lombok.SneakyThrows;
import service.RegisterService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration_user")
public class RegistrationServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.getWriter().write(
                RegisterService.registerUser(request.getParameter("name"), request.getParameter("password"))
        );
    }

}
