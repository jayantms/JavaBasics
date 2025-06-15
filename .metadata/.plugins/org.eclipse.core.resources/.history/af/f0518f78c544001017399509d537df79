package basics.collections.mysqlrowmapperinterface.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import basics.collections.mysqlrowmapperinterface.model.Student;

public class StudentDaoImpl implements StudentDao{
    
    // Defining JdbcTemplate as member variable in order
    // to use the query() method of the JdbcTemplate's class
    private JdbcTemplate jdbcTemplate;
    
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // This method will return the list 
    // of all the details of student
    public List<Student> getAllStudentDetails() {
        
        // Implementation of RowMapper interface
        return jdbcTemplate.query("SELECT * FROM student", new RowMapper<Student>() {

            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setDepartment(rs.getString(3));
                return student;
            }
        });
    }
}
