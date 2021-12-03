package dbworker;

import entity.Category;
import entity.Money;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static utill.Queries.*;

public class MoneyDbWorker extends DbWorker{
    public List<Money> getAllMoneyById(int id){
       return executeQueryGet(SELECT_ALL_MONEY_BY_ID_QUERY ,
                (preparedStatement) -> {preparedStatement.setInt(1,id);},
                (resultSet) -> {
                    List<Money> money = new ArrayList<>();
                    do {
                       money.add(moneyEntityFromResultSet(resultSet));
                    } while (resultSet.next());
                    return money;
                    
                });
    }

    public int addMoneyRecById(Category category, int number, Date date, int user_id){
        return executeQueryUpdate(INSERT_MONEY_QUERY,
                (preparedStatement) ->{
                    preparedStatement.setString(1, category.getDescription());
                    preparedStatement.setInt(2, number);
                    preparedStatement.setDate(3, new java.sql.Date(date.getTime()));
                    preparedStatement.setInt(4, user_id);
                });
    }

    public int addMoneyRecById(Money money, int user_id){
        return executeQueryUpdate(INSERT_MONEY_QUERY,
                (preparedStatement) ->{
                    preparedStatement.setString(1, money.getCategory().getDescription());
                    preparedStatement.setInt(2, money.getNumber());
                    preparedStatement.setDate(3, new java.sql.Date(money.getDate().getTime()));
                    preparedStatement.setInt(4, user_id);
                });
    }

    public void deleteMoneyRecById(int id){
        executeQueryUpdate(DELETE_MONEY_BY_ID_QUERY,
                preparedStatement -> preparedStatement.setInt(1, id));
    }

    private static Money moneyEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Money moneyEntity = Money.builder()  
                .category(Category.getByDescription(resultSet.getString("category")))
                .number(resultSet.getInt("number"))
                .date(resultSet.getDate("date"))
                .id(resultSet.getInt("id"))
                .build();
        return moneyEntity;
    }
}
