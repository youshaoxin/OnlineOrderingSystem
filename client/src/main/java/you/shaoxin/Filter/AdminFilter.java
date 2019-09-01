package you.shaoxin.Filter;

import org.springframework.stereotype.Component;
import you.shaoxin.domin.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 功能:
 * 创建时间: 2019-09-01 09:02 --游菜花
 */
@Component
@WebFilter(urlPatterns = {"/main.html"},filterName = "adminFilter")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        User admin = (User)session.getAttribute("admin");
        if (admin!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            response.sendRedirect("login.html");
        }
    }

    @Override
    public void destroy() {

    }
}
