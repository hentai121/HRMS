/**
 * 
 */
package com.fdzcxy.hrms.dao;

import java.util.List;
import java.util.Set;

import com.fdzcxy.hrms.domain.Employee;

/**
 * @author uerax
 *
 */
public interface EmployeeDao {
	List<Employee> getEmpToList();

	Set<Employee> getEmpToSet();
	
	void writeToFile();
	void add();
	void delete();
	void select();
}
