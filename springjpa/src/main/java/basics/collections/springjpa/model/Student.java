package basics.collections.springjpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    
	@Id
    private int id;
    private String name;
    private String department;
    
    public Student() { 
    	
    }
    
    // getters and setters method
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    
    // toString() method
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", department=" + department + "]";
    }    
}