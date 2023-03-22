<%@ page import="fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity" %>
<%@ page import="fr.ensicaen.sidiabdallah.tennis.entities.TournoiEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: sidi-abdallah
  Date: 21/03/2023
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InscriptionStatus</title>
</head>
<body>
<% AdherentEntity adherent = (AdherentEntity) request.getSession().getAttribute("adherent");
    List<TournoiEntity> tournois = (List<TournoiEntity>) request.getAttribute("tournois");
    TournoiEntity tournoi = (TournoiEntity) request.getAttribute("tournoi");
    boolean isAlreadyInscrit = (boolean) request.getAttribute("isAlreadyInscrit");

%>

<h3> Vous étes <%=adherent.getNom() + " "%> <%=adherent.getPrenom()%> </h3>
<h2><%if(isAlreadyInscrit) {
    %> Vous êtes déja inscrit au tournoi <%=tournoi.getNom()%>
    <%} else {
    %> Vous êtes maintenant inscrit au tournoi <%=tournoi.getNom()%> qui se déroulera à <%=tournoi.getLieu()%> le <%=tournoi.getDate()%>
</h2>
<%}%>

<p><a href = "Menu.jsp"> retour à la page Menu </a> </p>

</body>
</html>
