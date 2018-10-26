/**
 * 
 */
package com.fdzcxy.hrms.domain;

import com.fdzcxy.hrms.exception.ErrorInputException;
import com.fdzcxy.hrms.sysutils.SysUtils;

/**
 * @author uerax
 *
 */
public class Employee implements Comparable<Employee> {
	/**
	 * 员工号
	 */
	private String employeePayrollNumber;

	/**
	 * 电话
	 */
	private String telephoneNumber;

	/**
	 * 姓
	 */
	private String lastName;

	/**
	 * 名
	 */
	private String firstName;

	/**
	 * 职位
	 */
	private String initial;

	/**
	 * 部门号码
	 */
	private String departmentNumber;

	/**
	 * 职称
	 */
	private String jobTitle;

	/**
	 * 雇用日期
	 */
	private String dateOfHiring;

	public String getEmployeePayrollNumber() {
		return employeePayrollNumber;
	}

	public void setEmployeePayrollNumber(String employeePayrollNumber) {
		this.employeePayrollNumber = employeePayrollNumber;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDateOfHiring() {
		return dateOfHiring;
	}

	public void setDateOfHiring(String dateOfHiring) {
		this.dateOfHiring = dateOfHiring;
	}

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();

		sb.append(this.employeePayrollNumber).append(":").append(this.telephoneNumber).append(":").append(this.lastName)
				.append(":").append(this.firstName).append(":").append(this.initial).append(":")
				.append(this.departmentNumber).append(":").append(this.jobTitle).append(":").append(this.dateOfHiring);
		return sb.toString();
	}

	public static Employee parseEmpData(String s) {

		String[] str = s.split(":");
		Employee e = new Employee();

		e.setEmployeePayrollNumber(str[0]);
		e.setTelephoneNumber(str[1]);
		e.setFirstName(str[2]);
		e.setLastName(str[3]);
		e.setInitial(str[4]);
		e.setDepartmentNumber(str[5]);
		e.setJobTitle(str[6]);
		e.setDateOfHiring(str[7]);

		return e;
	}

	public void out() {
		System.out.println(this);
	}

	public void formatOut() {
		System.out.printf("%-15s%-15s%-10s%-10s%-15s%-10s%-25s%-15s\n", this.getFirstName(), this.getLastName(),
				this.getInitial(), this.getEmployeePayrollNumber(), this.getTelephoneNumber(),
				this.getDepartmentNumber(), this.getJobTitle(), this.getDateOfHiring());
	}

	public void shortOut() {
		System.out.println(this.firstName + "," + this.lastName + "," + this.telephoneNumber);

	}

	public void shortFormatOut() {
		System.out.printf("%-15s%-15s%-15s\n", this.firstName, this.lastName, this.telephoneNumber);
	}
	
	public boolean serch(String str) {
		
		if (str.equals(this.dateOfHiring)) return true;
		else if (str.equals(this.lastName)) return true;
		else if (str.equals(this.employeePayrollNumber)) return true;
		else if (str.equals(this.firstName)) return true;
		else if (str.equals(this.initial)) return true;
		else if (str.equals(this.telephoneNumber)) return true;
		else if (str.equals(this.departmentNumber)) return true;
		else if (str.equals(this.jobTitle)) return true;
		
		return false;
	}
	
	public boolean empPayNumRegex(String str) {
		String payrollNumberRegex = "\\d{3}";
		return str.matches(payrollNumberRegex);
	}
	
	public boolean telNumRegex(String str) {
		String telRegex = "^0[2-8]-[1-9]\\d{7}$";
		return str.matches(telRegex);
	}
	
	public boolean lastNameRegex(String str) {
		String firNameRegex = "[a-zA-Z\\s+]*";
		return str.matches(firNameRegex);
	}
	
	public boolean firstNameRegex(String str) {
		return this.lastNameRegex(str);
	}
	
	public boolean initialRegex(String str) {
		return this.lastNameRegex(str);
	}
	
	public boolean departNumRegex(String str) {
		String deptRegex = "[0-9]+";
		return str.matches(deptRegex);
	}
	
	public boolean jobtitleRegex(String str) {
		return this.lastNameRegex(str);
	}
	
	public boolean dateRegex(String str) {
		String dateRegex = "^[0-3]\\d-[0-1]\\d-\\d{4}";
		if (str.matches(dateRegex)) {
			//进行日期有效性检测
			if (SysUtils.dateFormatChecker(str)) {
				return true;
			}
		}
		throw new ErrorInputException("Invalid Date Hired");
	}
	

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.firstName.compareTo(o.firstName);
	}

}
