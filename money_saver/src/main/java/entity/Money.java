package entity;

import lombok.*;

import java.util.Date;


@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Money {

    public Money(Category category, int number, Date date) {
        this.category = category;
        this.number = number;
        this.date = date;
    }

    private int id;
    private Category category;
    private int number;
    private Date date;

}
