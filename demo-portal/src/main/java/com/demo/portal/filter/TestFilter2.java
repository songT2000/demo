package com.demo.portal.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter2 implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------------TestFilter2----------------");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
