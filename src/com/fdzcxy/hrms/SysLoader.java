/**
 * 
 */
package com.fdzcxy.hrms;

import com.fdzcxy.hrms.dao.EmployeeDao;
import com.fdzcxy.hrms.dao.EmployeeDaoImpl;
import com.fdzcxy.hrms.exception.InputException;
import com.fdzcxy.hrms.sysutils.SysUtils;
import com.fdzcxy.hrms.ui.UIType;

/**
 * @author uerax
 *
 */
public class SysLoader {
	
	public static void main(String[] args) {
		
		
		try {
			SysUtils.checkResource();
			EmployeeDaoImpl em = new EmployeeDaoImpl(true);
			SysUtils.renderUI(UIType.MainMenu);
		} catch (InputException e) {
			System.out.println(e.getMessage());
		} finally {
			if (SysUtils.checkExists()) {
				SysUtils.writer();
			}
		}

	}
}
