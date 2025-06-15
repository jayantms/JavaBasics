package basics.collections.multithreadedapp;

public class Employee {
	private int employeeNo; 
	private String name;
	
	public Employee(int employeeNo, String name) {
		super();
		this.employeeNo = employeeNo;
		this.name = name;
	}

	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", name=" + name + "]";
	} 
}
