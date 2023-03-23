<%--
  Created by IntelliJ IDEA.
  User: sidi-abdallah
  Date: 23/03/2023
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> create Account status</title></title>
</head>
<body>
<%boolean isInserted = (boolean) request.getAttribute("isInserted");%>

<h2><%if(!isInserted) {
%> Vous avez déja un compte%>
    <%} else {
    %> Votre compte a été créeé avec succes%>
</h2>
<%}%>
<p><a href = "Login.html"> retour à la page de login </a> </p>
</body>
</html>
