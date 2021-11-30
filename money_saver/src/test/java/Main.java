
import entity.Money;
import service.MoneyService;

import java.util.List;

import static dbworker.MoneyDbWorker.*;

public class Main {
    public static void main(String[] args) {
        MoneyService moneyService = new MoneyService();
        System.out.println(moneyService.getAllMoney(1));
    }
}
