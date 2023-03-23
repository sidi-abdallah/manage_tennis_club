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
    <link href="stylesheet.css" rel="stylesheet">
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
    TournoiEntity tournoi = (TournoiEntity) request.getAttribute("tournoi");
    boolean isAlreadyInscrit = (boolean) request.getAttribute("isAlreadyInscrit");

%>

<div class="tournois-status">
    <h1> Vous êtes <%=adherent.getNom() + " "%> <%=adherent.getPrenom()%> </h1>
    <h2><%if(isAlreadyInscrit) {
    %> Vous êtes déja inscrit au tournoi <%=tournoi.getNom()%>
        <%} else {
        %> Vous êtes maintenant inscrit au tournoi <%=tournoi.getNom()%> qui se déroulera à <%=tournoi.getLieu()%> le <%=tournoi.getDate()%>
    </h2>
    <%}%>
</div>
<a href = "Menu.jsp" id="back-to-menu"> retour à la page Menu </a>

</body>
</html>
