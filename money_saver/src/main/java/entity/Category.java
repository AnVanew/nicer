package entity;

import java.util.Arrays;
import java.util.Optional;

public enum Category {
    FOOD("food"),
    TRANSPORT("transport"),
    HOME("home"),
    COMMUNAL_PAYMENTS("comm.pay"),
    CAR("car"),
    DOG("dog");

    Category(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Category getByDescription(String description){
        return Arrays.stream(Category.values()).filter((money) -> money.getDescription().equalsIgnoreCase(description)).findFirst().orElse(null);
    }
}
