package com.fr.spring.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.fr.spring.jdbc.dao.EmployeeDAO;
import com.fr.spring.jdbc.model.Address;
import com.fr.spring.jdbc.model.Employee;
import com.fr.spring.jdbc.rowMapper.EmployeeRowMapper;

/**
 * This class extends "JdbcDaoSupport" support to eliminate the manual setting of datasource
 * private DataSource dataSource;
 *
 *	public void setDataSource(DataSource dataSource) {
 *		this.dataSource = dataSource;
 *	} 
 *  and creating the new JdbcTemplate object 
 *  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
 *  
 *  Instead it use getJdbcTemplate() method to get the JdbcTemplate reference
 *  
 * @author paddu
 *
 */
public class EmployeeDAOJDBCTemplateDaoSupport extends JdbcDaoSupport implements EmployeeDAO {

	/**
	 * 
	 */
	public void save(Employee employee) {

		String query = "insert into Employee (id, name, role) values (?,?,?)";
		Object[] args = new Object[] { employee.getId(), employee.getName(), employee.getRole() };
		int out = getJdbcTemplate().update(query, args);
		if (out != 0) {
			System.out.println("Employee saved with id=" + employee.getId());
		} else
			System.out.println("Employee save failed with id=" + employee.getId());
	}

	public Employee getById(int id) {
		String query = "select id, name, role from Employee where id = ?";
		// using RowMapper anonymous class, we can create a separate RowMapper for reuse
		Employee emp = getJdbcTemplate().queryForObject(query, new Object[] { id }, new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setRole(rs.getString("role"));
				return emp;
			}
		});

		return emp;
	}

	public void update(Employee employee) {
		String query = "update Employee set name=?, role=? where id=?";
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] { employee.getName(), employee.getRole(), employee.getId() };

		int out = getJdbcTemplate().update(query, args);
		if (out != 0) {
			System.out.println("Employee updated with id=" + employee.getId());
		} else
			System.out.println("No Employee found with id=" + employee.getId());
	}

	public void deleteById(int id) {

		String query = "delete from Employee where id=?";
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		int out = getJdbcTemplate().update(query, id);
		if (out != 0) {
			System.out.println("Employee deleted with id=" + id);
		} else
			System.out.println("No Employee found with id=" + id);
	}

	public List<Employee> getAll() {
		String query = "select id, name, role from Employee";
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String, Object>> empRows = getJdbcTemplate().queryForList(query);

		for (Map<String, Object> empRow : empRows) {
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
			emp.setName(String.valueOf(empRow.get("name")));
			emp.setRole(String.valueOf(empRow.get("role")));
			empList.add(emp);
		}
		return empList;
	}

	/**
	 * Custom rowMapper implementation. Eliminating the repeated code of default row
	 * mapper
	 */
	public Employee findByEmployeeId(int id) {

		String query = "select id, name, role from Employee where id = ?";
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Employee employee = getJdbcTemplate().queryForObject(query, new Object[] { id }, new EmployeeRowMapper());
		return employee;
	}

	public int[] insertEmployeeList(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createDBObject(Address address) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Employee findBeanByEmployeeId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
