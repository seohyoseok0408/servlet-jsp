package com.newlecture.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getServletContext();
        HttpSession session= req.getSession();
        Cookie[] cookies= req.getCookies();

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String v_ = req.getParameter("v");
        String op = req.getParameter("operator");

        int v = 0;

        if(!v_.equals("")) v = Integer.parseInt(v_);



        // 계산
        if(op.equals("=")){

//            int x = (Integer)application.getAttribute("value");
//            int x = (Integer)session.getAttribute("value");

            int x = 0;
            for(Cookie c : cookies)
                if(c.getName().equals("value")) {
                    x = Integer.parseInt(c.getValue());
                    break;
                }



            int y = v; // 지금 사용자가 전달한 value 값
//            String operator = (String)application.getAttribute("op");;
//            String operator = (String)session.getAttribute("op");;

            String operator = "";

            for(Cookie c : cookies)
                if(c.getName().equals("value")) {
                    operator = c.getValue();
                    break;
                }

            int result = 0;

            if(operator.equals("+")) // 버튼을 선택적으로 처리
                result = x + y;
            else
                result = x - y;

            resp.getWriter().println("result is "+ result);
        }else{ // 값을 저장
//            application.setAttribute("value", v);
//            application.setAttribute("op", op);

//            session.setAttribute("value", v);
//            session.setAttribute("op", op);

            Cookie valueCookie = new Cookie("value", String.valueOf(v));
            Cookie opCookie = new Cookie("op", op);

            valueCookie.setPath("/calc2");
            valueCookie.setMaxAge(24*60*60);
            opCookie.setPath("/calc2");
            resp.addCookie(valueCookie);
            resp.addCookie(opCookie);

            resp.sendRedirect("calc2.html");
        }
    }
}
