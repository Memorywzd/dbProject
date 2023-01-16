package design.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import static design.config.Auth.auth;

public class StudentRequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String token = request.getParameter("token");
        if (token == null || !auth(token, 0)) {
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
