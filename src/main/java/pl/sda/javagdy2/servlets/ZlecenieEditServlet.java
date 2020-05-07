package pl.sda.javagdy2.servlets;

import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Usluga;
import pl.sda.javagdy2.database.model.Zlecenie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/zlecenie/edit")
public class ZlecenieEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long zlecenieId = Long.parseLong(req.getParameter("ZlecenieId"));
            EntityDao dao = new EntityDao();
            Zlecenie zlecenie = dao.getById(Zlecenie.class, zlecenieId);
            req.setAttribute("zlecenieToEdit", zlecenie);
            req.setAttribute("klient_identifier", zlecenie.getKlient().getId());
            req.setAttribute("usluga", Usluga.values());
            req.getRequestDispatcher("/zlecenie_form.jsp").forward(req, resp);
        } catch (NumberFormatException | NullPointerException ne) {
            resp.sendRedirect("/klient/list");
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long editedZlecenieId = Long.parseLong(req.getParameter("editedZlecenie"));
            EntityDao dao = new EntityDao();
            Zlecenie zlecenie = dao.getById(Zlecenie.class, editedZlecenieId);
            Usluga usluga = Usluga.valueOf(req.getParameter("usluga"));
            double cena = Double.parseDouble(req.getParameter("cena"));
            zlecenie.setCena(cena);
            zlecenie.setUsluga(usluga);
            dao.saveOrUpdate(zlecenie);
            resp.sendRedirect("/klient/detail?identifier=" + zlecenie.getKlient().getId());
        } catch (NumberFormatException | NullPointerException ne) {
            resp.sendRedirect("/klient/list");
            return;
        }
    }


}
