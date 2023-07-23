package pl.demoapi.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Bank> getAllBlood() {
        return jdbcTemplate.query("SELECT * FROM Bank", BeanPropertyRowMapper.newInstance(Bank.class));
    }

    public Bank getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Bank WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Bank.class), id);
    }

    public int save(Bank bank) {
        jdbcTemplate.update("INSERT INTO Bank VALUES(?, ?, ?, ?, ?)",
                bank.getId(), bank.getCapacity(), bank.getBlood_type(), bank.getStart_date(), bank.getEnd_date());
        return 1;
    }

    public int deleteById(int id) {
        jdbcTemplate.update("DELETE FROM Bank WHERE id = ?", id);
        return 1;
    }

    public int updateBank(int id, Bank bank) {
        jdbcTemplate.update("UPDATE Bank SET capacity = ?, blood_type = ?, start_date = ?, end_date = ? WHERE id = ?",
                bank.getCapacity(), bank.getBlood_type(), bank.getStart_date(), bank.getEnd_date(), id);
        return 1;
    }

}