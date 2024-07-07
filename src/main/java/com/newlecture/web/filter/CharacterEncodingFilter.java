package com.newlecture.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {


        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
        System.out.println("before filter");
        filterChain.doFilter(request, response); // 다음 실행을 어디로 가게 할 것인가
        System.out.println("hello filter");
    }
}
