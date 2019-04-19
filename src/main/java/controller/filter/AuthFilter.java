package controller.filter;

import model.entity.User;
import model.entity.enums.Role;
import org.jetbrains.annotations.Nullable;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {

    private Map<Role, List<String>> allowedUri = new HashMap<>();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        allowedUri.put(Role.ADMIN, Arrays.asList(
                "logout","statistics","calculator")
        );
        allowedUri.put(Role.USER, Arrays.asList(
                "logout","statistics","calculator", "add")
        );
        // null represents not authenticated user(just a visitor)
        allowedUri.put(null, Arrays.asList(
                "signIn", "signUp")
        );
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Role role = getRole(httpRequest);
        String currentUri = getUri(httpRequest);
        if (allowedUri.get(role).contains(currentUri)) {
            chain.doFilter(request, response);
        } else if (role == null) {
            ((HttpServletResponse) response).sendRedirect("/signIn.jsp");
        } else {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @Nullable
    private Role getRole(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (nonNull(session)) {
            User user = (User) session.getAttribute("user");
            if (nonNull(user)) {
                return user.getRole();
            }
        }
        return null;
    }

    private String getUri(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return requestURI.replaceAll("/app/", "");
    }

    @Override
    public void destroy() {

    }
}
