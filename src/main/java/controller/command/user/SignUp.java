
package controller.command.user;

import controller.command.Command;
import model.entity.User;
import model.entity.enums.Lifestyle;
import model.entity.enums.Role;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUp implements Command {
    private final UserService userService;

    public SignUp(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setAge(Long.parseLong(request.getParameter("age")));
        user.setHeight(Long.parseLong(request.getParameter("height")));
        user.setWeight(Long.parseLong(request.getParameter("weight")));
        user.setLogin(request.getParameter("login"));
        user.setPass(request.getParameter("password"));
        user.setLifestyle(Lifestyle.valueOf(request.getParameter("lifestyle")));
        user.setIntake();
        // setting user status
        user.setRole(Role.USER);
        // save user to database
        userService.signUp(user);
        response.sendRedirect("/signIn.jsp");
    }
}

