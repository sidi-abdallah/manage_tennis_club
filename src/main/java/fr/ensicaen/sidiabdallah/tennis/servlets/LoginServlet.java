package fr.ensicaen.sidiabdallah.tennis.servlets;


import fr.ensicaen.sidiabdallah.tennis.appli.DataBase;
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

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
  //  private EntityManager _entityManager;

    @Override
    public void init() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TennisUnit");
//        _entityManager = emf.createEntityManager();


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        RequestDispatcher dispatcher;
        //List<AdherentEntity> entities = _entityManager.createQuery("SELECT e FROM AdherentEntity e", AdherentEntity.class).getResultList();
        List<AdherentEntity> adherents = DataBase.getAdherentEntity();
        for (AdherentEntity adherent: adherents) {
            //System.out.println(entity.getPassword());
            if(adherent.getEmail().equals(email) && adherent.getPassword().equals(password)) {
                // Création de la session utilisateur
                HttpSession session = request.getSession();
                session.setAttribute("adherent", adherent);
               // session.setAttribute("adherent", adherent);
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
