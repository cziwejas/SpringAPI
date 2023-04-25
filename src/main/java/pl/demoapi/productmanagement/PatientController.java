package pl.demoapi.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.demoapi.productmanagement.Patient;
import pl.demoapi.productmanagement.PatientRepository;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    pl.demoapi.productmanagement.PatientRepository PatientRepository;

    @GetMapping("/Patients")
    public List<Patient> getAll() {
        return PatientRepository.getAllPatients();
    }

    @GetMapping("/Bank")
    public List<Bank> getAllBlood() {
        return PatientRepository.getAllBlood();
    }


    @GetMapping("/brand/{id}")
    public List<Patient> getByBrand(@PathVariable("id") String id) {
        return PatientRepository.getByBrand(id);
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable("id") int id) {
        return PatientRepository.getById(id);
    }

    @PostMapping("/add")
    public int add(@RequestBody List<Patient> Patients) {
        return PatientRepository.save(Patients);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return PatientRepository.deleteById(id);
    }
}