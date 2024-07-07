<%--
  Created by IntelliJ IDEA.
  User: hyo_0
  Date: 2024-07-07
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- ------------------------------------------------ -->
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=request.getAttribute("result")%>입니다.
    ${result}<br >
    ${names[0]}<br >
    ${notice.id}<br >
    ${param.n}<br >
    ${param.n > 3}<br >
</body>
</html>
