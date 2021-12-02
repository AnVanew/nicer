package servlets;

import entity.Category;
import entity.Money;
import service.MoneyService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Category category = Category.getByDescription(String.valueOf(request.getParameter("category")));
        int number = Integer.parseInt(request.getParameter("number"));
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Money money = new Money(category, number, date);
        moneyService.addMoneyRecord(money, 1);
        doGet(request, response);
    }
}
