package pl.sda.javagdy2.servlets;

import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Klient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/klient/list")
public class KlientListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityDao dao = new EntityDao();
        List<Klient> lista = dao.list(Klient.class);
        req.setAttribute("klients", lista);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/klient_list.jsp");
        dispatcher.forward(req,resp);
    }
}

