package pl.sda.javagdy2.servlets;

import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Klient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/klient/add")
public class KlientAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/klient_formularz.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Klient klient = Klient.builder()
                .imie(request.getParameter("imie"))
                .nazwisko(request.getParameter("nazwisko"))
                .czyDajeNapiwki(request.getParameter("czyDajeNapiwki") != null)
                .iloscSamochodow(Integer.parseInt(request.getParameter("iloscSamochodow")))
                .ocenaKlienta(Integer.parseInt(request.getParameter("ocenaKlienta")))
                .build();

        EntityDao dao = new EntityDao();
        dao.saveOrUpdate(klient);

        response.sendRedirect("/klient/list");
    }
}
