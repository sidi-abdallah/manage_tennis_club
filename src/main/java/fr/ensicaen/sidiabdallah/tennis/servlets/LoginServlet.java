package fr.ensicaen.sidiabdallah.tennis.servlets;


import fr.ensicaen.sidiabdallah.tennis.appli.DataBase;
import fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        RequestDispatcher dispatcher;
        List<AdherentEntity> adherents = DataBase.getInstance().getAdherentEntities();
        for (AdherentEntity adherent: adherents) {
            if(adherent.getEmail().equals(email) && adherent.getPassword().equals(password)) {
                // Create a session if it doesn't exit yet
                HttpSession session = request.getSession(true);
                session.setAttribute("adherent", adherent);
                dispatcher = request.getRequestDispatcher("./Menu.jsp");
                dispatcher.forward(request, response);
            }
            else {
                dispatcher = request.getRequestDispatcher("./Login.html");
                dispatcher.forward(request, response);
            }

        }

    }
}
