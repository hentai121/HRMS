/**
 * 
 */
package com.fdzcxy.hrms.ui;

import java.util.ArrayList;

import com.fdzcxy.hrms.dao.EmployeeDao;
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
		
		EmployeeDao ed = new EmployeeDaoImpl();
		ed.delete();
	
		SysUtils.pause("\nPress Enter to continue...");
	}

}
