package Autowire;

public class Department {
	
	String DeptName;
	int deptNo;
	
	
	//constructor injection
	/*
	 * public Department(String deptName, int deptNo) {
	 * 
	 * this.DeptName = deptName; this.deptNo = deptNo; }
	 */
	
	
	public String getDeptName() {
		return DeptName;
	}
	//setter injection
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

}
