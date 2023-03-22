package fr.ensicaen.sidiabdallah.tennis.servlets;

import fr.ensicaen.sidiabdallah.tennis.appli.DataBase;
import fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.TournoiEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "inscriptionServlet", value = "/inscriptionServlet")
public class InscriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdherentEntity adherent = (AdherentEntity)request.getSession().getAttribute("adherent");
        String codeTournoi = request.getParameter("codeTournoi");
        List<TournoiEntity> tournois = DataBase.getInstance().getTournoiEntities();
        RequestDispatcher dispatcher;
        request.setAttribute("tournois", tournois);
        if(codeTournoi == null) {
            dispatcher = request.getRequestDispatcher("./InscriptionTournois.jsp");
            dispatcher.forward(request, response);
        } else {
            TournoiEntity tournoi = DataBase.getInstance().getTournoi(Integer.parseInt(codeTournoi));
            request.setAttribute("tournoi", tournoi);
            boolean isAlreadyInscrit = DataBase.getInstance().insertIntoInscrption(adherent, Integer.parseInt(codeTournoi));
            request.setAttribute("isAlreadyInscrit", isAlreadyInscrit);
            dispatcher = request.getRequestDispatcher("./InscriptionStatus.jsp");
            dispatcher.forward(request, response);
        }



    }
}
