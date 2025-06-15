package basics.collections.springjpa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import basics.collections.springjpa.model.Student;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImpl implements StudentDao{
    
	@Autowired
	StudentsRepo repo;

    public List<Student> getAllStudentDetails() {
    	return repo.findAll();
    }
}
