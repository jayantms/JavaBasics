package basics.collections.comparable;

public class Employee implements Comparable<Employee>{
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

	@Override
	public int compareTo(Employee iempno) {

		if(this.employeeNo > iempno.employeeNo) 
			return 1;
        else
			return -1;
	}
}
