/**
 * 
 */
package com.fdzcxy.hrms.ui;

import java.util.ArrayList;

import com.fdzcxy.hrms.dao.EmployeeDaoImpl;
import com.fdzcxy.hrms.domain.Employee;
import com.fdzcxy.hrms.exception.BlankInputException;
import com.fdzcxy.hrms.exception.ErrorInputException;
import com.fdzcxy.hrms.exception.NoFoundException;
import com.fdzcxy.hrms.sysutils.SysUtils;

/**
 * @author uerax
 *
 */
public class DeleteEmpUI implements BaseUI {

	/**
	 * 
	 */
	public DeleteEmpUI() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.fdzcxy.hrms.ui.BaseUI#run()
	 */
	@Override
	public void run() {
		
		System.out.println("¨C Employee Records:");
		System.out.println("======================================\n");
		System.out.println("Employee Record Deletion:\n");
		
		EmployeeDaoImpl em = new EmployeeDaoImpl();
		ArrayList<Employee> list = EmployeeDaoImpl.lists;
		
		Employee e = new Employee();
		
		findpayroll : while (true) {
		
			String str = null; 
			
			try {
				str = SysUtils.addGetInput("Enter employee 3 digit payroll number: ", "Invalid payroll number ¨C try again",  false);
				if (e.empPayNumRegex(str)) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getEmployeePayrollNumber().equals(str)) {
							list.get(i).out();							
							if (SysUtils.isY(str, 1)) {
								list.remove(i);
								if (SysUtils.isY(str, 0)) {
									continue findpayroll;
								}
								break findpayroll;
							}
							continue findpayroll;
							
						}
					}
					throw new NoFoundException("payroll number no found");
				} else {
					throw new ErrorInputException("Invalid payroll number ¨C try again");

				}
	
			} catch (BlankInputException err) {
				System.out.println(err.getMessage());
				continue;
			} catch (ErrorInputException eip) {
				System.out.println(eip.getMessage());
				continue;
			} catch (NoFoundException nfe) {
				System.out.println(nfe.getMessage());
				continue;
			} finally {
				EmployeeDaoImpl.lists = list;
			}
		}
		
		SysUtils.pause("\nPress Enter to continue...");
	}

}
