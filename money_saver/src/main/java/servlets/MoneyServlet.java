package servlets;

import entity.Money;
import service.MoneyService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class MoneyServlet extends HttpServlet {

    MoneyService moneyService = new MoneyService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Money> allMoney = moneyService.getAllMoney(Integer.valueOf(1));

        request.setAttribute("allMoney", allMoney);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/MoneyMainPage.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Money money = new Money();
    }
}
