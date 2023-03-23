<%--
  Created by IntelliJ IDEA.
  User: sidi-abdallah
  Date: 06/03/2023
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
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

<%@ page import="fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity" %> <%-- Importez la classe Person depuis le package "com.example.model" --%>
<%@ page import="java.io.PrintWriter" %>
<% AdherentEntity adherent = (AdherentEntity) request.getSession().getAttribute("adherent"); %>
<div class="menu-content">
    <h1> Vous êtes <%=adherent.getNom() + " "%> <%=adherent.getPrenom()%> </h1>

    <ul>
        <li> <a href = "actionServlet?action=A">Consultation de votre dossier adhérent </a> </li>
        <li> <a href = "actionServlet?action=I"> Inscription à un tournoi</a> </li>
    </ul>
</div>

</body>
</html>
