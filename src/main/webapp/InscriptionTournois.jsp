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
    <title>Title</title>
</head>
<body>
<% AdherentEntity adherent = (AdherentEntity) request.getSession().getAttribute("adherent");
    List<TournoiEntity> tournois = (List<TournoiEntity>) request.getAttribute("tournois");
%>

<h3> Vous étes <%=adherent.getNom() + " "%> <%=adherent.getPrenom()%> </h3>
<table>
    <% for(TournoiEntity tournoi: tournois) { %>
    <tr><td> <%= tournoi.getCodeTournoi()%></td>
        <td><%= tournoi.getNom()%></td>
        <td><%= tournoi.getDate() %></td>
        <td><%= tournoi.getLieu() %></td>
        <td> <a href = "actionServlet?action=I&codeTournoi="+<%= tournoi.getCodeTournoi()%>>  Inscription</a></td>
    </tr>
    <% } %>
</table>

</body>
</html>
