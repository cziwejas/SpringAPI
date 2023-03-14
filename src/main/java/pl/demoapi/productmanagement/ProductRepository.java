package pl.demoapi.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAll() {
        return jdbcTemplate.query("SELECT * FROM Product", BeanPropertyRowMapper.newInstance(Product.class));
    }

    public Product getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Product WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Product.class), id);
    }

    public int save(List<Product> products) {
        products.forEach( product -> jdbcTemplate.update("INSERT INTO Product VALUES(?, ?, ?, ?)",
                product.getId(), product.getName(), product.getPrize(), product.getDescription()));
        return 1;
    }

    public int deleteById(int id) {
        jdbcTemplate.update("DELETE FROM Product WHERE id = ?", id);
        return 1;
    }
}