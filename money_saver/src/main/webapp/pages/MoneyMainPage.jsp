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
                out.println("<li>" + m +
                        "<form method=\"post\" action=\"/deleteMoney\">\n" +
                        "    <input type=\"hidden\" name=\"id\" value=\"" + m.getId()+ "\" ><br />\n" +
                        "    <button type=\"submit\">Delete</button>\n" +
                        "</form> " +
                        "</li>");
            }
        } else {
            out.print("No money");
        }
    %>
</ul>

<form method="post">
    <label>Category:
        <input type="text" name="category"><br />
    </label>
    <label>Value:
        <input type="number" name="number"><br />
    </label>
    <label>Date:
        <input type="date" name="date"><br />
    </label>
    <button type="submit">Add</button>
</form>

</body>
</html>
