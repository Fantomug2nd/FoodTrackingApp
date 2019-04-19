package controller.command.user;

import controller.command.Command;
import model.entity.User;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignIn implements Command {
    private final UserService userService;

    public SignIn(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (userService.signIn(login, password)) {
            User user = userService.getUserByLogin(login).get();
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            System.out.println("Successfully login");
            response.sendRedirect("/");

        } else {

            System.out.println("Error: invalid login/password");
            String redirectLocation = String.format("/signIn.jsp?invalidCredentials=true&login=%s", login);
            response.sendRedirect(redirectLocation);
//            try {
//                request.getRequestDispatcher("/index.jsp").forward(request, response);
//            } catch (ServletException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
