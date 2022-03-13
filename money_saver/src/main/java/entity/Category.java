package entity;

import java.util.Arrays;
import java.util.Optional;

import static utill.Constants.*;

public enum Category {
    FOOD (FOOD_DESCRIPTION),
    TRANSPORT (TRANSPORT_DESCRIPTION),
    HOME (HOME_DESCRIPTION),
    COMMUNAL_PAYMENTS (COMMUNAL_PAYMENTS_DESCRIPTION),
    CAR (CAR_DESCRIPTION),
    PETS (PET_DESCRIPTION);

    Category(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public static Category getByDescription(String description){
        return Arrays.stream(Category.values()).filter((money) -> money.getDescription().equalsIgnoreCase(description)).findFirst().orElse(null);
    }
}
