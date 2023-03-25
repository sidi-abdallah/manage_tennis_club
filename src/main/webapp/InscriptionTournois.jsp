<%@ page import="fr.ensicaen.sidiabdallah.tennis.servlets.AdherentServlet" %>
<%@ page import="fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity" %>
<%@ page import="fr.ensicaen.sidiabdallah.tennis.entities.InscriptionEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.ensicaen.sidiabdallah.tennis.entities.TournoiEntity" %><%--
  Created by IntelliJ IDEA.
  User: sidi-abdallah
  Date: 21/03/2023
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InscriptionTournois</title>
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

<% AdherentEntity adherent = (AdherentEntity) request.getSession().getAttribute("adherent");
    List<TournoiEntity> tournois = (List<TournoiEntity>) request.getAttribute("tournois");
%>

<div class="tournois-content">
    <h1> Vous êtes <%=adherent.getNom() + " "%> <%=adherent.getPrenom()%> </h1>
    <table>
        <% for(TournoiEntity tournoi: tournois) { %>
        <tr><td> <%= tournoi.getCodeTournoi()%></td>
            <td><%= tournoi.getNom()%></td>
            <td><%= tournoi.getDate() %></td>
            <td><%= tournoi.getLieu() %></td>
            <td> <a href = "actionServlet?action=I&codeTournoi=<%=tournoi.getCodeTournoi()%>" id="inscription-tournoi">  Inscription</a></td>
        </tr>
        <% } %>
    </table>
</div>

<a href = "Menu.jsp" id="back"> <== Revenir au menu principal</a>
</body>
</html>
