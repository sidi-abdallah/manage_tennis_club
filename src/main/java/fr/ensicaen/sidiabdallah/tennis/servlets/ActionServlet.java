package fr.ensicaen.sidiabdallah.tennis.servlets;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "actionServlet", urlPatterns = "/actionServlet")
public class ActionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String action = request.getParameter("action");
        RequestDispatcher dispatcher;
        // get the session and don't create it if it doesn't exist
        HttpSession session = request.getSession(false);

        if(action.equals("L")) {
            dispatcher = request.getRequestDispatcher("./loginServlet");
            dispatcher.forward(request, response);
        }

        if(action.equals("C")) {
            dispatcher = request.getRequestDispatcher("./newAccountServlet");
            dispatcher.forward(request, response);
        }

        if (session != null) {

            if(action.equals("A")) {
                dispatcher = request.getRequestDispatcher("adherentServlet");
                dispatcher.forward(request, response);
            }
            else if(action.equals("I")) {
                dispatcher = request.getRequestDispatcher("inscriptionServlet");
                dispatcher.forward(request, response);
            }
            else if(action.equals("D")) {
                dispatcher = request.getRequestDispatcher("desinscriptionServlet");
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
