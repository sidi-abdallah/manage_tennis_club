package fr.ensicaen.sidiabdallah.tennis.servlets;

import fr.ensicaen.sidiabdallah.tennis.appli.DataBase;
import fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "desinscriptionServlet", value = "/desinscriptionServlet")
public class DesinscriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        String codeTournoi = request.getParameter("codeTournoi");
        AdherentEntity adherent = (AdherentEntity)request.getSession().getAttribute("adherent");
        DataBase.getInstance().removeFromInscription(adherent.getNumeroAdherent(), Integer.parseInt(codeTournoi));
        rd = request.getRequestDispatcher("/adherentServlet");
        rd.forward(request, response);
    }
}
