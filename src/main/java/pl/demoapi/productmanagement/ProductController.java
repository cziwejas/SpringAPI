package pl.demoapi.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("")
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") int id) {
        return productRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Product> products) {
        return productRepository.save(products);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id) {
        return productRepository.deleteById(id);
    }
}