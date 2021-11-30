<%@ page import="java.util.List" %>
<%@ page import="entity.Money" %><%--
  Created by IntelliJ IDEA.
  User: naicinfa
  Date: 30.11.2021
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All money</title>
</head>
<body>
<ul>
    <%
        List<Money> money = (List<Money>) request.getAttribute("allMoney");

        if (money != null && !money.isEmpty()) {
            for (Money m : money) {
                out.println("<li>" + m + "</li>");
            }
        }
    %>
</ul>

</body>
</html>
