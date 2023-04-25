package pl.demoapi.productmanagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String blood_type;
    private String password;

    @Override
    public String toString() {
        return this.id + " - " + this.name + " - " + this.surname + " - " + this.age + " - "
                + this.email + " - " + this.blood_type + " - " + this.password;
    }
}