package session.servlet;

import jdk.vm.ci.meta.Local;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalTime;

@WebServlet("/helloSession")

public class HelloSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.getRequestDispatcher("WEB-INF/pages/helloSession.jsp").forward(req,resp);


        LocalTime sessionStartTime;
        HttpSession session = req.getSession();

        if(session.isNew()) {
            sessionStartTime = LocalTime.now();
            session.setAttribute("SessionStartTime",sessionStartTime);
        }

        else {
            sessionStartTime = (LocalTime)session.getAttribute("SessionStartTime");
        }
        resp.getWriter().println("this session started at: " + sessionStartTime);

    }
}
