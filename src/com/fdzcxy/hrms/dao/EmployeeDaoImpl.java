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
import java.util.TreeSet;

import com.fdzcxy.hrms.domain.Employee;
import com.fdzcxy.hrms.exception.NoFoundException;

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

	/* (non-Javadoc)
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
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.fdzcxy.HRMS.dao.EmployeeDao#getEmpToSet()
	 */
	@Override
	public TreeSet<Employee> getEmpToSet() {
		// TODO Auto-generated method stub
		return new TreeSet<Employee>(EmployeeDaoImpl.lists);
	}

	@Override
	public void writeToFile() {
		
		FileWriter fw = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			
			fw = new FileWriter(DATA_FILE);
			
			for (Employee e : lists) {
				sb.append(e.toString()).append("\n");
			}
			
			fw.write(sb.toString());
		} catch (IOException e) {
			System.out.println("ÎÄ¼þÐ´Èë´íÎó");
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
