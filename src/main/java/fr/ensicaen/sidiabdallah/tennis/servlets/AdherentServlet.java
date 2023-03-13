package fr.ensicaen.sidiabdallah.tennis.servlets;

import javax.persistence.Query;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "adherentServlet", value = "/adherentServlet")
public class AdherentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        Query query = createQuery("FROM TournoiEntity t, InscriptionEntity i, AdherentEntity a " +
//                "WHERE t.codeTournoi = i.codeTournoi AND i.numero_adherent = a.numero_adherent AND" +
//                " a.email = email");

        //execution de la requete
        response.sendRedirect("http://localhost:8080/tennis/adherent.jsp");


    }
}
