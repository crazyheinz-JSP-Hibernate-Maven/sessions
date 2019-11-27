package session.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/CalculatorEL")
public class CalculatorServletEL extends HttpServlet {
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

        session.setAttribute("result",result);
        session.setAttribute("message",message);

        req.getRequestDispatcher("WEB-INF/pages/CalculatorPage.jsp").forward(req,resp);
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




