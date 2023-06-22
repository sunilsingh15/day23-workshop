package sg.edu.nus.iss.day23workshop.model;

import java.sql.Date;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullOrder {

    private int id;
    private Date orderDate;
    private int customerID;
    private Double totalPrice;
    private Double costPrice;
    
}
