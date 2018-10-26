/**
 * 
 */
package com.fdzcxy.hrms.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.fdzcxy.hrms.domain.Employee;
import com.fdzcxy.hrms.exception.BlankInputException;
import com.fdzcxy.hrms.exception.ErrorInputException;
import com.fdzcxy.hrms.exception.NoFoundException;
import com.fdzcxy.hrms.sysutils.SysUtils;

/**
 * @author uerax
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {

	public static final String DATA_FILE = "records.txt";
	public static ArrayList<Employee> lists;

	public EmployeeDaoImpl(boolean x) {
		EmployeeDaoImpl.lists = getEmpToList();
	}

	public EmployeeDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fdzcxy.HRMS.dao.EmployeeDao#getEmpToList()
	 */
	@Override
	public ArrayList<Employee> getEmpToList() {

		BufferedReader br = null;
		String s = "";
		ArrayList<Employee> list = new ArrayList<>();

		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(DATA_FILE)));

			while ((s = br.readLine()) != null) {
				list.add(Employee.parseEmpData(s));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fdzcxy.HRMS.dao.EmployeeDao#getEmpToSet()
	 */
	@Override
	public TreeSet<Employee> getEmpToSet() {
		// TODO Auto-generated method stub
		return new TreeSet<Employee>(EmployeeDaoImpl.lists);
	}

	@Override
	public void add() {

		Employee e = new Employee();
		String str = null;
		// Ա���ż��
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter employee 3 digit payroll number: ",
						"No payroll number entered �C try again", false);

				if (e.empPayNumRegex(str)) {
					e.setEmployeePayrollNumber(str);
					break;
				} else {
					throw new ErrorInputException("Invalid payroll number �C try again");
				}

			} catch (BlankInputException err) {
				System.out.println(err.getMessage());
				continue;
			} catch (ErrorInputException eip) {
				System.out.println(eip.getMessage());
				continue;
			}
		}

		// Ա���绰���
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Phone Number (02-12345678): ", "No phone number entered �C try again",
						false);

				if (e.telNumRegex(str)) {
					e.setTelephoneNumber(str);
					break;
				} else {
					throw new ErrorInputException("Invalid phone number �C try again");
				}

			} catch (BlankInputException err) {
				System.out.println(err.getMessage());
				continue;
			} catch (ErrorInputException eip) {
				System.out.println(eip.getMessage());
				continue;
			}
		}

		// Ա�������
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Last Name: ", "No first name entered �C try again", false);

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

		// Ա���ռ��
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter First Name: ", "No first name entered �C try again", false);

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

		// Ա��ְλ���
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Middle Init: ", "No Middle Init entered �C try again", false);

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

		// ���ź�����
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Dept #(digital):", "No Dept # entered �C try again", false);

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

		// ְ�Ƽ��
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Job Title: ", "No Job title entered �C try again", false);

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

		// ���ڼ��
		while (true) {
			try {
				str = SysUtils.addGetInput("Enter Date Hired (dd-mm-yyyy): ", "No date hired entered �C try again ",
						false);

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

		EmployeeDaoImpl.lists.add(e);
		System.out.println("Record Saved");
		SysUtils.pause("\nPress Enter to continue...");
	}

	@Override
	public void delete() {

		Employee e = new Employee();

		findpayroll: while (true) {

			String str = null;

			try {
				str = SysUtils.addGetInput("Enter employee 3 digit payroll number: ",
						"Invalid payroll number �C try again", false);
				if (e.empPayNumRegex(str)) {
					for (int i = 0; i < EmployeeDaoImpl.lists.size(); i++) {
						if (EmployeeDaoImpl.lists.get(i).getEmployeePayrollNumber().equals(str)) {
							EmployeeDaoImpl.lists.get(i).out();
							if (SysUtils.isY(str, 1)) {
								EmployeeDaoImpl.lists.remove(i);
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
					throw new ErrorInputException("Invalid payroll number �C try again");

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
			}
		}

	}

	@Override
	public void select() {

		String str = null;
		Boolean isFind = false;

		while (true) {
			System.out.print("Enter keyword: ");
			try {
				str = SysUtils.getInput("No keyword entered �C try again", false);
			} catch (BlankInputException e) {
				System.out.println(e.getMessage());
				continue;
			}
			for (Employee e : EmployeeDaoImpl.lists) {
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
			System.out.println("Keyword �C " + str + " - not found");
			SysUtils.pause("\nPress Enter to continue...");
		}
	}

	@Override
	public void writeToFile() {

		FileWriter fw = null;
		StringBuffer sb = new StringBuffer();

		try {

			fw = new FileWriter(DATA_FILE);

			for (Employee e : EmployeeDaoImpl.lists) {
				sb.append(e.toString()).append("\n");
			}

			fw.write(sb.toString());
		} catch (IOException e) {
			System.out.println("�ļ�д�����");
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
