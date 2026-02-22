package Servlet;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import Model.User;
import Service.DataStorage;

@WebServlet("/Servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        for (User user : DataStorage.users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", email);
                response.sendRedirect(request.getContextPath() + "/products.jsp");
                return;
            }
        }
        request.setAttribute("error", "Invalid Email or Password");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}