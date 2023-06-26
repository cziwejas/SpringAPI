package pl.demoapi.productmanagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfusion {
    private int transfusion_id;
    private int blood_id;
    private int patient_id;
    private String date;
}