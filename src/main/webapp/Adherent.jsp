<%@ page import="fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity" %><%--
  Created by IntelliJ IDEA.
  User: sidi-abdallah
  Date: 09/03/2023
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <titl>Adherent page</titl></title>
</head>
<body>
<% AdherentEntity adh = (AdherentEntity) request.getSession().getAttribute("adherent");%>
    <h2> Informations adhérent </h2>
    <table>
        <tr>
            <td> Numero </td>
            <td> <%=adh.getNumeroAdherent ()%></td>
        </tr>
        <tr>
        <td> Nom </td>
            <td> <%=adh.getNom()%></td>
        </tr>
        <tr>
            <td> Prénom </td>
            <td> <%=adh.getPrenom()%></td>
        </tr>
        <tr>
            <td> Adresse </td>
            <td> <%=adh.getAdresse()%></td>
        </tr>
        <tr>
            <td> Télephone </td>
            <td> <%=adh.getTelephone()%></td>
        </tr>
        <tr>
            <td> email </td>
            <td> <%=adh.getEmail()%></td>
        </tr>

    </table>
    <h2>Tournois auxquels vous êtes inscrits</h2>
<table>
    <th>
    <td> Code</td>
    <td> Nom</td>
    <td> Date</td>
    <td> Lieu</td>
    <td> </td>
    </th>
    <tr></tr>

</table>
</body>
</html>
