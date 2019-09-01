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
 * 功能:登录过滤器
 * 创建时间: 2019-09-01 07:37 --游菜花
 */
@Component
@WebFilter(urlPatterns = {"/index.html"},filterName = "userFilter")
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            response.sendRedirect("login.html");
        }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}

