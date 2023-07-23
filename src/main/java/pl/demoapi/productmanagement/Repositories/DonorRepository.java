package pl.demoapi.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
public class DonorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Donor> getAllDonors() {
        return jdbcTemplate.query("SELECT * FROM Donor", BeanPropertyRowMapper.newInstance(Donor.class));
    }

    public Donor getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Donor WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Donor.class), id);
    }

    public int save(Donor donor) {
        jdbcTemplate.update("INSERT INTO Donor VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
                donor.getId(), donor.getName(), donor.getSurname(), donor.getAge(), donor.getEmail(), donor.getBlood_type(), donor.getBlood_given(), donor.getPassword());
        return 1;
    }

    public int deleteById(int id) {
        jdbcTemplate.update("DELETE FROM Donor WHERE id = ?", id);
        return 1;
    }

    public int updateDonor(int id, Donor donor) {
        jdbcTemplate.update("UPDATE Donor SET name = ?, surname = ?, age = ?, email = ?, blood_type = ?, blood_given = ?, password = ? WHERE id = ?",
                donor.getName(), donor.getSurname(), donor.getAge(), donor.getEmail(), donor.getBlood_type(), donor.getBlood_given(), donor.getPassword(), id);
        return 1;
    }
}