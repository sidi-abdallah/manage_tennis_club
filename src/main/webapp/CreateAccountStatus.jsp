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
    <link href = "stylesheet.css" rel = "stylesheet">
</head>
<body>
<header>
    <table>
        <tr>
            <td>
                <img src="./images/ensi_logo.png">
            </td>
            <td>
                <p>ENSICAEN Tennis club<br>6 Avenue  du Marechal Juin<br>14050 Caen Cedex<br>Tél : 02.51.45.27.89</p>
            </td>
        </tr>
    </table>
</header>

<%boolean isInserted = (boolean) request.getAttribute("isInserted");%>
<div class="tournois-status">
    <h2><%if(!isInserted) {
    %> Vous avez déja un compte
        <%} else {
        %> Votre compte a été créeé avec succes
    </h2>
    <%}%>
</div>
<a href = "Login.html" id = "back"> <= retour à la page de login </a>
</body>
</html>
