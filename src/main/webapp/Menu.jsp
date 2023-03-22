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
</head>
<body>
<%@ page import="fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity" %> <%-- Importez la classe Person depuis le package "com.example.model" --%>
<%@ page import="java.io.PrintWriter" %>
<% AdherentEntity adherent = (AdherentEntity) request.getSession().getAttribute("adherent"); %>
<h3> Vous étes <%=adherent.getNom() + " "%> <%=adherent.getPrenom()%> </h3>

<ul>
    <li> <a href = "actionServlet?action=A">Consultation de votre dossier adhérent</a> </li>
    <li> <a href = "actionServlet?action=I">  Inscription à un tournoi</a> </li>
</ul>

</body>
</html>
