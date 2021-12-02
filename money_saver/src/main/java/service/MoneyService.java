package service;

import dbworker.MoneyDbWorker;
import entity.Category;
import entity.Money;

import java.util.Date;
import java.util.List;

public class MoneyService {

    MoneyDbWorker moneyDbWorker = new MoneyDbWorker();

    public List<Money> getAllMoney(int userId){
        return moneyDbWorker.getAllMoneyById(userId);
    }

    public void addMoneyRecord(Category category, int sum, Date date, int userId){
        moneyDbWorker.addMoneyRecById(category, sum, date, userId);
    }

    public void addMoneyRecord(Money money, int userId){
        moneyDbWorker.addMoneyRecById(money, userId);
    }

    public void deleteMoneyRecord(int id){
        moneyDbWorker.deleteMoneyRecById(id);
    }
}
