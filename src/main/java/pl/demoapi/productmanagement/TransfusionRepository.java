package pl.demoapi.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransfusionRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Transfusion> getAllTrans() {
        return jdbcTemplate.query("SELECT * FROM Transfusion", BeanPropertyRowMapper.newInstance(Transfusion.class));
    }

    public Transfusion getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Transfusion WHERE transfusion_id = ?",
                BeanPropertyRowMapper.newInstance(Transfusion.class), id);
    }

    public int save(Transfusion trans) {
        jdbcTemplate.update("INSERT INTO Transfusion VALUES(?, ?, ?, ?)", trans.getTransfusion_id(), trans.getBlood_id(), trans.getPatient_id(), trans.getDate());
        return 1;
    }

    public int deleteById(int id) {
        jdbcTemplate.update("DELETE FROM Transfusion WHERE transfusion_id = ?", id);
        return 1;
    }

    public int updateTrans(int id, Transfusion trans) {
        jdbcTemplate.update("UPDATE Transfusion SET blood_id = ?, patient_id = ?, date = ? WHERE transfusion_id = ?",
                trans.getBlood_id(), trans.getPatient_id(), trans.getDate(), id);
        return 1;
    }

}