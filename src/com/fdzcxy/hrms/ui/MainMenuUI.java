/**
 * 
 */
package com.fdzcxy.hrms.ui;

import com.fdzcxy.hrms.sysutils.SysUtils;
import com.fdzcxy.hrms.exception.BlankInputException;

/**
 * @author uerax
 *
 */
public class MainMenuUI implements BaseUI {

	/**
	 * 
	 */
	public MainMenuUI() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fdzcxy.hrms.ui.BaseUI#run()
	 */
	@Override
	public void run() {

		Boolean isContinue = true;

		while (isContinue) {

			System.out.println("Employee Information - Main Menu");
			System.out.println("=====================================================");
			System.out.println("1 - Print All Current Records");
			System.out.println("2 每 Print All Current Records (formatted)");
			System.out.println("3 每 Print Names and Phone Numbers");
			System.out.println("4 每 Print Names and Phone Numbers (formatted)");
			System.out.println("5 - Search for specific Record(s)");
			System.out.println("6 - Add New Records");
			System.out.println("7 每 Delete Records\n");
			System.out.println("Q - Quit\n");
			System.out.print("Your Selection: ");

			String str = null;

			try {

				str = SysUtils.getInput("No selection entered. Press Enter to continue＃", false);
				str = str.toUpperCase();

				switch (str) {

				case "1":
					SysUtils.renderUI(UIType.EmpOuter);
					break;
				case "2":
					SysUtils.renderUI(UIType.FormatEmpOuter);
					break;
				case "3":
					SysUtils.renderUI(UIType.ShortOuter);
					break;
				case "4":
					SysUtils.renderUI(UIType.FormatShortOuter);
					break;
				case "5":
					SysUtils.renderUI(UIType.SerchEmp);
					break;
				case "6":
					SysUtils.renderUI(UIType.AddEmp);
					break;
				case "7":
					SysUtils.renderUI(UIType.DeleteEmp);
					break;
				case "Q":
					isContinue = false;
					break;
				default:
					SysUtils.pause("Invalid code Invalid code! Press Enter to continue＃ ");
					break;
				}
			} catch (BlankInputException e) {
				SysUtils.pause(e.getMessage());
				continue;
			}
		}

		System.out.println("\nThank you for using HRMIS V1.0,bye!");
	}

}
