package servlets;

import service.MoneyService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteMoneyServlet extends HttpServlet {

    private MoneyService moneyService = new MoneyService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        moneyService.deleteMoneyRecord(Integer.parseInt(req.getParameter("id")));

        resp.sendRedirect(req.getContextPath() + "/main_money");
    }
}
