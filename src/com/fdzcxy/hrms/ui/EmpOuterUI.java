/**
 * 
 */
package com.fdzcxy.hrms.ui;

import java.util.List;

import com.fdzcxy.hrms.dao.EmployeeDao;
import com.fdzcxy.hrms.dao.EmployeeDaoImpl;
import com.fdzcxy.hrms.domain.Employee;
import com.fdzcxy.hrms.sysutils.SysUtils;

/**
 * @author uerax
 *
 */
public class EmpOuterUI implements BaseUI {

	/**
	 * 
	 */
	public EmpOuterUI() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.fdzcxy.hrms.ui.BaseUI#run()
	 */
	@Override
	public void run() {
		EmployeeDaoImpl em = new EmployeeDaoImpl();
		
		List<Employee> list = EmployeeDaoImpl.lists;
		
		for (Employee e : list) {
			e.out();
		}
		
		SysUtils.pause("\nPress Enter to continue...");

	}

}
