<%--
  Created by IntelliJ IDEA.
  User: hyo_0
  Date: 2024-07-07
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% // Controller
    int num = 0;
    String  num_ = request.getParameter("n");

    if(num_ != null && !num_.equals(""))
        num = Integer.parseInt(num_);

    String result; // Model

    if(num%2 != 0)
        result = "홀수";

    else
        result = "짝수";

%>
<!-- ------------------------------------------------ -->
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=result %>입니다.
</body>
</html>
