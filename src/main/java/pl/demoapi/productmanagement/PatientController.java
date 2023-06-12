package pl.demoapi.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.demoapi.productmanagement.Patient;
import pl.demoapi.productmanagement.PatientRepository;

import java.util.List;

@CrossOrigin
@RestController
public class PatientController {

    @Autowired
    pl.demoapi.productmanagement.PatientRepository PatientRepository;

    @GetMapping("/Patients")
    public List<Patient> getAll() {
        return PatientRepository.getAllPatients();
    }

    @GetMapping("/Patients/{id}")
    public Patient getById(@PathVariable("id") int id) {
        return PatientRepository.getById(id);
    }

    @PostMapping("/Patients/add")
    public int add(@RequestBody List<Patient> Patients) {
        return PatientRepository.save(Patients);
    }

    @DeleteMapping("/Patients/Delete/{id}")
    public int delete(@PathVariable("id") int id) {
        return PatientRepository.deleteById(id);
    }

    @PutMapping("/Patients/Update/{id}")
    public int updatePatient(@PathVariable("id") int id, @RequestBody Patient patient) {
        return PatientRepository.updatePatient(id, patient);
    }
}