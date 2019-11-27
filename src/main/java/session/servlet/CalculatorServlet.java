package session.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Calculator")
public class CalculatorServlet extends HttpServlet {



    private final String RESULT = "CalculatorServlet.result";
    private final String NUMBER = "number";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        Object resultAttribute = session.getAttribute(RESULT);

        int result = 0;
        if (resultAttribute != null ) {
            result = (Integer) resultAttribute;
        }

        String message = "";
        Object messageAttribute = req.getAttribute("message");
        if (messageAttribute != null) {
            message = (String) messageAttribute;
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method='POST'>");
            out.println(message + "<br />");
            out.println("Result:" + result + "<br />");
            out.println("<input type='number' name='number' /><br />");
            out.println("<input type='submit' name='operation' value='+' />");
            out.println("<input type='submit' name='operation' value='-' />");
            out.println("<input type='submit' name='operation' value='x' />");
            out.println("<input type='submit' name='operation' value='/' />");
            out.println("<input type='submit' name='operation' value='CE' />");

            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object resultAttribute = session.getAttribute(RESULT);
        int result = 0;
        String message = "";

        if (resultAttribute != null ) {
            result = (Integer) resultAttribute;
        }

        String operation = req.getParameter("operation");
        String numberParameter = req.getParameter(NUMBER);

        switch (operation) {
            case "+" :
                try {
                    result += Integer.parseInt(numberParameter);
                } catch (NumberFormatException ex) {
                    message = "Invalid number";
                }
                break;
            case "-" :
                try {
                    result -= Integer.parseInt(numberParameter);
                } catch (NumberFormatException ex) {
                    message = "Invalid number";
                }
                break;
            case "x" :
                try {
                    result *= Integer.parseInt(numberParameter);
                } catch (NumberFormatException ex) {
                    message = "Invalid number";
                }
                break;
            case "/" :
                try {
                    result /= Integer.parseInt(numberParameter);
                } catch (NumberFormatException ex) {
                    message = "Invalid number";
                }
                break;

            case "CE" :
                try {
                    result = 0;
                } catch (NumberFormatException ex) {
                    message = "Invalid number";
                }
                break;




        }

        req.setAttribute("message",message);
        session.setAttribute(RESULT,result);
        doGet(req,resp);
    }
}



