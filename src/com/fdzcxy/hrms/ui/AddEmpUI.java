/**
 * 
 */
package com.fdzcxy.hrms.ui;

import java.util.ArrayList;
import java.util.List;

import com.fdzcxy.hrms.dao.EmployeeDao;
import com.fdzcxy.hrms.dao.EmployeeDaoImpl;
import com.fdzcxy.hrms.domain.Employee;
import com.fdzcxy.hrms.exception.BlankInputException;
import com.fdzcxy.hrms.exception.ErrorInputException;
import com.fdzcxy.hrms.sysutils.SysUtils;

/**
 * @author uerax
 *
 */
public class AddEmpUI implements BaseUI {

	/**
	 * 
	 */
	public AddEmpUI() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fdzcxy.hrms.ui.BaseUI#run()
	 */
	@Override
	public void run() {

		System.out.println("– Employee Records:");
		System.out.println("======================================\n");
		System.out.println("Employee Record Additions:\n");
		System.out.println("Enter the following details of the new employee:\n");
		System.out.println("Employee 3 digit payroll number");
		System.out.println("Phone Number");
		System.out.println("Last Name");
		System.out.println("First Name");
		System.out.println("Middle Init");
		System.out.println("Dept #");
		System.out.println("Job Title");
		System.out.println("Date Hired\n");

		Employee e = new Employee();
		String str = null;
		ArrayList<Employee> list = EmployeeDaoImpl.lists;

		// 员工号检测
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter employee 3 digit payroll number: ",
						"No payroll number entered – try again", false);

				if (e.empPayNumRegex(str)) {
					e.setEmployeePayrollNumber(str);
					break;
				} else {
					throw new ErrorInputException("Invalid payroll number – try again");
				}

			} catch (BlankInputException err) {
				System.out.println(err.getMessage());
				continue;
			} catch (ErrorInputException eip) {
				System.out.println(eip.getMessage());
				continue;
			}
		}

		// 员工电话检测
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Phone Number (02-12345678): ", "No phone number entered – try again",
						false);

				if (e.telNumRegex(str)) {
					e.setTelephoneNumber(str);
					break;
				} else {
					throw new ErrorInputException("Invalid phone number – try again");
				}

			} catch (BlankInputException err) {
				System.out.println(err.getMessage());
				continue;
			} catch (ErrorInputException eip) {
				System.out.println(eip.getMessage());
				continue;
			}
		}

		// 员工名检测
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Last Name: ", "No first name entered – try again", false);

				if (e.lastNameRegex(str)) {
					e.setLastName(str);
					break;
				} else {
					throw new ErrorInputException("last name can contain only alphabetical characters and spaces");
				}

			} catch (BlankInputException err) {
				System.out.println(err.getMessage());
				continue;
			} catch (ErrorInputException eip) {
				System.out.println(eip.getMessage());
				continue;
			}
		}

		// 员工姓检测
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter First Name: ", "No first name entered – try again", false);

				if (e.firstNameRegex(str)) {
					e.setFirstName(str);
					break;
				} else {
					throw new ErrorInputException("First name can contain only alphabetical characters and spaces");
				}

			} catch (BlankInputException err) {
				System.out.println(err.getMessage());
				continue;
			} catch (ErrorInputException eip) {
				System.out.println(eip.getMessage());
				continue;
			}
		}

		// 员工职位检测
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Middle Init: ", "No Middle Init entered – try again", false);

				if (e.initialRegex(str)) {
					e.setInitial(str);
					break;
				} else {
					throw new ErrorInputException("Middle Init can contain only alphabetical characters and spaces");
				}

			} catch (BlankInputException err) {
				System.out.println(err.getMessage());
				continue;
			} catch (ErrorInputException eip) {
				System.out.println(eip.getMessage());
				continue;
			}
		}

		// 部门号码检测
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Dept #(digital):", "No Dept # entered – try again", false);

				if (e.departNumRegex(str)) {
					e.setDepartmentNumber(str);
					break;
				} else {
					throw new ErrorInputException("Dept # can contain only digits with no spaces");
				}

			} catch (BlankInputException err) {
				System.out.println(err.getMessage());
				continue;
			} catch (ErrorInputException eip) {
				System.out.println(eip.getMessage());
				continue;
			}
		}

		// 职称检测
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Job Title: ", "No Job title entered – try again", false);

				if (e.jobtitleRegex(str)) {
					e.setJobTitle(str);
					break;
				} else {
					throw new ErrorInputException("Job title can contain only alphabetical characters and spaces");
				}

			} catch (BlankInputException err) {
				System.out.println(err.getMessage());
				continue;
			} catch (ErrorInputException eip) {
				System.out.println(eip.getMessage());
				continue;
			}
		}
		
		// 日期检测
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Date Hired (dd-mm-yyyy): ", "No date hired entered – try again ", false);

				if (e.dateRegex(str)) {
					e.setDateOfHiring(str);
					break;
				} else {
					throw new ErrorInputException("Invalid Date Hired");
				}

			} catch (BlankInputException err) {
				System.out.println(err.getMessage());
				continue;
			} catch (ErrorInputException eip) {
				System.out.println(eip.getMessage());
				continue;
			}
		}
		
		list.add(e);
		EmployeeDaoImpl.lists = list;
		System.out.println("Record Saved");
		SysUtils.pause("\nPress Enter to continue...");
		
	}

}
