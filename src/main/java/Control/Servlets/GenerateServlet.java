package Control.Servlets;

import Control.Generator.GeneratorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Jari on 23-Jan-17.
 */
@WebServlet(name = "hello", urlPatterns = "/newrule")
public class GenerateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GeneratorService gen = new GeneratorService();
        String code = req.getParameter("code");
        String ruleid = req.getParameter("ruleid");
        String action = req.getParameter("action");
        String respString = "";
        if (code != null) {System.out.println(code);}
        if (code.equals("2h8xx92") && ruleid != null) {
            try {
                try {
                    if (action.equals("INSERT") || action.equals("UPDATE")) {
                        gen.executeTemplate(Integer.parseInt(ruleid), action);
                    } else if (action.equals("DELETE")) {
                        gen.deleteBusinessRule(Integer.parseInt(ruleid));
                    }

                } catch (NumberFormatException e) { e.printStackTrace(); }
            }
            catch (SQLException e) { e.printStackTrace(); }
            resp.getWriter().write("SUCCESS");
        } else {
            resp.getWriter().write("FAILED");
        }
    }

}
