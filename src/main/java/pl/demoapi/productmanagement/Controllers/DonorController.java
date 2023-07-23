package pl.demoapi.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DonorController {

    @Autowired
    DonorRepository donorRepository;

    @GetMapping("/Donors")
    public List<Donor> getAllDonors() {
        return donorRepository.getAllDonors();
    }

    @GetMapping("/Donor/{id}")
    public Donor getById(@PathVariable("id") int id) {
        return donorRepository.getById(id);
    }

    @PostMapping("/Donor/add")
    public int add(@RequestBody Donor donor) {
        return donorRepository.save(donor);
    }

    @DeleteMapping("/Donor/Delete/{id}")
    public int delete(@PathVariable("id") int id) {
        return donorRepository.deleteById(id);
    }

    @PutMapping("/Donor/Update/{id}")
    public int updateDonor(@PathVariable("id") int id, @RequestBody Donor donor) {
        return donorRepository.updateDonor(id, donor);
    }
}