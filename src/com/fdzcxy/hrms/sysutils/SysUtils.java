/**
 * 
 */
package com.fdzcxy.hrms.sysutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fdzcxy.hrms.dao.EmployeeDaoImpl;
import com.fdzcxy.hrms.exception.BlankInputException;
import com.fdzcxy.hrms.exception.ErrorInputException;
import com.fdzcxy.hrms.exception.NoFoundException;
import com.fdzcxy.hrms.ui.UIFactory;
import com.fdzcxy.hrms.ui.UIType;

/**
 * @author uerax
 *
 */
public final class SysUtils {

	public static String getInput(String errMsg, boolean allowEmpty) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";

		try {
			str = br.readLine();
			// 如果allowEmpty为true则不会抛出错误
			if (isEmpty(str) && !allowEmpty) {
				throw new BlankInputException(errMsg);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return str;
	}

	public static String addGetInput(String Msg, String errMsg, boolean allowEmply) {
		System.out.print(Msg);
		return getInput(errMsg, allowEmply);
	}

	public static Boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static void pause() {
		getInput("", true);
	}

	public static void pause(String msg) {
		System.out.println(msg);
		getInput("", true);
	}

	public static void renderUI(UIType type) {
		UIFactory.getUI(type).run();
	}

	public static void checkResource() {

		File dataFile = new File(EmployeeDaoImpl.DATA_FILE);
		if (!dataFile.exists())
			throw new NoFoundException("Employee information data file not found ! Now exit!");

	}
	
	public static boolean checkExists() {
		File dataFile = new File(EmployeeDaoImpl.DATA_FILE);
		
		return dataFile.exists();
	}
	
	public static boolean dateFormatChecker(String str) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			// 严格检测日期
			sdf.setLenient(false);
			// 将str转换为相同format的日期格式, 如果不符合则抛出异常
			sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ErrorInputException("Invalid Date Hired");
		}

		return true;
	}
	
	public static boolean isY(String str, int mode) {
		

		if (mode == 1) {
			System.out.print("Confirm record deletion, (y)es or (n)o : ");
		} else {
			System.out.print("Delete another? (y)es or (n)o : ");
		}
		String s = getInput("", true).toUpperCase();
		
		return s.equals("Y");
	}
	
	public static void writer() {
		EmployeeDaoImpl em = new EmployeeDaoImpl();
		em.writeToFile();
	}

}
