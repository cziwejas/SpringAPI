package pl.demoapi.productmanagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    private int id;
    private String capacity;
    private String blood_type;
    private String start_date;
    private String end_date;

}