package fr.ensicaen.sidiabdallah.tennis.servlets;

import fr.ensicaen.sidiabdallah.tennis.appli.DataBase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "newAccountServlet", value = "/newAccountServlet")
public class newAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String adresse = request.getParameter("adresse");
        String password = request.getParameter("mdp1");
        boolean isInserted = DataBase.getInstance().insertAdherent(lastName, firstName, email, password, adresse, tel);
        request.setAttribute("isInserted" , isInserted);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("./CreateAccountStatus.jsp");
        dispatcher.forward(request, response);

    }
}
