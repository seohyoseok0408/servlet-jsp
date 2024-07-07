package com.newlecture.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/spag")
public class Spag extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = 0;
        String  num_ = request.getParameter("n");

        if(num_ != null && !num_.equals(""))
            num = Integer.parseInt(num_);

        String result; // Model

        if(num%2 != 0)
            result = "홀수";
        else
            result = "짝수";

        request.setAttribute("r", result);
        //redirect - 새로 요청시
        //foward  - 이어갈시
        RequestDispatcher dispatcher = request.getRequestDispatcher("spag.jsp");
        //dispatcher 로 포워딩 가능

        dispatcher.forward(request, response);
    }
}
