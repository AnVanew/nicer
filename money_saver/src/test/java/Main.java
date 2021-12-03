
import entity.Category;
import entity.Money;
import service.MoneyService;

import java.util.Arrays;
import java.util.List;

import static dbworker.MoneyDbWorker.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(Category.values()));
    }
}
