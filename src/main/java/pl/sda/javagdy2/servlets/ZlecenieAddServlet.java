package pl.sda.javagdy2.servlets;

import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Klient;
import pl.sda.javagdy2.database.model.Usluga;
import pl.sda.javagdy2.database.model.Zlecenie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/zlecenie/add")
public class ZlecenieAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String klientId =  req.getParameter("klientId");
        if(klientId == null || klientId.isEmpty()){
            resp.sendRedirect("/klient/list");
            return;
        }
        req.setAttribute("klient_identifier", klientId);
        req.setAttribute("uslugi", Usluga.values());

        req.getRequestDispatcher("/zlecenie_form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cenaString = req.getParameter("cena");
        String uslugaString = req.getParameter("usluga");
        if (cenaString == null || uslugaString == null || cenaString.isEmpty() || uslugaString.isEmpty()) {
            resp.sendRedirect("/klient/list");
            return;
        }
        Usluga zlecenieUsluga = Usluga.valueOf(uslugaString);
        double zlecenieCena = Double.parseDouble(cenaString);
        Zlecenie zlecenie = new Zlecenie(zlecenieUsluga, zlecenieCena);
        String klientId = req.getParameter("klientZlecenia");
        if (klientId == null || klientId.isEmpty()) {
            resp.sendRedirect("/klient/list");
            return;
        }
        Long klientIdLong = Long.parseLong(klientId);
        EntityDao dao = new EntityDao();
        Klient klient = dao.getById(Klient.class, klientIdLong);
        zlecenie.setKlient(klient);
        dao.saveOrUpdate(zlecenie);
        resp.sendRedirect("/klient/detail?identifier=" + klientId);
    }
}
