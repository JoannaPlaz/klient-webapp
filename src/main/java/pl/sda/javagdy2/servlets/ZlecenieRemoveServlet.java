package pl.sda.javagdy2.servlets;

import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Zlecenie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/zlecenie/delete")
public class ZlecenieRemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identyfikator = req.getParameter("zlecenieId");
        if(identyfikator == null || identyfikator.isEmpty()){
            resp.sendRedirect("/klient/list");
            return;
        }
        Long identyfikatorLong = Long.parseLong(identyfikator);
        EntityDao dao = new EntityDao();
        Zlecenie zlecenie = dao.getById(Zlecenie.class, identyfikatorLong);
        if(zlecenie == null){
            resp.sendRedirect("/klient/list");
            return;
        }
        dao.delete(zlecenie);
        resp.sendRedirect("/klient/detail?identifier=" + zlecenie.getKlient().getId());
    }
}
