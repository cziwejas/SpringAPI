package pl.demoapi.productmanagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donor {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String blood_type;
    private String blood_given;
    private String password;

}