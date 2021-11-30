package entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@Builder
@Data
@ToString
public class Money {

    private String category;
    private int number;
    private Date date;
    
}
