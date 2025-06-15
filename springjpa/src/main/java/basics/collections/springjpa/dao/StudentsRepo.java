package basics.collections.springjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import basics.collections.springjpa.model.Student;

public interface StudentsRepo extends JpaRepository<Student, Integer> {

}
