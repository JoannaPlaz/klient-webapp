package pl.sda.javagdy2.servlets;

import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Klient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/klient/detail")
public class KlientDetailServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identifierString = req.getParameter("identifier");
        if(identifierString == null || identifierString.isEmpty()){
            resp.sendRedirect("/klient/list");
            return;
        }

        Long identifier = Long.parseLong(identifierString);

        EntityDao dao = new EntityDao();
        Klient klient = dao.getById(Klient.class, identifier);
        if(klient == null){
            resp.sendRedirect("/klient/list");
            return;
        }
        req.setAttribute("klientDetails", klient);
        req.getRequestDispatcher("/klient_detail.jsp").forward(req,resp);
    }
}
