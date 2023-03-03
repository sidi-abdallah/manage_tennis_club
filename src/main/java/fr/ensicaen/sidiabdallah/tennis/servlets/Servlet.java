package fr.ensicaen.sidiabdallah.tennis.servlets;

import fr.ensicaen.sidiabdallah.tennis.entities.InscriptionEntity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.util.List;

@WebServlet(name = "servlet", urlPatterns = "/servlet")
public class Servlet extends HttpServlet {
    private EntityManager _entityManager;
   // private EntityManagerFactory _emf;

    @Override
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TennisUnit");
        _entityManager = emf.createEntityManager();
        List<InscriptionEntity> entities = _entityManager.createQuery("SELECT e FROM InscriptionEntity e", InscriptionEntity.class).getResultList();
        for (InscriptionEntity entity : entities) {
            System.out.println(entity.getCodeTournoi());
        }
        /* try {
            Class.forName("org.postgresql.Driver");
            _connection =  DriverManager.getConnection("jdbc:postgresql://eensicaen.fr//clinique", "sidi-abdallah", "Mokhtar19012");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        //connection =

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setContentType("text/html");

       // Writer writer = response.getWriter();

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Récapitulatif des informations saisies</h1>");
        response.getWriter().println("<p>email : " + email + "</p>");
        response.getWriter().println("<p>password : " + password + "</p>");
       // response.getWriter().println("<p>Email : " + email + "</p>");
        response.getWriter().println("</body></html>");

    }
}
