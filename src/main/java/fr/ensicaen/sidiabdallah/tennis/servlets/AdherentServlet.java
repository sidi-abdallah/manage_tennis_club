package fr.ensicaen.sidiabdallah.tennis.servlets;

import fr.ensicaen.sidiabdallah.tennis.appli.DataBase;
import fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.TournoiEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "adherentServlet", value = "/adherentServlet")
public class AdherentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdherentEntity adherent = (AdherentEntity)request.getSession().getAttribute("adherent");
        List<TournoiEntity> tournois = DataBase.getInstance().getTournois(adherent);
       // List<InscriptionEntity> tournois = new ArrayList<>(adherent.getInscriptions());
        request.setAttribute("tournois", tournois); // ajouter l'attribut "tournois" à la requête
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("./Adherent.jsp");
        dispatcher.forward(request, response);


    }
}
