<%@ page import="org.hibernate.boot.model.relational.Database" %>
<%@ page import="fr.ensicaen.sidiabdallah.tennis.appli.DataBase" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.ensicaen.sidiabdallah.tennis.entities.InscriptionEntity" %><%--
  Created by IntelliJ IDEA.
  User: sidi-abdallah
  Date: 27/02/2023
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action = "servlet" method = "post">
    <label for="email">e-mail adresse:</label><br>
    <input type="email" id="email" name="email"><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password"><br>
    <input type="submit" value="Connect">
</form>
    <% DataBase base = new DataBase();
        ArrayList<InscriptionEntity> list = base.getInsecriptionEntity();
        for(InscriptionEntity entity: list) {
            System.out.println(entity.getCodeTournoi() + "<br>");
        }


    %>
</body>
</html>
