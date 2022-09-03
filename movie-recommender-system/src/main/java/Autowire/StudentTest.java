package Autowire;

public class StudentTest {
	
	public static void main(String args[]) {
		
		Student st = new Student();
		st.setRollNo(100);
		st.setsName("Somu");
		Department dept = new Department();
		dept.setDeptName("IT");
		dept.setDeptNo(10001);
		st.setDepartment(dept);
		System.out.println("Student record is:"+st.getsName());
		
	}

}
