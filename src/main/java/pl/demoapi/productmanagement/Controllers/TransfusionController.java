package pl.demoapi.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TransfusionController {
    @Autowired
    TransfusionRepository transfusionRepository;

    @GetMapping("/Trans")
    public List<Transfusion> getAll() {
        return transfusionRepository.getAllTrans();
    }

    @GetMapping("/Trans/{id}")
    public Transfusion getById(@PathVariable("id") int id) {
        return transfusionRepository.getById(id);
    }

    @PostMapping("/Trans/add")
    public int add(@RequestBody Transfusion trans) {
        return transfusionRepository.save(trans);
    }

    @DeleteMapping("/Trans/Delete/{id}")
    public int delete(@PathVariable("id") int id) {
        return transfusionRepository.deleteById(id);
    }

    @PutMapping("/Trans/Update/{id}")
    public int updatePatient(@PathVariable("id") int id, @RequestBody Transfusion trans) {
        return transfusionRepository.updateTrans(id, trans);
    }
}