package pl.sda.javagdy2.servlets;

import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Klient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/klient/remove")
public class KlientRemoveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identyfilkator = req.getParameter("identToRemove");
        Long identyfikatorLong = Long.parseLong(identyfilkator);

        EntityDao dao = new EntityDao();
        Klient klient = dao.getById(Klient.class, identyfikatorLong);
        dao.delete(klient);
        resp.sendRedirect("/klient/list");
    }
}
