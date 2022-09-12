package com.fr.spring.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.fr.spring.jdbc.dao.EmployeeDAO;
import com.fr.spring.jdbc.model.Address;
import com.fr.spring.jdbc.model.Employee;

public class EmployeeDAONamesParameterJDBCTemplateImpl extends NamedParameterJdbcDaoSupport implements EmployeeDAO {

	
	/**
	 * 
	 */
	public void save(Employee employee) {
		String query = "insert into Employee (id, name, role) values (:id,:name,:role)";
		
		
		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("id", employee.getId());
		parameters.put("name", employee.getName());
		parameters.put("role", employee.getRole());
		
		int out = getNamedParameterJdbcTemplate().update(query, parameters);
		
		if(out !=0){
			System.out.println("Employee saved with id="+employee.getId());
		}else System.out.println("Employee save failed with id="+employee.getId());
	}

	/**
	 * 
	 */
	public Employee getById(int id) {
		String query = "select id, name, role from Employee where id =:id";
		
		SqlParameterSource param = new MapSqlParameterSource("id", id);
		
		final Employee employee = getNamedParameterJdbcTemplate().query(query, param, new ResultSetExtractor<Employee>() {
			 
		    public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
		        if (rs.next()) {
		            Employee emp = new Employee();
		            emp.setId(rs.getInt("id"));
		            emp.setName(rs.getString("name"));
		            emp.setRole(rs.getString("roll"));
		             
		            return emp;
		        }
		        return null;
		    }
		     
		});
		return employee;
		
	}

	/**
	 * 
	 */
	public void update(Employee employee) {
		
		String query = "update Employee set name= :name, role= :role where id= :id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", employee.getName());
		paramMap.put("role", employee.getRole());
		paramMap.put("id", employee.getId());
		
		int count = getNamedParameterJdbcTemplate().update(query, paramMap);
		
		if(count==1) {
			System.out.println(count+ " ======= Record updated in database ====");
		}
		
	}

	public void deleteById(int id) {
		
		String query = "delete from Employee where id= :id";

		SqlParameterSource param = new MapSqlParameterSource("id", id);
		int count = getNamedParameterJdbcTemplate().update(query, param);
	
		if(count==1) {
			System.out.println(count+ " ======= Record Deleted from database ====");
		}
	}

	/**
	 * 
	 */
	public List<Employee> getAll() {
		
		String sql = "SELECT * FROM employee";
		 
		@SuppressWarnings("unchecked")
		List<Employee> result = getNamedParameterJdbcTemplate().query(sql, new RowMapper() {
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		         
		        Employee emp = new Employee();
		        emp.setId(rs.getInt("id"));
		        emp.setName(rs.getString("name"));
		        emp.setRole(rs.getString("role"));
		        return emp;
		    }
		});
		
		
		return result;
	}

	public Employee findBeanByEmployeeId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee findByEmployeeId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int[] insertEmployeeList(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createDBObject(Address address) {
		// TODO Auto-generated method stub
		return 0;
	}
}
