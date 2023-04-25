package pl.demoapi.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Patient> getAllPatients() {
        return jdbcTemplate.query("SELECT * FROM Patient", BeanPropertyRowMapper.newInstance(Patient.class));
    }

    public List<Bank> getAllBlood() {
        return jdbcTemplate.query("SELECT * FROM Bank", BeanPropertyRowMapper.newInstance(Bank.class));
    }

    public List<Patient> getByBrand(String brand) {
        return jdbcTemplate.query("SELECT * FROM Patient WHERE description = ?",
                BeanPropertyRowMapper.newInstance(Patient.class), brand);
    }

    public Patient getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Patient WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Patient.class), id);
    }

    public int save(List<Patient> Patients) {
        Patients.forEach( Patient -> jdbcTemplate.update("INSERT INTO Patient VALUES(?, ?, ?, ?)",
                Patient.getId(), Patient.getName(), Patient.getSurname(), Patient.getAge()));
        return 1;
    }

    public int deleteById(int id) {
        jdbcTemplate.update("DELETE FROM Patient WHERE id = ?", id);
        return 1;
    }
}