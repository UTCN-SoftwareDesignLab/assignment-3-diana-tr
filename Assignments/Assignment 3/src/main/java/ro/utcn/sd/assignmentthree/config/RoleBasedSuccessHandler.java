package ro.utcn.sd.assignmentthree.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RoleBasedSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        boolean admin = false;
        boolean doctor = false;
        boolean secretary = false;


        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if ("ROLE_ADMIN".equals(authority.getAuthority())) {
                admin = true;
            }
            if ("ROLE_DOCTOR".equals(authority.getAuthority())) {
                doctor = true;
            }
            if ("ROLE_SECRETARY".equals(authority.getAuthority())) {
                secretary = true;
            }
        }

        if (admin) {
            System.out.println("admin logged");
            httpServletResponse.sendRedirect("/admin");
        }
        if (doctor) {
            httpServletResponse.sendRedirect("/doctor");
        }
        if (secretary) {
            httpServletResponse.sendRedirect("/secretary");
        }
    }
}
