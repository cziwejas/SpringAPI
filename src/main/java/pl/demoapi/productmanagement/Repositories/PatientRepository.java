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

    public Patient getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Patient WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Patient.class), id);
    }

    public int save(Patient patient) {
        jdbcTemplate.update("INSERT INTO Patient VALUES(?, ?, ?, ?, ?, ?, ?)",
                patient.getId(), patient.getName(), patient.getSurname(), patient.getAge(), patient.getEmail(), patient.getBlood_type(), patient.getPassword());
        return 1;
    }

    public int saveList(List<Patient> Patients) {
        Patients.forEach( Patient -> jdbcTemplate.update("INSERT INTO Patient VALUES(?, ?, ?, ?, ?, ?, ?)",
                Patient.getId(), Patient.getName(), Patient.getSurname(), Patient.getAge(), Patient.getEmail(), Patient.getBlood_type(), Patient.getPassword()));
        return 1;
    }

    public int deleteById(int id) {
        jdbcTemplate.update("DELETE FROM Patient WHERE id = ?", id);
        return 1;
    }

    public int updatePatient(int id, Patient patient) {
        jdbcTemplate.update("UPDATE Patient SET name = ?, surname = ?, age = ?, email = ?, blood_type = ?, password = ? WHERE id = ?",
                patient.getName(), patient.getSurname(), patient.getAge(), patient.getEmail(), patient.getBlood_type(), patient.getPassword(), id);
        return 1;
    }
}