package pl.demoapi.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BankController {

    @Autowired
    BankRepository bankRepository;

    @GetMapping("/Bank")
    public List<Bank> getAllBlood() {
        return bankRepository.getAllBlood();
    }

    @GetMapping("/Bank/{id}")
    public Bank getById(@PathVariable("id") int id) {
        return bankRepository.getById(id);
    }

    @PostMapping("/Bank/add")
    public int add(@RequestBody Bank bank) {
        return bankRepository.save(bank);
    }

    @DeleteMapping("/Bank/Delete/{id}")
    public int delete(@PathVariable("id") int id) {
        return bankRepository.deleteById(id);
    }

    @PutMapping("/Bank/Update/{id}")
    public int updatePatient(@PathVariable("id") int id, @RequestBody Bank bank) {
        return bankRepository.updateBank(id, bank);
    }

}