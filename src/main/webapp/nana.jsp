<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: hyo_0
  Date: 2024-07-07
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
//    response.setCharacterEncoding("UTF-8");
//    response.setContentType("text/html; charset=UTF-8"); // 지시자를 통해 이미 처리함
//    PrintWriter out = response.getWriter(); // out이라는 내장 객체가 이미 존재
    String cnt_ = request.getParameter("cnt");

    int cnt = 100;

    if (cnt_ != null && !cnt_.equals(""))
        cnt = Integer.parseInt(cnt_);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% for(int i=0; i<cnt; i++) { %>
        안녕 Servlet!!<br />
    <%} %>


</body>
</html>
