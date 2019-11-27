package session.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalTime;


@WebServlet("/session")
public class HelloSessionControllerEL extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalTime sessionStartTime;
        HttpSession session = req.getSession();

        if(session.getAttribute("sessionStartTime") == null);
        sessionStartTime = LocalTime.now();
        session.setAttribute("sessionStartTime",sessionStartTime);

        req.getRequestDispatcher("WEB-INF/pages/helloSession.jsp").forward(req,resp);
    }




}
