package fr.ensicaen.sidiabdallah.tennis.servlets;

import fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.InscriptionEntity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.util.List;

@WebServlet(name = "actionServlet", urlPatterns = "/actionServlet")
public class ActionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String action = request.getParameter("action");
        RequestDispatcher dispatcher;

        //response.setContentType("text/html");
//        // Récupération de la session associée à la requête
        HttpSession session = request.getSession(false);

        AdherentEntity adh;

        if (session != null /*&& adh != null && session.getAttribute("email").equals(email)*/) {
            adh = (AdherentEntity)session.getAttribute("adherent");
            if(action.equals("A")) {
                dispatcher = request.getRequestDispatcher("./adherentServlet");
                dispatcher.forward(request, response);
            }
            else if(action.equals("I")) {
                dispatcher = request.getRequestDispatcher("./inscriptionServlet");
                dispatcher.forward(request, response);
            }
            else {

                dispatcher = request.getRequestDispatcher("./Menu.jsp");
                dispatcher.forward(request, response);
            }

        } else {
            if(action.equals("L")) {
                dispatcher = request.getRequestDispatcher("./loginServlet");
                dispatcher.forward(request, response);
            }
            else {

                dispatcher = request.getRequestDispatcher("./Login.html");
                dispatcher.forward(request, response);
            }

        }


    }
}
