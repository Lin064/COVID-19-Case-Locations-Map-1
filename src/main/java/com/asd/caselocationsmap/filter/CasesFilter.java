package com.asd.caselocationsmap.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CasesFilter", urlPatterns = "/create-cases.html")
public class CasesFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        // Check the identity and permissions of the current user
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin == null || admin == false)
        {
            String redirectPath = req.getContextPath() + "/403.html" ;
            resp.sendRedirect(redirectPath);
            return;
        }

        // Allow request
        chain.doFilter(request, response);
    }
}
