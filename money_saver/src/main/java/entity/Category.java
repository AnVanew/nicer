package entity;

import lombok.Data;

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
}
