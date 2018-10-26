/**
 * 
 */
package com.fdzcxy.hrms.ui;

import java.util.Set;

import com.fdzcxy.hrms.dao.EmployeeDao;
import com.fdzcxy.hrms.dao.EmployeeDaoImpl;
import com.fdzcxy.hrms.domain.Employee;
import com.fdzcxy.hrms.sysutils.SysUtils;

/**
 * @author uerax
 *
 */
public class FormatShortOuterUI implements BaseUI {

	/**
	 * 
	 */
	public FormatShortOuterUI() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.fdzcxy.hrms.ui.BaseUI#run()
	 */
	@Override
	public void run() {
		EmployeeDao em = new EmployeeDaoImpl();
		Set<Employee> set = em.getEmpToSet();
		for (Employee e : set) {
			e.shortFormatOut();
		}
		
		SysUtils.pause("\nPress Enter to continue...");

	}

}
