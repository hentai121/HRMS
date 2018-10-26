/**
 * 
 */
package com.fdzcxy.hrms.ui;

import java.util.List;

import com.fdzcxy.hrms.dao.EmployeeDao;
import com.fdzcxy.hrms.dao.EmployeeDaoImpl;
import com.fdzcxy.hrms.domain.Employee;
import com.fdzcxy.hrms.exception.BlankInputException;
import com.fdzcxy.hrms.sysutils.SysUtils;

/**
 * @author uerax
 *
 */
public class SerchEmpUI implements BaseUI {

	/**
	 * 
	 */
	public SerchEmpUI() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.fdzcxy.hrms.ui.BaseUI#run()
	 */
	@Override
	public void run() {
	
		String str = null;
		EmployeeDao em = new EmployeeDaoImpl();
		List<Employee> list = EmployeeDaoImpl.lists;
		Boolean isFind = false;
		
		while (true) {
			System.out.print("Enter keyword: ");
			try {
				str = SysUtils.getInput("No keyword entered ¨C try again", false);
			} catch (BlankInputException e) {
				System.out.println(e.getMessage());
				continue;
			}
			for (Employee e : list) {
				if (e.serch(str)) {
					e.out();
					isFind = true;
				}
			}
			break;
		}
		if (isFind) {
			SysUtils.pause("\nPress Enter to continue...");
		} else {
			System.out.println("Keyword ¨C " + str + " - not found");
			SysUtils.pause("\nPress Enter to continue...");
		}
	}
		

}
