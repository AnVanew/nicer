package entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Builder
@Data
public class Money {

    private String category;
    private int number;
    private Date date;

}
